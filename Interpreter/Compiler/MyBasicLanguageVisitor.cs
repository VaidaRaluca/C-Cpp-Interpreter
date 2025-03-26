using Antlr4.Runtime;
using Antlr4.Runtime.Misc;
using System;
using System.Collections;
using System.Collections.Generic;
using static System.Runtime.InteropServices.JavaScript.JSType;

public class MyBasicLanguageVisitor : BasicLanguageBaseVisitor<object>
{

    private Stack<Scope> scopeStack;
    private Scope globalScope;
    private Dictionary<string, (string returnType, List<(string type, string name)> parameters, BasicLanguageParser.StatementContext[] body)> functionDeclarations;
    private Stack<(bool isReturning, object value)> returnStack;

    public MyBasicLanguageVisitor()
    {
        scopeStack = new Stack<Scope>();
        globalScope = new Scope();
        scopeStack.Push(globalScope);
        functionDeclarations = new();
        returnStack = new();
    }

    public override object VisitFunctionDefinition(BasicLanguageParser.FunctionDefinitionContext context)
    {
        string functionName = context.VARIABLE_NAME().GetText();
        string returnType = context.type().GetText();
        List<(string, string)> parameterList = context.parameterList()?.parameter()
    .Select(p => (p.type().GetText(), p.VARIABLE_NAME().GetText())).ToList() ?? new List<(string, string)>();

        var seenParameters = new HashSet<string>();
        foreach (var param in parameterList)
        {
            if (!seenParameters.Add(param.Item2)) 
            {
                throw new Exception($"Error: Duplicate parameter '{param.Item2}'");
            }
        }
        if (functionDeclarations.ContainsKey(functionName))
        {
            var existingFunction = functionDeclarations[functionName];
            var existingParameters = existingFunction.parameters;
            if (existingParameters.Count == parameterList.Count)
            {
                bool parametersMatch = true;
                for (int i = 0; i < parameterList.Count; i++)
                {
                    if (existingParameters[i].type != parameterList[i].Item1)
                    {
                        parametersMatch = false;
                        break;
                    }
                }
                if (parametersMatch)
                {
                    throw new Exception($"Error: Duplicate function definition for '{functionName}' with identical parameter types.");
                }
            }
        }
        functionDeclarations[functionName] = (returnType, parameterList, context.statement());
        return null;
    }

    public override object VisitFunctionCall(BasicLanguageParser.FunctionCallContext context)
    {
        string functionName = context.VARIABLE_NAME().GetText();
        if (!functionDeclarations.ContainsKey(functionName))
        {
            throw new Exception($"Error: Function Definition for {functionName} does not exist.");
        }
        List<object> argumentList = context.argumentList()?.expr()
     .Select(a => EvaluateExpression(a)).ToList() ?? new List<object>();
        var (returnType, parameterList, instructions) = functionDeclarations[functionName];
        if (argumentList.Count() != parameterList.Count())
        {
            throw new Exception($"Error: Argument List and Parameter List d not correspond.");
        }
        scopeStack.Push(new Scope(globalScope));
        foreach (var pair in argumentList.Zip(parameterList, (arg, param) => (arg, param)))
        {
            var (arg, param) = pair;
            string paramType = param.Item1;
            string paramName = param.Item2;
            scopeStack.Peek().AddVariable(paramName, paramType, arg);
        }

        returnStack.Push((false, null));

        foreach (var instruction in instructions)
        {
            Visit(instruction);
        }
        var (isReturning, returnValue) = returnStack.Pop();

        scopeStack.Pop();

        return Scope.Converter(returnType, returnValue);
    }

    public override object VisitReturnStmt(BasicLanguageParser.ReturnStmtContext context)
    {
        var (isReturning, returnValue) = returnStack.Pop();
        returnStack.Push((true, (context.expr() != null) ? Visit(context.expr()) : null));
        return returnStack.Peek().value;
    }

    public override object VisitDeclaration(BasicLanguageParser.DeclarationContext context)
    {
        string type = context.type().GetText();

        for (int i = 0; i < context.VARIABLE_NAME().Length; i++)
        {
            string varName = context.VARIABLE_NAME(i).GetText();
            if (scopeStack.Peek().ReturnAllVariables().ContainsKey(varName))
            {
                throw new Exception($"Error: Variable '{varName}' is already declared in the current scope.");
            }
            if (globalScope.ReturnAllVariables().ContainsKey(varName))
            {
                throw new Exception($"Error: Variable '{varName}' is already declared in the global scope.");
            }
            object value = GetDefaultValue(type);
            if (context.expr(i) != null)
            {
                value = EvaluateExpression(context.expr(i));
            }
            scopeStack.Peek().AddVariable(varName, type, value);

            Console.WriteLine($"Declared {type} {varName} = {scopeStack.Peek().GetVariable(varName)}");
        }

        return null;
    }

    public override object VisitStatement(BasicLanguageParser.StatementContext context)
    {
        if (returnStack.Peek().isReturning)
            return null;
        return VisitChildren(context);
    }

    public override object VisitAssignExpr(BasicLanguageParser.AssignExprContext context)
    {
        string varName = context.VARIABLE_NAME().GetText();
        object value = EvaluateExpression(context.expr());
        scopeStack.Peek().SetVariable(varName, value);

        Console.WriteLine($"Assigned value {scopeStack.Peek().GetVariable(varName)} to {varName}");
        return null;
    }

    public override object VisitParenExpr(BasicLanguageParser.ParenExprContext context)
    {
        return EvaluateExpression(context.expr());
    }

    private object GetDefaultValue(string type)
    {
        if (type == "int") return 0;
        else if (type == "float") return 0.0f;
        else if (type == "string") return "";
        else if (type == "double") return 0.0;
        return null;
    }

    public static bool IsValidType(string expectedType, object value)
    {
        if (expectedType == "int" && value is int) return true;
        if ((expectedType == "float" || expectedType == "double") && (value is float || value is double)) return true;
        if (expectedType == "string" && value is string) return true;

        Console.WriteLine($"Type Error: Expected '{expectedType}', but got '{value.GetType().Name}'.");
        return false;
    }

    private object EvaluateExpression(BasicLanguageParser.ExprContext context)
    {
        if (context is BasicLanguageParser.IntValueExprContext intExpr)
        {
            return int.Parse(intExpr.GetText());
        }
        else if (context is BasicLanguageParser.FloatValueExprContext floatExpr)
        {
            return float.Parse(floatExpr.GetText());
        }
        else if (context is BasicLanguageParser.StringValueExprContext stringExpr)
        {
            return stringExpr.GetText().Trim('"');
        }
        else if (context is BasicLanguageParser.DoubleValueExprContext doubleExpr)
        {
            return double.Parse(doubleExpr.GetText());
        }
        else if (context is BasicLanguageParser.FunctionCallExprContext functionCallExpr)
        {
            return Visit(functionCallExpr);
        }
        else if (context is BasicLanguageParser.VariableExprContext varExpr)
        {
            string varName = varExpr.GetText();
            return scopeStack.Peek().GetVariable(varName);
        }
        else if (context is BasicLanguageParser.ParenExprContext parenExpr)
        {
            return VisitParenExpr(parenExpr);
        }
        else if (context is BasicLanguageParser.AddSubExprContext addSubExpr)
        {
            return VisitAddSubExpr(addSubExpr);
        }
        else if (context is BasicLanguageParser.MulDivExprContext mulDivExpr)
        {
            return VisitMulDivExpr(mulDivExpr);
        }
        else if (context is BasicLanguageParser.ModExprContext modExpr)
        {
            return VisitModExpr(modExpr);
        }
        else if (context is BasicLanguageParser.EqExprContext eqExpr)
        {
            return VisitEqExpr(eqExpr);
        }
        else if (context is BasicLanguageParser.NeqExprContext neqExpr)
        {
            return VisitNeqExpr(neqExpr);
        }
        else if (context is BasicLanguageParser.GtExprContext gtExpr)
        {
            return VisitGtExpr(gtExpr);
        }
        else if (context is BasicLanguageParser.LtExprContext ltExpr)
        {
            return VisitLtExpr(ltExpr);
        }
        else if (context is BasicLanguageParser.LeqExprContext leqExpr)
        {
            return VisitLeqExpr(leqExpr);
        }
        else if (context is BasicLanguageParser.GeqExprContext geqExpr)
        {
            return VisitGeqExpr(geqExpr);
        }
        else if (context is BasicLanguageParser.AndExprContext andExpr)
        {
            return VisitAndExpr(andExpr);
        }
        else if (context is BasicLanguageParser.OrExprContext orExpr)
        {
            return VisitOrExpr(orExpr);
        }
        else if (context is BasicLanguageParser.NotExprContext notExpr)
        {
            return VisitNotExpr(notExpr);
        }
        else if (context is BasicLanguageParser.PostfixIncrementExprContext postfixIncrementExpr)
        {
            return VisitPostfixIncrementExpr(postfixIncrementExpr);
        }
        else if (context is BasicLanguageParser.PostfixDecrementExprContext postfixDecrementExpr)
        {
            return VisitPostfixDecrementExpr(postfixDecrementExpr);
        }
        else if (context is BasicLanguageParser.PrefixIncrementExprContext prefixIncrementExpr)
        {
            return VisitPrefixIncrementExpr(prefixIncrementExpr);
        }
        else if (context is BasicLanguageParser.PrefixDecrementExprContext prefixDecrementExpr)
        {
            return VisitPrefixDecrementExpr(prefixDecrementExpr);
        }

        throw new Exception($"Unsupported expression: {context.GetText()}");
    }

    public override object VisitIfStmt(BasicLanguageParser.IfStmtContext context)
    {
        object conditionResult = EvaluateExpression(context.expr());
        if (conditionResult is bool condition)
        {
            if (condition)
            {
                foreach (var statement in context.statement())
                {
                    Visit(statement);
                }
            }
            else if (context.elseStmt() != null)
            {
                return Visit(context.elseStmt());
            }
        }
        else
        {
            throw new Exception("Type Error: If condition must evaluate to a boolean value.");
        }

        return null;
    }


    public override object VisitWhileStmt(BasicLanguageParser.WhileStmtContext context)
    {
        object conditionResult = EvaluateExpression(context.expr());
        if (conditionResult is bool condition)
        {
            while (condition)
            {
                if (returnStack.Peek().isReturning)
                {
                    break;
                }
                foreach (var statement in context.statement())
                {
                    Visit(statement);
                }
                conditionResult = EvaluateExpression(context.expr());
                if (conditionResult is bool newCondition)
                {
                    condition = newCondition;
                }
                else
                {
                    throw new Exception("Type Error: While condition must evaluate to a boolean value.");
                }
            }
        }
        else
        {
            throw new Exception("Type Error: While condition must evaluate to a boolean value.");
        }
        return null;
    }

    public override object VisitForStmt(BasicLanguageParser.ForStmtContext context)
    {
        if (context.multiDeclaration() != null)
        {
            Visit(context.multiDeclaration());
        }
        else if (context.multiAssignment() != null)
        {
            Visit(context.multiAssignment());
        }


        while (true)
        {
            if (returnStack.Peek().isReturning)
            {
                break;
            }
            if (context.expr() != null)
            {
                object conditionResult = EvaluateExpression(context.expr());
                if (!(conditionResult is bool condition) || !condition)
                {
                    break;
                }
            }

            foreach (var statement in context.statement())
            {
                Visit(statement);
            }

            if (context.exprList() != null)
            {
                VisitExprList(context.exprList());
            }
        }

        return null;
    }

    public override object VisitMultiAssignment(BasicLanguageParser.MultiAssignmentContext context)
    {
        for (int i = 0; i < context.VARIABLE_NAME().Length; i++)
        {
            string varName = context.VARIABLE_NAME(i).GetText();

            object evaluatedValue = EvaluateExpression(context.expr(i));
            scopeStack.Peek().SetVariable(varName, evaluatedValue);
            Console.WriteLine($"Assigned value {evaluatedValue} to {varName}");
        }

        return null;
    }


    public override object VisitMultiDeclaration(BasicLanguageParser.MultiDeclarationContext context)
    {
        string type = context.type().GetText();

        for (int i = 0; i < context.VARIABLE_NAME().Length; i++)
        {
            string varName = context.VARIABLE_NAME(i).GetText();
            object defaultValue = GetDefaultValue(type);

            var exprContext = context.expr(i);
            if (exprContext != null)
            {
                object evaluatedValue = EvaluateExpression(exprContext);
                if (!IsValidType(type, evaluatedValue))
                {
                    throw new Exception($"Type Error: Cannot assign value '{evaluatedValue}' to '{varName}' of type '{type}'.");
                }
                defaultValue = evaluatedValue;
            }

            scopeStack.Peek().AddVariable(varName, type, defaultValue);
            Console.WriteLine($"Declared {type} {varName} = {defaultValue}");
        }

        return null;
    }


    public override object VisitExprList(BasicLanguageParser.ExprListContext context)
    {
        foreach (var expr in context.expr())
        {
            EvaluateExpression(expr);
        }
        return null;
    }


    public override object VisitElseStmt(BasicLanguageParser.ElseStmtContext context)
    {
        foreach (var statement in context.statement())
        {
            Visit(statement);
        }
        return null;
    }


    public override object VisitAddSubExpr(BasicLanguageParser.AddSubExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));
        if (left.GetType() == typeof(string) && right.GetType() == typeof(string))
        {
            if (context.ADD_OP() != null)
                return Convert.ToString(left) + Convert.ToString(right);
            throw new Exception("Cannot substract strings");
        }
        else if (left.GetType() == typeof(string) || right.GetType() == typeof(string))
            throw new Exception("Cannot add or substract a string with anything else");
        if (left.GetType() == typeof(double) || right.GetType() == typeof(double))
        {
            return context.ADD_OP() != null ? Convert.ToDouble(left) + Convert.ToDouble(right) : Convert.ToDouble(left) - Convert.ToDouble(right);
        }
        if (left.GetType() == typeof(float) || right.GetType() == typeof(float))
        {
            return context.ADD_OP() != null ? Convert.ToSingle(left) + Convert.ToSingle(right) : Convert.ToSingle(left) - Convert.ToSingle(right);
        }
        if (left.GetType() == typeof(int) || right.GetType() == typeof(int))
        {
            return context.ADD_OP() != null ? Convert.ToInt32(left) + Convert.ToInt32(right) : Convert.ToInt32(left) - Convert.ToInt32(right);
        }
        throw new Exception("Type Error: Invalid operands for addition or subtraction.");
    }

    public override object VisitMulDivExpr(BasicLanguageParser.MulDivExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));
        if ((left.GetType() == typeof(string) || right.GetType() == typeof(string)) || (left.GetType() == typeof(string) && right.GetType() == typeof(string)))
            throw new Exception("Cannot multiply or divide strings ");
        if (context.MUL_OP == null && Convert.ToInt32(right) == 0)
            throw new Exception("Cannot divide by zero");
        if (left.GetType() == typeof(double) || right.GetType() == typeof(double))
        {
            return context.MUL_OP() != null ? Convert.ToDouble(left) * Convert.ToDouble(right) : Convert.ToDouble(left) / Convert.ToDouble(right);
        }
        if (left.GetType() == typeof(float) || right.GetType() == typeof(float))
        {
            return context.MUL_OP() != null ? Convert.ToSingle(left) * Convert.ToSingle(right) : Convert.ToSingle(left) / Convert.ToSingle(right);
        }
        if (left.GetType() == typeof(int) || right.GetType() == typeof(int))
        {
            return context.MUL_OP() != null ? Convert.ToInt32(left) * Convert.ToInt32(right) : Convert.ToInt32(left) / Convert.ToInt32(right);
        }
        throw new Exception("Type Error: Invalid operands for addition or subtraction.");
    }

    public override object VisitModExpr(BasicLanguageParser.ModExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));

        if (left is int lInt && right is int rInt)
        {
            if (rInt == 0)
            {
                throw new Exception("Runtime Error: Modulo by zero is not allowed.");
            }
            return lInt % rInt;
        }
        throw new Exception("Type Error: Modulo operation only supports integer operands.");
    }
    public override object VisitAddAssignExpr(BasicLanguageParser.AddAssignExprContext context)
    {
        string varName = context.VARIABLE_NAME().GetText();

        object currentValue = scopeStack.Peek().GetVariable(varName);
        object decrementValue = EvaluateExpression(context.expr());

        if (currentValue is int lInt && decrementValue is int rInt)
        {
            scopeStack.Peek().SetVariable(varName, lInt + rInt);
        }
        else if (currentValue is float lFloat && decrementValue is float rFloat)
        {
            scopeStack.Peek().SetVariable(varName, lFloat + rFloat);
        }
        else if (currentValue is double lDouble && decrementValue is double rDouble)
        {
            scopeStack.Peek().SetVariable(varName, lDouble + rDouble);
        }
        else
        {
            throw new Exception($"Type Error: Cannot use -= with incompatible types '{currentValue.GetType().Name}' and '{decrementValue.GetType().Name}'.");
        }

        Console.WriteLine($"Updated {varName} to {scopeStack.Peek().GetVariable(varName)} using '+='.");
        return null;
    }

    public override object VisitSubAssignExpr(BasicLanguageParser.SubAssignExprContext context)
    {
        string varName = context.VARIABLE_NAME().GetText();

        object currentValue = scopeStack.Peek().GetVariable(varName);
        object decrementValue = EvaluateExpression(context.expr());

        if (currentValue is int lInt && decrementValue is int rInt)
        {
            scopeStack.Peek().SetVariable(varName, lInt - rInt);
        }
        else if (currentValue is float lFloat && decrementValue is float rFloat)
        {
            scopeStack.Peek().SetVariable(varName, lFloat - rFloat);
        }
        else if (currentValue is double lDouble && decrementValue is double rDouble)
        {
            scopeStack.Peek().SetVariable(varName, lDouble - rDouble);
        }
        else
        {
            throw new Exception($"Type Error: Cannot use -= with incompatible types '{currentValue.GetType().Name}' and '{decrementValue.GetType().Name}'.");
        }

        Console.WriteLine($"Updated {varName} to {scopeStack.Peek().GetVariable(varName)}  using '+='.");
        return null;
    }

    public override object VisitMulAssignExpr(BasicLanguageParser.MulAssignExprContext context)
    {
        string varName = context.VARIABLE_NAME().GetText();
        object currentValue = scopeStack.Peek().GetVariable(varName);
        object factorValue = EvaluateExpression(context.expr());

        if (currentValue is int lInt && factorValue is int rInt)
        {
            scopeStack.Peek().SetVariable(varName, lInt * rInt);
        }
        else if (currentValue is float lFloat && factorValue is float rFloat)
        {
            scopeStack.Peek().SetVariable(varName, lFloat * rFloat);
        }
        else if (currentValue is double lDouble && factorValue is double rDouble)
        {
            scopeStack.Peek().SetVariable(varName, lDouble * rDouble);
        }
        else
        {
            throw new Exception($"Type Error: Cannot use *= with incompatible types '{currentValue.GetType().Name}' and '{factorValue.GetType().Name}'.");
        }

        Console.WriteLine($"Updated {varName} to {scopeStack.Peek().GetVariable(varName)} using '*='.");
        return null;
    }

    public override object VisitDivAssignExpr(BasicLanguageParser.DivAssignExprContext context)
    {
        string varName = context.VARIABLE_NAME().GetText();

        object currentValue = scopeStack.Peek().GetVariable(varName);
        object divisorValue = EvaluateExpression(context.expr());

        if (divisorValue is int rInt && rInt == 0 || divisorValue is float rFloat && rFloat == 0.0f || divisorValue is double rDouble && rDouble == 0.0)
        {
            throw new Exception("Runtime Error: Division by zero is not allowed.");
        }

        if (currentValue is int lInt && divisorValue is int dInt)
        {
            scopeStack.Peek().SetVariable(varName, lInt / dInt);
        }
        else if (currentValue is float lFloat && divisorValue is float dFloat)
        {
            scopeStack.Peek().SetVariable(varName, lFloat / dFloat);
        }
        else if (currentValue is double lDouble && divisorValue is double dDouble)
        {
            scopeStack.Peek().SetVariable(varName, lDouble / dDouble);
        }
        else
        {
            throw new Exception($"Type Error: Cannot use /= with incompatible types '{currentValue.GetType().Name}' and '{divisorValue.GetType().Name}'.");
        }

        Console.WriteLine($"Updated {varName} to {scopeStack.Peek().GetVariable(varName)}   using '+='.");
        return null;
    }

    public override object VisitModAssignExpr(BasicLanguageParser.ModAssignExprContext context)
    {
        string varName = context.VARIABLE_NAME().GetText();
        object currentValue = scopeStack.Peek().GetVariable(varName);
        object modValue = EvaluateExpression(context.expr());

        if (modValue is int rInt && rInt == 0)
        {
            throw new Exception("Runtime Error: Modulo by zero is not allowed.");
        }

        if (currentValue is int lInt && modValue is int mInt)
        {
            scopeStack.Peek().SetVariable(varName, lInt % mInt);
        }
        else
        {
            throw new Exception($"Type Error: Cannot use %= with incompatible types '{currentValue.GetType().Name}' and '{modValue.GetType().Name}'.");
        }

        Console.WriteLine($"Updated {varName} to {scopeStack.Peek().GetVariable(varName)} using '%='.");
        return null;
    }


    public override object VisitEqExpr(BasicLanguageParser.EqExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));

        if (left.GetType() == typeof(int) && right.GetType() == typeof(int))
        {
            return Convert.ToInt32(left) == Convert.ToInt32(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) == Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) == Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(double))
        {
            return Convert.ToSingle(left) == Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) == Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) == Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(int))
        {
            return Convert.ToSingle(left) == Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) == Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(int))
        {
            return Convert.ToDouble(left) == Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(string) && right.GetType() == typeof(string))
        {
            return Convert.ToString(left) == Convert.ToString(right);
        }

        throw new Exception("Type Error: Invalid operands for equality comparison.");
    }

    public override object VisitNeqExpr(BasicLanguageParser.NeqExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));

        if (left.GetType() == typeof(int) && right.GetType() == typeof(int))
        {
            return Convert.ToInt32(left) != Convert.ToInt32(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) != Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) != Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(double))
        {
            return Convert.ToSingle(left) != Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) != Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) != Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(int))
        {
            return Convert.ToSingle(left) != Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) != Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(int))
        {
            return Convert.ToDouble(left) != Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(string) && right.GetType() == typeof(string))
        {
            return Convert.ToString(left) != Convert.ToString(right);
        }

        throw new Exception("Type Error: Invalid operands for equality comparison.");
    }

    public override object VisitLtExpr(BasicLanguageParser.LtExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));

        if (left.GetType() == typeof(int) && right.GetType() == typeof(int))
        {
            return Convert.ToInt32(left) < Convert.ToInt32(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) < Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) < Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(double))
        {
            return Convert.ToSingle(left) < Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) < Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) < Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(int))
        {
            return Convert.ToSingle(left) < Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) < Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(int))
        {
            return Convert.ToDouble(left) < Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(string) && right.GetType() == typeof(string))
        {
            return Convert.ToString(left).Length < Convert.ToString(right).Length;
        }

        throw new Exception("Type Error: Invalid operands for less than comparison.");
    }


    public override object VisitGtExpr(BasicLanguageParser.GtExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));

        if (left.GetType() == typeof(int) && right.GetType() == typeof(int))
        {
            return Convert.ToInt32(left) > Convert.ToInt32(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) > Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) > Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(double))
        {
            return Convert.ToSingle(left) > Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) > Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) > Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(int))
        {
            return Convert.ToSingle(left) > Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) > Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(int))
        {
            return Convert.ToDouble(left) > Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(string) && right.GetType() == typeof(string))
        {
            return Convert.ToString(left).Length > Convert.ToString(right).Length;
        }

        throw new Exception("Type Error: Invalid operands for greater than comparison.");
    }

    public override object VisitLeqExpr(BasicLanguageParser.LeqExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));

        if (left.GetType() == typeof(int) && right.GetType() == typeof(int))
        {
            return Convert.ToInt32(left) <= Convert.ToInt32(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) <= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) <= Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(double))
        {
            return Convert.ToSingle(left) <= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) <= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) <= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(int))
        {
            return Convert.ToSingle(left) <= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) <= Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(int))
        {
            return Convert.ToDouble(left) <= Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(string) && right.GetType() == typeof(string))
        {
            return Convert.ToString(left).Length <= Convert.ToString(right).Length;
        }

        throw new Exception("Type Error: Invalid operands for less than and egual to comparison.");
    }

    public override object VisitGeqExpr(BasicLanguageParser.GeqExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));

        if (left.GetType() == typeof(int) && right.GetType() == typeof(int))
        {
            return Convert.ToInt32(left) >= Convert.ToInt32(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) >= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) >= Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(double))
        {
            return Convert.ToSingle(left) >= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) >= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(float))
        {
            return Convert.ToSingle(left) >= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(float) && right.GetType() == typeof(int))
        {
            return Convert.ToSingle(left) >= Convert.ToSingle(right);
        }
        else if (left.GetType() == typeof(int) && right.GetType() == typeof(double))
        {
            return Convert.ToDouble(left) >= Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(double) && right.GetType() == typeof(int))
        {
            return Convert.ToDouble(left) >= Convert.ToDouble(right);
        }
        else if (left.GetType() == typeof(string) && right.GetType() == typeof(string))
        {
            return Convert.ToString(left).Length >= Convert.ToString(right).Length;
        }

        throw new Exception("Type Error: Invalid operands for greater than and egual to comparison.");
    }

    public override object VisitAndExpr(BasicLanguageParser.AndExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));

        if (left is bool leftBool && right is bool rightBool)
        {
            return leftBool && rightBool;
        }

        throw new Exception("Type Error: AND operation requires boolean operands.");
    }

    public override object VisitOrExpr(BasicLanguageParser.OrExprContext context)
    {
        object left = EvaluateExpression(context.expr(0));
        object right = EvaluateExpression(context.expr(1));

        if (left is bool leftBool && right is bool rightBool)
        {
            return leftBool || rightBool;
        }

        throw new Exception("Type Error: AND operation requires boolean operands.");
    }

    public override object VisitNotExpr(BasicLanguageParser.NotExprContext context)
    {
        object value = EvaluateExpression(context.expr());

        if (value is bool boolValue)
        {
            return !boolValue;
        }

        throw new Exception("Type Error: NOT operation requires a boolean operand.");
    }
    public override object VisitPostfixIncrementExpr(BasicLanguageParser.PostfixIncrementExprContext context)
    {
        if (context.expr() is BasicLanguageParser.VariableExprContext varExpr)
        {
            string varName = varExpr.GetText();

            object value = scopeStack.Peek().GetVariable(varName);

            if (value is int intValue)
            {
                scopeStack.Peek().SetVariable(varName, intValue + 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return intValue;
            }
            else if (value is float floatValue)
            {
                scopeStack.Peek().SetVariable(varName, floatValue + 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return floatValue;
            }
            else if (value is double doubleValue)
            {
                scopeStack.Peek().SetVariable(varName, doubleValue + 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return doubleValue;
            }
            else
            {
                throw new Exception($"Type Error: Cannot increment non-numeric variable '{varName}'.");
            }
        }

        throw new Exception("Syntax Error: Postfix increment requires a variable.");
    }

    public override object VisitPostfixDecrementExpr(BasicLanguageParser.PostfixDecrementExprContext context)
    {
        if (context.expr() is BasicLanguageParser.VariableExprContext varExpr)
        {
            string varName = varExpr.GetText();
            object value = scopeStack.Peek().GetVariable(varName);

            if (value is int intValue)
            {
                scopeStack.Peek().SetVariable(varName, intValue - 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return intValue;
            }
            else if (value is float floatValue)
            {
                scopeStack.Peek().SetVariable(varName, floatValue - 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return floatValue;
            }
            else if (value is double doubleValue)
            {
                scopeStack.Peek().SetVariable(varName, doubleValue - 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return doubleValue;
            }
            else
            {
                throw new Exception($"Type Error: Cannot increment non-numeric variable '{varName}'.");
            }
        }

        throw new Exception("Syntax Error: Postfix increment requires a variable.");
    }

    public override object VisitPrefixIncrementExpr(BasicLanguageParser.PrefixIncrementExprContext context)
    {
        if (context.expr() is BasicLanguageParser.VariableExprContext varExpr)
        {
            string varName = varExpr.GetText();
            object value = scopeStack.Peek().GetVariable(varName);

            if (value is int intValue)
            {
                scopeStack.Peek().SetVariable(varName, intValue + 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return scopeStack.Peek().GetVariable(varName);
            }
            else if (value is float floatValue)
            {
                scopeStack.Peek().SetVariable(varName, floatValue + 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return scopeStack.Peek().GetVariable(varName);
            }
            else if (value is double doubleValue)
            {
                scopeStack.Peek().SetVariable(varName, doubleValue + 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return scopeStack.Peek().GetVariable(varName);
            }
            else
            {
                throw new Exception($"Type Error: Cannot increment non-numeric variable '{varName}'.");
            }
        }
        throw new Exception("Syntax Error: Prefix increment requires a variable.");
    }


    public override object VisitPrefixDecrementExpr(BasicLanguageParser.PrefixDecrementExprContext context)
    {
        if (context.expr() is BasicLanguageParser.VariableExprContext varExpr)
        {
            string varName = varExpr.GetText();
            object value = scopeStack.Peek().GetVariable(varName);

            if (value is int intValue)
            {
                scopeStack.Peek().SetVariable(varName, intValue - 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return scopeStack.Peek().GetVariable(varName);
            }
            else if (value is float floatValue)
            {
                scopeStack.Peek().SetVariable(varName, floatValue - 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return scopeStack.Peek().GetVariable(varName);
            }
            else if (value is double doubleValue)
            {
                scopeStack.Peek().SetVariable(varName, doubleValue - 1);
                Console.WriteLine($"Variable '{varName}' incremented to {scopeStack.Peek().GetVariable(varName)}");
                return scopeStack.Peek().GetVariable(varName);
            }
            else
            {
                throw new Exception($"Type Error: Cannot increment non-numeric variable '{varName}'.");
            }
        }

        throw new Exception("Syntax Error: Prefix increment requires a variable.");
    }

    public override object VisitBlockStmt(BasicLanguageParser.BlockStmtContext context)
    {
        scopeStack.Push(new Scope(scopeStack.Peek()));
        VisitChildren(context);
        scopeStack.Pop();
        return null;
    }

    public void CallMain()
    {
        scopeStack.Push(new Scope(globalScope));
        returnStack.Push((false, null));
        if (functionDeclarations.ContainsKey("main"))
        {
            foreach (var instruction in functionDeclarations["main"].body)
            {
                Visit(instruction);
            }
        }
        returnStack.Pop();
        scopeStack.Pop();
        return;
    }


    public void PrintGlobalVariables()
    {
        using (StreamWriter writer = new StreamWriter("../../../GlobalVariables.txt", false))
        {
            Dictionary<string, (string type, object value)> globalVariables = globalScope.ReturnAllVariables();
            foreach (var variable in globalVariables)
            {
                writer.WriteLine($"Name: {variable.Key}, Type: {variable.Value.type}, Value: {variable.Value.value}");
            }
        }
    }

    private void PrintLocalVariables(BasicLanguageParser.StatementContext statement, StreamWriter writer)
    {
        var declaration = statement.declaration();
        if (declaration != null)
        {
            string type = declaration.type().GetText();

            for (int i = 0; i < declaration.VARIABLE_NAME().Length; i++)
            {
                string name = declaration.VARIABLE_NAME(i).GetText();
                object value = GetDefaultValue(type);

                if (declaration.expr(i) != null)
                {
                    value = EvaluateExpression(declaration.expr(i));
                }

                writer.WriteLine($"Variable Name: {name}, Variable Type: {type}, Variable Initial Value: {value}");
            }
        }
    }

    private List<(string Type, int Line)> GetControlStructures(ParserRuleContext structure)
    {
        var structures = new List<(string Type, int Line)>();
        foreach (var child in structure.children)
        {
            if (child is BasicLanguageParser.IfStmtContext ifBlock)
            {
                structures.Add(("If Structure", ifBlock.Start.Line));
                var elseBlock = ifBlock.elseStmt();
                if (elseBlock != null)
                {
                    structures.Add(("Else Structure", elseBlock.Start.Line));
                }
            }
            else if (child is BasicLanguageParser.ForStmtContext forBlock)
            {
                structures.Add(("For Structure", forBlock.Start.Line));
            }
            else if (child is BasicLanguageParser.WhileStmtContext whileBlock)
            {
                structures.Add(("While Structure", whileBlock.Start.Line));
            }
            if (child is ParserRuleContext childContext)
            {
                structures.AddRange(GetControlStructures(childContext));
            }
        }
        return structures;
    }

    private bool IsRecursive(string functionName, ParserRuleContext context)
    {
        foreach (var child in context.children)
        {
            if (child is BasicLanguageParser.FunctionCallContext call)
            {
                if (call.VARIABLE_NAME().GetText() == functionName)
                {
                    return true;
                }
            }
            else if (child is ParserRuleContext childContext)
            {
                if (IsRecursive(functionName, childContext))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void PrintFunctionDeclarations()
    {
        using (StreamWriter writer = new StreamWriter("../../../FunctionDeclarations.txt", false))
        {
            foreach (var function in functionDeclarations)
            {
                writer.WriteLine($"Function Name: {function.Key}, Returned Type: {function.Value.returnType} ");
                foreach (var param in function.Value.parameters)
                {
                    writer.WriteLine($"Parameter Type: {param.type}, Parameter Name: {param.name}");
                }
                bool isRecursive = false;
                foreach (var call in function.Value.body)
                {
                    if (IsRecursive(function.Key, call))
                    {
                        isRecursive = true;
                    }
                }
                if (isRecursive)
                {
                    writer.WriteLine($"Function is Recursive");
                }
                else
                {
                    writer.WriteLine($"Function is Iterative");
                }
                foreach (var statement in function.Value.body)
                {
                    PrintLocalVariables(statement, writer);
                }
                foreach (var structure in function.Value.body)
                {
                    List<(string, int)> controlStructures = GetControlStructures(structure);
                    foreach (var controlStructure in controlStructures)
                    {
                        writer.WriteLine(controlStructure);
                    }
                }
                writer.WriteLine("\n");
            }
        }
    }
}

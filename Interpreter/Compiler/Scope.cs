using Antlr4.Runtime.Misc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

public class Scope
{
    private Dictionary<string, (string type, object value)> variables;
    private Scope parent;
    public Scope(Scope parentTemp = null)
    {
        variables = new Dictionary<string, (string, object)>();
        parent = parentTemp;
    }

    public object GetVariable(string name)
    {
        if (variables.ContainsKey(name))
        {
            return variables[name].value;
        }
        if (parent != null)
        {
            return parent.GetVariable(name);
        }
        return null;  
    }

    public bool isFound(string name)
    {
        if (variables.ContainsKey(name))
        {
            return true;
        }
        if (parent != null)
        {
            return parent.isFound(name);
        }
        return false;
    }

    public object SetVariable(string name, object value)
    {
        if (variables.ContainsKey(name))
        {
            object convertedValue = Converter(variables[name].type, value);
            variables[name] = (variables[name].type, convertedValue);
            return variables[name].value;
        }
        if (parent != null)
        {
            return parent.SetVariable(name, value);
        }
        if (!variables.ContainsKey(name))
        {
            throw new Exception($"Error: Variable '{name}' is not declared.");
        }
        return null;
    }

    public object AddVariable(string name, string type, object value)
    {
        if (isFound(name))
        {
            throw new Exception($"Error: Variable '{name}' is already declared in the current scope.");
        }
        variables[name] = (type, Converter(type,value));
        return null;
    }

    public Dictionary<string, (string type, object value)> ReturnAllVariables()
    {
        return variables;
    }

    public static object Converter(string type, object value)
    {
        if (value != null && value is string && type != "string")
        {
            throw new Exception($"Error: Cannot assign {value} to type {type}.");
        }
        if (value != null && value is int && type == "string")
        {
            throw new Exception($"Error: Cannot assign {value} to type {type}.");
        }
        switch (type)
        {
            case "int": return Convert.ToInt32(value);
            case "float": return Convert.ToSingle(value);
            case "double": return Convert.ToDouble(value);
            case "string": return Convert.ToString(value);
        }
        return null;
    }

}


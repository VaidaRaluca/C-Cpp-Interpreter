using Antlr4.Runtime;
using System;
using System.IO;

public class Program
{
    public static void Main(string[] args)
    {
        string code = File.ReadAllText("../../../Input.txt");

        AntlrInputStream inputStream = new AntlrInputStream(code);
        BasicLanguageLexer lexer = new BasicLanguageLexer(inputStream);
        if (File.Exists("../../../LexerError.txt"))
            File.WriteAllText("../../../LexerError.txt", string.Empty);
        lexer.RemoveErrorListeners();
        lexer.AddErrorListener(new LexicalErrorListener("../../../LexerError.txt"));
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        BasicLanguageParser parser = new BasicLanguageParser(commonTokenStream);
        if (File.Exists("../../../ParserError.txt"))
            File.WriteAllText("../../../ParserError.txt", string.Empty);
        parser.RemoveErrorListeners();
        parser.AddErrorListener(new SyntaxErrorListener("../../../ParserError.txt"));
        var context = parser.program();

        MyBasicLanguageVisitor visitor = new MyBasicLanguageVisitor();

        visitor.Visit(context);
        visitor.PrintGlobalVariables();
        visitor.PrintFunctionDeclarations();
        visitor.CallMain();
        List<string> lexicalUnits = new List<string>();
        lexer.Reset();
        IToken token;
        lexicalUnits.Add("+----------------------+-----------------------------+--------+");
        lexicalUnits.Add("|       Token          |           Lexeme            |  Line  |");
        lexicalUnits.Add("+----------------------+-----------------------------+--------+");


        while ((token = lexer.NextToken()).Type != Antlr4.Runtime.TokenConstants.EOF)
        {
            string tokenType = lexer.Vocabulary.GetSymbolicName(token.Type);
            string lexeme = token.Text;
            int line = token.Line;
            lexicalUnits.Add(
                $"| {tokenType,-20} | {lexeme,-27} | {line,-6} |"
            );
        }
        lexicalUnits.Add("+----------------------+-----------------------------+--------+");
        File.WriteAllLines("../../../LexicalUnits.txt", lexicalUnits);


        Console.WriteLine("Code processed successfully!");
    }
}
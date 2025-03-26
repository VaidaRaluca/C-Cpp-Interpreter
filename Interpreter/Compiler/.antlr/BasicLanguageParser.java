// Generated from c:/Users/raluc/FACULTATE/LFC/Compiler/Compiler/BasicLanguage.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BasicLanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTEGER_TYPE=1, FLOAT_TYPE=2, STRING_TYPE=3, DOUBLE_TYPE=4, VOID_TYPE=5, 
		IF_KEYWORD=6, ELSE_KEYWORD=7, WHILE_KEYWORD=8, FOR_KEYWORD=9, RETURN_KEYWORD=10, 
		ADD_OP=11, SUB_OP=12, MUL_OP=13, DIV_OP=14, MOD_OP=15, ASSIGN_OP=16, EQ_OP=17, 
		NEQ_OP=18, LT_OP=19, GT_OP=20, LEQ_OP=21, GEQ_OP=22, AND_OP=23, OR_OP=24, 
		NOT_OP=25, ADD_ASSIGN_OP=26, SUB_ASSIGN_OP=27, MUL_ASSIGN_OP=28, DIV_ASSIGN_OP=29, 
		MOD_ASSIGN_OP=30, INCREMENT_OP=31, DECREMENT_OP=32, LPAREN=33, RPAREN=34, 
		LBRACE=35, RBRACE=36, SEMI=37, COMMA=38, DOT=39, INTEGER_VALUE=40, FLOAT_VALUE=41, 
		STRING_VALUE=42, DOUBLE_VALUE=43, VARIABLE_NAME=44, WS=45, COMMENT=46, 
		LINE_COMMENT=47;
	public static final int
		RULE_program = 0, RULE_returnStmt = 1, RULE_functionDefinition = 2, RULE_parameterList = 3, 
		RULE_parameter = 4, RULE_functionCall = 5, RULE_argumentList = 6, RULE_statement = 7, 
		RULE_blockStmt = 8, RULE_declaration = 9, RULE_type = 10, RULE_value = 11, 
		RULE_assignmentStmt = 12, RULE_exprStmt = 13, RULE_expr = 14, RULE_ifStmt = 15, 
		RULE_elseStmt = 16, RULE_whileStmt = 17, RULE_forStmt = 18, RULE_multiDeclaration = 19, 
		RULE_multiAssignment = 20, RULE_exprList = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "returnStmt", "functionDefinition", "parameterList", "parameter", 
			"functionCall", "argumentList", "statement", "blockStmt", "declaration", 
			"type", "value", "assignmentStmt", "exprStmt", "expr", "ifStmt", "elseStmt", 
			"whileStmt", "forStmt", "multiDeclaration", "multiAssignment", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'string'", "'double'", "'void'", "'if'", "'else'", 
			"'while'", "'for'", "'return'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", 
			"'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'&&'", "'||'", "'!'", 
			"'+='", "'-='", "'*='", "'/='", "'%='", "'++'", "'--'", "'('", "')'", 
			"'{'", "'}'", "';'", "','", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INTEGER_TYPE", "FLOAT_TYPE", "STRING_TYPE", "DOUBLE_TYPE", "VOID_TYPE", 
			"IF_KEYWORD", "ELSE_KEYWORD", "WHILE_KEYWORD", "FOR_KEYWORD", "RETURN_KEYWORD", 
			"ADD_OP", "SUB_OP", "MUL_OP", "DIV_OP", "MOD_OP", "ASSIGN_OP", "EQ_OP", 
			"NEQ_OP", "LT_OP", "GT_OP", "LEQ_OP", "GEQ_OP", "AND_OP", "OR_OP", "NOT_OP", 
			"ADD_ASSIGN_OP", "SUB_ASSIGN_OP", "MUL_ASSIGN_OP", "DIV_ASSIGN_OP", "MOD_ASSIGN_OP", 
			"INCREMENT_OP", "DECREMENT_OP", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"SEMI", "COMMA", "DOT", "INTEGER_VALUE", "FLOAT_VALUE", "STRING_VALUE", 
			"DOUBLE_VALUE", "VARIABLE_NAME", "WS", "COMMENT", "LINE_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "BasicLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BasicLanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(BasicLanguageParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) {
				{
				setState(46);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(44);
					declaration();
					}
					break;
				case 2:
					{
					setState(45);
					functionDefinition();
					}
					break;
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN_KEYWORD() { return getToken(BasicLanguageParser.RETURN_KEYWORD, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitReturnStmt(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(RETURN_KEYWORD);
			setState(54);
			expr(0);
			setState(55);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(BasicLanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BasicLanguageParser.RBRACE, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitFunctionDefinition(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			type();
			setState(58);
			match(VARIABLE_NAME);
			setState(59);
			match(LPAREN);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) {
				{
				setState(60);
				parameterList();
				}
			}

			setState(63);
			match(RPAREN);
			setState(64);
			match(LBRACE);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34099926402942L) != 0)) {
				{
				{
				setState(65);
				statement();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicLanguageParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitParameterList(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			parameter();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(74);
				match(COMMA);
				setState(75);
				parameter();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitParameter(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			type();
			setState(82);
			match(VARIABLE_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(VARIABLE_NAME);
			setState(85);
			match(LPAREN);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34099926401024L) != 0)) {
				{
				setState(86);
				argumentList();
				}
			}

			setState(89);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicLanguageParser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitArgumentList(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			expr(0);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(92);
				match(COMMA);
				setState(93);
				expr(0);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentStmtContext assignmentStmt() {
			return getRuleContext(AssignmentStmtContext.class,0);
		}
		public ExprStmtContext exprStmt() {
			return getRuleContext(ExprStmtContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(104);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				assignmentStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				exprStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				blockStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
				returnStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends ParserRuleContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitBlockStmt(this);
		}
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_blockStmt);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF_KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				ifStmt();
				}
				break;
			case WHILE_KEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				whileStmt();
				}
				break;
			case FOR_KEYWORD:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				forStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(BasicLanguageParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(BasicLanguageParser.VARIABLE_NAME, i);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public List<TerminalNode> ASSIGN_OP() { return getTokens(BasicLanguageParser.ASSIGN_OP); }
		public TerminalNode ASSIGN_OP(int i) {
			return getToken(BasicLanguageParser.ASSIGN_OP, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicLanguageParser.COMMA, i);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			type();
			setState(112);
			match(VARIABLE_NAME);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN_OP) {
				{
				setState(113);
				match(ASSIGN_OP);
				setState(114);
				expr(0);
				}
			}

			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(117);
				match(COMMA);
				setState(118);
				match(VARIABLE_NAME);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN_OP) {
					{
					setState(119);
					match(ASSIGN_OP);
					setState(120);
					expr(0);
					}
				}

				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INTEGER_TYPE() { return getToken(BasicLanguageParser.INTEGER_TYPE, 0); }
		public TerminalNode FLOAT_TYPE() { return getToken(BasicLanguageParser.FLOAT_TYPE, 0); }
		public TerminalNode STRING_TYPE() { return getToken(BasicLanguageParser.STRING_TYPE, 0); }
		public TerminalNode DOUBLE_TYPE() { return getToken(BasicLanguageParser.DOUBLE_TYPE, 0); }
		public TerminalNode VOID_TYPE() { return getToken(BasicLanguageParser.VOID_TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode INTEGER_VALUE() { return getToken(BasicLanguageParser.INTEGER_VALUE, 0); }
		public TerminalNode FLOAT_VALUE() { return getToken(BasicLanguageParser.FLOAT_VALUE, 0); }
		public TerminalNode STRING_VALUE() { return getToken(BasicLanguageParser.STRING_VALUE, 0); }
		public TerminalNode DOUBLE_VALUE() { return getToken(BasicLanguageParser.DOUBLE_VALUE, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16492674416640L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStmtContext extends ParserRuleContext {
		public AssignmentStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStmt; }
	 
		public AssignmentStmtContext() { }
		public void copyFrom(AssignmentStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivAssignExprContext extends AssignmentStmtContext {
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public TerminalNode DIV_ASSIGN_OP() { return getToken(BasicLanguageParser.DIV_ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public DivAssignExprContext(AssignmentStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterDivAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitDivAssignExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModAssignExprContext extends AssignmentStmtContext {
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public TerminalNode MOD_ASSIGN_OP() { return getToken(BasicLanguageParser.MOD_ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public ModAssignExprContext(AssignmentStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterModAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitModAssignExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubAssignExprContext extends AssignmentStmtContext {
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public TerminalNode SUB_ASSIGN_OP() { return getToken(BasicLanguageParser.SUB_ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public SubAssignExprContext(AssignmentStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterSubAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitSubAssignExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulAssignExprContext extends AssignmentStmtContext {
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public TerminalNode MUL_ASSIGN_OP() { return getToken(BasicLanguageParser.MUL_ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public MulAssignExprContext(AssignmentStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterMulAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitMulAssignExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignExprContext extends AssignmentStmtContext {
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public TerminalNode ASSIGN_OP() { return getToken(BasicLanguageParser.ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public AssignExprContext(AssignmentStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitAssignExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddAssignExprContext extends AssignmentStmtContext {
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public TerminalNode ADD_ASSIGN_OP() { return getToken(BasicLanguageParser.ADD_ASSIGN_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public AddAssignExprContext(AssignmentStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterAddAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitAddAssignExpr(this);
		}
	}

	public final AssignmentStmtContext assignmentStmt() throws RecognitionException {
		AssignmentStmtContext _localctx = new AssignmentStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignmentStmt);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new AssignExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(VARIABLE_NAME);
				setState(135);
				match(ASSIGN_OP);
				setState(136);
				expr(0);
				setState(137);
				match(SEMI);
				}
				break;
			case 2:
				_localctx = new AddAssignExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				match(VARIABLE_NAME);
				setState(140);
				match(ADD_ASSIGN_OP);
				setState(141);
				expr(0);
				setState(142);
				match(SEMI);
				}
				break;
			case 3:
				_localctx = new SubAssignExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(144);
				match(VARIABLE_NAME);
				setState(145);
				match(SUB_ASSIGN_OP);
				setState(146);
				expr(0);
				setState(147);
				match(SEMI);
				}
				break;
			case 4:
				_localctx = new MulAssignExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				match(VARIABLE_NAME);
				setState(150);
				match(MUL_ASSIGN_OP);
				setState(151);
				expr(0);
				setState(152);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new DivAssignExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(154);
				match(VARIABLE_NAME);
				setState(155);
				match(DIV_ASSIGN_OP);
				setState(156);
				expr(0);
				setState(157);
				match(SEMI);
				}
				break;
			case 6:
				_localctx = new ModAssignExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
				match(VARIABLE_NAME);
				setState(160);
				match(MOD_ASSIGN_OP);
				setState(161);
				expr(0);
				setState(162);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public ExprStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitExprStmt(this);
		}
	}

	public final ExprStmtContext exprStmt() throws RecognitionException {
		ExprStmtContext _localctx = new ExprStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_exprStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			expr(0);
			setState(167);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrefixIncrementExprContext extends ExprContext {
		public TerminalNode INCREMENT_OP() { return getToken(BasicLanguageParser.INCREMENT_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrefixIncrementExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterPrefixIncrementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitPrefixIncrementExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND_OP() { return getToken(BasicLanguageParser.AND_OP, 0); }
		public AndExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitAndExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeqExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LEQ_OP() { return getToken(BasicLanguageParser.LEQ_OP, 0); }
		public LeqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterLeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitLeqExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixIncrementExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INCREMENT_OP() { return getToken(BasicLanguageParser.INCREMENT_OP, 0); }
		public PostfixIncrementExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterPostfixIncrementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitPostfixIncrementExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatValueExprContext extends ExprContext {
		public TerminalNode FLOAT_VALUE() { return getToken(BasicLanguageParser.FLOAT_VALUE, 0); }
		public FloatValueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterFloatValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitFloatValueExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringValueExprContext extends ExprContext {
		public TerminalNode STRING_VALUE() { return getToken(BasicLanguageParser.STRING_VALUE, 0); }
		public StringValueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterStringValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitStringValueExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GeqExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GEQ_OP() { return getToken(BasicLanguageParser.GEQ_OP, 0); }
		public GeqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterGeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitGeqExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DoubleValueExprContext extends ExprContext {
		public TerminalNode DOUBLE_VALUE() { return getToken(BasicLanguageParser.DOUBLE_VALUE, 0); }
		public DoubleValueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterDoubleValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitDoubleValueExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LtExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT_OP() { return getToken(BasicLanguageParser.LT_OP, 0); }
		public LtExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterLtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitLtExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GtExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GT_OP() { return getToken(BasicLanguageParser.GT_OP, 0); }
		public GtExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterGtExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitGtExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntValueExprContext extends ExprContext {
		public TerminalNode INTEGER_VALUE() { return getToken(BasicLanguageParser.INTEGER_VALUE, 0); }
		public IntValueExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterIntValueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitIntValueExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixDecrementExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DECREMENT_OP() { return getToken(BasicLanguageParser.DECREMENT_OP, 0); }
		public PostfixDecrementExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterPostfixDecrementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitPostfixDecrementExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR_OP() { return getToken(BasicLanguageParser.OR_OP, 0); }
		public OrExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitOrExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrefixDecrementExprContext extends ExprContext {
		public TerminalNode DECREMENT_OP() { return getToken(BasicLanguageParser.DECREMENT_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrefixDecrementExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterPrefixDecrementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitPrefixDecrementExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL_OP() { return getToken(BasicLanguageParser.MUL_OP, 0); }
		public TerminalNode DIV_OP() { return getToken(BasicLanguageParser.DIV_OP, 0); }
		public MulDivExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterMulDivExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitMulDivExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQ_OP() { return getToken(BasicLanguageParser.EQ_OP, 0); }
		public EqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitEqExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NeqExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NEQ_OP() { return getToken(BasicLanguageParser.NEQ_OP, 0); }
		public NeqExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterNeqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitNeqExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallExprContext extends ExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCallExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterFunctionCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitFunctionCallExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableExprContext extends ExprContext {
		public TerminalNode VARIABLE_NAME() { return getToken(BasicLanguageParser.VARIABLE_NAME, 0); }
		public VariableExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterVariableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitVariableExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExprContext extends ExprContext {
		public TerminalNode NOT_OP() { return getToken(BasicLanguageParser.NOT_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitNotExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MOD_OP() { return getToken(BasicLanguageParser.MOD_OP, 0); }
		public ModExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterModExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitModExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitParenExpr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD_OP() { return getToken(BasicLanguageParser.ADD_OP, 0); }
		public TerminalNode SUB_OP() { return getToken(BasicLanguageParser.SUB_OP, 0); }
		public AddSubExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterAddSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitAddSubExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(170);
				match(NOT_OP);
				setState(171);
				expr(12);
				}
				break;
			case 2:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(LPAREN);
				setState(173);
				expr(0);
				setState(174);
				match(RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new PrefixIncrementExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				match(INCREMENT_OP);
				setState(177);
				expr(8);
				}
				break;
			case 4:
				{
				_localctx = new PrefixDecrementExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(DECREMENT_OP);
				setState(179);
				expr(7);
				}
				break;
			case 5:
				{
				_localctx = new IntValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(INTEGER_VALUE);
				}
				break;
			case 6:
				{
				_localctx = new FloatValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(181);
				match(FLOAT_VALUE);
				}
				break;
			case 7:
				{
				_localctx = new DoubleValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(DOUBLE_VALUE);
				}
				break;
			case 8:
				{
				_localctx = new StringValueExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(183);
				match(STRING_VALUE);
				}
				break;
			case 9:
				{
				_localctx = new FunctionCallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				functionCall();
				}
				break;
			case 10:
				{
				_localctx = new VariableExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(185);
				match(VARIABLE_NAME);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(233);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(231);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(189);
						match(MUL_OP);
						setState(190);
						expr(26);
						}
						break;
					case 2:
						{
						_localctx = new MulDivExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(192);
						match(DIV_OP);
						setState(193);
						expr(25);
						}
						break;
					case 3:
						{
						_localctx = new ModExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(194);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(195);
						match(MOD_OP);
						setState(196);
						expr(24);
						}
						break;
					case 4:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(197);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(198);
						match(ADD_OP);
						setState(199);
						expr(23);
						}
						break;
					case 5:
						{
						_localctx = new AddSubExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(200);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(201);
						match(SUB_OP);
						setState(202);
						expr(22);
						}
						break;
					case 6:
						{
						_localctx = new EqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(203);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(204);
						match(EQ_OP);
						setState(205);
						expr(21);
						}
						break;
					case 7:
						{
						_localctx = new NeqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(206);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(207);
						match(NEQ_OP);
						setState(208);
						expr(20);
						}
						break;
					case 8:
						{
						_localctx = new LtExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(209);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(210);
						match(LT_OP);
						setState(211);
						expr(19);
						}
						break;
					case 9:
						{
						_localctx = new GtExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(212);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(213);
						match(GT_OP);
						setState(214);
						expr(18);
						}
						break;
					case 10:
						{
						_localctx = new LeqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(215);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(216);
						match(LEQ_OP);
						setState(217);
						expr(17);
						}
						break;
					case 11:
						{
						_localctx = new GeqExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(218);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(219);
						match(GEQ_OP);
						setState(220);
						expr(16);
						}
						break;
					case 12:
						{
						_localctx = new AndExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(221);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(222);
						match(AND_OP);
						setState(223);
						expr(15);
						}
						break;
					case 13:
						{
						_localctx = new OrExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(224);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(225);
						match(OR_OP);
						setState(226);
						expr(14);
						}
						break;
					case 14:
						{
						_localctx = new PostfixIncrementExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(227);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(228);
						match(INCREMENT_OP);
						}
						break;
					case 15:
						{
						_localctx = new PostfixDecrementExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(230);
						match(DECREMENT_OP);
						}
						break;
					}
					} 
				}
				setState(235);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF_KEYWORD() { return getToken(BasicLanguageParser.IF_KEYWORD, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(BasicLanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BasicLanguageParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStmtContext elseStmt() {
			return getRuleContext(ElseStmtContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(IF_KEYWORD);
			setState(237);
			match(LPAREN);
			setState(238);
			expr(0);
			setState(239);
			match(RPAREN);
			setState(240);
			match(LBRACE);
			setState(242); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(241);
				statement();
				}
				}
				setState(244); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34099926402942L) != 0) );
			setState(246);
			match(RBRACE);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE_KEYWORD) {
				{
				setState(247);
				elseStmt();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStmtContext extends ParserRuleContext {
		public TerminalNode ELSE_KEYWORD() { return getToken(BasicLanguageParser.ELSE_KEYWORD, 0); }
		public TerminalNode LBRACE() { return getToken(BasicLanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BasicLanguageParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitElseStmt(this);
		}
	}

	public final ElseStmtContext elseStmt() throws RecognitionException {
		ElseStmtContext _localctx = new ElseStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(ELSE_KEYWORD);
			setState(251);
			match(LBRACE);
			setState(253); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(252);
				statement();
				}
				}
				setState(255); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34099926402942L) != 0) );
			setState(257);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE_KEYWORD() { return getToken(BasicLanguageParser.WHILE_KEYWORD, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(BasicLanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BasicLanguageParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitWhileStmt(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(WHILE_KEYWORD);
			setState(260);
			match(LPAREN);
			setState(261);
			expr(0);
			setState(262);
			match(RPAREN);
			setState(263);
			match(LBRACE);
			setState(265); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(264);
				statement();
				}
				}
				setState(267); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34099926402942L) != 0) );
			setState(269);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR_KEYWORD() { return getToken(BasicLanguageParser.FOR_KEYWORD, 0); }
		public TerminalNode LPAREN() { return getToken(BasicLanguageParser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(BasicLanguageParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(BasicLanguageParser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(BasicLanguageParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(BasicLanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BasicLanguageParser.RBRACE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MultiDeclarationContext multiDeclaration() {
			return getRuleContext(MultiDeclarationContext.class,0);
		}
		public MultiAssignmentContext multiAssignment() {
			return getRuleContext(MultiAssignmentContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitForStmt(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(FOR_KEYWORD);
			setState(272);
			match(LPAREN);
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER_TYPE:
			case FLOAT_TYPE:
			case STRING_TYPE:
			case DOUBLE_TYPE:
			case VOID_TYPE:
			case VARIABLE_NAME:
				{
				setState(275);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case INTEGER_TYPE:
				case FLOAT_TYPE:
				case STRING_TYPE:
				case DOUBLE_TYPE:
				case VOID_TYPE:
					{
					setState(273);
					multiDeclaration();
					}
					break;
				case VARIABLE_NAME:
					{
					setState(274);
					multiAssignment();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case SEMI:
				{
				setState(277);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34099926401024L) != 0)) {
				{
				setState(280);
				expr(0);
				}
			}

			setState(283);
			match(SEMI);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34099926401024L) != 0)) {
				{
				setState(284);
				exprList();
				}
			}

			setState(287);
			match(RPAREN);
			setState(288);
			match(LBRACE);
			setState(290); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(289);
				statement();
				}
				}
				setState(292); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 34099926402942L) != 0) );
			setState(294);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(BasicLanguageParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(BasicLanguageParser.VARIABLE_NAME, i);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public List<TerminalNode> ASSIGN_OP() { return getTokens(BasicLanguageParser.ASSIGN_OP); }
		public TerminalNode ASSIGN_OP(int i) {
			return getToken(BasicLanguageParser.ASSIGN_OP, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicLanguageParser.COMMA, i);
		}
		public MultiDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterMultiDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitMultiDeclaration(this);
		}
	}

	public final MultiDeclarationContext multiDeclaration() throws RecognitionException {
		MultiDeclarationContext _localctx = new MultiDeclarationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_multiDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			type();
			setState(297);
			match(VARIABLE_NAME);
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN_OP) {
				{
				setState(298);
				match(ASSIGN_OP);
				setState(299);
				expr(0);
				}
			}

			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(302);
				match(COMMA);
				setState(303);
				match(VARIABLE_NAME);
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN_OP) {
					{
					setState(304);
					match(ASSIGN_OP);
					setState(305);
					expr(0);
					}
				}

				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiAssignmentContext extends ParserRuleContext {
		public List<TerminalNode> VARIABLE_NAME() { return getTokens(BasicLanguageParser.VARIABLE_NAME); }
		public TerminalNode VARIABLE_NAME(int i) {
			return getToken(BasicLanguageParser.VARIABLE_NAME, i);
		}
		public List<TerminalNode> ASSIGN_OP() { return getTokens(BasicLanguageParser.ASSIGN_OP); }
		public TerminalNode ASSIGN_OP(int i) {
			return getToken(BasicLanguageParser.ASSIGN_OP, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(BasicLanguageParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BasicLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicLanguageParser.COMMA, i);
		}
		public MultiAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterMultiAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitMultiAssignment(this);
		}
	}

	public final MultiAssignmentContext multiAssignment() throws RecognitionException {
		MultiAssignmentContext _localctx = new MultiAssignmentContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_multiAssignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			match(VARIABLE_NAME);
			setState(316);
			match(ASSIGN_OP);
			setState(317);
			expr(0);
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(318);
				match(COMMA);
				setState(319);
				match(VARIABLE_NAME);
				setState(320);
				match(ASSIGN_OP);
				setState(321);
				expr(0);
				}
				}
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(327);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BasicLanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BasicLanguageParser.COMMA, i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BasicLanguageListener ) ((BasicLanguageListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			expr(0);
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(330);
				match(COMMA);
				setState(331);
				expr(0);
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 25);
		case 1:
			return precpred(_ctx, 24);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 22);
		case 4:
			return precpred(_ctx, 21);
		case 5:
			return precpred(_ctx, 20);
		case 6:
			return precpred(_ctx, 19);
		case 7:
			return precpred(_ctx, 18);
		case 8:
			return precpred(_ctx, 17);
		case 9:
			return precpred(_ctx, 16);
		case 10:
			return precpred(_ctx, 15);
		case 11:
			return precpred(_ctx, 14);
		case 12:
			return precpred(_ctx, 13);
		case 13:
			return precpred(_ctx, 10);
		case 14:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001/\u0152\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0005\u0000/\b\u0000\n\u0000\f\u00002\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002>\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002C\b\u0002\n\u0002\f\u0002"+
		"F\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003M\b\u0003\n\u0003\f\u0003P\t\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005X\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"_\b\u0006\n\u0006\f\u0006b\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007i\b\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0003\bn\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0003\tt\b\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\tz\b\t\u0005\t|\b\t\n\t\f\t\u007f\t\t\u0001\t"+
		"\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00a5\b\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00bb\b\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005"+
		"\u000e\u00e8\b\u000e\n\u000e\f\u000e\u00eb\t\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0004\u000f\u00f3\b\u000f"+
		"\u000b\u000f\f\u000f\u00f4\u0001\u000f\u0001\u000f\u0003\u000f\u00f9\b"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0004\u0010\u00fe\b\u0010\u000b"+
		"\u0010\f\u0010\u00ff\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0004\u0011\u010a\b\u0011\u000b"+
		"\u0011\f\u0011\u010b\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0114\b\u0012\u0001\u0012\u0003\u0012\u0117"+
		"\b\u0012\u0001\u0012\u0003\u0012\u011a\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u011e\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0004\u0012"+
		"\u0123\b\u0012\u000b\u0012\f\u0012\u0124\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u012d\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0133\b\u0013\u0005"+
		"\u0013\u0135\b\u0013\n\u0013\f\u0013\u0138\t\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0005\u0014\u0143\b\u0014\n\u0014\f\u0014\u0146\t\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u014d"+
		"\b\u0015\n\u0015\f\u0015\u0150\t\u0015\u0001\u0015\u0000\u0001\u001c\u0016"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*\u0000\u0002\u0001\u0000\u0001\u0005\u0001\u0000(+"+
		"\u0176\u00000\u0001\u0000\u0000\u0000\u00025\u0001\u0000\u0000\u0000\u0004"+
		"9\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\bQ\u0001\u0000"+
		"\u0000\u0000\nT\u0001\u0000\u0000\u0000\f[\u0001\u0000\u0000\u0000\u000e"+
		"h\u0001\u0000\u0000\u0000\u0010m\u0001\u0000\u0000\u0000\u0012o\u0001"+
		"\u0000\u0000\u0000\u0014\u0082\u0001\u0000\u0000\u0000\u0016\u0084\u0001"+
		"\u0000\u0000\u0000\u0018\u00a4\u0001\u0000\u0000\u0000\u001a\u00a6\u0001"+
		"\u0000\u0000\u0000\u001c\u00ba\u0001\u0000\u0000\u0000\u001e\u00ec\u0001"+
		"\u0000\u0000\u0000 \u00fa\u0001\u0000\u0000\u0000\"\u0103\u0001\u0000"+
		"\u0000\u0000$\u010f\u0001\u0000\u0000\u0000&\u0128\u0001\u0000\u0000\u0000"+
		"(\u013b\u0001\u0000\u0000\u0000*\u0149\u0001\u0000\u0000\u0000,/\u0003"+
		"\u0012\t\u0000-/\u0003\u0004\u0002\u0000.,\u0001\u0000\u0000\u0000.-\u0001"+
		"\u0000\u0000\u0000/2\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u0000"+
		"01\u0001\u0000\u0000\u000013\u0001\u0000\u0000\u000020\u0001\u0000\u0000"+
		"\u000034\u0005\u0000\u0000\u00014\u0001\u0001\u0000\u0000\u000056\u0005"+
		"\n\u0000\u000067\u0003\u001c\u000e\u000078\u0005%\u0000\u00008\u0003\u0001"+
		"\u0000\u0000\u00009:\u0003\u0014\n\u0000:;\u0005,\u0000\u0000;=\u0005"+
		"!\u0000\u0000<>\u0003\u0006\u0003\u0000=<\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0005\"\u0000\u0000@D\u0005"+
		"#\u0000\u0000AC\u0003\u000e\u0007\u0000BA\u0001\u0000\u0000\u0000CF\u0001"+
		"\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000"+
		"EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000GH\u0005$\u0000\u0000"+
		"H\u0005\u0001\u0000\u0000\u0000IN\u0003\b\u0004\u0000JK\u0005&\u0000\u0000"+
		"KM\u0003\b\u0004\u0000LJ\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0007\u0001\u0000"+
		"\u0000\u0000PN\u0001\u0000\u0000\u0000QR\u0003\u0014\n\u0000RS\u0005,"+
		"\u0000\u0000S\t\u0001\u0000\u0000\u0000TU\u0005,\u0000\u0000UW\u0005!"+
		"\u0000\u0000VX\u0003\f\u0006\u0000WV\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0005\"\u0000\u0000Z\u000b\u0001"+
		"\u0000\u0000\u0000[`\u0003\u001c\u000e\u0000\\]\u0005&\u0000\u0000]_\u0003"+
		"\u001c\u000e\u0000^\\\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000"+
		"`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a\r\u0001\u0000\u0000"+
		"\u0000b`\u0001\u0000\u0000\u0000ci\u0003\u0012\t\u0000di\u0003\u0018\f"+
		"\u0000ei\u0003\u001a\r\u0000fi\u0003\u0010\b\u0000gi\u0003\u0002\u0001"+
		"\u0000hc\u0001\u0000\u0000\u0000hd\u0001\u0000\u0000\u0000he\u0001\u0000"+
		"\u0000\u0000hf\u0001\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000i\u000f"+
		"\u0001\u0000\u0000\u0000jn\u0003\u001e\u000f\u0000kn\u0003\"\u0011\u0000"+
		"ln\u0003$\u0012\u0000mj\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000"+
		"ml\u0001\u0000\u0000\u0000n\u0011\u0001\u0000\u0000\u0000op\u0003\u0014"+
		"\n\u0000ps\u0005,\u0000\u0000qr\u0005\u0010\u0000\u0000rt\u0003\u001c"+
		"\u000e\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t}\u0001"+
		"\u0000\u0000\u0000uv\u0005&\u0000\u0000vy\u0005,\u0000\u0000wx\u0005\u0010"+
		"\u0000\u0000xz\u0003\u001c\u000e\u0000yw\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z|\u0001\u0000\u0000\u0000{u\u0001\u0000\u0000\u0000"+
		"|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000"+
		"\u0000\u0000~\u0080\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0005%\u0000\u0000\u0081\u0013\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0007\u0000\u0000\u0000\u0083\u0015\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0007\u0001\u0000\u0000\u0085\u0017\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0005,\u0000\u0000\u0087\u0088\u0005\u0010\u0000\u0000\u0088\u0089"+
		"\u0003\u001c\u000e\u0000\u0089\u008a\u0005%\u0000\u0000\u008a\u00a5\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0005,\u0000\u0000\u008c\u008d\u0005\u001a"+
		"\u0000\u0000\u008d\u008e\u0003\u001c\u000e\u0000\u008e\u008f\u0005%\u0000"+
		"\u0000\u008f\u00a5\u0001\u0000\u0000\u0000\u0090\u0091\u0005,\u0000\u0000"+
		"\u0091\u0092\u0005\u001b\u0000\u0000\u0092\u0093\u0003\u001c\u000e\u0000"+
		"\u0093\u0094\u0005%\u0000\u0000\u0094\u00a5\u0001\u0000\u0000\u0000\u0095"+
		"\u0096\u0005,\u0000\u0000\u0096\u0097\u0005\u001c\u0000\u0000\u0097\u0098"+
		"\u0003\u001c\u000e\u0000\u0098\u0099\u0005%\u0000\u0000\u0099\u00a5\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0005,\u0000\u0000\u009b\u009c\u0005\u001d"+
		"\u0000\u0000\u009c\u009d\u0003\u001c\u000e\u0000\u009d\u009e\u0005%\u0000"+
		"\u0000\u009e\u00a5\u0001\u0000\u0000\u0000\u009f\u00a0\u0005,\u0000\u0000"+
		"\u00a0\u00a1\u0005\u001e\u0000\u0000\u00a1\u00a2\u0003\u001c\u000e\u0000"+
		"\u00a2\u00a3\u0005%\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4"+
		"\u0086\u0001\u0000\u0000\u0000\u00a4\u008b\u0001\u0000\u0000\u0000\u00a4"+
		"\u0090\u0001\u0000\u0000\u0000\u00a4\u0095\u0001\u0000\u0000\u0000\u00a4"+
		"\u009a\u0001\u0000\u0000\u0000\u00a4\u009f\u0001\u0000\u0000\u0000\u00a5"+
		"\u0019\u0001\u0000\u0000\u0000\u00a6\u00a7\u0003\u001c\u000e\u0000\u00a7"+
		"\u00a8\u0005%\u0000\u0000\u00a8\u001b\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0006\u000e\uffff\uffff\u0000\u00aa\u00ab\u0005\u0019\u0000\u0000\u00ab"+
		"\u00bb\u0003\u001c\u000e\f\u00ac\u00ad\u0005!\u0000\u0000\u00ad\u00ae"+
		"\u0003\u001c\u000e\u0000\u00ae\u00af\u0005\"\u0000\u0000\u00af\u00bb\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0005\u001f\u0000\u0000\u00b1\u00bb\u0003"+
		"\u001c\u000e\b\u00b2\u00b3\u0005 \u0000\u0000\u00b3\u00bb\u0003\u001c"+
		"\u000e\u0007\u00b4\u00bb\u0005(\u0000\u0000\u00b5\u00bb\u0005)\u0000\u0000"+
		"\u00b6\u00bb\u0005+\u0000\u0000\u00b7\u00bb\u0005*\u0000\u0000\u00b8\u00bb"+
		"\u0003\n\u0005\u0000\u00b9\u00bb\u0005,\u0000\u0000\u00ba\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ba\u00ac\u0001\u0000\u0000\u0000\u00ba\u00b0\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b2\u0001\u0000\u0000\u0000\u00ba\u00b4\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b5\u0001\u0000\u0000\u0000\u00ba\u00b6\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b7\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00e9\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\n\u0019\u0000\u0000\u00bd\u00be\u0005\r"+
		"\u0000\u0000\u00be\u00e8\u0003\u001c\u000e\u001a\u00bf\u00c0\n\u0018\u0000"+
		"\u0000\u00c0\u00c1\u0005\u000e\u0000\u0000\u00c1\u00e8\u0003\u001c\u000e"+
		"\u0019\u00c2\u00c3\n\u0017\u0000\u0000\u00c3\u00c4\u0005\u000f\u0000\u0000"+
		"\u00c4\u00e8\u0003\u001c\u000e\u0018\u00c5\u00c6\n\u0016\u0000\u0000\u00c6"+
		"\u00c7\u0005\u000b\u0000\u0000\u00c7\u00e8\u0003\u001c\u000e\u0017\u00c8"+
		"\u00c9\n\u0015\u0000\u0000\u00c9\u00ca\u0005\f\u0000\u0000\u00ca\u00e8"+
		"\u0003\u001c\u000e\u0016\u00cb\u00cc\n\u0014\u0000\u0000\u00cc\u00cd\u0005"+
		"\u0011\u0000\u0000\u00cd\u00e8\u0003\u001c\u000e\u0015\u00ce\u00cf\n\u0013"+
		"\u0000\u0000\u00cf\u00d0\u0005\u0012\u0000\u0000\u00d0\u00e8\u0003\u001c"+
		"\u000e\u0014\u00d1\u00d2\n\u0012\u0000\u0000\u00d2\u00d3\u0005\u0013\u0000"+
		"\u0000\u00d3\u00e8\u0003\u001c\u000e\u0013\u00d4\u00d5\n\u0011\u0000\u0000"+
		"\u00d5\u00d6\u0005\u0014\u0000\u0000\u00d6\u00e8\u0003\u001c\u000e\u0012"+
		"\u00d7\u00d8\n\u0010\u0000\u0000\u00d8\u00d9\u0005\u0015\u0000\u0000\u00d9"+
		"\u00e8\u0003\u001c\u000e\u0011\u00da\u00db\n\u000f\u0000\u0000\u00db\u00dc"+
		"\u0005\u0016\u0000\u0000\u00dc\u00e8\u0003\u001c\u000e\u0010\u00dd\u00de"+
		"\n\u000e\u0000\u0000\u00de\u00df\u0005\u0017\u0000\u0000\u00df\u00e8\u0003"+
		"\u001c\u000e\u000f\u00e0\u00e1\n\r\u0000\u0000\u00e1\u00e2\u0005\u0018"+
		"\u0000\u0000\u00e2\u00e8\u0003\u001c\u000e\u000e\u00e3\u00e4\n\n\u0000"+
		"\u0000\u00e4\u00e8\u0005\u001f\u0000\u0000\u00e5\u00e6\n\t\u0000\u0000"+
		"\u00e6\u00e8\u0005 \u0000\u0000\u00e7\u00bc\u0001\u0000\u0000\u0000\u00e7"+
		"\u00bf\u0001\u0000\u0000\u0000\u00e7\u00c2\u0001\u0000\u0000\u0000\u00e7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00e7\u00c8\u0001\u0000\u0000\u0000\u00e7"+
		"\u00cb\u0001\u0000\u0000\u0000\u00e7\u00ce\u0001\u0000\u0000\u0000\u00e7"+
		"\u00d1\u0001\u0000\u0000\u0000\u00e7\u00d4\u0001\u0000\u0000\u0000\u00e7"+
		"\u00d7\u0001\u0000\u0000\u0000\u00e7\u00da\u0001\u0000\u0000\u0000\u00e7"+
		"\u00dd\u0001\u0000\u0000\u0000\u00e7\u00e0\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8"+
		"\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ea\u001d\u0001\u0000\u0000\u0000\u00eb"+
		"\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0006\u0000\u0000\u00ed"+
		"\u00ee\u0005!\u0000\u0000\u00ee\u00ef\u0003\u001c\u000e\u0000\u00ef\u00f0"+
		"\u0005\"\u0000\u0000\u00f0\u00f2\u0005#\u0000\u0000\u00f1\u00f3\u0003"+
		"\u000e\u0007\u0000\u00f2\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f8\u0005"+
		"$\u0000\u0000\u00f7\u00f9\u0003 \u0010\u0000\u00f8\u00f7\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u001f\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0005\u0007\u0000\u0000\u00fb\u00fd\u0005#\u0000\u0000"+
		"\u00fc\u00fe\u0003\u000e\u0007\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000"+
		"\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0101\u0001\u0000\u0000\u0000"+
		"\u0101\u0102\u0005$\u0000\u0000\u0102!\u0001\u0000\u0000\u0000\u0103\u0104"+
		"\u0005\b\u0000\u0000\u0104\u0105\u0005!\u0000\u0000\u0105\u0106\u0003"+
		"\u001c\u000e\u0000\u0106\u0107\u0005\"\u0000\u0000\u0107\u0109\u0005#"+
		"\u0000\u0000\u0108\u010a\u0003\u000e\u0007\u0000\u0109\u0108\u0001\u0000"+
		"\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u0005$\u0000\u0000\u010e#\u0001\u0000\u0000\u0000"+
		"\u010f\u0110\u0005\t\u0000\u0000\u0110\u0116\u0005!\u0000\u0000\u0111"+
		"\u0114\u0003&\u0013\u0000\u0112\u0114\u0003(\u0014\u0000\u0113\u0111\u0001"+
		"\u0000\u0000\u0000\u0113\u0112\u0001\u0000\u0000\u0000\u0114\u0117\u0001"+
		"\u0000\u0000\u0000\u0115\u0117\u0005%\u0000\u0000\u0116\u0113\u0001\u0000"+
		"\u0000\u0000\u0116\u0115\u0001\u0000\u0000\u0000\u0117\u0119\u0001\u0000"+
		"\u0000\u0000\u0118\u011a\u0003\u001c\u000e\u0000\u0119\u0118\u0001\u0000"+
		"\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000"+
		"\u0000\u0000\u011b\u011d\u0005%\u0000\u0000\u011c\u011e\u0003*\u0015\u0000"+
		"\u011d\u011c\u0001\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000"+
		"\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0120\u0005\"\u0000\u0000\u0120"+
		"\u0122\u0005#\u0000\u0000\u0121\u0123\u0003\u000e\u0007\u0000\u0122\u0121"+
		"\u0001\u0000\u0000\u0000\u0123\u0124\u0001\u0000\u0000\u0000\u0124\u0122"+
		"\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000\u0000\u0000\u0125\u0126"+
		"\u0001\u0000\u0000\u0000\u0126\u0127\u0005$\u0000\u0000\u0127%\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0003\u0014\n\u0000\u0129\u012c\u0005,\u0000"+
		"\u0000\u012a\u012b\u0005\u0010\u0000\u0000\u012b\u012d\u0003\u001c\u000e"+
		"\u0000\u012c\u012a\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000"+
		"\u0000\u012d\u0136\u0001\u0000\u0000\u0000\u012e\u012f\u0005&\u0000\u0000"+
		"\u012f\u0132\u0005,\u0000\u0000\u0130\u0131\u0005\u0010\u0000\u0000\u0131"+
		"\u0133\u0003\u001c\u000e\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132"+
		"\u0133\u0001\u0000\u0000\u0000\u0133\u0135\u0001\u0000\u0000\u0000\u0134"+
		"\u012e\u0001\u0000\u0000\u0000\u0135\u0138\u0001\u0000\u0000\u0000\u0136"+
		"\u0134\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000\u0137"+
		"\u0139\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0139"+
		"\u013a\u0005%\u0000\u0000\u013a\'\u0001\u0000\u0000\u0000\u013b\u013c"+
		"\u0005,\u0000\u0000\u013c\u013d\u0005\u0010\u0000\u0000\u013d\u0144\u0003"+
		"\u001c\u000e\u0000\u013e\u013f\u0005&\u0000\u0000\u013f\u0140\u0005,\u0000"+
		"\u0000\u0140\u0141\u0005\u0010\u0000\u0000\u0141\u0143\u0003\u001c\u000e"+
		"\u0000\u0142\u013e\u0001\u0000\u0000\u0000\u0143\u0146\u0001\u0000\u0000"+
		"\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000"+
		"\u0000\u0145\u0147\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000\u0000"+
		"\u0000\u0147\u0148\u0005%\u0000\u0000\u0148)\u0001\u0000\u0000\u0000\u0149"+
		"\u014e\u0003\u001c\u000e\u0000\u014a\u014b\u0005&\u0000\u0000\u014b\u014d"+
		"\u0003\u001c\u000e\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014d\u0150"+
		"\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f"+
		"\u0001\u0000\u0000\u0000\u014f+\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u001e.0=DNW`hmsy}\u00a4\u00ba\u00e7\u00e9\u00f4\u00f8"+
		"\u00ff\u010b\u0113\u0116\u0119\u011d\u0124\u012c\u0132\u0136\u0144\u014e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
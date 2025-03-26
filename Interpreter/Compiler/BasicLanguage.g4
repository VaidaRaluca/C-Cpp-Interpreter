grammar BasicLanguage;

//LEXER
INTEGER_TYPE: 'int';
FLOAT_TYPE: 'float';
STRING_TYPE: 'string';
DOUBLE_TYPE: 'double';
VOID_TYPE: 'void';
IF_KEYWORD: 'if';
ELSE_KEYWORD: 'else';
WHILE_KEYWORD: 'while';
FOR_KEYWORD: 'for';
RETURN_KEYWORD: 'return';

ADD_OP: '+';
SUB_OP: '-';
MUL_OP: '*';
DIV_OP: '/';
MOD_OP: '%';
ASSIGN_OP: '=';
EQ_OP: '==';
NEQ_OP: '!=';
LT_OP: '<';
GT_OP: '>';
LEQ_OP: '<=';
GEQ_OP: '>=';
AND_OP: '&&';
OR_OP: '||';
NOT_OP: '!';
ADD_ASSIGN_OP: '+=';
SUB_ASSIGN_OP: '-=';
MUL_ASSIGN_OP: '*=';
DIV_ASSIGN_OP: '/=';
MOD_ASSIGN_OP: '%=';

INCREMENT_OP: '++';
DECREMENT_OP: '--';

LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
SEMI: ';';
COMMA: ',';
DOT: '.';

INTEGER_VALUE: ('0' | [1-9][0-9]*);
FLOAT_VALUE: ('0' | [1-9][0-9]*) '.' [0-9]+;
STRING_VALUE: '"' (~["\\] | '\\' .)* '"';
DOUBLE_VALUE: FLOAT_VALUE [eE] [+-]? [0-9]+;

VARIABLE_NAME: [a-zA-Z_][a-zA-Z0-9_]*;

WS: [ \t\r\n]+ -> skip;
COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;

//PARSER

program: (declaration | functionDefinition)* EOF;

returnStmt: RETURN_KEYWORD expr SEMI;

functionDefinition:
	type VARIABLE_NAME LPAREN parameterList? RPAREN LBRACE statement* RBRACE;

parameterList: parameter (COMMA parameter)*;
parameter: type VARIABLE_NAME;

functionCall: VARIABLE_NAME LPAREN argumentList? RPAREN;
argumentList: expr (COMMA expr)*;

statement:
	declaration
	| assignmentStmt
	| exprStmt
	| blockStmt
	| returnStmt;

blockStmt: ifStmt | whileStmt | forStmt;

declaration:
	type VARIABLE_NAME (ASSIGN_OP expr)? (
		COMMA VARIABLE_NAME (ASSIGN_OP expr)?
	)* SEMI;

type:
	INTEGER_TYPE
	| FLOAT_TYPE
	| STRING_TYPE
	| DOUBLE_TYPE
	| VOID_TYPE;

value:
	INTEGER_VALUE
	| FLOAT_VALUE
	| STRING_VALUE
	| DOUBLE_VALUE;

assignmentStmt:
	VARIABLE_NAME ASSIGN_OP expr SEMI		# AssignExpr
	| VARIABLE_NAME ADD_ASSIGN_OP expr SEMI	# AddAssignExpr
	| VARIABLE_NAME SUB_ASSIGN_OP expr SEMI	# SubAssignExpr
	| VARIABLE_NAME MUL_ASSIGN_OP expr SEMI	# MulAssignExpr
	| VARIABLE_NAME DIV_ASSIGN_OP expr SEMI	# DivAssignExpr
	| VARIABLE_NAME MOD_ASSIGN_OP expr SEMI	# ModAssignExpr;

exprStmt: expr SEMI;

expr:
	expr MUL_OP expr		# MulDivExpr
	| expr DIV_OP expr		# MulDivExpr
	| expr MOD_OP expr		# ModExpr
	| expr ADD_OP expr		# AddSubExpr
	| expr SUB_OP expr		# AddSubExpr
	| expr EQ_OP expr		# EqExpr
	| expr NEQ_OP expr		# NeqExpr
	| expr LT_OP expr		# LtExpr
	| expr GT_OP expr		# GtExpr
	| expr LEQ_OP expr		# LeqExpr
	| expr GEQ_OP expr		# GeqExpr
	| expr AND_OP expr		# AndExpr
	| expr OR_OP expr		# OrExpr
	| NOT_OP expr			# NotExpr
	| LPAREN expr RPAREN	# ParenExpr
	| expr INCREMENT_OP		# PostfixIncrementExpr
	| expr DECREMENT_OP		# PostfixDecrementExpr
	| INCREMENT_OP expr		# PrefixIncrementExpr
	| DECREMENT_OP expr		# PrefixDecrementExpr
	| INTEGER_VALUE			# IntValueExpr
	| FLOAT_VALUE			# FloatValueExpr
	| DOUBLE_VALUE			# DoubleValueExpr
	| STRING_VALUE			# StringValueExpr
	| functionCall			# functionCallExpr
	| VARIABLE_NAME			# VariableExpr;

ifStmt:
	IF_KEYWORD LPAREN expr RPAREN LBRACE statement+ RBRACE (
		elseStmt
	)?;

elseStmt: ELSE_KEYWORD LBRACE statement+ RBRACE;

whileStmt:
	WHILE_KEYWORD LPAREN expr RPAREN LBRACE statement+ RBRACE;

forStmt:
	FOR_KEYWORD LPAREN (
		(multiDeclaration | multiAssignment)
		| SEMI
	) expr? SEMI exprList? RPAREN LBRACE statement+ RBRACE;

multiDeclaration:
	type VARIABLE_NAME (ASSIGN_OP expr)? (
		COMMA VARIABLE_NAME (ASSIGN_OP expr)?
	)* SEMI;

multiAssignment:
	VARIABLE_NAME ASSIGN_OP expr (
		COMMA VARIABLE_NAME ASSIGN_OP expr
	)* SEMI;

exprList: expr (COMMA expr)*;
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***

***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***
***REMOVED***

// $antlr-format alignTrailingComments true, columnLimit 150, minEmptyLines 1, maxEmptyLinesToKeep 1, reflowComments false, useTab false
// $antlr-format allowShortRulesOnASingleLine false, allowShortBlocksOnASingleLine true, alignSemicolons hanging, alignColons hanging

grammar CSV;

// Parsing Rules

// CSV file structure
csvFile
    : hdr row+ EOF
    ;

hdr
    : row
    ;

row
    : field (';' field)* '\r'? '\n' 
    ;

field
    : rule
    | id
    | question
    | decisionType
    | cardinality
    | range
    | decisionVisibilityCallExpression
    | HEADER
    | IDENTIFIER
    |
    ;

// Parsing Rules for specific elements
id
    : IDENTIFIER
    ;

cardinality
    : DoubleLiteralExpression ':' DoubleLiteralExpression
    ;

// Question
question
    : QUESTION
    ;

expression
    : unaryExpression
    | literalExpression
    | isTaken
    | decisionValueCallExpression
    | binaryExpression
    ;

unaryExpression
    : '!' IDENTIFIER
    | '!' EnumerationLiteralExpression
    ;

range
    : (IDENTIFIER | literalExpression | binaryExpression | cardinality)+ ('|' (IDENTIFIER | literalExpression  | binaryExpression | cardinality)+)+
    | DoubleLiteralExpression '-' DoubleLiteralExpression
    | IDENTIFIER ('-' IDENTIFIER)+ ('|' (IDENTIFIER | literalExpression  | binaryExpression | cardinality)+)
    ;

decisionVisibilityCallExpression
    : expression ( AND | OR | EQUALS | GREATER_THAN | LESS_THAN ) expression
    | expression
    ;

isTaken
    : ISTAKEN LPAREN IDENTIFIER RPAREN
    | ISTAKEN LPAREN expression RPAREN
    ;

decisionValueCallExpression
    : GETVALUE LPAREN IDENTIFIER RPAREN
    | GETVALUE LPAREN expression RPAREN
    ;

binaryExpression
    :  andExpression
    |  orExpression
    |  xorExpression
    |  equalityExpression
    |  greaterThanExpression
    |  lessThanExpression
    |  greaterEqualsExpression
    |  lessEqualsExpression
    ;

andExpression
    : LPAREN expression AND expression RPAREN
    ;

orExpression
    : LPAREN expression OR expression RPAREN
    ;

xorExpression
    : LPAREN expression XOR expression RPAREN
    ;

equalityExpression
    : LPAREN expression EQUALS expression RPAREN
    ;

greaterThanExpression
    : LPAREN expression GREATER_THAN expression RPAREN
    ;

lessThanExpression
    : LPAREN expression LESS_THAN expression RPAREN
    ;

greaterEqualsExpression
    : LPAREN expression GREATER_EQUALS expression RPAREN
    ;

lessEqualsExpression
    : LPAREN expression LESS_EQUALS expression RPAREN
    ;

literalExpression
    : EnumerationLiteralExpression
    | BooleanLiteralExpression
    | StringLiteralExpression
    | DoubleLiteralExpression
    | IDENTIFIER
    ;

decisionType
    : ValueDecision
    | EnumerationDecision
    | BooleanDecision
    | StringDecision
    ;

// Action and Rule Definitions
rule
    : '"' rule '"'
    | rule rule
    | IF LPAREN? expression RPAREN? LBRACE (action ';'?)* RBRACE 
    ;

action
    : valueRestrictionAction
    ;

valueRestrictionAction
    : allows
    | disallows
    | enForce
    ;

allows
    : ALLOW LPAREN IDENTIFIER RPAREN
    | ALLOW LPAREN EnumerationLiteralExpression RPAREN
    ;

disallows
    : DISALLOW LPAREN IDENTIFIER RPAREN
    | DISALLOW LPAREN EnumerationLiteralExpression RPAREN
    ;

enForce
    : enumEnForce
    | booleanEnForce
    | doubleEnForce
    | stringEnForce
    ;

enumEnForce
    : IDENTIFIER SET IDENTIFIER
    ;

stringEnForce
    : IDENTIFIER SET StringLiteralExpression
    ;

booleanEnForce
    : IDENTIFIER SET BooleanLiteralExpression
    ;

doubleEnForce
    : IDENTIFIER SET DoubleLiteralExpression
    ;


// Lexer Rules

QUESTION
    : (~[?\r\n;])+ '?'   // everything except ? or \r or \n or ; followed by a ?
    | 'nothing' // Edge case for empty question
    ;

WS
    : [ ]+ -> skip  
    ;

HEADER : 'Question'
    | 'ID'
    | 'Type'
    | 'Range'
    | 'Cardinality'
    | 'Constraint/Rule'
    | 'Visible/relevant if'
    ;

// Keywords
ALLOW        : 'allow' | 'Allow';
DISALLOW     : 'disAllow' | 'DisAllow';
ISTAKEN      : 'isTaken' | 'IsTaken';
GETVALUE     : 'getValue' | 'GetValue';

// Operators
EQUALS       : '***REMOVED***' ;
GREATER_THAN : '>'  ;
LESS_THAN    : '<'  ;
LESS_EQUALS  : '<=' ;
GREATER_EQUALS : '>=' ;
OR           : '||' ;
AND          : '&&' ;
XOR          : '^'  ;
PIPE         : '|'  ;
SET          : '='  ;
// Delimiters
LPAREN       : '(' ;
RPAREN       : ')' ;
LBRACE       : '{' ;
RBRACE       : '}' ;
COLON        : ':' ;
IF           : 'if' ;


//Literal Expressions
BooleanLiteralExpression
    : TRUE
    | FALSE
    ;
TRUE
    : 'TRUE'
    | 'true'
    ;
FALSE
    : 'FALSE'
    | 'false'
    ;

DoubleLiteralExpression
    : [0-9]+
    | [0-9]+ '.' [0-9]+
    ;

EnumerationLiteralExpression
    : IDENTIFIER '.' IDENTIFIER
    ;

StringLiteralExpression
    : '\'' IDENTIFIER '\''
    ;

// Decision Types
ValueDecision
    : StringDecision
    | NumberDecision
    ;

StringDecision
    : 'String'
    ;

NumberDecision
    : 'Double'
    ;

EnumerationDecision
    : ENUMERATION
    ;
ENUMERATION  
    : 'Enumeration' 
    ;

BooleanDecision
    : 'Boolean'
    ;

IDENTIFIER
    : [a-zA-Z0-9_][a-zA-Z0-9_]*
    | [a-zA-Z_][a-zA-Z-]*
    ; 

/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author David Kowal
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/

parser grammar DoplerParser;

options {tokenVocab = DoplerLexer;}

document
    : jsonDocument
    | csvFile
    ;


// JSON File Structure
jsonDocument
    : LBRACE jsonValue? RBRACE EOF
    ;

jsonValue
    : DQ DOPLER_KEY DQ COLON LBRACE (jsonObject COMMA?)* RBRACE
    | LBRACE RBRACE
    ;

jsonObject
    : DQ id DQ COLON LBRACE (jsonPair COMMA?)* RBRACE
    | LBRACE RBRACE
    ;

jsonPair
    : QUESTION_KEY DQ question DQ
    | DQ TYPE_KEY DQ COLON DQ decisionType DQ
    | DQ RANGE_KEY DQ COLON DQ range DQ
    | DQ CARDINALITY_KEY DQ COLON DQ (cardinality | ) DQ
    | DQ CONSTRAINT_RULE_KEY DQ COLON (rule | DQ DQ | )
    | DQ VISIBLE_RELEVANT_KEY DQ COLON DQ (decisionVisibilityCallExpression | ) DQ
    ;


// Parsing Rules

// CSV file structure
csvFile
    : hdr row+ EOF
    ;

hdr
    : row
    ;

row
    : field (SEMICOLON field)* CR? LF 
    ;

field
    : rule
    | id
    | question
    | decisionType
    | cardinality
    | range
    | decisionVisibilityCallExpression
    | header
    | IDENTIFIER
    |
    ;

header
    : QUESTION_KEY
    | TYPE_KEY
    | RANGE_KEY
    | CARDINALITY_KEY
    | CONSTRAINT_RULE_KEY
    | VISIBLE_RELEVANT_KEY
    ;

// Parsing Rules for specific elements
id
    : IDENTIFIER
    ;

cardinality
    : DoubleLiteralExpression COLON DoubleLiteralExpression
    ;

// Question
question
    : QUESTION
    ;

// Range
range
    : rangeItem (rangeItem)*(PIPE rangeItem (rangeItem)*)+
    | DoubleLiteralExpression MINUS DoubleLiteralExpression
    ;

rangeItem
    : IDENTIFIER
    | specialCharacter
    | expression
    | subrange 
    | cardinality
    | QUESTION
    | header
    ;

specialCharacter
    : RPAREN | LPAREN | LBRACE | RBRACE | COLON | ANPERSAND | PERCENT | COMMA | SPECIAL_CHAR
    ;

subrange
    : expression (( AND | OR | EQUALS | GREATER_THAN | LESS_THAN | LESS_EQUALS | GREATER_EQUALS) expression)*
    ;

// Expressions
expression
    : unaryExpression
    | literalExpression
    | isTaken
    | decisionValueCallExpression
    | binaryExpression
    ;

unaryExpression
    : NOT expression
    | NOT EnumerationLiteralExpression
    ;

decisionVisibilityCallExpression
    : expression (( AND | OR | EQUALS | GREATER_THAN | LESS_THAN ) expression)*
    | expression
    ;

isTaken
    : ISTAKEN LPAREN IDENTIFIER RPAREN
    ;

decisionValueCallExpression
    : GETVALUE LPAREN IDENTIFIER RPAREN
    | IDENTIFIER
    ;

// Binary Expressions
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

// Literal Expressions
literalExpression
    : enumerationLiteralExpression
    | booleanLiteralExpression
    | stringLiteralExpression
    | doubleLiteralExpression
    ;

enumerationLiteralExpression
    : EnumerationLiteralExpression
    ;

booleanLiteralExpression
    : BooleanLiteralExpression
    ;

stringLiteralExpression
    : StringLiteralExpression
    ;

doubleLiteralExpression
    : DoubleLiteralExpression
    ;


// Decision Types
decisionType
    : NumberDecision
    | EnumerationDecision
    | BooleanDecision
    | StringDecision
    ;

// Action and Rule Definitions
rule
    : DQ rule DQ
    | rule rule
    | IF LPAREN? expression RPAREN? LBRACE (action SEMICOLON?)* RBRACE 
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
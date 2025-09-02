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

package edu.kit.dopler.io.antlr.resources;
// Generated from DoplerParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class DoplerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CR=1, LF=2, QUESTION_KEY=3, QUESTION=4, ID_KEY=5, TYPE_KEY=6, RANGE_KEY=7, 
		CARDINALITY_KEY=8, CONSTRAINT_RULE_KEY=9, VISIBLE_RELEVANT_KEY=10, WS_DEFAULT=11, 
		WS_JSON=12, HEADER=13, ALLOW=14, DISALLOW=15, ISTAKEN=16, GETVALUE=17, 
		EQUALS=18, GREATER_THAN=19, LESS_THAN=20, LESS_EQUALS=21, GREATER_EQUALS=22, 
		OR=23, AND=24, XOR=25, PIPE=26, SET=27, NOT=28, MINUS=29, LPAREN=30, RPAREN=31, 
		LBRACE=32, RBRACE=33, COLON=34, IF=35, ANPERSAND=36, PERCENT=37, COMMA=38, 
		SEMICOLON=39, DQ=40, BooleanLiteralExpression=41, TRUE=42, FALSE=43, DoubleLiteralExpression=44, 
		EnumerationLiteralExpression=45, StringLiteralExpression=46, StringDecision=47, 
		NumberDecision=48, EnumerationDecision=49, ENUMERATION=50, BooleanDecision=51, 
		SPECIAL_CHAR=52, IDENTIFIER=53;
	public static final int
		RULE_document = 0, RULE_jsonDocument = 1, RULE_jsonValue = 2, RULE_jsonObject = 3, 
		RULE_jsonPair = 4, RULE_csvFile = 5, RULE_hdr = 6, RULE_row = 7, RULE_field = 8, 
		RULE_id = 9, RULE_cardinality = 10, RULE_question = 11, RULE_range = 12, 
		RULE_rangeItem = 13, RULE_specialCharacter = 14, RULE_subrange = 15, RULE_expression = 16, 
		RULE_unaryExpression = 17, RULE_decisionVisibilityCallExpression = 18, 
		RULE_isTaken = 19, RULE_decisionValueCallExpression = 20, RULE_binaryExpression = 21, 
		RULE_andExpression = 22, RULE_orExpression = 23, RULE_xorExpression = 24, 
		RULE_equalityExpression = 25, RULE_greaterThanExpression = 26, RULE_lessThanExpression = 27, 
		RULE_greaterEqualsExpression = 28, RULE_lessEqualsExpression = 29, RULE_literalExpression = 30, 
		RULE_enumerationLiteralExpression = 31, RULE_booleanLiteralExpression = 32, 
		RULE_stringLiteralExpression = 33, RULE_doubleLiteralExpression = 34, 
		RULE_decisionType = 35, RULE_rule = 36, RULE_action = 37, RULE_valueRestrictionAction = 38, 
		RULE_allows = 39, RULE_disallows = 40, RULE_enForce = 41, RULE_enumEnForce = 42, 
		RULE_stringEnForce = 43, RULE_booleanEnForce = 44, RULE_doubleEnForce = 45;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "jsonDocument", "jsonValue", "jsonObject", "jsonPair", "csvFile", 
			"hdr", "row", "field", "id", "cardinality", "question", "range", "rangeItem", 
			"specialCharacter", "subrange", "expression", "unaryExpression", "decisionVisibilityCallExpression", 
			"isTaken", "decisionValueCallExpression", "binaryExpression", "andExpression", 
			"orExpression", "xorExpression", "equalityExpression", "greaterThanExpression", 
			"lessThanExpression", "greaterEqualsExpression", "lessEqualsExpression", 
			"literalExpression", "enumerationLiteralExpression", "booleanLiteralExpression", 
			"stringLiteralExpression", "doubleLiteralExpression", "decisionType", 
			"rule", "action", "valueRestrictionAction", "allows", "disallows", "enForce", 
			"enumEnForce", "stringEnForce", "booleanEnForce", "doubleEnForce"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'\"Question\":'", null, "'ID'", "'Type'", "'Range'", 
			"'Cardinality'", "'Constraint/Rule'", "'Visible/relevant if'", null, 
			null, null, null, null, null, null, "'=='", "'>'", "'<'", "'<='", "'>='", 
			"'||'", "'&&'", "'^'", "'|'", "'='", "'!'", "'-'", "'('", "')'", "'{'", 
			"'}'", "':'", "'if'", "'&'", "'%'", "','", "';'", "'\"'", null, null, 
			null, null, null, null, "'String'", "'Double'", null, "'Enumeration'", 
			"'Boolean'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CR", "LF", "QUESTION_KEY", "QUESTION", "ID_KEY", "TYPE_KEY", "RANGE_KEY", 
			"CARDINALITY_KEY", "CONSTRAINT_RULE_KEY", "VISIBLE_RELEVANT_KEY", "WS_DEFAULT", 
			"WS_JSON", "HEADER", "ALLOW", "DISALLOW", "ISTAKEN", "GETVALUE", "EQUALS", 
			"GREATER_THAN", "LESS_THAN", "LESS_EQUALS", "GREATER_EQUALS", "OR", "AND", 
			"XOR", "PIPE", "SET", "NOT", "MINUS", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"COLON", "IF", "ANPERSAND", "PERCENT", "COMMA", "SEMICOLON", "DQ", "BooleanLiteralExpression", 
			"TRUE", "FALSE", "DoubleLiteralExpression", "EnumerationLiteralExpression", 
			"StringLiteralExpression", "StringDecision", "NumberDecision", "EnumerationDecision", 
			"ENUMERATION", "BooleanDecision", "SPECIAL_CHAR", "IDENTIFIER"
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
	public String getGrammarFileName() { return "DoplerParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DoplerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public JsonDocumentContext jsonDocument() {
			return getRuleContext(JsonDocumentContext.class,0);
		}
		public CsvFileContext csvFile() {
			return getRuleContext(CsvFileContext.class,0);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				jsonDocument();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				csvFile();
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
	public static class JsonDocumentContext extends ParserRuleContext {
		public JsonValueContext jsonValue() {
			return getRuleContext(JsonValueContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DoplerParser.EOF, 0); }
		public JsonDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterJsonDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitJsonDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitJsonDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonDocumentContext jsonDocument() throws RecognitionException {
		JsonDocumentContext _localctx = new JsonDocumentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_jsonDocument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			jsonValue();
			setState(97);
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
	public static class JsonValueContext extends ParserRuleContext {
		public JsonObjectContext jsonObject() {
			return getRuleContext(JsonObjectContext.class,0);
		}
		public JsonValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterJsonValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitJsonValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitJsonValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonValueContext jsonValue() throws RecognitionException {
		JsonValueContext _localctx = new JsonValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_jsonValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			jsonObject();
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
	public static class JsonObjectContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(DoplerParser.LBRACE, 0); }
		public List<JsonPairContext> jsonPair() {
			return getRuleContexts(JsonPairContext.class);
		}
		public JsonPairContext jsonPair(int i) {
			return getRuleContext(JsonPairContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(DoplerParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DoplerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DoplerParser.COMMA, i);
		}
		public JsonObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonObject; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterJsonObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitJsonObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitJsonObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonObjectContext jsonObject() throws RecognitionException {
		JsonObjectContext _localctx = new JsonObjectContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_jsonObject);
		int _la;
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				match(LBRACE);
				setState(102);
				jsonPair();
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(103);
					match(COMMA);
					setState(104);
					jsonPair();
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(LBRACE);
				setState(113);
				match(RBRACE);
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
	public static class JsonPairContext extends ParserRuleContext {
		public List<TerminalNode> DQ() { return getTokens(DoplerParser.DQ); }
		public TerminalNode DQ(int i) {
			return getToken(DoplerParser.DQ, i);
		}
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(DoplerParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(DoplerParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(DoplerParser.RBRACE, 0); }
		public List<JsonPairContext> jsonPair() {
			return getRuleContexts(JsonPairContext.class);
		}
		public JsonPairContext jsonPair(int i) {
			return getRuleContext(JsonPairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DoplerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DoplerParser.COMMA, i);
		}
		public TerminalNode QUESTION_KEY() { return getToken(DoplerParser.QUESTION_KEY, 0); }
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode ID_KEY() { return getToken(DoplerParser.ID_KEY, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode TYPE_KEY() { return getToken(DoplerParser.TYPE_KEY, 0); }
		public DecisionTypeContext decisionType() {
			return getRuleContext(DecisionTypeContext.class,0);
		}
		public TerminalNode RANGE_KEY() { return getToken(DoplerParser.RANGE_KEY, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode CARDINALITY_KEY() { return getToken(DoplerParser.CARDINALITY_KEY, 0); }
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public TerminalNode CONSTRAINT_RULE_KEY() { return getToken(DoplerParser.CONSTRAINT_RULE_KEY, 0); }
		public RuleContext rule_() {
			return getRuleContext(RuleContext.class,0);
		}
		public TerminalNode VISIBLE_RELEVANT_KEY() { return getToken(DoplerParser.VISIBLE_RELEVANT_KEY, 0); }
		public DecisionVisibilityCallExpressionContext decisionVisibilityCallExpression() {
			return getRuleContext(DecisionVisibilityCallExpressionContext.class,0);
		}
		public JsonPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jsonPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterJsonPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitJsonPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitJsonPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JsonPairContext jsonPair() throws RecognitionException {
		JsonPairContext _localctx = new JsonPairContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_jsonPair);
		int _la;
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(DQ);
				setState(117);
				match(IDENTIFIER);
				setState(118);
				match(DQ);
				setState(119);
				match(COLON);
				setState(120);
				match(LBRACE);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==QUESTION_KEY || _la==DQ) {
					{
					{
					setState(121);
					jsonPair();
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(122);
						match(COMMA);
						}
					}

					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(130);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(QUESTION_KEY);
				setState(132);
				match(DQ);
				setState(133);
				question();
				setState(134);
				match(DQ);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(136);
				match(DQ);
				setState(137);
				match(ID_KEY);
				setState(138);
				match(DQ);
				setState(139);
				match(COLON);
				setState(140);
				match(DQ);
				setState(141);
				id();
				setState(142);
				match(DQ);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				match(DQ);
				setState(145);
				match(TYPE_KEY);
				setState(146);
				match(DQ);
				setState(147);
				match(COLON);
				setState(148);
				match(DQ);
				setState(149);
				decisionType();
				setState(150);
				match(DQ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				match(DQ);
				setState(153);
				match(RANGE_KEY);
				setState(154);
				match(DQ);
				setState(155);
				match(COLON);
				setState(156);
				match(DQ);
				setState(157);
				range();
				setState(158);
				match(DQ);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(160);
				match(DQ);
				setState(161);
				match(CARDINALITY_KEY);
				setState(162);
				match(DQ);
				setState(163);
				match(COLON);
				setState(164);
				match(DQ);
				setState(167);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DoubleLiteralExpression:
					{
					setState(165);
					cardinality();
					}
					break;
				case DQ:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(169);
				match(DQ);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(170);
				match(DQ);
				setState(171);
				match(CONSTRAINT_RULE_KEY);
				setState(172);
				match(DQ);
				setState(173);
				match(COLON);
				setState(178);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(174);
					rule_(0);
					}
					break;
				case 2:
					{
					setState(175);
					match(DQ);
					setState(176);
					match(DQ);
					}
					break;
				case 3:
					{
					}
					break;
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(180);
				match(DQ);
				setState(181);
				match(VISIBLE_RELEVANT_KEY);
				setState(182);
				match(DQ);
				setState(183);
				match(COLON);
				setState(184);
				match(DQ);
				setState(187);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ISTAKEN:
				case GETVALUE:
				case NOT:
				case LPAREN:
				case BooleanLiteralExpression:
				case DoubleLiteralExpression:
				case EnumerationLiteralExpression:
				case StringLiteralExpression:
				case IDENTIFIER:
					{
					setState(185);
					decisionVisibilityCallExpression();
					}
					break;
				case DQ:
					{
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(189);
				match(DQ);
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
	public static class CsvFileContext extends ParserRuleContext {
		public HdrContext hdr() {
			return getRuleContext(HdrContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DoplerParser.EOF, 0); }
		public List<RowContext> row() {
			return getRuleContexts(RowContext.class);
		}
		public RowContext row(int i) {
			return getRuleContext(RowContext.class,i);
		}
		public CsvFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_csvFile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterCsvFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitCsvFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitCsvFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CsvFileContext csvFile() throws RecognitionException {
		CsvFileContext _localctx = new CsvFileContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_csvFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			hdr();
			setState(194); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(193);
				row();
				}
				}
				setState(196); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 16875303658004502L) != 0) );
			setState(198);
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
	public static class HdrContext extends ParserRuleContext {
		public RowContext row() {
			return getRuleContext(RowContext.class,0);
		}
		public HdrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hdr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterHdr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitHdr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitHdr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HdrContext hdr() throws RecognitionException {
		HdrContext _localctx = new HdrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_hdr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			row();
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
	public static class RowContext extends ParserRuleContext {
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public TerminalNode LF() { return getToken(DoplerParser.LF, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(DoplerParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(DoplerParser.SEMICOLON, i);
		}
		public TerminalNode CR() { return getToken(DoplerParser.CR, 0); }
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitRow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			field();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(203);
				match(SEMICOLON);
				setState(204);
				field();
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CR) {
				{
				setState(210);
				match(CR);
				}
			}

			setState(213);
			match(LF);
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
	public static class FieldContext extends ParserRuleContext {
		public RuleContext rule_() {
			return getRuleContext(RuleContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public DecisionTypeContext decisionType() {
			return getRuleContext(DecisionTypeContext.class,0);
		}
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public DecisionVisibilityCallExpressionContext decisionVisibilityCallExpression() {
			return getRuleContext(DecisionVisibilityCallExpressionContext.class,0);
		}
		public TerminalNode HEADER() { return getToken(DoplerParser.HEADER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_field);
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				rule_(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				question();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				decisionType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(219);
				cardinality();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
				range();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(221);
				decisionVisibilityCallExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(222);
				match(HEADER);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(223);
				match(IDENTIFIER);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
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
	public static class IdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(IDENTIFIER);
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
	public static class CardinalityContext extends ParserRuleContext {
		public List<TerminalNode> DoubleLiteralExpression() { return getTokens(DoplerParser.DoubleLiteralExpression); }
		public TerminalNode DoubleLiteralExpression(int i) {
			return getToken(DoplerParser.DoubleLiteralExpression, i);
		}
		public TerminalNode COLON() { return getToken(DoplerParser.COLON, 0); }
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitCardinality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitCardinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cardinality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(DoubleLiteralExpression);
			setState(230);
			match(COLON);
			setState(231);
			match(DoubleLiteralExpression);
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
	public static class QuestionContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(DoplerParser.QUESTION, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(QUESTION);
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
	public static class RangeContext extends ParserRuleContext {
		public List<RangeItemContext> rangeItem() {
			return getRuleContexts(RangeItemContext.class);
		}
		public RangeItemContext rangeItem(int i) {
			return getRuleContext(RangeItemContext.class,i);
		}
		public List<TerminalNode> PIPE() { return getTokens(DoplerParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(DoplerParser.PIPE, i);
		}
		public List<TerminalNode> DoubleLiteralExpression() { return getTokens(DoplerParser.DoubleLiteralExpression); }
		public TerminalNode DoubleLiteralExpression(int i) {
			return getToken(DoplerParser.DoubleLiteralExpression, i);
		}
		public TerminalNode MINUS() { return getToken(DoplerParser.MINUS, 0); }
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_range);
		int _la;
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				rangeItem();
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13636657798651920L) != 0)) {
					{
					{
					setState(236);
					rangeItem();
					}
					}
					setState(241);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(242);
					match(PIPE);
					setState(243);
					rangeItem();
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13636657798651920L) != 0)) {
						{
						{
						setState(244);
						rangeItem();
						}
						}
						setState(249);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(252); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PIPE );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(DoubleLiteralExpression);
				setState(255);
				match(MINUS);
				setState(256);
				match(DoubleLiteralExpression);
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
	public static class RangeItemContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public SpecialCharacterContext specialCharacter() {
			return getRuleContext(SpecialCharacterContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SubrangeContext subrange() {
			return getRuleContext(SubrangeContext.class,0);
		}
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(DoplerParser.QUESTION, 0); }
		public TerminalNode HEADER() { return getToken(DoplerParser.HEADER, 0); }
		public RangeItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterRangeItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitRangeItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitRangeItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeItemContext rangeItem() throws RecognitionException {
		RangeItemContext _localctx = new RangeItemContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_rangeItem);
		try {
			setState(266);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				specialCharacter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(261);
				expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(262);
				subrange();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(263);
				cardinality();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(264);
				match(QUESTION);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(265);
				match(HEADER);
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
	public static class SpecialCharacterContext extends ParserRuleContext {
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(DoplerParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(DoplerParser.RBRACE, 0); }
		public TerminalNode COLON() { return getToken(DoplerParser.COLON, 0); }
		public TerminalNode ANPERSAND() { return getToken(DoplerParser.ANPERSAND, 0); }
		public TerminalNode PERCENT() { return getToken(DoplerParser.PERCENT, 0); }
		public TerminalNode COMMA() { return getToken(DoplerParser.COMMA, 0); }
		public TerminalNode SPECIAL_CHAR() { return getToken(DoplerParser.SPECIAL_CHAR, 0); }
		public SpecialCharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialCharacter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterSpecialCharacter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitSpecialCharacter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitSpecialCharacter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialCharacterContext specialCharacter() throws RecognitionException {
		SpecialCharacterContext _localctx = new SpecialCharacterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_specialCharacter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4504113949704192L) != 0)) ) {
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
	public static class SubrangeContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(DoplerParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(DoplerParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(DoplerParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(DoplerParser.OR, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(DoplerParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(DoplerParser.EQUALS, i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(DoplerParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(DoplerParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(DoplerParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(DoplerParser.LESS_THAN, i);
		}
		public List<TerminalNode> LESS_EQUALS() { return getTokens(DoplerParser.LESS_EQUALS); }
		public TerminalNode LESS_EQUALS(int i) {
			return getToken(DoplerParser.LESS_EQUALS, i);
		}
		public List<TerminalNode> GREATER_EQUALS() { return getTokens(DoplerParser.GREATER_EQUALS); }
		public TerminalNode GREATER_EQUALS(int i) {
			return getToken(DoplerParser.GREATER_EQUALS, i);
		}
		public SubrangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterSubrange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitSubrange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitSubrange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubrangeContext subrange() throws RecognitionException {
		SubrangeContext _localctx = new SubrangeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_subrange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			expression();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 33292288L) != 0)) {
				{
				{
				setState(271);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 33292288L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(272);
				expression();
				}
				}
				setState(277);
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
	public static class ExpressionContext extends ParserRuleContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public LiteralExpressionContext literalExpression() {
			return getRuleContext(LiteralExpressionContext.class,0);
		}
		public IsTakenContext isTaken() {
			return getRuleContext(IsTakenContext.class,0);
		}
		public DecisionValueCallExpressionContext decisionValueCallExpression() {
			return getRuleContext(DecisionValueCallExpressionContext.class,0);
		}
		public BinaryExpressionContext binaryExpression() {
			return getRuleContext(BinaryExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression);
		try {
			setState(283);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				unaryExpression();
				}
				break;
			case BooleanLiteralExpression:
			case DoubleLiteralExpression:
			case EnumerationLiteralExpression:
			case StringLiteralExpression:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				literalExpression();
				}
				break;
			case ISTAKEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				isTaken();
				}
				break;
			case GETVALUE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(281);
				decisionValueCallExpression();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(282);
				binaryExpression();
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
	public static class UnaryExpressionContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(DoplerParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EnumerationLiteralExpression() { return getToken(DoplerParser.EnumerationLiteralExpression, 0); }
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unaryExpression);
		try {
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				match(NOT);
				setState(286);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(NOT);
				setState(288);
				match(EnumerationLiteralExpression);
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
	public static class DecisionVisibilityCallExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(DoplerParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(DoplerParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(DoplerParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(DoplerParser.OR, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(DoplerParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(DoplerParser.EQUALS, i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(DoplerParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(DoplerParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(DoplerParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(DoplerParser.LESS_THAN, i);
		}
		public DecisionVisibilityCallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionVisibilityCallExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterDecisionVisibilityCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitDecisionVisibilityCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitDecisionVisibilityCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecisionVisibilityCallExpressionContext decisionVisibilityCallExpression() throws RecognitionException {
		DecisionVisibilityCallExpressionContext _localctx = new DecisionVisibilityCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_decisionVisibilityCallExpression);
		int _la;
		try {
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(291);
				expression();
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 27000832L) != 0)) {
					{
					{
					setState(292);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 27000832L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(293);
					expression();
					}
					}
					setState(298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				expression();
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
	public static class IsTakenContext extends ParserRuleContext {
		public TerminalNode ISTAKEN() { return getToken(DoplerParser.ISTAKEN, 0); }
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public IsTakenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isTaken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterIsTaken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitIsTaken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitIsTaken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsTakenContext isTaken() throws RecognitionException {
		IsTakenContext _localctx = new IsTakenContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_isTaken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(ISTAKEN);
			setState(303);
			match(LPAREN);
			setState(304);
			match(IDENTIFIER);
			setState(305);
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
	public static class DecisionValueCallExpressionContext extends ParserRuleContext {
		public TerminalNode GETVALUE() { return getToken(DoplerParser.GETVALUE, 0); }
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public DecisionValueCallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionValueCallExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterDecisionValueCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitDecisionValueCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitDecisionValueCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecisionValueCallExpressionContext decisionValueCallExpression() throws RecognitionException {
		DecisionValueCallExpressionContext _localctx = new DecisionValueCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_decisionValueCallExpression);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GETVALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(307);
				match(GETVALUE);
				setState(308);
				match(LPAREN);
				setState(309);
				match(IDENTIFIER);
				setState(310);
				match(RPAREN);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				match(IDENTIFIER);
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
	public static class BinaryExpressionContext extends ParserRuleContext {
		public AndExpressionContext andExpression() {
			return getRuleContext(AndExpressionContext.class,0);
		}
		public OrExpressionContext orExpression() {
			return getRuleContext(OrExpressionContext.class,0);
		}
		public XorExpressionContext xorExpression() {
			return getRuleContext(XorExpressionContext.class,0);
		}
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public GreaterThanExpressionContext greaterThanExpression() {
			return getRuleContext(GreaterThanExpressionContext.class,0);
		}
		public LessThanExpressionContext lessThanExpression() {
			return getRuleContext(LessThanExpressionContext.class,0);
		}
		public GreaterEqualsExpressionContext greaterEqualsExpression() {
			return getRuleContext(GreaterEqualsExpressionContext.class,0);
		}
		public LessEqualsExpressionContext lessEqualsExpression() {
			return getRuleContext(LessEqualsExpressionContext.class,0);
		}
		public BinaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryExpressionContext binaryExpression() throws RecognitionException {
		BinaryExpressionContext _localctx = new BinaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_binaryExpression);
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				andExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				orExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
				xorExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(317);
				equalityExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(318);
				greaterThanExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(319);
				lessThanExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(320);
				greaterEqualsExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(321);
				lessEqualsExpression();
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
	public static class AndExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(DoplerParser.AND, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_andExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(LPAREN);
			setState(325);
			expression();
			setState(326);
			match(AND);
			setState(327);
			expression();
			setState(328);
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
	public static class OrExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(DoplerParser.OR, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_orExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(LPAREN);
			setState(331);
			expression();
			setState(332);
			match(OR);
			setState(333);
			expression();
			setState(334);
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
	public static class XorExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode XOR() { return getToken(DoplerParser.XOR, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public XorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterXorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitXorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitXorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XorExpressionContext xorExpression() throws RecognitionException {
		XorExpressionContext _localctx = new XorExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_xorExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(LPAREN);
			setState(337);
			expression();
			setState(338);
			match(XOR);
			setState(339);
			expression();
			setState(340);
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
	public static class EqualityExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(DoplerParser.EQUALS, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_equalityExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(LPAREN);
			setState(343);
			expression();
			setState(344);
			match(EQUALS);
			setState(345);
			expression();
			setState(346);
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
	public static class GreaterThanExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER_THAN() { return getToken(DoplerParser.GREATER_THAN, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public GreaterThanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterThanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterGreaterThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitGreaterThanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitGreaterThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterThanExpressionContext greaterThanExpression() throws RecognitionException {
		GreaterThanExpressionContext _localctx = new GreaterThanExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_greaterThanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(LPAREN);
			setState(349);
			expression();
			setState(350);
			match(GREATER_THAN);
			setState(351);
			expression();
			setState(352);
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
	public static class LessThanExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LESS_THAN() { return getToken(DoplerParser.LESS_THAN, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public LessThanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessThanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterLessThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitLessThanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitLessThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessThanExpressionContext lessThanExpression() throws RecognitionException {
		LessThanExpressionContext _localctx = new LessThanExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_lessThanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(LPAREN);
			setState(355);
			expression();
			setState(356);
			match(LESS_THAN);
			setState(357);
			expression();
			setState(358);
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
	public static class GreaterEqualsExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER_EQUALS() { return getToken(DoplerParser.GREATER_EQUALS, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public GreaterEqualsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterEqualsExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterGreaterEqualsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitGreaterEqualsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitGreaterEqualsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterEqualsExpressionContext greaterEqualsExpression() throws RecognitionException {
		GreaterEqualsExpressionContext _localctx = new GreaterEqualsExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_greaterEqualsExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(LPAREN);
			setState(361);
			expression();
			setState(362);
			match(GREATER_EQUALS);
			setState(363);
			expression();
			setState(364);
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
	public static class LessEqualsExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LESS_EQUALS() { return getToken(DoplerParser.LESS_EQUALS, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public LessEqualsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessEqualsExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterLessEqualsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitLessEqualsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitLessEqualsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessEqualsExpressionContext lessEqualsExpression() throws RecognitionException {
		LessEqualsExpressionContext _localctx = new LessEqualsExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_lessEqualsExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(LPAREN);
			setState(367);
			expression();
			setState(368);
			match(LESS_EQUALS);
			setState(369);
			expression();
			setState(370);
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
	public static class LiteralExpressionContext extends ParserRuleContext {
		public EnumerationLiteralExpressionContext enumerationLiteralExpression() {
			return getRuleContext(EnumerationLiteralExpressionContext.class,0);
		}
		public BooleanLiteralExpressionContext booleanLiteralExpression() {
			return getRuleContext(BooleanLiteralExpressionContext.class,0);
		}
		public StringLiteralExpressionContext stringLiteralExpression() {
			return getRuleContext(StringLiteralExpressionContext.class,0);
		}
		public DoubleLiteralExpressionContext doubleLiteralExpression() {
			return getRuleContext(DoubleLiteralExpressionContext.class,0);
		}
		public LiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralExpressionContext literalExpression() throws RecognitionException {
		LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_literalExpression);
		try {
			setState(376);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EnumerationLiteralExpression:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				enumerationLiteralExpression();
				}
				break;
			case BooleanLiteralExpression:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				booleanLiteralExpression();
				}
				break;
			case StringLiteralExpression:
				enterOuterAlt(_localctx, 3);
				{
				setState(374);
				stringLiteralExpression();
				}
				break;
			case DoubleLiteralExpression:
				enterOuterAlt(_localctx, 4);
				{
				setState(375);
				doubleLiteralExpression();
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
	public static class EnumerationLiteralExpressionContext extends ParserRuleContext {
		public TerminalNode EnumerationLiteralExpression() { return getToken(DoplerParser.EnumerationLiteralExpression, 0); }
		public EnumerationLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerationLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterEnumerationLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitEnumerationLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitEnumerationLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationLiteralExpressionContext enumerationLiteralExpression() throws RecognitionException {
		EnumerationLiteralExpressionContext _localctx = new EnumerationLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_enumerationLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(EnumerationLiteralExpression);
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
	public static class BooleanLiteralExpressionContext extends ParserRuleContext {
		public TerminalNode BooleanLiteralExpression() { return getToken(DoplerParser.BooleanLiteralExpression, 0); }
		public BooleanLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterBooleanLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitBooleanLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitBooleanLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralExpressionContext booleanLiteralExpression() throws RecognitionException {
		BooleanLiteralExpressionContext _localctx = new BooleanLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_booleanLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(BooleanLiteralExpression);
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
	public static class StringLiteralExpressionContext extends ParserRuleContext {
		public TerminalNode StringLiteralExpression() { return getToken(DoplerParser.StringLiteralExpression, 0); }
		public StringLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterStringLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitStringLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitStringLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralExpressionContext stringLiteralExpression() throws RecognitionException {
		StringLiteralExpressionContext _localctx = new StringLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_stringLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(StringLiteralExpression);
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
	public static class DoubleLiteralExpressionContext extends ParserRuleContext {
		public TerminalNode DoubleLiteralExpression() { return getToken(DoplerParser.DoubleLiteralExpression, 0); }
		public DoubleLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterDoubleLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitDoubleLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitDoubleLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleLiteralExpressionContext doubleLiteralExpression() throws RecognitionException {
		DoubleLiteralExpressionContext _localctx = new DoubleLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_doubleLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(DoubleLiteralExpression);
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
	public static class DecisionTypeContext extends ParserRuleContext {
		public TerminalNode NumberDecision() { return getToken(DoplerParser.NumberDecision, 0); }
		public TerminalNode EnumerationDecision() { return getToken(DoplerParser.EnumerationDecision, 0); }
		public TerminalNode BooleanDecision() { return getToken(DoplerParser.BooleanDecision, 0); }
		public TerminalNode StringDecision() { return getToken(DoplerParser.StringDecision, 0); }
		public DecisionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterDecisionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitDecisionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitDecisionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecisionTypeContext decisionType() throws RecognitionException {
		DecisionTypeContext _localctx = new DecisionTypeContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_decisionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3236962232172544L) != 0)) ) {
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
	public static class RuleContext extends ParserRuleContext {
		public List<TerminalNode> DQ() { return getTokens(DoplerParser.DQ); }
		public TerminalNode DQ(int i) {
			return getToken(DoplerParser.DQ, i);
		}
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public TerminalNode IF() { return getToken(DoplerParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(DoplerParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(DoplerParser.RBRACE, 0); }
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(DoplerParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(DoplerParser.SEMICOLON, i);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RuleContext rule_() throws RecognitionException {
		return rule_(0);
	}

	private RuleContext rule_(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RuleContext _localctx = new RuleContext(_ctx, _parentState);
		RuleContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_rule, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQ:
				{
				setState(389);
				match(DQ);
				setState(390);
				rule_(0);
				setState(391);
				match(DQ);
				}
				break;
			case IF:
				{
				setState(393);
				match(IF);
				setState(395);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(394);
					match(LPAREN);
					}
					break;
				}
				setState(397);
				expression();
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(398);
					match(RPAREN);
					}
				}

				setState(401);
				match(LBRACE);
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199254790144L) != 0)) {
					{
					{
					setState(402);
					action();
					setState(404);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(403);
						match(SEMICOLON);
						}
					}

					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(411);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(419);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RuleContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_rule);
					setState(415);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(416);
					rule_(3);
					}
					} 
				}
				setState(421);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
	public static class ActionContext extends ParserRuleContext {
		public ValueRestrictionActionContext valueRestrictionAction() {
			return getRuleContext(ValueRestrictionActionContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			valueRestrictionAction();
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
	public static class ValueRestrictionActionContext extends ParserRuleContext {
		public AllowsContext allows() {
			return getRuleContext(AllowsContext.class,0);
		}
		public DisallowsContext disallows() {
			return getRuleContext(DisallowsContext.class,0);
		}
		public EnForceContext enForce() {
			return getRuleContext(EnForceContext.class,0);
		}
		public ValueRestrictionActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueRestrictionAction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterValueRestrictionAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitValueRestrictionAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitValueRestrictionAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueRestrictionActionContext valueRestrictionAction() throws RecognitionException {
		ValueRestrictionActionContext _localctx = new ValueRestrictionActionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_valueRestrictionAction);
		try {
			setState(427);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALLOW:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				allows();
				}
				break;
			case DISALLOW:
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
				disallows();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(426);
				enForce();
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
	public static class AllowsContext extends ParserRuleContext {
		public TerminalNode ALLOW() { return getToken(DoplerParser.ALLOW, 0); }
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public TerminalNode EnumerationLiteralExpression() { return getToken(DoplerParser.EnumerationLiteralExpression, 0); }
		public AllowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterAllows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitAllows(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitAllows(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllowsContext allows() throws RecognitionException {
		AllowsContext _localctx = new AllowsContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_allows);
		try {
			setState(437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(429);
				match(ALLOW);
				setState(430);
				match(LPAREN);
				setState(431);
				match(IDENTIFIER);
				setState(432);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(433);
				match(ALLOW);
				setState(434);
				match(LPAREN);
				setState(435);
				match(EnumerationLiteralExpression);
				setState(436);
				match(RPAREN);
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
	public static class DisallowsContext extends ParserRuleContext {
		public TerminalNode DISALLOW() { return getToken(DoplerParser.DISALLOW, 0); }
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public TerminalNode EnumerationLiteralExpression() { return getToken(DoplerParser.EnumerationLiteralExpression, 0); }
		public DisallowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disallows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterDisallows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitDisallows(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitDisallows(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisallowsContext disallows() throws RecognitionException {
		DisallowsContext _localctx = new DisallowsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_disallows);
		try {
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(439);
				match(DISALLOW);
				setState(440);
				match(LPAREN);
				setState(441);
				match(IDENTIFIER);
				setState(442);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(443);
				match(DISALLOW);
				setState(444);
				match(LPAREN);
				setState(445);
				match(EnumerationLiteralExpression);
				setState(446);
				match(RPAREN);
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
	public static class EnForceContext extends ParserRuleContext {
		public EnumEnForceContext enumEnForce() {
			return getRuleContext(EnumEnForceContext.class,0);
		}
		public BooleanEnForceContext booleanEnForce() {
			return getRuleContext(BooleanEnForceContext.class,0);
		}
		public DoubleEnForceContext doubleEnForce() {
			return getRuleContext(DoubleEnForceContext.class,0);
		}
		public StringEnForceContext stringEnForce() {
			return getRuleContext(StringEnForceContext.class,0);
		}
		public EnForceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enForce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnForceContext enForce() throws RecognitionException {
		EnForceContext _localctx = new EnForceContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_enForce);
		try {
			setState(453);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(449);
				enumEnForce();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
				booleanEnForce();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(451);
				doubleEnForce();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(452);
				stringEnForce();
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
	public static class EnumEnForceContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(DoplerParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(DoplerParser.IDENTIFIER, i);
		}
		public TerminalNode SET() { return getToken(DoplerParser.SET, 0); }
		public EnumEnForceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumEnForce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterEnumEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitEnumEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitEnumEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumEnForceContext enumEnForce() throws RecognitionException {
		EnumEnForceContext _localctx = new EnumEnForceContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_enumEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			match(IDENTIFIER);
			setState(456);
			match(SET);
			setState(457);
			match(IDENTIFIER);
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
	public static class StringEnForceContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode SET() { return getToken(DoplerParser.SET, 0); }
		public TerminalNode StringLiteralExpression() { return getToken(DoplerParser.StringLiteralExpression, 0); }
		public StringEnForceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringEnForce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterStringEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitStringEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitStringEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringEnForceContext stringEnForce() throws RecognitionException {
		StringEnForceContext _localctx = new StringEnForceContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_stringEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(IDENTIFIER);
			setState(460);
			match(SET);
			setState(461);
			match(StringLiteralExpression);
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
	public static class BooleanEnForceContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode SET() { return getToken(DoplerParser.SET, 0); }
		public TerminalNode BooleanLiteralExpression() { return getToken(DoplerParser.BooleanLiteralExpression, 0); }
		public BooleanEnForceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanEnForce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterBooleanEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitBooleanEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitBooleanEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanEnForceContext booleanEnForce() throws RecognitionException {
		BooleanEnForceContext _localctx = new BooleanEnForceContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_booleanEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(IDENTIFIER);
			setState(464);
			match(SET);
			setState(465);
			match(BooleanLiteralExpression);
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
	public static class DoubleEnForceContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode SET() { return getToken(DoplerParser.SET, 0); }
		public TerminalNode DoubleLiteralExpression() { return getToken(DoplerParser.DoubleLiteralExpression, 0); }
		public DoubleEnForceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleEnForce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterDoubleEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitDoubleEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DoplerParserVisitor ) return ((DoplerParserVisitor<? extends T>)visitor).visitDoubleEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleEnForceContext doubleEnForce() throws RecognitionException {
		DoubleEnForceContext _localctx = new DoubleEnForceContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_doubleEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			match(IDENTIFIER);
			setState(468);
			match(SET);
			setState(469);
			match(DoubleLiteralExpression);
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
		case 36:
			return rule_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rule_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00015\u01d8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0001\u0000\u0001\u0000\u0003\u0000_\b\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003j\b\u0003\n\u0003\f\u0003m\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003s\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004|\b\u0004\u0005\u0004~\b\u0004\n\u0004\f\u0004\u0081"+
		"\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004\u00a8\b\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004\u00b3\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00bc\b\u0004\u0001"+
		"\u0004\u0003\u0004\u00bf\b\u0004\u0001\u0005\u0001\u0005\u0004\u0005\u00c3"+
		"\b\u0005\u000b\u0005\f\u0005\u00c4\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00ce\b\u0007"+
		"\n\u0007\f\u0007\u00d1\t\u0007\u0001\u0007\u0003\u0007\u00d4\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00e2\b\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0005\f\u00ee"+
		"\b\f\n\f\f\f\u00f1\t\f\u0001\f\u0001\f\u0001\f\u0005\f\u00f6\b\f\n\f\f"+
		"\f\u00f9\t\f\u0004\f\u00fb\b\f\u000b\f\f\f\u00fc\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0102\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u010b\b\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u0112\b\u000f\n\u000f\f\u000f\u0115\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u011c\b\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0122\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0127\b\u0012\n\u0012"+
		"\f\u0012\u012a\t\u0012\u0001\u0012\u0003\u0012\u012d\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0139\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u0143\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0003\u001e\u0179\b\u001e\u0001\u001f\u0001\u001f\u0001 "+
		"\u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0003$\u018c\b$\u0001$\u0001$\u0003$\u0190"+
		"\b$\u0001$\u0001$\u0001$\u0003$\u0195\b$\u0005$\u0197\b$\n$\f$\u019a\t"+
		"$\u0001$\u0001$\u0003$\u019e\b$\u0001$\u0001$\u0005$\u01a2\b$\n$\f$\u01a5"+
		"\t$\u0001%\u0001%\u0001&\u0001&\u0001&\u0003&\u01ac\b&\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u01b6\b\'\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0003(\u01c0\b(\u0001"+
		")\u0001)\u0001)\u0001)\u0003)\u01c6\b)\u0001*\u0001*\u0001*\u0001*\u0001"+
		"+\u0001+\u0001+\u0001+\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0000\u0001H.\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPR"+
		"TVXZ\u0000\u0004\u0003\u0000\u001e\"$&44\u0001\u0000\u0012\u0018\u0002"+
		"\u0000\u0012\u0014\u0017\u0018\u0002\u0000/133\u01ef\u0000^\u0001\u0000"+
		"\u0000\u0000\u0002`\u0001\u0000\u0000\u0000\u0004c\u0001\u0000\u0000\u0000"+
		"\u0006r\u0001\u0000\u0000\u0000\b\u00be\u0001\u0000\u0000\u0000\n\u00c0"+
		"\u0001\u0000\u0000\u0000\f\u00c8\u0001\u0000\u0000\u0000\u000e\u00ca\u0001"+
		"\u0000\u0000\u0000\u0010\u00e1\u0001\u0000\u0000\u0000\u0012\u00e3\u0001"+
		"\u0000\u0000\u0000\u0014\u00e5\u0001\u0000\u0000\u0000\u0016\u00e9\u0001"+
		"\u0000\u0000\u0000\u0018\u0101\u0001\u0000\u0000\u0000\u001a\u010a\u0001"+
		"\u0000\u0000\u0000\u001c\u010c\u0001\u0000\u0000\u0000\u001e\u010e\u0001"+
		"\u0000\u0000\u0000 \u011b\u0001\u0000\u0000\u0000\"\u0121\u0001\u0000"+
		"\u0000\u0000$\u012c\u0001\u0000\u0000\u0000&\u012e\u0001\u0000\u0000\u0000"+
		"(\u0138\u0001\u0000\u0000\u0000*\u0142\u0001\u0000\u0000\u0000,\u0144"+
		"\u0001\u0000\u0000\u0000.\u014a\u0001\u0000\u0000\u00000\u0150\u0001\u0000"+
		"\u0000\u00002\u0156\u0001\u0000\u0000\u00004\u015c\u0001\u0000\u0000\u0000"+
		"6\u0162\u0001\u0000\u0000\u00008\u0168\u0001\u0000\u0000\u0000:\u016e"+
		"\u0001\u0000\u0000\u0000<\u0178\u0001\u0000\u0000\u0000>\u017a\u0001\u0000"+
		"\u0000\u0000@\u017c\u0001\u0000\u0000\u0000B\u017e\u0001\u0000\u0000\u0000"+
		"D\u0180\u0001\u0000\u0000\u0000F\u0182\u0001\u0000\u0000\u0000H\u019d"+
		"\u0001\u0000\u0000\u0000J\u01a6\u0001\u0000\u0000\u0000L\u01ab\u0001\u0000"+
		"\u0000\u0000N\u01b5\u0001\u0000\u0000\u0000P\u01bf\u0001\u0000\u0000\u0000"+
		"R\u01c5\u0001\u0000\u0000\u0000T\u01c7\u0001\u0000\u0000\u0000V\u01cb"+
		"\u0001\u0000\u0000\u0000X\u01cf\u0001\u0000\u0000\u0000Z\u01d3\u0001\u0000"+
		"\u0000\u0000\\_\u0003\u0002\u0001\u0000]_\u0003\n\u0005\u0000^\\\u0001"+
		"\u0000\u0000\u0000^]\u0001\u0000\u0000\u0000_\u0001\u0001\u0000\u0000"+
		"\u0000`a\u0003\u0004\u0002\u0000ab\u0005\u0000\u0000\u0001b\u0003\u0001"+
		"\u0000\u0000\u0000cd\u0003\u0006\u0003\u0000d\u0005\u0001\u0000\u0000"+
		"\u0000ef\u0005 \u0000\u0000fk\u0003\b\u0004\u0000gh\u0005&\u0000\u0000"+
		"hj\u0003\b\u0004\u0000ig\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0001\u0000\u0000"+
		"\u0000mk\u0001\u0000\u0000\u0000no\u0005!\u0000\u0000os\u0001\u0000\u0000"+
		"\u0000pq\u0005 \u0000\u0000qs\u0005!\u0000\u0000re\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000s\u0007\u0001\u0000\u0000\u0000tu\u0005(\u0000"+
		"\u0000uv\u00055\u0000\u0000vw\u0005(\u0000\u0000wx\u0005\"\u0000\u0000"+
		"x\u007f\u0005 \u0000\u0000y{\u0003\b\u0004\u0000z|\u0005&\u0000\u0000"+
		"{z\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|~\u0001\u0000\u0000"+
		"\u0000}y\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f"+
		"}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0082"+
		"\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u00bf"+
		"\u0005!\u0000\u0000\u0083\u0084\u0005\u0003\u0000\u0000\u0084\u0085\u0005"+
		"(\u0000\u0000\u0085\u0086\u0003\u0016\u000b\u0000\u0086\u0087\u0005(\u0000"+
		"\u0000\u0087\u00bf\u0001\u0000\u0000\u0000\u0088\u0089\u0005(\u0000\u0000"+
		"\u0089\u008a\u0005\u0005\u0000\u0000\u008a\u008b\u0005(\u0000\u0000\u008b"+
		"\u008c\u0005\"\u0000\u0000\u008c\u008d\u0005(\u0000\u0000\u008d\u008e"+
		"\u0003\u0012\t\u0000\u008e\u008f\u0005(\u0000\u0000\u008f\u00bf\u0001"+
		"\u0000\u0000\u0000\u0090\u0091\u0005(\u0000\u0000\u0091\u0092\u0005\u0006"+
		"\u0000\u0000\u0092\u0093\u0005(\u0000\u0000\u0093\u0094\u0005\"\u0000"+
		"\u0000\u0094\u0095\u0005(\u0000\u0000\u0095\u0096\u0003F#\u0000\u0096"+
		"\u0097\u0005(\u0000\u0000\u0097\u00bf\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u0005(\u0000\u0000\u0099\u009a\u0005\u0007\u0000\u0000\u009a\u009b\u0005"+
		"(\u0000\u0000\u009b\u009c\u0005\"\u0000\u0000\u009c\u009d\u0005(\u0000"+
		"\u0000\u009d\u009e\u0003\u0018\f\u0000\u009e\u009f\u0005(\u0000\u0000"+
		"\u009f\u00bf\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005(\u0000\u0000\u00a1"+
		"\u00a2\u0005\b\u0000\u0000\u00a2\u00a3\u0005(\u0000\u0000\u00a3\u00a4"+
		"\u0005\"\u0000\u0000\u00a4\u00a7\u0005(\u0000\u0000\u00a5\u00a8\u0003"+
		"\u0014\n\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a9\u00bf\u0005(\u0000\u0000\u00aa\u00ab\u0005(\u0000\u0000"+
		"\u00ab\u00ac\u0005\t\u0000\u0000\u00ac\u00ad\u0005(\u0000\u0000\u00ad"+
		"\u00b2\u0005\"\u0000\u0000\u00ae\u00b3\u0003H$\u0000\u00af\u00b0\u0005"+
		"(\u0000\u0000\u00b0\u00b3\u0005(\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b2\u00ae\u0001\u0000\u0000\u0000\u00b2\u00af\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00bf\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b5\u0005(\u0000\u0000\u00b5\u00b6\u0005\n\u0000\u0000"+
		"\u00b6\u00b7\u0005(\u0000\u0000\u00b7\u00b8\u0005\"\u0000\u0000\u00b8"+
		"\u00bb\u0005(\u0000\u0000\u00b9\u00bc\u0003$\u0012\u0000\u00ba\u00bc\u0001"+
		"\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00ba\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0005"+
		"(\u0000\u0000\u00bet\u0001\u0000\u0000\u0000\u00be\u0083\u0001\u0000\u0000"+
		"\u0000\u00be\u0088\u0001\u0000\u0000\u0000\u00be\u0090\u0001\u0000\u0000"+
		"\u0000\u00be\u0098\u0001\u0000\u0000\u0000\u00be\u00a0\u0001\u0000\u0000"+
		"\u0000\u00be\u00aa\u0001\u0000\u0000\u0000\u00be\u00b4\u0001\u0000\u0000"+
		"\u0000\u00bf\t\u0001\u0000\u0000\u0000\u00c0\u00c2\u0003\f\u0006\u0000"+
		"\u00c1\u00c3\u0003\u000e\u0007\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0005\u0000\u0000\u0001\u00c7\u000b\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c9\u0003\u000e\u0007\u0000\u00c9\r\u0001\u0000\u0000\u0000\u00ca"+
		"\u00cf\u0003\u0010\b\u0000\u00cb\u00cc\u0005\'\u0000\u0000\u00cc\u00ce"+
		"\u0003\u0010\b\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001"+
		"\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d4\u0005\u0001\u0000\u0000\u00d3\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0005\u0002\u0000\u0000\u00d6\u000f\u0001"+
		"\u0000\u0000\u0000\u00d7\u00e2\u0003H$\u0000\u00d8\u00e2\u0003\u0012\t"+
		"\u0000\u00d9\u00e2\u0003\u0016\u000b\u0000\u00da\u00e2\u0003F#\u0000\u00db"+
		"\u00e2\u0003\u0014\n\u0000\u00dc\u00e2\u0003\u0018\f\u0000\u00dd\u00e2"+
		"\u0003$\u0012\u0000\u00de\u00e2\u0005\r\u0000\u0000\u00df\u00e2\u0005"+
		"5\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1\u00d7\u0001\u0000"+
		"\u0000\u0000\u00e1\u00d8\u0001\u0000\u0000\u0000\u00e1\u00d9\u0001\u0000"+
		"\u0000\u0000\u00e1\u00da\u0001\u0000\u0000\u0000\u00e1\u00db\u0001\u0000"+
		"\u0000\u0000\u00e1\u00dc\u0001\u0000\u0000\u0000\u00e1\u00dd\u0001\u0000"+
		"\u0000\u0000\u00e1\u00de\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000"+
		"\u0000\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e2\u0011\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e4\u00055\u0000\u0000\u00e4\u0013\u0001\u0000\u0000"+
		"\u0000\u00e5\u00e6\u0005,\u0000\u0000\u00e6\u00e7\u0005\"\u0000\u0000"+
		"\u00e7\u00e8\u0005,\u0000\u0000\u00e8\u0015\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0005\u0004\u0000\u0000\u00ea\u0017\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ef\u0003\u001a\r\u0000\u00ec\u00ee\u0003\u001a\r\u0000\u00ed\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00fa"+
		"\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0005\u001a\u0000\u0000\u00f3\u00f7\u0003\u001a\r\u0000\u00f4\u00f6\u0003"+
		"\u001a\r\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000"+
		"\u0000\u0000\u00fa\u00f2\u0001\u0000\u0000\u0000\u00fb\u00fc\u0001\u0000"+
		"\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000"+
		"\u0000\u0000\u00fd\u0102\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005,\u0000"+
		"\u0000\u00ff\u0100\u0005\u001d\u0000\u0000\u0100\u0102\u0005,\u0000\u0000"+
		"\u0101\u00eb\u0001\u0000\u0000\u0000\u0101\u00fe\u0001\u0000\u0000\u0000"+
		"\u0102\u0019\u0001\u0000\u0000\u0000\u0103\u010b\u00055\u0000\u0000\u0104"+
		"\u010b\u0003\u001c\u000e\u0000\u0105\u010b\u0003 \u0010\u0000\u0106\u010b"+
		"\u0003\u001e\u000f\u0000\u0107\u010b\u0003\u0014\n\u0000\u0108\u010b\u0005"+
		"\u0004\u0000\u0000\u0109\u010b\u0005\r\u0000\u0000\u010a\u0103\u0001\u0000"+
		"\u0000\u0000\u010a\u0104\u0001\u0000\u0000\u0000\u010a\u0105\u0001\u0000"+
		"\u0000\u0000\u010a\u0106\u0001\u0000\u0000\u0000\u010a\u0107\u0001\u0000"+
		"\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u0109\u0001\u0000"+
		"\u0000\u0000\u010b\u001b\u0001\u0000\u0000\u0000\u010c\u010d\u0007\u0000"+
		"\u0000\u0000\u010d\u001d\u0001\u0000\u0000\u0000\u010e\u0113\u0003 \u0010"+
		"\u0000\u010f\u0110\u0007\u0001\u0000\u0000\u0110\u0112\u0003 \u0010\u0000"+
		"\u0111\u010f\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000\u0000\u0000"+
		"\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000"+
		"\u0114\u001f\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"+
		"\u0116\u011c\u0003\"\u0011\u0000\u0117\u011c\u0003<\u001e\u0000\u0118"+
		"\u011c\u0003&\u0013\u0000\u0119\u011c\u0003(\u0014\u0000\u011a\u011c\u0003"+
		"*\u0015\u0000\u011b\u0116\u0001\u0000\u0000\u0000\u011b\u0117\u0001\u0000"+
		"\u0000\u0000\u011b\u0118\u0001\u0000\u0000\u0000\u011b\u0119\u0001\u0000"+
		"\u0000\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c!\u0001\u0000\u0000"+
		"\u0000\u011d\u011e\u0005\u001c\u0000\u0000\u011e\u0122\u0003 \u0010\u0000"+
		"\u011f\u0120\u0005\u001c\u0000\u0000\u0120\u0122\u0005-\u0000\u0000\u0121"+
		"\u011d\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0122"+
		"#\u0001\u0000\u0000\u0000\u0123\u0128\u0003 \u0010\u0000\u0124\u0125\u0007"+
		"\u0002\u0000\u0000\u0125\u0127\u0003 \u0010\u0000\u0126\u0124\u0001\u0000"+
		"\u0000\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u012d\u0001\u0000"+
		"\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012d\u0003 \u0010"+
		"\u0000\u012c\u0123\u0001\u0000\u0000\u0000\u012c\u012b\u0001\u0000\u0000"+
		"\u0000\u012d%\u0001\u0000\u0000\u0000\u012e\u012f\u0005\u0010\u0000\u0000"+
		"\u012f\u0130\u0005\u001e\u0000\u0000\u0130\u0131\u00055\u0000\u0000\u0131"+
		"\u0132\u0005\u001f\u0000\u0000\u0132\'\u0001\u0000\u0000\u0000\u0133\u0134"+
		"\u0005\u0011\u0000\u0000\u0134\u0135\u0005\u001e\u0000\u0000\u0135\u0136"+
		"\u00055\u0000\u0000\u0136\u0139\u0005\u001f\u0000\u0000\u0137\u0139\u0005"+
		"5\u0000\u0000\u0138\u0133\u0001\u0000\u0000\u0000\u0138\u0137\u0001\u0000"+
		"\u0000\u0000\u0139)\u0001\u0000\u0000\u0000\u013a\u0143\u0003,\u0016\u0000"+
		"\u013b\u0143\u0003.\u0017\u0000\u013c\u0143\u00030\u0018\u0000\u013d\u0143"+
		"\u00032\u0019\u0000\u013e\u0143\u00034\u001a\u0000\u013f\u0143\u00036"+
		"\u001b\u0000\u0140\u0143\u00038\u001c\u0000\u0141\u0143\u0003:\u001d\u0000"+
		"\u0142\u013a\u0001\u0000\u0000\u0000\u0142\u013b\u0001\u0000\u0000\u0000"+
		"\u0142\u013c\u0001\u0000\u0000\u0000\u0142\u013d\u0001\u0000\u0000\u0000"+
		"\u0142\u013e\u0001\u0000\u0000\u0000\u0142\u013f\u0001\u0000\u0000\u0000"+
		"\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0141\u0001\u0000\u0000\u0000"+
		"\u0143+\u0001\u0000\u0000\u0000\u0144\u0145\u0005\u001e\u0000\u0000\u0145"+
		"\u0146\u0003 \u0010\u0000\u0146\u0147\u0005\u0018\u0000\u0000\u0147\u0148"+
		"\u0003 \u0010\u0000\u0148\u0149\u0005\u001f\u0000\u0000\u0149-\u0001\u0000"+
		"\u0000\u0000\u014a\u014b\u0005\u001e\u0000\u0000\u014b\u014c\u0003 \u0010"+
		"\u0000\u014c\u014d\u0005\u0017\u0000\u0000\u014d\u014e\u0003 \u0010\u0000"+
		"\u014e\u014f\u0005\u001f\u0000\u0000\u014f/\u0001\u0000\u0000\u0000\u0150"+
		"\u0151\u0005\u001e\u0000\u0000\u0151\u0152\u0003 \u0010\u0000\u0152\u0153"+
		"\u0005\u0019\u0000\u0000\u0153\u0154\u0003 \u0010\u0000\u0154\u0155\u0005"+
		"\u001f\u0000\u0000\u01551\u0001\u0000\u0000\u0000\u0156\u0157\u0005\u001e"+
		"\u0000\u0000\u0157\u0158\u0003 \u0010\u0000\u0158\u0159\u0005\u0012\u0000"+
		"\u0000\u0159\u015a\u0003 \u0010\u0000\u015a\u015b\u0005\u001f\u0000\u0000"+
		"\u015b3\u0001\u0000\u0000\u0000\u015c\u015d\u0005\u001e\u0000\u0000\u015d"+
		"\u015e\u0003 \u0010\u0000\u015e\u015f\u0005\u0013\u0000\u0000\u015f\u0160"+
		"\u0003 \u0010\u0000\u0160\u0161\u0005\u001f\u0000\u0000\u01615\u0001\u0000"+
		"\u0000\u0000\u0162\u0163\u0005\u001e\u0000\u0000\u0163\u0164\u0003 \u0010"+
		"\u0000\u0164\u0165\u0005\u0014\u0000\u0000\u0165\u0166\u0003 \u0010\u0000"+
		"\u0166\u0167\u0005\u001f\u0000\u0000\u01677\u0001\u0000\u0000\u0000\u0168"+
		"\u0169\u0005\u001e\u0000\u0000\u0169\u016a\u0003 \u0010\u0000\u016a\u016b"+
		"\u0005\u0016\u0000\u0000\u016b\u016c\u0003 \u0010\u0000\u016c\u016d\u0005"+
		"\u001f\u0000\u0000\u016d9\u0001\u0000\u0000\u0000\u016e\u016f\u0005\u001e"+
		"\u0000\u0000\u016f\u0170\u0003 \u0010\u0000\u0170\u0171\u0005\u0015\u0000"+
		"\u0000\u0171\u0172\u0003 \u0010\u0000\u0172\u0173\u0005\u001f\u0000\u0000"+
		"\u0173;\u0001\u0000\u0000\u0000\u0174\u0179\u0003>\u001f\u0000\u0175\u0179"+
		"\u0003@ \u0000\u0176\u0179\u0003B!\u0000\u0177\u0179\u0003D\"\u0000\u0178"+
		"\u0174\u0001\u0000\u0000\u0000\u0178\u0175\u0001\u0000\u0000\u0000\u0178"+
		"\u0176\u0001\u0000\u0000\u0000\u0178\u0177\u0001\u0000\u0000\u0000\u0179"+
		"=\u0001\u0000\u0000\u0000\u017a\u017b\u0005-\u0000\u0000\u017b?\u0001"+
		"\u0000\u0000\u0000\u017c\u017d\u0005)\u0000\u0000\u017dA\u0001\u0000\u0000"+
		"\u0000\u017e\u017f\u0005.\u0000\u0000\u017fC\u0001\u0000\u0000\u0000\u0180"+
		"\u0181\u0005,\u0000\u0000\u0181E\u0001\u0000\u0000\u0000\u0182\u0183\u0007"+
		"\u0003\u0000\u0000\u0183G\u0001\u0000\u0000\u0000\u0184\u0185\u0006$\uffff"+
		"\uffff\u0000\u0185\u0186\u0005(\u0000\u0000\u0186\u0187\u0003H$\u0000"+
		"\u0187\u0188\u0005(\u0000\u0000\u0188\u019e\u0001\u0000\u0000\u0000\u0189"+
		"\u018b\u0005#\u0000\u0000\u018a\u018c\u0005\u001e\u0000\u0000\u018b\u018a"+
		"\u0001\u0000\u0000\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u018d"+
		"\u0001\u0000\u0000\u0000\u018d\u018f\u0003 \u0010\u0000\u018e\u0190\u0005"+
		"\u001f\u0000\u0000\u018f\u018e\u0001\u0000\u0000\u0000\u018f\u0190\u0001"+
		"\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0191\u0198\u0005"+
		" \u0000\u0000\u0192\u0194\u0003J%\u0000\u0193\u0195\u0005\'\u0000\u0000"+
		"\u0194\u0193\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000"+
		"\u0195\u0197\u0001\u0000\u0000\u0000\u0196\u0192\u0001\u0000\u0000\u0000"+
		"\u0197\u019a\u0001\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000"+
		"\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u019b\u0001\u0000\u0000\u0000"+
		"\u019a\u0198\u0001\u0000\u0000\u0000\u019b\u019c\u0005!\u0000\u0000\u019c"+
		"\u019e\u0001\u0000\u0000\u0000\u019d\u0184\u0001\u0000\u0000\u0000\u019d"+
		"\u0189\u0001\u0000\u0000\u0000\u019e\u01a3\u0001\u0000\u0000\u0000\u019f"+
		"\u01a0\n\u0002\u0000\u0000\u01a0\u01a2\u0003H$\u0003\u01a1\u019f\u0001"+
		"\u0000\u0000\u0000\u01a2\u01a5\u0001\u0000\u0000\u0000\u01a3\u01a1\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4I\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6\u01a7\u0003L&\u0000"+
		"\u01a7K\u0001\u0000\u0000\u0000\u01a8\u01ac\u0003N\'\u0000\u01a9\u01ac"+
		"\u0003P(\u0000\u01aa\u01ac\u0003R)\u0000\u01ab\u01a8\u0001\u0000\u0000"+
		"\u0000\u01ab\u01a9\u0001\u0000\u0000\u0000\u01ab\u01aa\u0001\u0000\u0000"+
		"\u0000\u01acM\u0001\u0000\u0000\u0000\u01ad\u01ae\u0005\u000e\u0000\u0000"+
		"\u01ae\u01af\u0005\u001e\u0000\u0000\u01af\u01b0\u00055\u0000\u0000\u01b0"+
		"\u01b6\u0005\u001f\u0000\u0000\u01b1\u01b2\u0005\u000e\u0000\u0000\u01b2"+
		"\u01b3\u0005\u001e\u0000\u0000\u01b3\u01b4\u0005-\u0000\u0000\u01b4\u01b6"+
		"\u0005\u001f\u0000\u0000\u01b5\u01ad\u0001\u0000\u0000\u0000\u01b5\u01b1"+
		"\u0001\u0000\u0000\u0000\u01b6O\u0001\u0000\u0000\u0000\u01b7\u01b8\u0005"+
		"\u000f\u0000\u0000\u01b8\u01b9\u0005\u001e\u0000\u0000\u01b9\u01ba\u0005"+
		"5\u0000\u0000\u01ba\u01c0\u0005\u001f\u0000\u0000\u01bb\u01bc\u0005\u000f"+
		"\u0000\u0000\u01bc\u01bd\u0005\u001e\u0000\u0000\u01bd\u01be\u0005-\u0000"+
		"\u0000\u01be\u01c0\u0005\u001f\u0000\u0000\u01bf\u01b7\u0001\u0000\u0000"+
		"\u0000\u01bf\u01bb\u0001\u0000\u0000\u0000\u01c0Q\u0001\u0000\u0000\u0000"+
		"\u01c1\u01c6\u0003T*\u0000\u01c2\u01c6\u0003X,\u0000\u01c3\u01c6\u0003"+
		"Z-\u0000\u01c4\u01c6\u0003V+\u0000\u01c5\u01c1\u0001\u0000\u0000\u0000"+
		"\u01c5\u01c2\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000"+
		"\u01c5\u01c4\u0001\u0000\u0000\u0000\u01c6S\u0001\u0000\u0000\u0000\u01c7"+
		"\u01c8\u00055\u0000\u0000\u01c8\u01c9\u0005\u001b\u0000\u0000\u01c9\u01ca"+
		"\u00055\u0000\u0000\u01caU\u0001\u0000\u0000\u0000\u01cb\u01cc\u00055"+
		"\u0000\u0000\u01cc\u01cd\u0005\u001b\u0000\u0000\u01cd\u01ce\u0005.\u0000"+
		"\u0000\u01ceW\u0001\u0000\u0000\u0000\u01cf\u01d0\u00055\u0000\u0000\u01d0"+
		"\u01d1\u0005\u001b\u0000\u0000\u01d1\u01d2\u0005)\u0000\u0000\u01d2Y\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u00055\u0000\u0000\u01d4\u01d5\u0005\u001b"+
		"\u0000\u0000\u01d5\u01d6\u0005,\u0000\u0000\u01d6[\u0001\u0000\u0000\u0000"+
		"$^kr{\u007f\u00a7\u00b2\u00bb\u00be\u00c4\u00cf\u00d3\u00e1\u00ef\u00f7"+
		"\u00fc\u0101\u010a\u0113\u011b\u0121\u0128\u012c\u0138\u0142\u0178\u018b"+
		"\u018f\u0194\u0198\u019d\u01a3\u01ab\u01b5\u01bf\u01c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
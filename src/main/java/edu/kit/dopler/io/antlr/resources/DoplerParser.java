// Generated from DoplerParser.g4 by ANTLR 4.13.2
package edu.kit.dopler.io.antlr.resources;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class DoplerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CR=1, LF=2, QUESTION_KEY=3, QUESTION=4, TYPE_KEY=5, RANGE_KEY=6, CARDINALITY_KEY=7, 
		CONSTRAINT_RULE_KEY=8, VISIBLE_RELEVANT_KEY=9, DOPLER_KEY=10, WS_DEFAULT=11, 
		WS_JSON=12, ALLOW=13, DISALLOW=14, ISTAKEN=15, GETVALUE=16, EQUALS=17, 
		GREATER_THAN=18, LESS_THAN=19, LESS_EQUALS=20, GREATER_EQUALS=21, OR=22, 
		AND=23, XOR=24, PIPE=25, SET=26, NOT=27, MINUS=28, LPAREN=29, RPAREN=30, 
		LBRACE=31, RBRACE=32, COLON=33, IF=34, ANPERSAND=35, PERCENT=36, COMMA=37, 
		SEMICOLON=38, DQ=39, BooleanLiteralExpression=40, TRUE=41, FALSE=42, DoubleLiteralExpression=43, 
		EnumerationLiteralExpression=44, StringLiteralExpression=45, StringDecision=46, 
		NumberDecision=47, EnumerationDecision=48, ENUMERATION=49, BooleanDecision=50, 
		SPECIAL_CHAR=51, IDENTIFIER=52;
	public static final int
		RULE_document = 0, RULE_jsonDocument = 1, RULE_jsonValue = 2, RULE_jsonObject = 3, 
		RULE_jsonPair = 4, RULE_csvFile = 5, RULE_hdr = 6, RULE_row = 7, RULE_field = 8, 
		RULE_header = 9, RULE_id = 10, RULE_cardinality = 11, RULE_question = 12, 
		RULE_range = 13, RULE_rangeItem = 14, RULE_specialCharacter = 15, RULE_subrange = 16, 
		RULE_expression = 17, RULE_decisionVisibilityCallExpression = 18, RULE_literalExpression = 19, 
		RULE_enumerationLiteralExpression = 20, RULE_booleanLiteralExpression = 21, 
		RULE_stringLiteralExpression = 22, RULE_doubleLiteralExpression = 23, 
		RULE_decisionType = 24, RULE_drule = 25, RULE_action = 26, RULE_valueRestrictionAction = 27, 
		RULE_allows = 28, RULE_disallows = 29, RULE_enForce = 30, RULE_enumEnForce = 31, 
		RULE_stringEnForce = 32, RULE_booleanEnForce = 33, RULE_doubleEnForce = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "jsonDocument", "jsonValue", "jsonObject", "jsonPair", "csvFile", 
			"hdr", "row", "field", "header", "id", "cardinality", "question", "range", 
			"rangeItem", "specialCharacter", "subrange", "expression", "decisionVisibilityCallExpression", 
			"literalExpression", "enumerationLiteralExpression", "booleanLiteralExpression", 
			"stringLiteralExpression", "doubleLiteralExpression", "decisionType", 
			"drule", "action", "valueRestrictionAction", "allows", "disallows", "enForce", 
			"enumEnForce", "stringEnForce", "booleanEnForce", "doubleEnForce"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'\"Question\":'", null, "'Type'", "'Range'", "'Cardinality'", 
			"'Constraint/Rule'", "'Visible/relevant if'", "'DOPLER'", null, null, 
			null, null, null, null, "'=='", "'>'", "'<'", "'<='", "'>='", "'||'", 
			"'&&'", "'^'", "'|'", "'='", "'!'", "'-'", "'('", "')'", "'{'", "'}'", 
			"':'", "'if'", "'&'", "'%'", "','", "';'", "'\"'", null, null, null, 
			null, null, null, "'String'", "'Double'", null, "'Enumeration'", "'Boolean'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CR", "LF", "QUESTION_KEY", "QUESTION", "TYPE_KEY", "RANGE_KEY", 
			"CARDINALITY_KEY", "CONSTRAINT_RULE_KEY", "VISIBLE_RELEVANT_KEY", "DOPLER_KEY", 
			"WS_DEFAULT", "WS_JSON", "ALLOW", "DISALLOW", "ISTAKEN", "GETVALUE", 
			"EQUALS", "GREATER_THAN", "LESS_THAN", "LESS_EQUALS", "GREATER_EQUALS", 
			"OR", "AND", "XOR", "PIPE", "SET", "NOT", "MINUS", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "COLON", "IF", "ANPERSAND", "PERCENT", "COMMA", "SEMICOLON", 
			"DQ", "BooleanLiteralExpression", "TRUE", "FALSE", "DoubleLiteralExpression", 
			"EnumerationLiteralExpression", "StringLiteralExpression", "StringDecision", 
			"NumberDecision", "EnumerationDecision", "ENUMERATION", "BooleanDecision", 
			"SPECIAL_CHAR", "IDENTIFIER"
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
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				jsonDocument();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
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
		public TerminalNode LBRACE() { return getToken(DoplerParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(DoplerParser.RBRACE, 0); }
		public TerminalNode EOF() { return getToken(DoplerParser.EOF, 0); }
		public JsonValueContext jsonValue() {
			return getRuleContext(JsonValueContext.class,0);
		}
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
	}

	public final JsonDocumentContext jsonDocument() throws RecognitionException {
		JsonDocumentContext _localctx = new JsonDocumentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_jsonDocument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(LBRACE);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE || _la==DQ) {
				{
				setState(75);
				jsonValue();
				}
			}

			setState(78);
			match(RBRACE);
			setState(79);
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
		public List<TerminalNode> DQ() { return getTokens(DoplerParser.DQ); }
		public TerminalNode DQ(int i) {
			return getToken(DoplerParser.DQ, i);
		}
		public TerminalNode DOPLER_KEY() { return getToken(DoplerParser.DOPLER_KEY, 0); }
		public TerminalNode COLON() { return getToken(DoplerParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(DoplerParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(DoplerParser.RBRACE, 0); }
		public List<JsonObjectContext> jsonObject() {
			return getRuleContexts(JsonObjectContext.class);
		}
		public JsonObjectContext jsonObject(int i) {
			return getRuleContext(JsonObjectContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DoplerParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DoplerParser.COMMA, i);
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
	}

	public final JsonValueContext jsonValue() throws RecognitionException {
		JsonValueContext _localctx = new JsonValueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_jsonValue);
		int _la;
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(DQ);
				setState(82);
				match(DOPLER_KEY);
				setState(83);
				match(DQ);
				setState(84);
				match(COLON);
				setState(85);
				match(LBRACE);
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACE || _la==DQ) {
					{
					{
					setState(86);
					jsonObject();
					setState(88);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(87);
						match(COMMA);
						}
					}

					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(95);
				match(RBRACE);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(LBRACE);
				setState(97);
				match(RBRACE);
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
	public static class JsonObjectContext extends ParserRuleContext {
		public List<TerminalNode> DQ() { return getTokens(DoplerParser.DQ); }
		public TerminalNode DQ(int i) {
			return getToken(DoplerParser.DQ, i);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
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
	}

	public final JsonObjectContext jsonObject() throws RecognitionException {
		JsonObjectContext _localctx = new JsonObjectContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_jsonObject);
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(DQ);
				setState(101);
				id();
				setState(102);
				match(DQ);
				setState(103);
				match(COLON);
				setState(104);
				match(LBRACE);
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==QUESTION_KEY || _la==DQ) {
					{
					{
					setState(105);
					jsonPair();
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(106);
						match(COMMA);
						}
					}

					}
					}
					setState(113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(114);
				match(RBRACE);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(LBRACE);
				setState(117);
				match(RBRACE);
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
	public static class JsonPairContext extends ParserRuleContext {
		public TerminalNode QUESTION_KEY() { return getToken(DoplerParser.QUESTION_KEY, 0); }
		public List<TerminalNode> DQ() { return getTokens(DoplerParser.DQ); }
		public TerminalNode DQ(int i) {
			return getToken(DoplerParser.DQ, i);
		}
		public QuestionContext question() {
			return getRuleContext(QuestionContext.class,0);
		}
		public TerminalNode TYPE_KEY() { return getToken(DoplerParser.TYPE_KEY, 0); }
		public TerminalNode COLON() { return getToken(DoplerParser.COLON, 0); }
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
		public DruleContext drule() {
			return getRuleContext(DruleContext.class,0);
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
	}

	public final JsonPairContext jsonPair() throws RecognitionException {
		JsonPairContext _localctx = new JsonPairContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_jsonPair);
		try {
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(QUESTION_KEY);
				setState(121);
				match(DQ);
				setState(126);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(122);
					question();
					}
					break;
				case 2:
					{
					setState(123);
					match(DQ);
					setState(124);
					match(DQ);
					}
					break;
				case 3:
					{
					}
					break;
				}
				setState(128);
				match(DQ);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(DQ);
				setState(130);
				match(TYPE_KEY);
				setState(131);
				match(DQ);
				setState(132);
				match(COLON);
				setState(133);
				match(DQ);
				setState(138);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(134);
					decisionType();
					}
					break;
				case 2:
					{
					setState(135);
					match(DQ);
					setState(136);
					match(DQ);
					}
					break;
				case 3:
					{
					}
					break;
				}
				setState(140);
				match(DQ);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				match(DQ);
				setState(142);
				match(RANGE_KEY);
				setState(143);
				match(DQ);
				setState(144);
				match(COLON);
				setState(145);
				match(DQ);
				setState(150);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(146);
					range();
					}
					break;
				case 2:
					{
					setState(147);
					match(DQ);
					setState(148);
					match(DQ);
					}
					break;
				case 3:
					{
					}
					break;
				}
				setState(152);
				match(DQ);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				match(DQ);
				setState(154);
				match(CARDINALITY_KEY);
				setState(155);
				match(DQ);
				setState(156);
				match(COLON);
				setState(157);
				match(DQ);
				setState(162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(158);
					cardinality();
					}
					break;
				case 2:
					{
					setState(159);
					match(DQ);
					setState(160);
					match(DQ);
					}
					break;
				case 3:
					{
					}
					break;
				}
				setState(164);
				match(DQ);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(165);
				match(DQ);
				setState(166);
				match(CONSTRAINT_RULE_KEY);
				setState(167);
				match(DQ);
				setState(168);
				match(COLON);
				setState(173);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(169);
					drule(0);
					}
					break;
				case 2:
					{
					setState(170);
					match(DQ);
					setState(171);
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
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(175);
				match(DQ);
				setState(176);
				match(VISIBLE_RELEVANT_KEY);
				setState(177);
				match(DQ);
				setState(178);
				match(COLON);
				setState(179);
				match(DQ);
				setState(184);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(180);
					decisionVisibilityCallExpression();
					}
					break;
				case 2:
					{
					setState(181);
					match(DQ);
					setState(182);
					match(DQ);
					}
					break;
				case 3:
					{
					}
					break;
				}
				setState(186);
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
	}

	public final CsvFileContext csvFile() throws RecognitionException {
		CsvFileContext _localctx = new CsvFileContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_csvFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			hdr();
			setState(191); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(190);
				row();
				}
				}
				setState(193); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8437651828999166L) != 0) );
			setState(195);
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
	}

	public final HdrContext hdr() throws RecognitionException {
		HdrContext _localctx = new HdrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_hdr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
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
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			field();
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMICOLON) {
				{
				{
				setState(200);
				match(SEMICOLON);
				setState(201);
				field();
				}
				}
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CR) {
				{
				setState(207);
				match(CR);
				}
			}

			setState(210);
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
		public DruleContext drule() {
			return getRuleContext(DruleContext.class,0);
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
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
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
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_field);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				drule(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(213);
				id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(214);
				question();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(215);
				decisionType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(216);
				cardinality();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(217);
				range();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(218);
				decisionVisibilityCallExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(219);
				header();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(220);
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
	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode QUESTION_KEY() { return getToken(DoplerParser.QUESTION_KEY, 0); }
		public TerminalNode TYPE_KEY() { return getToken(DoplerParser.TYPE_KEY, 0); }
		public TerminalNode RANGE_KEY() { return getToken(DoplerParser.RANGE_KEY, 0); }
		public TerminalNode CARDINALITY_KEY() { return getToken(DoplerParser.CARDINALITY_KEY, 0); }
		public TerminalNode CONSTRAINT_RULE_KEY() { return getToken(DoplerParser.CONSTRAINT_RULE_KEY, 0); }
		public TerminalNode VISIBLE_RELEVANT_KEY() { return getToken(DoplerParser.VISIBLE_RELEVANT_KEY, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1000L) != 0)) ) {
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
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
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
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cardinality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(DoubleLiteralExpression);
			setState(229);
			match(COLON);
			setState(230);
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
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
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
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_range);
		int _la;
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				rangeItem();
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6818328899322872L) != 0)) {
					{
					{
					setState(235);
					rangeItem();
					}
					}
					setState(240);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(249); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(241);
					match(PIPE);
					setState(242);
					rangeItem();
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6818328899322872L) != 0)) {
						{
						{
						setState(243);
						rangeItem();
						}
						}
						setState(248);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(251); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==PIPE );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253);
				match(DoubleLiteralExpression);
				setState(254);
				match(MINUS);
				setState(255);
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
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
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
	}

	public final RangeItemContext rangeItem() throws RecognitionException {
		RangeItemContext _localctx = new RangeItemContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rangeItem);
		try {
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(258);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				specialCharacter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(261);
				subrange();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(262);
				cardinality();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(263);
				match(QUESTION);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(264);
				header();
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
	}

	public final SpecialCharacterContext specialCharacter() throws RecognitionException {
		SpecialCharacterContext _localctx = new SpecialCharacterContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_specialCharacter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2252056974852096L) != 0)) ) {
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
	}

	public final SubrangeContext subrange() throws RecognitionException {
		SubrangeContext _localctx = new SubrangeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_subrange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			expression(0);
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16646144L) != 0)) {
				{
				{
				setState(270);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16646144L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(271);
				expression(0);
				}
				}
				setState(276);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IsTakenContext extends ExpressionContext {
		public TerminalNode ISTAKEN() { return getToken(DoplerParser.ISTAKEN, 0); }
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public IsTakenContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterIsTaken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitIsTaken(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XorExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode XOR() { return getToken(DoplerParser.XOR, 0); }
		public XorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterXorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitXorExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecisionValueCallExpressionContext extends ExpressionContext {
		public TerminalNode GETVALUE() { return getToken(DoplerParser.GETVALUE, 0); }
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public DecisionValueCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterDecisionValueCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitDecisionValueCallExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThanExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER_THAN() { return getToken(DoplerParser.GREATER_THAN, 0); }
		public GreaterThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterGreaterThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitGreaterThanExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterEqualsExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER_EQUALS() { return getToken(DoplerParser.GREATER_EQUALS, 0); }
		public GreaterEqualsExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterGreaterEqualsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitGreaterEqualsExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessEqualsExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LESS_EQUALS() { return getToken(DoplerParser.LESS_EQUALS, 0); }
		public LessEqualsExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterLessEqualsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitLessEqualsExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(DoplerParser.OR, 0); }
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitOrExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(DoplerParser.AND, 0); }
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitAndExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExpressionContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(DoplerParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(DoplerParser.RPAREN, 0); }
		public ParenthesizedExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterParenthesizedExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitParenthesizedExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(DoplerParser.EQUALS, 0); }
		public TerminalNode SET() { return getToken(DoplerParser.SET, 0); }
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitEqualityExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessThanExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LESS_THAN() { return getToken(DoplerParser.LESS_THAN, 0); }
		public LessThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterLessThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitLessThanExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(DoplerParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitUnaryExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryLiteralContext extends ExpressionContext {
		public LiteralExpressionContext literalExpression() {
			return getRuleContext(LiteralExpressionContext.class,0);
		}
		public PrimaryLiteralContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterPrimaryLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitPrimaryLiteral(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				_localctx = new ParenthesizedExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(278);
				match(LPAREN);
				setState(279);
				expression(0);
				setState(280);
				match(RPAREN);
				}
				break;
			case NOT:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				match(NOT);
				setState(283);
				expression(13);
				}
				break;
			case ISTAKEN:
				{
				_localctx = new IsTakenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284);
				match(ISTAKEN);
				setState(285);
				match(LPAREN);
				setState(286);
				match(IDENTIFIER);
				setState(287);
				match(RPAREN);
				}
				break;
			case GETVALUE:
				{
				_localctx = new DecisionValueCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				match(GETVALUE);
				setState(289);
				match(LPAREN);
				setState(290);
				match(IDENTIFIER);
				setState(291);
				match(RPAREN);
				}
				break;
			case BooleanLiteralExpression:
			case DoubleLiteralExpression:
			case EnumerationLiteralExpression:
			case StringLiteralExpression:
				{
				_localctx = new PrimaryLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				literalExpression();
				}
				break;
			case IDENTIFIER:
				{
				_localctx = new DecisionValueCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(320);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(297);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==SET) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(298);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new GreaterThanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(299);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(300);
						match(GREATER_THAN);
						setState(301);
						expression(10);
						}
						break;
					case 3:
						{
						_localctx = new LessThanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(302);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(303);
						match(LESS_THAN);
						setState(304);
						expression(9);
						}
						break;
					case 4:
						{
						_localctx = new GreaterEqualsExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(305);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(306);
						match(GREATER_EQUALS);
						setState(307);
						expression(8);
						}
						break;
					case 5:
						{
						_localctx = new LessEqualsExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(308);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(309);
						match(LESS_EQUALS);
						setState(310);
						expression(7);
						}
						break;
					case 6:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(311);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(312);
						match(AND);
						setState(313);
						expression(6);
						}
						break;
					case 7:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(314);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(315);
						match(OR);
						setState(316);
						expression(5);
						}
						break;
					case 8:
						{
						_localctx = new XorExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(317);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(318);
						match(XOR);
						setState(319);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
	public static class DecisionVisibilityCallExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}

	public final DecisionVisibilityCallExpressionContext decisionVisibilityCallExpression() throws RecognitionException {
		DecisionVisibilityCallExpressionContext _localctx = new DecisionVisibilityCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_decisionVisibilityCallExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			expression(0);
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
	}

	public final LiteralExpressionContext literalExpression() throws RecognitionException {
		LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_literalExpression);
		try {
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EnumerationLiteralExpression:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				enumerationLiteralExpression();
				}
				break;
			case BooleanLiteralExpression:
				enterOuterAlt(_localctx, 2);
				{
				setState(328);
				booleanLiteralExpression();
				}
				break;
			case StringLiteralExpression:
				enterOuterAlt(_localctx, 3);
				{
				setState(329);
				stringLiteralExpression();
				}
				break;
			case DoubleLiteralExpression:
				enterOuterAlt(_localctx, 4);
				{
				setState(330);
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
	}

	public final EnumerationLiteralExpressionContext enumerationLiteralExpression() throws RecognitionException {
		EnumerationLiteralExpressionContext _localctx = new EnumerationLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_enumerationLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
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
	}

	public final BooleanLiteralExpressionContext booleanLiteralExpression() throws RecognitionException {
		BooleanLiteralExpressionContext _localctx = new BooleanLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_booleanLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
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
	}

	public final StringLiteralExpressionContext stringLiteralExpression() throws RecognitionException {
		StringLiteralExpressionContext _localctx = new StringLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_stringLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
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
	}

	public final DoubleLiteralExpressionContext doubleLiteralExpression() throws RecognitionException {
		DoubleLiteralExpressionContext _localctx = new DoubleLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_doubleLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
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
	}

	public final DecisionTypeContext decisionType() throws RecognitionException {
		DecisionTypeContext _localctx = new DecisionTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_decisionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1618481116086272L) != 0)) ) {
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
	public static class DruleContext extends ParserRuleContext {
		public List<TerminalNode> DQ() { return getTokens(DoplerParser.DQ); }
		public TerminalNode DQ(int i) {
			return getToken(DoplerParser.DQ, i);
		}
		public List<DruleContext> drule() {
			return getRuleContexts(DruleContext.class);
		}
		public DruleContext drule(int i) {
			return getRuleContext(DruleContext.class,i);
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
		public DruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).enterDrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DoplerParserListener ) ((DoplerParserListener)listener).exitDrule(this);
		}
	}

	public final DruleContext drule() throws RecognitionException {
		return drule(0);
	}

	private DruleContext drule(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		DruleContext _localctx = new DruleContext(_ctx, _parentState);
		DruleContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_drule, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DQ:
				{
				setState(344);
				match(DQ);
				setState(345);
				drule(0);
				setState(346);
				match(DQ);
				}
				break;
			case IF:
				{
				setState(348);
				match(IF);
				setState(350);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(349);
					match(LPAREN);
					}
					break;
				}
				setState(352);
				expression(0);
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(353);
					match(RPAREN);
					}
				}

				setState(356);
				match(LBRACE);
				setState(361); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(357);
					action();
					setState(359);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SEMICOLON) {
						{
						setState(358);
						match(SEMICOLON);
						}
					}

					}
					}
					setState(363); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599627395072L) != 0) );
				setState(365);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(373);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new DruleContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_drule);
					setState(369);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(370);
					drule(3);
					}
					} 
				}
				setState(375);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
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
	}

	public final ValueRestrictionActionContext valueRestrictionAction() throws RecognitionException {
		ValueRestrictionActionContext _localctx = new ValueRestrictionActionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_valueRestrictionAction);
		try {
			setState(381);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALLOW:
				enterOuterAlt(_localctx, 1);
				{
				setState(378);
				allows();
				}
				break;
			case DISALLOW:
				enterOuterAlt(_localctx, 2);
				{
				setState(379);
				disallows();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(380);
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
	}

	public final AllowsContext allows() throws RecognitionException {
		AllowsContext _localctx = new AllowsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_allows);
		try {
			setState(391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				match(ALLOW);
				setState(384);
				match(LPAREN);
				setState(385);
				match(IDENTIFIER);
				setState(386);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(387);
				match(ALLOW);
				setState(388);
				match(LPAREN);
				setState(389);
				match(EnumerationLiteralExpression);
				setState(390);
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
	}

	public final DisallowsContext disallows() throws RecognitionException {
		DisallowsContext _localctx = new DisallowsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_disallows);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				match(DISALLOW);
				setState(394);
				match(LPAREN);
				setState(395);
				match(IDENTIFIER);
				setState(396);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				match(DISALLOW);
				setState(398);
				match(LPAREN);
				setState(399);
				match(EnumerationLiteralExpression);
				setState(400);
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
		public BooleanEnForceContext booleanEnForce() {
			return getRuleContext(BooleanEnForceContext.class,0);
		}
		public DoubleEnForceContext doubleEnForce() {
			return getRuleContext(DoubleEnForceContext.class,0);
		}
		public StringEnForceContext stringEnForce() {
			return getRuleContext(StringEnForceContext.class,0);
		}
		public EnumEnForceContext enumEnForce() {
			return getRuleContext(EnumEnForceContext.class,0);
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
	}

	public final EnForceContext enForce() throws RecognitionException {
		EnForceContext _localctx = new EnForceContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_enForce);
		try {
			setState(407);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				booleanEnForce();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				doubleEnForce();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(405);
				stringEnForce();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(406);
				enumEnForce();
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
		public TerminalNode IDENTIFIER() { return getToken(DoplerParser.IDENTIFIER, 0); }
		public TerminalNode SET() { return getToken(DoplerParser.SET, 0); }
		public List<RangeItemContext> rangeItem() {
			return getRuleContexts(RangeItemContext.class);
		}
		public RangeItemContext rangeItem(int i) {
			return getRuleContext(RangeItemContext.class,i);
		}
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
	}

	public final EnumEnForceContext enumEnForce() throws RecognitionException {
		EnumEnForceContext _localctx = new EnumEnForceContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_enumEnForce);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			match(IDENTIFIER);
			setState(410);
			match(SET);
			setState(414);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(411);
					rangeItem();
					}
					} 
				}
				setState(416);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
	}

	public final StringEnForceContext stringEnForce() throws RecognitionException {
		StringEnForceContext _localctx = new StringEnForceContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_stringEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(IDENTIFIER);
			setState(418);
			match(SET);
			setState(419);
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
	}

	public final BooleanEnForceContext booleanEnForce() throws RecognitionException {
		BooleanEnForceContext _localctx = new BooleanEnForceContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_booleanEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(IDENTIFIER);
			setState(422);
			match(SET);
			setState(423);
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
	}

	public final DoubleEnForceContext doubleEnForce() throws RecognitionException {
		DoubleEnForceContext _localctx = new DoubleEnForceContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_doubleEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(IDENTIFIER);
			setState(426);
			match(SET);
			setState(427);
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
		case 17:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 25:
			return drule_sempred((DruleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean drule_sempred(DruleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00014\u01ae\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0001\u0000\u0003\u0000I\b\u0000\u0001\u0001\u0001\u0001\u0003"+
		"\u0001M\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002Y\b\u0002\u0005\u0002[\b\u0002\n\u0002\f\u0002^\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002c\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"l\b\u0003\u0005\u0003n\b\u0003\n\u0003\f\u0003q\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003w\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u007f"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u008b"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0097"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00a3"+
		"\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00ae\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00b9\b\u0004\u0001\u0004\u0003"+
		"\u0004\u00bc\b\u0004\u0001\u0005\u0001\u0005\u0004\u0005\u00c0\b\u0005"+
		"\u000b\u0005\f\u0005\u00c1\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00cb\b\u0007\n\u0007"+
		"\f\u0007\u00ce\t\u0007\u0001\u0007\u0003\u0007\u00d1\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00df\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0005\r\u00ed\b\r\n\r\f\r\u00f0\t\r\u0001\r\u0001\r\u0001\r\u0005\r"+
		"\u00f5\b\r\n\r\f\r\u00f8\t\r\u0004\r\u00fa\b\r\u000b\r\f\r\u00fb\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u0101\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u010a\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\u0111\b\u0010\n\u0010\f\u0010\u0114\t\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0127\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0141"+
		"\b\u0011\n\u0011\f\u0011\u0144\t\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u014c\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u015f\b\u0019"+
		"\u0001\u0019\u0001\u0019\u0003\u0019\u0163\b\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0168\b\u0019\u0004\u0019\u016a\b\u0019\u000b"+
		"\u0019\f\u0019\u016b\u0001\u0019\u0001\u0019\u0003\u0019\u0170\b\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u0174\b\u0019\n\u0019\f\u0019\u0177"+
		"\t\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0003"+
		"\u001b\u017e\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0188\b\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0003\u001d\u0192\b\u001d\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0003\u001e\u0198\b\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0005\u001f\u019d\b\u001f\n\u001f\f\u001f\u01a0\t\u001f\u0001 "+
		"\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0000\u0002\"2#\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BD\u0000"+
		"\u0005\u0002\u0000\u0003\u0003\u0005\t\u0003\u0000\u001d!#%33\u0001\u0000"+
		"\u0011\u0017\u0002\u0000\u0011\u0011\u001a\u001a\u0002\u0000.022\u01d8"+
		"\u0000H\u0001\u0000\u0000\u0000\u0002J\u0001\u0000\u0000\u0000\u0004b"+
		"\u0001\u0000\u0000\u0000\u0006v\u0001\u0000\u0000\u0000\b\u00bb\u0001"+
		"\u0000\u0000\u0000\n\u00bd\u0001\u0000\u0000\u0000\f\u00c5\u0001\u0000"+
		"\u0000\u0000\u000e\u00c7\u0001\u0000\u0000\u0000\u0010\u00de\u0001\u0000"+
		"\u0000\u0000\u0012\u00e0\u0001\u0000\u0000\u0000\u0014\u00e2\u0001\u0000"+
		"\u0000\u0000\u0016\u00e4\u0001\u0000\u0000\u0000\u0018\u00e8\u0001\u0000"+
		"\u0000\u0000\u001a\u0100\u0001\u0000\u0000\u0000\u001c\u0109\u0001\u0000"+
		"\u0000\u0000\u001e\u010b\u0001\u0000\u0000\u0000 \u010d\u0001\u0000\u0000"+
		"\u0000\"\u0126\u0001\u0000\u0000\u0000$\u0145\u0001\u0000\u0000\u0000"+
		"&\u014b\u0001\u0000\u0000\u0000(\u014d\u0001\u0000\u0000\u0000*\u014f"+
		"\u0001\u0000\u0000\u0000,\u0151\u0001\u0000\u0000\u0000.\u0153\u0001\u0000"+
		"\u0000\u00000\u0155\u0001\u0000\u0000\u00002\u016f\u0001\u0000\u0000\u0000"+
		"4\u0178\u0001\u0000\u0000\u00006\u017d\u0001\u0000\u0000\u00008\u0187"+
		"\u0001\u0000\u0000\u0000:\u0191\u0001\u0000\u0000\u0000<\u0197\u0001\u0000"+
		"\u0000\u0000>\u0199\u0001\u0000\u0000\u0000@\u01a1\u0001\u0000\u0000\u0000"+
		"B\u01a5\u0001\u0000\u0000\u0000D\u01a9\u0001\u0000\u0000\u0000FI\u0003"+
		"\u0002\u0001\u0000GI\u0003\n\u0005\u0000HF\u0001\u0000\u0000\u0000HG\u0001"+
		"\u0000\u0000\u0000I\u0001\u0001\u0000\u0000\u0000JL\u0005\u001f\u0000"+
		"\u0000KM\u0003\u0004\u0002\u0000LK\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0005 \u0000\u0000OP\u0005\u0000"+
		"\u0000\u0001P\u0003\u0001\u0000\u0000\u0000QR\u0005\'\u0000\u0000RS\u0005"+
		"\n\u0000\u0000ST\u0005\'\u0000\u0000TU\u0005!\u0000\u0000U\\\u0005\u001f"+
		"\u0000\u0000VX\u0003\u0006\u0003\u0000WY\u0005%\u0000\u0000XW\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000ZV\u0001"+
		"\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000"+
		"\\]\u0001\u0000\u0000\u0000]_\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000_c\u0005 \u0000\u0000`a\u0005\u001f\u0000\u0000ac\u0005 \u0000\u0000"+
		"bQ\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000c\u0005\u0001\u0000"+
		"\u0000\u0000de\u0005\'\u0000\u0000ef\u0003\u0014\n\u0000fg\u0005\'\u0000"+
		"\u0000gh\u0005!\u0000\u0000ho\u0005\u001f\u0000\u0000ik\u0003\b\u0004"+
		"\u0000jl\u0005%\u0000\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000ln\u0001\u0000\u0000\u0000mi\u0001\u0000\u0000\u0000nq\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pr\u0001"+
		"\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rs\u0005 \u0000\u0000sw\u0001"+
		"\u0000\u0000\u0000tu\u0005\u001f\u0000\u0000uw\u0005 \u0000\u0000vd\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000w\u0007\u0001\u0000\u0000"+
		"\u0000xy\u0005\u0003\u0000\u0000y~\u0005\'\u0000\u0000z\u007f\u0003\u0018"+
		"\f\u0000{|\u0005\'\u0000\u0000|\u007f\u0005\'\u0000\u0000}\u007f\u0001"+
		"\u0000\u0000\u0000~z\u0001\u0000\u0000\u0000~{\u0001\u0000\u0000\u0000"+
		"~}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u00bc"+
		"\u0005\'\u0000\u0000\u0081\u0082\u0005\'\u0000\u0000\u0082\u0083\u0005"+
		"\u0005\u0000\u0000\u0083\u0084\u0005\'\u0000\u0000\u0084\u0085\u0005!"+
		"\u0000\u0000\u0085\u008a\u0005\'\u0000\u0000\u0086\u008b\u00030\u0018"+
		"\u0000\u0087\u0088\u0005\'\u0000\u0000\u0088\u008b\u0005\'\u0000\u0000"+
		"\u0089\u008b\u0001\u0000\u0000\u0000\u008a\u0086\u0001\u0000\u0000\u0000"+
		"\u008a\u0087\u0001\u0000\u0000\u0000\u008a\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u00bc\u0005\'\u0000\u0000\u008d"+
		"\u008e\u0005\'\u0000\u0000\u008e\u008f\u0005\u0006\u0000\u0000\u008f\u0090"+
		"\u0005\'\u0000\u0000\u0090\u0091\u0005!\u0000\u0000\u0091\u0096\u0005"+
		"\'\u0000\u0000\u0092\u0097\u0003\u001a\r\u0000\u0093\u0094\u0005\'\u0000"+
		"\u0000\u0094\u0097\u0005\'\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000"+
		"\u0096\u0092\u0001\u0000\u0000\u0000\u0096\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u0095\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000"+
		"\u0098\u00bc\u0005\'\u0000\u0000\u0099\u009a\u0005\'\u0000\u0000\u009a"+
		"\u009b\u0005\u0007\u0000\u0000\u009b\u009c\u0005\'\u0000\u0000\u009c\u009d"+
		"\u0005!\u0000\u0000\u009d\u00a2\u0005\'\u0000\u0000\u009e\u00a3\u0003"+
		"\u0016\u000b\u0000\u009f\u00a0\u0005\'\u0000\u0000\u00a0\u00a3\u0005\'"+
		"\u0000\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2\u009e\u0001\u0000"+
		"\u0000\u0000\u00a2\u009f\u0001\u0000\u0000\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00bc\u0005\'\u0000"+
		"\u0000\u00a5\u00a6\u0005\'\u0000\u0000\u00a6\u00a7\u0005\b\u0000\u0000"+
		"\u00a7\u00a8\u0005\'\u0000\u0000\u00a8\u00ad\u0005!\u0000\u0000\u00a9"+
		"\u00ae\u00032\u0019\u0000\u00aa\u00ab\u0005\'\u0000\u0000\u00ab\u00ae"+
		"\u0005\'\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ae\u00bc\u0001\u0000\u0000\u0000\u00af\u00b0\u0005"+
		"\'\u0000\u0000\u00b0\u00b1\u0005\t\u0000\u0000\u00b1\u00b2\u0005\'\u0000"+
		"\u0000\u00b2\u00b3\u0005!\u0000\u0000\u00b3\u00b8\u0005\'\u0000\u0000"+
		"\u00b4\u00b9\u0003$\u0012\u0000\u00b5\u00b6\u0005\'\u0000\u0000\u00b6"+
		"\u00b9\u0005\'\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bc"+
		"\u0005\'\u0000\u0000\u00bbx\u0001\u0000\u0000\u0000\u00bb\u0081\u0001"+
		"\u0000\u0000\u0000\u00bb\u008d\u0001\u0000\u0000\u0000\u00bb\u0099\u0001"+
		"\u0000\u0000\u0000\u00bb\u00a5\u0001\u0000\u0000\u0000\u00bb\u00af\u0001"+
		"\u0000\u0000\u0000\u00bc\t\u0001\u0000\u0000\u0000\u00bd\u00bf\u0003\f"+
		"\u0006\u0000\u00be\u00c0\u0003\u000e\u0007\u0000\u00bf\u00be\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c4\u0005\u0000\u0000\u0001\u00c4\u000b\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0003\u000e\u0007\u0000\u00c6\r\u0001\u0000\u0000"+
		"\u0000\u00c7\u00cc\u0003\u0010\b\u0000\u00c8\u00c9\u0005&\u0000\u0000"+
		"\u00c9\u00cb\u0003\u0010\b\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cd\u00d0\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d1\u0005\u0001\u0000\u0000\u00d0"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u0002\u0000\u0000\u00d3"+
		"\u000f\u0001\u0000\u0000\u0000\u00d4\u00df\u00032\u0019\u0000\u00d5\u00df"+
		"\u0003\u0014\n\u0000\u00d6\u00df\u0003\u0018\f\u0000\u00d7\u00df\u0003"+
		"0\u0018\u0000\u00d8\u00df\u0003\u0016\u000b\u0000\u00d9\u00df\u0003\u001a"+
		"\r\u0000\u00da\u00df\u0003$\u0012\u0000\u00db\u00df\u0003\u0012\t\u0000"+
		"\u00dc\u00df\u00054\u0000\u0000\u00dd\u00df\u0001\u0000\u0000\u0000\u00de"+
		"\u00d4\u0001\u0000\u0000\u0000\u00de\u00d5\u0001\u0000\u0000\u0000\u00de"+
		"\u00d6\u0001\u0000\u0000\u0000\u00de\u00d7\u0001\u0000\u0000\u0000\u00de"+
		"\u00d8\u0001\u0000\u0000\u0000\u00de\u00d9\u0001\u0000\u0000\u0000\u00de"+
		"\u00da\u0001\u0000\u0000\u0000\u00de\u00db\u0001\u0000\u0000\u0000\u00de"+
		"\u00dc\u0001\u0000\u0000\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u0011\u0001\u0000\u0000\u0000\u00e0\u00e1\u0007\u0000\u0000\u0000\u00e1"+
		"\u0013\u0001\u0000\u0000\u0000\u00e2\u00e3\u00054\u0000\u0000\u00e3\u0015"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e5\u0005+\u0000\u0000\u00e5\u00e6\u0005"+
		"!\u0000\u0000\u00e6\u00e7\u0005+\u0000\u0000\u00e7\u0017\u0001\u0000\u0000"+
		"\u0000\u00e8\u00e9\u0005\u0004\u0000\u0000\u00e9\u0019\u0001\u0000\u0000"+
		"\u0000\u00ea\u00ee\u0003\u001c\u000e\u0000\u00eb\u00ed\u0003\u001c\u000e"+
		"\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f9\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f1\u00f2\u0005\u0019\u0000\u0000\u00f2\u00f6\u0003\u001c\u000e"+
		"\u0000\u00f3\u00f5\u0003\u001c\u000e\u0000\u00f4\u00f3\u0001\u0000\u0000"+
		"\u0000\u00f5\u00f8\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f9\u00f1\u0001\u0000\u0000"+
		"\u0000\u00fa\u00fb\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000"+
		"\u0000\u00fb\u00fc\u0001\u0000\u0000\u0000\u00fc\u0101\u0001\u0000\u0000"+
		"\u0000\u00fd\u00fe\u0005+\u0000\u0000\u00fe\u00ff\u0005\u001c\u0000\u0000"+
		"\u00ff\u0101\u0005+\u0000\u0000\u0100\u00ea\u0001\u0000\u0000\u0000\u0100"+
		"\u00fd\u0001\u0000\u0000\u0000\u0101\u001b\u0001\u0000\u0000\u0000\u0102"+
		"\u010a\u00054\u0000\u0000\u0103\u010a\u0003\u001e\u000f\u0000\u0104\u010a"+
		"\u0003\"\u0011\u0000\u0105\u010a\u0003 \u0010\u0000\u0106\u010a\u0003"+
		"\u0016\u000b\u0000\u0107\u010a\u0005\u0004\u0000\u0000\u0108\u010a\u0003"+
		"\u0012\t\u0000\u0109\u0102\u0001\u0000\u0000\u0000\u0109\u0103\u0001\u0000"+
		"\u0000\u0000\u0109\u0104\u0001\u0000\u0000\u0000\u0109\u0105\u0001\u0000"+
		"\u0000\u0000\u0109\u0106\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000"+
		"\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u001d\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0007\u0001\u0000\u0000\u010c\u001f\u0001\u0000"+
		"\u0000\u0000\u010d\u0112\u0003\"\u0011\u0000\u010e\u010f\u0007\u0002\u0000"+
		"\u0000\u010f\u0111\u0003\"\u0011\u0000\u0110\u010e\u0001\u0000\u0000\u0000"+
		"\u0111\u0114\u0001\u0000\u0000\u0000\u0112\u0110\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0001\u0000\u0000\u0000\u0113!\u0001\u0000\u0000\u0000\u0114"+
		"\u0112\u0001\u0000\u0000\u0000\u0115\u0116\u0006\u0011\uffff\uffff\u0000"+
		"\u0116\u0117\u0005\u001d\u0000\u0000\u0117\u0118\u0003\"\u0011\u0000\u0118"+
		"\u0119\u0005\u001e\u0000\u0000\u0119\u0127\u0001\u0000\u0000\u0000\u011a"+
		"\u011b\u0005\u001b\u0000\u0000\u011b\u0127\u0003\"\u0011\r\u011c\u011d"+
		"\u0005\u000f\u0000\u0000\u011d\u011e\u0005\u001d\u0000\u0000\u011e\u011f"+
		"\u00054\u0000\u0000\u011f\u0127\u0005\u001e\u0000\u0000\u0120\u0121\u0005"+
		"\u0010\u0000\u0000\u0121\u0122\u0005\u001d\u0000\u0000\u0122\u0123\u0005"+
		"4\u0000\u0000\u0123\u0127\u0005\u001e\u0000\u0000\u0124\u0127\u0003&\u0013"+
		"\u0000\u0125\u0127\u00054\u0000\u0000\u0126\u0115\u0001\u0000\u0000\u0000"+
		"\u0126\u011a\u0001\u0000\u0000\u0000\u0126\u011c\u0001\u0000\u0000\u0000"+
		"\u0126\u0120\u0001\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000"+
		"\u0126\u0125\u0001\u0000\u0000\u0000\u0127\u0142\u0001\u0000\u0000\u0000"+
		"\u0128\u0129\n\n\u0000\u0000\u0129\u012a\u0007\u0003\u0000\u0000\u012a"+
		"\u0141\u0003\"\u0011\u000b\u012b\u012c\n\t\u0000\u0000\u012c\u012d\u0005"+
		"\u0012\u0000\u0000\u012d\u0141\u0003\"\u0011\n\u012e\u012f\n\b\u0000\u0000"+
		"\u012f\u0130\u0005\u0013\u0000\u0000\u0130\u0141\u0003\"\u0011\t\u0131"+
		"\u0132\n\u0007\u0000\u0000\u0132\u0133\u0005\u0015\u0000\u0000\u0133\u0141"+
		"\u0003\"\u0011\b\u0134\u0135\n\u0006\u0000\u0000\u0135\u0136\u0005\u0014"+
		"\u0000\u0000\u0136\u0141\u0003\"\u0011\u0007\u0137\u0138\n\u0005\u0000"+
		"\u0000\u0138\u0139\u0005\u0017\u0000\u0000\u0139\u0141\u0003\"\u0011\u0006"+
		"\u013a\u013b\n\u0004\u0000\u0000\u013b\u013c\u0005\u0016\u0000\u0000\u013c"+
		"\u0141\u0003\"\u0011\u0005\u013d\u013e\n\u0003\u0000\u0000\u013e\u013f"+
		"\u0005\u0018\u0000\u0000\u013f\u0141\u0003\"\u0011\u0004\u0140\u0128\u0001"+
		"\u0000\u0000\u0000\u0140\u012b\u0001\u0000\u0000\u0000\u0140\u012e\u0001"+
		"\u0000\u0000\u0000\u0140\u0131\u0001\u0000\u0000\u0000\u0140\u0134\u0001"+
		"\u0000\u0000\u0000\u0140\u0137\u0001\u0000\u0000\u0000\u0140\u013a\u0001"+
		"\u0000\u0000\u0000\u0140\u013d\u0001\u0000\u0000\u0000\u0141\u0144\u0001"+
		"\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0142\u0143\u0001"+
		"\u0000\u0000\u0000\u0143#\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000"+
		"\u0000\u0000\u0145\u0146\u0003\"\u0011\u0000\u0146%\u0001\u0000\u0000"+
		"\u0000\u0147\u014c\u0003(\u0014\u0000\u0148\u014c\u0003*\u0015\u0000\u0149"+
		"\u014c\u0003,\u0016\u0000\u014a\u014c\u0003.\u0017\u0000\u014b\u0147\u0001"+
		"\u0000\u0000\u0000\u014b\u0148\u0001\u0000\u0000\u0000\u014b\u0149\u0001"+
		"\u0000\u0000\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014c\'\u0001\u0000"+
		"\u0000\u0000\u014d\u014e\u0005,\u0000\u0000\u014e)\u0001\u0000\u0000\u0000"+
		"\u014f\u0150\u0005(\u0000\u0000\u0150+\u0001\u0000\u0000\u0000\u0151\u0152"+
		"\u0005-\u0000\u0000\u0152-\u0001\u0000\u0000\u0000\u0153\u0154\u0005+"+
		"\u0000\u0000\u0154/\u0001\u0000\u0000\u0000\u0155\u0156\u0007\u0004\u0000"+
		"\u0000\u01561\u0001\u0000\u0000\u0000\u0157\u0158\u0006\u0019\uffff\uffff"+
		"\u0000\u0158\u0159\u0005\'\u0000\u0000\u0159\u015a\u00032\u0019\u0000"+
		"\u015a\u015b\u0005\'\u0000\u0000\u015b\u0170\u0001\u0000\u0000\u0000\u015c"+
		"\u015e\u0005\"\u0000\u0000\u015d\u015f\u0005\u001d\u0000\u0000\u015e\u015d"+
		"\u0001\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u0160"+
		"\u0001\u0000\u0000\u0000\u0160\u0162\u0003\"\u0011\u0000\u0161\u0163\u0005"+
		"\u001e\u0000\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0162\u0163\u0001"+
		"\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0169\u0005"+
		"\u001f\u0000\u0000\u0165\u0167\u00034\u001a\u0000\u0166\u0168\u0005&\u0000"+
		"\u0000\u0167\u0166\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000"+
		"\u0000\u0168\u016a\u0001\u0000\u0000\u0000\u0169\u0165\u0001\u0000\u0000"+
		"\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000"+
		"\u0000\u016d\u016e\u0005 \u0000\u0000\u016e\u0170\u0001\u0000\u0000\u0000"+
		"\u016f\u0157\u0001\u0000\u0000\u0000\u016f\u015c\u0001\u0000\u0000\u0000"+
		"\u0170\u0175\u0001\u0000\u0000\u0000\u0171\u0172\n\u0002\u0000\u0000\u0172"+
		"\u0174\u00032\u0019\u0003\u0173\u0171\u0001\u0000\u0000\u0000\u0174\u0177"+
		"\u0001\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0176"+
		"\u0001\u0000\u0000\u0000\u01763\u0001\u0000\u0000\u0000\u0177\u0175\u0001"+
		"\u0000\u0000\u0000\u0178\u0179\u00036\u001b\u0000\u01795\u0001\u0000\u0000"+
		"\u0000\u017a\u017e\u00038\u001c\u0000\u017b\u017e\u0003:\u001d\u0000\u017c"+
		"\u017e\u0003<\u001e\u0000\u017d\u017a\u0001\u0000\u0000\u0000\u017d\u017b"+
		"\u0001\u0000\u0000\u0000\u017d\u017c\u0001\u0000\u0000\u0000\u017e7\u0001"+
		"\u0000\u0000\u0000\u017f\u0180\u0005\r\u0000\u0000\u0180\u0181\u0005\u001d"+
		"\u0000\u0000\u0181\u0182\u00054\u0000\u0000\u0182\u0188\u0005\u001e\u0000"+
		"\u0000\u0183\u0184\u0005\r\u0000\u0000\u0184\u0185\u0005\u001d\u0000\u0000"+
		"\u0185\u0186\u0005,\u0000\u0000\u0186\u0188\u0005\u001e\u0000\u0000\u0187"+
		"\u017f\u0001\u0000\u0000\u0000\u0187\u0183\u0001\u0000\u0000\u0000\u0188"+
		"9\u0001\u0000\u0000\u0000\u0189\u018a\u0005\u000e\u0000\u0000\u018a\u018b"+
		"\u0005\u001d\u0000\u0000\u018b\u018c\u00054\u0000\u0000\u018c\u0192\u0005"+
		"\u001e\u0000\u0000\u018d\u018e\u0005\u000e\u0000\u0000\u018e\u018f\u0005"+
		"\u001d\u0000\u0000\u018f\u0190\u0005,\u0000\u0000\u0190\u0192\u0005\u001e"+
		"\u0000\u0000\u0191\u0189\u0001\u0000\u0000\u0000\u0191\u018d\u0001\u0000"+
		"\u0000\u0000\u0192;\u0001\u0000\u0000\u0000\u0193\u0198\u0003B!\u0000"+
		"\u0194\u0198\u0003D\"\u0000\u0195\u0198\u0003@ \u0000\u0196\u0198\u0003"+
		">\u001f\u0000\u0197\u0193\u0001\u0000\u0000\u0000\u0197\u0194\u0001\u0000"+
		"\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000\u0197\u0196\u0001\u0000"+
		"\u0000\u0000\u0198=\u0001\u0000\u0000\u0000\u0199\u019a\u00054\u0000\u0000"+
		"\u019a\u019e\u0005\u001a\u0000\u0000\u019b\u019d\u0003\u001c\u000e\u0000"+
		"\u019c\u019b\u0001\u0000\u0000\u0000\u019d\u01a0\u0001\u0000\u0000\u0000"+
		"\u019e\u019c\u0001\u0000\u0000\u0000\u019e\u019f\u0001\u0000\u0000\u0000"+
		"\u019f?\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1"+
		"\u01a2\u00054\u0000\u0000\u01a2\u01a3\u0005\u001a\u0000\u0000\u01a3\u01a4"+
		"\u0005-\u0000\u0000\u01a4A\u0001\u0000\u0000\u0000\u01a5\u01a6\u00054"+
		"\u0000\u0000\u01a6\u01a7\u0005\u001a\u0000\u0000\u01a7\u01a8\u0005(\u0000"+
		"\u0000\u01a8C\u0001\u0000\u0000\u0000\u01a9\u01aa\u00054\u0000\u0000\u01aa"+
		"\u01ab\u0005\u001a\u0000\u0000\u01ab\u01ac\u0005+\u0000\u0000\u01acE\u0001"+
		"\u0000\u0000\u0000(HLX\\bkov~\u008a\u0096\u00a2\u00ad\u00b8\u00bb\u00c1"+
		"\u00cc\u00d0\u00de\u00ee\u00f6\u00fb\u0100\u0109\u0112\u0126\u0140\u0142"+
		"\u014b\u015e\u0162\u0167\u016b\u016f\u0175\u017d\u0187\u0191\u0197\u019e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
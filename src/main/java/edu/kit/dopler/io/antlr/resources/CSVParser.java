package edu.kit.dopler.io.antlr.resources;
// Generated from CSV.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CSVParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, QUESTION=6, WS=7, HEADER=8, ALLOW=9, 
		DISALLOW=10, ISTAKEN=11, GETVALUE=12, EQUALS=13, GREATER_THAN=14, LESS_THAN=15, 
		LESS_EQUALS=16, GREATER_EQUALS=17, OR=18, AND=19, XOR=20, PIPE=21, SET=22, 
		LPAREN=23, RPAREN=24, LBRACE=25, RBRACE=26, COLON=27, IF=28, ANPERSAND=29, 
		PERCENT=30, COMMA=31, SEMICOLON=32, BooleanLiteralExpression=33, TRUE=34, 
		FALSE=35, DoubleLiteralExpression=36, EnumerationLiteralExpression=37, 
		StringLiteralExpression=38, StringDecision=39, NumberDecision=40, EnumerationDecision=41, 
		ENUMERATION=42, BooleanDecision=43, SPECIAL_CHAR=44, IDENTIFIER=45;
	public static final int
		RULE_csvFile = 0, RULE_hdr = 1, RULE_row = 2, RULE_field = 3, RULE_id = 4, 
		RULE_cardinality = 5, RULE_question = 6, RULE_range = 7, RULE_rangeItem = 8, 
		RULE_specialCharacter = 9, RULE_subrange = 10, RULE_expression = 11, RULE_unaryExpression = 12, 
		RULE_decisionVisibilityCallExpression = 13, RULE_isTaken = 14, RULE_decisionValueCallExpression = 15, 
		RULE_binaryExpression = 16, RULE_andExpression = 17, RULE_orExpression = 18, 
		RULE_xorExpression = 19, RULE_equalityExpression = 20, RULE_greaterThanExpression = 21, 
		RULE_lessThanExpression = 22, RULE_greaterEqualsExpression = 23, RULE_lessEqualsExpression = 24, 
		RULE_literalExpression = 25, RULE_enumerationLiteralExpression = 26, RULE_booleanLiteralExpression = 27, 
		RULE_stringLiteralExpression = 28, RULE_doubleLiteralExpression = 29, 
		RULE_decisionType = 30, RULE_rule = 31, RULE_action = 32, RULE_valueRestrictionAction = 33, 
		RULE_allows = 34, RULE_disallows = 35, RULE_enForce = 36, RULE_enumEnForce = 37, 
		RULE_stringEnForce = 38, RULE_booleanEnForce = 39, RULE_doubleEnForce = 40;
	private static String[] makeRuleNames() {
		return new String[] {
			"csvFile", "hdr", "row", "field", "id", "cardinality", "question", "range", 
			"rangeItem", "specialCharacter", "subrange", "expression", "unaryExpression", 
			"decisionVisibilityCallExpression", "isTaken", "decisionValueCallExpression", 
			"binaryExpression", "andExpression", "orExpression", "xorExpression", 
			"equalityExpression", "greaterThanExpression", "lessThanExpression", 
			"greaterEqualsExpression", "lessEqualsExpression", "literalExpression", 
			"enumerationLiteralExpression", "booleanLiteralExpression", "stringLiteralExpression", 
			"doubleLiteralExpression", "decisionType", "rule", "action", "valueRestrictionAction", 
			"allows", "disallows", "enForce", "enumEnForce", "stringEnForce", "booleanEnForce", 
			"doubleEnForce"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\r'", "'\\n'", "'-'", "'!'", "'\"'", null, null, null, null, 
			null, null, null, "'***REMOVED***'", "'>'", "'<'", "'<='", "'>='", "'||'", "'&&'", 
			"'^'", "'|'", "'='", "'('", "')'", "'{'", "'}'", "':'", "'if'", "'&'", 
			"'%'", "','", "';'", null, null, null, null, null, null, "'String'", 
			"'Double'", null, "'Enumeration'", "'Boolean'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "QUESTION", "WS", "HEADER", "ALLOW", 
			"DISALLOW", "ISTAKEN", "GETVALUE", "EQUALS", "GREATER_THAN", "LESS_THAN", 
			"LESS_EQUALS", "GREATER_EQUALS", "OR", "AND", "XOR", "PIPE", "SET", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "COLON", "IF", "ANPERSAND", "PERCENT", 
			"COMMA", "SEMICOLON", "BooleanLiteralExpression", "TRUE", "FALSE", "DoubleLiteralExpression", 
			"EnumerationLiteralExpression", "StringLiteralExpression", "StringDecision", 
			"NumberDecision", "EnumerationDecision", "ENUMERATION", "BooleanDecision", 
			"SPECIAL_CHAR", "IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	***REMOVED****
	 * @deprecated Use {@link #VOCABULARY} instead.
	 ***REMOVED***
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] ***REMOVED*** null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] ***REMOVED*** null) {
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
	public String getGrammarFileName() { return "CSV.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CSVParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CsvFileContext extends ParserRuleContext {
		public HdrContext hdr() {
			return getRuleContext(HdrContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CSVParser.EOF, 0); }
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
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterCsvFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitCsvFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitCsvFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CsvFileContext csvFile() throws RecognitionException {
		CsvFileContext _localctx = new CsvFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_csvFile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			hdr();
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				row();
				}
				}
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 65919149676918L) != 0) );
			setState(88);
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
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterHdr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitHdr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitHdr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HdrContext hdr() throws RecognitionException {
		HdrContext _localctx = new HdrContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_hdr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
		public List<TerminalNode> SEMICOLON() { return getTokens(CSVParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CSVParser.SEMICOLON, i);
		}
		public RowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_row; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitRow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RowContext row() throws RecognitionException {
		RowContext _localctx = new RowContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_row);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			field();
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la***REMOVED***SEMICOLON) {
				{
				{
				setState(93);
				match(SEMICOLON);
				setState(94);
				field();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la***REMOVED***T__0) {
				{
				setState(100);
				match(T__0);
				}
			}

			setState(103);
			match(T__1);
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
		public TerminalNode HEADER() { return getToken(CSVParser.HEADER, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_field);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				rule_(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				question();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(108);
				decisionType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(109);
				cardinality();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(110);
				range();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(111);
				decisionVisibilityCallExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(112);
				match(HEADER);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(113);
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
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
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
		public List<TerminalNode> DoubleLiteralExpression() { return getTokens(CSVParser.DoubleLiteralExpression); }
		public TerminalNode DoubleLiteralExpression(int i) {
			return getToken(CSVParser.DoubleLiteralExpression, i);
		}
		public TerminalNode COLON() { return getToken(CSVParser.COLON, 0); }
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitCardinality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitCardinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cardinality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(DoubleLiteralExpression);
			setState(120);
			match(COLON);
			setState(121);
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
		public TerminalNode QUESTION() { return getToken(CSVParser.QUESTION, 0); }
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_question);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
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
		public List<TerminalNode> PIPE() { return getTokens(CSVParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(CSVParser.PIPE, i);
		}
		public List<TerminalNode> DoubleLiteralExpression() { return getTokens(CSVParser.DoubleLiteralExpression); }
		public TerminalNode DoubleLiteralExpression(int i) {
			return getToken(CSVParser.DoubleLiteralExpression, i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitRange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitRange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_range);
		int _la;
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				rangeItem();
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 53270202554704L) != 0)) {
					{
					{
					setState(126);
					rangeItem();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(132);
					match(PIPE);
					setState(133);
					rangeItem();
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 53270202554704L) != 0)) {
						{
						{
						setState(134);
						rangeItem();
						}
						}
						setState(139);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(142); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la***REMOVED***PIPE );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(DoubleLiteralExpression);
				setState(145);
				match(T__2);
				setState(146);
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
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
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
		public TerminalNode QUESTION() { return getToken(CSVParser.QUESTION, 0); }
		public TerminalNode HEADER() { return getToken(CSVParser.HEADER, 0); }
		public RangeItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterRangeItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitRangeItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitRangeItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeItemContext rangeItem() throws RecognitionException {
		RangeItemContext _localctx = new RangeItemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_rangeItem);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				specialCharacter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(151);
				expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(152);
				subrange();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(153);
				cardinality();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(154);
				match(QUESTION);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(155);
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
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(CSVParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CSVParser.RBRACE, 0); }
		public TerminalNode COLON() { return getToken(CSVParser.COLON, 0); }
		public TerminalNode ANPERSAND() { return getToken(CSVParser.ANPERSAND, 0); }
		public TerminalNode PERCENT() { return getToken(CSVParser.PERCENT, 0); }
		public TerminalNode COMMA() { return getToken(CSVParser.COMMA, 0); }
		public TerminalNode SPECIAL_CHAR() { return getToken(CSVParser.SPECIAL_CHAR, 0); }
		public SpecialCharacterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialCharacter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterSpecialCharacter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitSpecialCharacter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitSpecialCharacter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialCharacterContext specialCharacter() throws RecognitionException {
		SpecialCharacterContext _localctx = new SpecialCharacterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_specialCharacter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 17596204187648L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)***REMOVED***Token.EOF ) matchedEOF = true;
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
		public List<TerminalNode> AND() { return getTokens(CSVParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CSVParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(CSVParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CSVParser.OR, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(CSVParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(CSVParser.EQUALS, i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(CSVParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(CSVParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(CSVParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(CSVParser.LESS_THAN, i);
		}
		public List<TerminalNode> LESS_EQUALS() { return getTokens(CSVParser.LESS_EQUALS); }
		public TerminalNode LESS_EQUALS(int i) {
			return getToken(CSVParser.LESS_EQUALS, i);
		}
		public List<TerminalNode> GREATER_EQUALS() { return getTokens(CSVParser.GREATER_EQUALS); }
		public TerminalNode GREATER_EQUALS(int i) {
			return getToken(CSVParser.GREATER_EQUALS, i);
		}
		public SubrangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrange; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterSubrange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitSubrange(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitSubrange(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubrangeContext subrange() throws RecognitionException {
		SubrangeContext _localctx = new SubrangeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_subrange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			expression();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 1040384L) != 0)) {
				{
				{
				setState(161);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 1040384L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)***REMOVED***Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(162);
				expression();
				}
				}
				setState(167);
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
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				unaryExpression();
				}
				break;
			case BooleanLiteralExpression:
			case DoubleLiteralExpression:
			case EnumerationLiteralExpression:
			case StringLiteralExpression:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				literalExpression();
				}
				break;
			case ISTAKEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				isTaken();
				}
				break;
			case GETVALUE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(171);
				decisionValueCallExpression();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EnumerationLiteralExpression() { return getToken(CSVParser.EnumerationLiteralExpression, 0); }
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitUnaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_unaryExpression);
		try {
			setState(179);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(T__3);
				setState(176);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(T__3);
				setState(178);
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
		public List<TerminalNode> AND() { return getTokens(CSVParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(CSVParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(CSVParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(CSVParser.OR, i);
		}
		public List<TerminalNode> EQUALS() { return getTokens(CSVParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(CSVParser.EQUALS, i);
		}
		public List<TerminalNode> GREATER_THAN() { return getTokens(CSVParser.GREATER_THAN); }
		public TerminalNode GREATER_THAN(int i) {
			return getToken(CSVParser.GREATER_THAN, i);
		}
		public List<TerminalNode> LESS_THAN() { return getTokens(CSVParser.LESS_THAN); }
		public TerminalNode LESS_THAN(int i) {
			return getToken(CSVParser.LESS_THAN, i);
		}
		public DecisionVisibilityCallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionVisibilityCallExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterDecisionVisibilityCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitDecisionVisibilityCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitDecisionVisibilityCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecisionVisibilityCallExpressionContext decisionVisibilityCallExpression() throws RecognitionException {
		DecisionVisibilityCallExpressionContext _localctx = new DecisionVisibilityCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_decisionVisibilityCallExpression);
		int _la;
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				expression();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 843776L) != 0)) {
					{
					{
					setState(182);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 843776L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)***REMOVED***Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(183);
					expression();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
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
		public TerminalNode ISTAKEN() { return getToken(CSVParser.ISTAKEN, 0); }
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public IsTakenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isTaken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterIsTaken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitIsTaken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitIsTaken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsTakenContext isTaken() throws RecognitionException {
		IsTakenContext _localctx = new IsTakenContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_isTaken);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(ISTAKEN);
			setState(193);
			match(LPAREN);
			setState(194);
			match(IDENTIFIER);
			setState(195);
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
		public TerminalNode GETVALUE() { return getToken(CSVParser.GETVALUE, 0); }
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public DecisionValueCallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionValueCallExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterDecisionValueCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitDecisionValueCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitDecisionValueCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecisionValueCallExpressionContext decisionValueCallExpression() throws RecognitionException {
		DecisionValueCallExpressionContext _localctx = new DecisionValueCallExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_decisionValueCallExpression);
		try {
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GETVALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(GETVALUE);
				setState(198);
				match(LPAREN);
				setState(199);
				match(IDENTIFIER);
				setState(200);
				match(RPAREN);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
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
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryExpressionContext binaryExpression() throws RecognitionException {
		BinaryExpressionContext _localctx = new BinaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_binaryExpression);
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				andExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				orExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				xorExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				equalityExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(208);
				greaterThanExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(209);
				lessThanExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(210);
				greaterEqualsExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(211);
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
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(CSVParser.AND, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public AndExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitAndExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitAndExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndExpressionContext andExpression() throws RecognitionException {
		AndExpressionContext _localctx = new AndExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_andExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(LPAREN);
			setState(215);
			expression();
			setState(216);
			match(AND);
			setState(217);
			expression();
			setState(218);
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
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(CSVParser.OR, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public OrExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrExpressionContext orExpression() throws RecognitionException {
		OrExpressionContext _localctx = new OrExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_orExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(LPAREN);
			setState(221);
			expression();
			setState(222);
			match(OR);
			setState(223);
			expression();
			setState(224);
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
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode XOR() { return getToken(CSVParser.XOR, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public XorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xorExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterXorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitXorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitXorExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final XorExpressionContext xorExpression() throws RecognitionException {
		XorExpressionContext _localctx = new XorExpressionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_xorExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(LPAREN);
			setState(227);
			expression();
			setState(228);
			match(XOR);
			setState(229);
			expression();
			setState(230);
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
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(CSVParser.EQUALS, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_equalityExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(LPAREN);
			setState(233);
			expression();
			setState(234);
			match(EQUALS);
			setState(235);
			expression();
			setState(236);
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
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER_THAN() { return getToken(CSVParser.GREATER_THAN, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public GreaterThanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterThanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterGreaterThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitGreaterThanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitGreaterThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterThanExpressionContext greaterThanExpression() throws RecognitionException {
		GreaterThanExpressionContext _localctx = new GreaterThanExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_greaterThanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(LPAREN);
			setState(239);
			expression();
			setState(240);
			match(GREATER_THAN);
			setState(241);
			expression();
			setState(242);
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
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LESS_THAN() { return getToken(CSVParser.LESS_THAN, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public LessThanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessThanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterLessThanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitLessThanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitLessThanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessThanExpressionContext lessThanExpression() throws RecognitionException {
		LessThanExpressionContext _localctx = new LessThanExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_lessThanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(LPAREN);
			setState(245);
			expression();
			setState(246);
			match(LESS_THAN);
			setState(247);
			expression();
			setState(248);
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
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GREATER_EQUALS() { return getToken(CSVParser.GREATER_EQUALS, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public GreaterEqualsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_greaterEqualsExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterGreaterEqualsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitGreaterEqualsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitGreaterEqualsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GreaterEqualsExpressionContext greaterEqualsExpression() throws RecognitionException {
		GreaterEqualsExpressionContext _localctx = new GreaterEqualsExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_greaterEqualsExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(LPAREN);
			setState(251);
			expression();
			setState(252);
			match(GREATER_EQUALS);
			setState(253);
			expression();
			setState(254);
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
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LESS_EQUALS() { return getToken(CSVParser.LESS_EQUALS, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public LessEqualsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lessEqualsExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterLessEqualsExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitLessEqualsExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitLessEqualsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LessEqualsExpressionContext lessEqualsExpression() throws RecognitionException {
		LessEqualsExpressionContext _localctx = new LessEqualsExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_lessEqualsExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(LPAREN);
			setState(257);
			expression();
			setState(258);
			match(LESS_EQUALS);
			setState(259);
			expression();
			setState(260);
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
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralExpressionContext literalExpression() throws RecognitionException {
		LiteralExpressionContext _localctx = new LiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_literalExpression);
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EnumerationLiteralExpression:
				enterOuterAlt(_localctx, 1);
				{
				setState(262);
				enumerationLiteralExpression();
				}
				break;
			case BooleanLiteralExpression:
				enterOuterAlt(_localctx, 2);
				{
				setState(263);
				booleanLiteralExpression();
				}
				break;
			case StringLiteralExpression:
				enterOuterAlt(_localctx, 3);
				{
				setState(264);
				stringLiteralExpression();
				}
				break;
			case DoubleLiteralExpression:
				enterOuterAlt(_localctx, 4);
				{
				setState(265);
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
		public TerminalNode EnumerationLiteralExpression() { return getToken(CSVParser.EnumerationLiteralExpression, 0); }
		public EnumerationLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumerationLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterEnumerationLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitEnumerationLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitEnumerationLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumerationLiteralExpressionContext enumerationLiteralExpression() throws RecognitionException {
		EnumerationLiteralExpressionContext _localctx = new EnumerationLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_enumerationLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
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
		public TerminalNode BooleanLiteralExpression() { return getToken(CSVParser.BooleanLiteralExpression, 0); }
		public BooleanLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterBooleanLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitBooleanLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitBooleanLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralExpressionContext booleanLiteralExpression() throws RecognitionException {
		BooleanLiteralExpressionContext _localctx = new BooleanLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_booleanLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
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
		public TerminalNode StringLiteralExpression() { return getToken(CSVParser.StringLiteralExpression, 0); }
		public StringLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterStringLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitStringLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitStringLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralExpressionContext stringLiteralExpression() throws RecognitionException {
		StringLiteralExpressionContext _localctx = new StringLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_stringLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
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
		public TerminalNode DoubleLiteralExpression() { return getToken(CSVParser.DoubleLiteralExpression, 0); }
		public DoubleLiteralExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleLiteralExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterDoubleLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitDoubleLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitDoubleLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleLiteralExpressionContext doubleLiteralExpression() throws RecognitionException {
		DoubleLiteralExpressionContext _localctx = new DoubleLiteralExpressionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_doubleLiteralExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
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
		public TerminalNode NumberDecision() { return getToken(CSVParser.NumberDecision, 0); }
		public TerminalNode EnumerationDecision() { return getToken(CSVParser.EnumerationDecision, 0); }
		public TerminalNode BooleanDecision() { return getToken(CSVParser.BooleanDecision, 0); }
		public TerminalNode StringDecision() { return getToken(CSVParser.StringDecision, 0); }
		public DecisionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterDecisionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitDecisionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitDecisionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecisionTypeContext decisionType() throws RecognitionException {
		DecisionTypeContext _localctx = new DecisionTypeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_decisionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 12644383719424L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)***REMOVED***Token.EOF ) matchedEOF = true;
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
		public List<RuleContext> rule_() {
			return getRuleContexts(RuleContext.class);
		}
		public RuleContext rule_(int i) {
			return getRuleContext(RuleContext.class,i);
		}
		public TerminalNode IF() { return getToken(CSVParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(CSVParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CSVParser.RBRACE, 0); }
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(CSVParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CSVParser.SEMICOLON, i);
		}
		public RuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitRule(this);
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
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_rule, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(279);
				match(T__4);
				setState(280);
				rule_(0);
				setState(281);
				match(T__4);
				}
				break;
			case IF:
				{
				setState(283);
				match(IF);
				setState(285);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(284);
					match(LPAREN);
					}
					break;
				}
				setState(287);
				expression();
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la***REMOVED***RPAREN) {
					{
					setState(288);
					match(RPAREN);
					}
				}

				setState(291);
				match(LBRACE);
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 35184372090368L) != 0)) {
					{
					{
					setState(292);
					action();
					setState(294);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la***REMOVED***SEMICOLON) {
						{
						setState(293);
						match(SEMICOLON);
						}
					}

					}
					}
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(301);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt***REMOVED***1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RuleContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_rule);
					setState(305);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(306);
					rule_(3);
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
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
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterValueRestrictionAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitValueRestrictionAction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitValueRestrictionAction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueRestrictionActionContext valueRestrictionAction() throws RecognitionException {
		ValueRestrictionActionContext _localctx = new ValueRestrictionActionContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_valueRestrictionAction);
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALLOW:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				allows();
				}
				break;
			case DISALLOW:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				disallows();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(316);
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
		public TerminalNode ALLOW() { return getToken(CSVParser.ALLOW, 0); }
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public TerminalNode EnumerationLiteralExpression() { return getToken(CSVParser.EnumerationLiteralExpression, 0); }
		public AllowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterAllows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitAllows(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitAllows(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllowsContext allows() throws RecognitionException {
		AllowsContext _localctx = new AllowsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_allows);
		try {
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				match(ALLOW);
				setState(320);
				match(LPAREN);
				setState(321);
				match(IDENTIFIER);
				setState(322);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(323);
				match(ALLOW);
				setState(324);
				match(LPAREN);
				setState(325);
				match(EnumerationLiteralExpression);
				setState(326);
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
		public TerminalNode DISALLOW() { return getToken(CSVParser.DISALLOW, 0); }
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public TerminalNode EnumerationLiteralExpression() { return getToken(CSVParser.EnumerationLiteralExpression, 0); }
		public DisallowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disallows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterDisallows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitDisallows(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitDisallows(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisallowsContext disallows() throws RecognitionException {
		DisallowsContext _localctx = new DisallowsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_disallows);
		try {
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(329);
				match(DISALLOW);
				setState(330);
				match(LPAREN);
				setState(331);
				match(IDENTIFIER);
				setState(332);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				match(DISALLOW);
				setState(334);
				match(LPAREN);
				setState(335);
				match(EnumerationLiteralExpression);
				setState(336);
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
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnForceContext enForce() throws RecognitionException {
		EnForceContext _localctx = new EnForceContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_enForce);
		try {
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				enumEnForce();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				booleanEnForce();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				doubleEnForce();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(342);
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
		public List<TerminalNode> IDENTIFIER() { return getTokens(CSVParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(CSVParser.IDENTIFIER, i);
		}
		public TerminalNode SET() { return getToken(CSVParser.SET, 0); }
		public EnumEnForceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumEnForce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterEnumEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitEnumEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitEnumEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumEnForceContext enumEnForce() throws RecognitionException {
		EnumEnForceContext _localctx = new EnumEnForceContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_enumEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(IDENTIFIER);
			setState(346);
			match(SET);
			setState(347);
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
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public TerminalNode SET() { return getToken(CSVParser.SET, 0); }
		public TerminalNode StringLiteralExpression() { return getToken(CSVParser.StringLiteralExpression, 0); }
		public StringEnForceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringEnForce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterStringEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitStringEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitStringEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringEnForceContext stringEnForce() throws RecognitionException {
		StringEnForceContext _localctx = new StringEnForceContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_stringEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(IDENTIFIER);
			setState(350);
			match(SET);
			setState(351);
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
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public TerminalNode SET() { return getToken(CSVParser.SET, 0); }
		public TerminalNode BooleanLiteralExpression() { return getToken(CSVParser.BooleanLiteralExpression, 0); }
		public BooleanEnForceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanEnForce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterBooleanEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitBooleanEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitBooleanEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanEnForceContext booleanEnForce() throws RecognitionException {
		BooleanEnForceContext _localctx = new BooleanEnForceContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_booleanEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(IDENTIFIER);
			setState(354);
			match(SET);
			setState(355);
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
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public TerminalNode SET() { return getToken(CSVParser.SET, 0); }
		public TerminalNode DoubleLiteralExpression() { return getToken(CSVParser.DoubleLiteralExpression, 0); }
		public DoubleEnForceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doubleEnForce; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).enterDoubleEnForce(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSVListener ) ((CSVListener)listener).exitDoubleEnForce(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSVVisitor ) return ((CSVVisitor<? extends T>)visitor).visitDoubleEnForce(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DoubleEnForceContext doubleEnForce() throws RecognitionException {
		DoubleEnForceContext _localctx = new DoubleEnForceContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_doubleEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(IDENTIFIER);
			setState(358);
			match(SET);
			setState(359);
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
		case 31:
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
		"\u0004\u0001-\u016a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0001\u0000\u0001\u0000\u0004\u0000U\b\u0000\u000b\u0000\f\u0000"+
		"V\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002`\b\u0002\n\u0002\f\u0002c\t\u0002\u0001\u0002"+
		"\u0003\u0002f\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003t\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u0080\b\u0007\n\u0007\f\u0007\u0083"+
		"\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0088\b\u0007"+
		"\n\u0007\f\u0007\u008b\t\u0007\u0004\u0007\u008d\b\u0007\u000b\u0007\f"+
		"\u0007\u008e\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0094\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u009d"+
		"\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0005\n\u00a4\b\n\n\n\f\n"+
		"\u00a7\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00ae\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u00b4"+
		"\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00b9\b\r\n\r\f\r\u00bc\t\r\u0001"+
		"\r\u0003\r\u00bf\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00cb\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00d5\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u010b\b\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u011e"+
		"\b\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0122\b\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0003\u001f\u0127\b\u001f\u0005\u001f\u0129\b"+
		"\u001f\n\u001f\f\u001f\u012c\t\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u0130\b\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0134\b\u001f\n\u001f"+
		"\f\u001f\u0137\t\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0003!\u013e"+
		"\b!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003"+
		"\"\u0148\b\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003"+
		"#\u0152\b#\u0001$\u0001$\u0001$\u0001$\u0003$\u0158\b$\u0001%\u0001%\u0001"+
		"%\u0001%\u0001&\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001(\u0001(\u0001(\u0000\u0001>)\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02"+
		"468:<>@BDFHJLNP\u0000\u0004\u0003\u0000\u0017\u001b\u001d\u001f,,\u0001"+
		"\u0000\r\u0013\u0002\u0000\r\u000f\u0012\u0013\u0002\u0000\')++\u0176"+
		"\u0000R\u0001\u0000\u0000\u0000\u0002Z\u0001\u0000\u0000\u0000\u0004\\"+
		"\u0001\u0000\u0000\u0000\u0006s\u0001\u0000\u0000\u0000\bu\u0001\u0000"+
		"\u0000\u0000\nw\u0001\u0000\u0000\u0000\f{\u0001\u0000\u0000\u0000\u000e"+
		"\u0093\u0001\u0000\u0000\u0000\u0010\u009c\u0001\u0000\u0000\u0000\u0012"+
		"\u009e\u0001\u0000\u0000\u0000\u0014\u00a0\u0001\u0000\u0000\u0000\u0016"+
		"\u00ad\u0001\u0000\u0000\u0000\u0018\u00b3\u0001\u0000\u0000\u0000\u001a"+
		"\u00be\u0001\u0000\u0000\u0000\u001c\u00c0\u0001\u0000\u0000\u0000\u001e"+
		"\u00ca\u0001\u0000\u0000\u0000 \u00d4\u0001\u0000\u0000\u0000\"\u00d6"+
		"\u0001\u0000\u0000\u0000$\u00dc\u0001\u0000\u0000\u0000&\u00e2\u0001\u0000"+
		"\u0000\u0000(\u00e8\u0001\u0000\u0000\u0000*\u00ee\u0001\u0000\u0000\u0000"+
		",\u00f4\u0001\u0000\u0000\u0000.\u00fa\u0001\u0000\u0000\u00000\u0100"+
		"\u0001\u0000\u0000\u00002\u010a\u0001\u0000\u0000\u00004\u010c\u0001\u0000"+
		"\u0000\u00006\u010e\u0001\u0000\u0000\u00008\u0110\u0001\u0000\u0000\u0000"+
		":\u0112\u0001\u0000\u0000\u0000<\u0114\u0001\u0000\u0000\u0000>\u012f"+
		"\u0001\u0000\u0000\u0000@\u0138\u0001\u0000\u0000\u0000B\u013d\u0001\u0000"+
		"\u0000\u0000D\u0147\u0001\u0000\u0000\u0000F\u0151\u0001\u0000\u0000\u0000"+
		"H\u0157\u0001\u0000\u0000\u0000J\u0159\u0001\u0000\u0000\u0000L\u015d"+
		"\u0001\u0000\u0000\u0000N\u0161\u0001\u0000\u0000\u0000P\u0165\u0001\u0000"+
		"\u0000\u0000RT\u0003\u0002\u0001\u0000SU\u0003\u0004\u0002\u0000TS\u0001"+
		"\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000"+
		"VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0005\u0000\u0000"+
		"\u0001Y\u0001\u0001\u0000\u0000\u0000Z[\u0003\u0004\u0002\u0000[\u0003"+
		"\u0001\u0000\u0000\u0000\\a\u0003\u0006\u0003\u0000]^\u0005 \u0000\u0000"+
		"^`\u0003\u0006\u0003\u0000_]\u0001\u0000\u0000\u0000`c\u0001\u0000\u0000"+
		"\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000be\u0001\u0000"+
		"\u0000\u0000ca\u0001\u0000\u0000\u0000df\u0005\u0001\u0000\u0000ed\u0001"+
		"\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000"+
		"gh\u0005\u0002\u0000\u0000h\u0005\u0001\u0000\u0000\u0000it\u0003>\u001f"+
		"\u0000jt\u0003\b\u0004\u0000kt\u0003\f\u0006\u0000lt\u0003<\u001e\u0000"+
		"mt\u0003\n\u0005\u0000nt\u0003\u000e\u0007\u0000ot\u0003\u001a\r\u0000"+
		"pt\u0005\b\u0000\u0000qt\u0005-\u0000\u0000rt\u0001\u0000\u0000\u0000"+
		"si\u0001\u0000\u0000\u0000sj\u0001\u0000\u0000\u0000sk\u0001\u0000\u0000"+
		"\u0000sl\u0001\u0000\u0000\u0000sm\u0001\u0000\u0000\u0000sn\u0001\u0000"+
		"\u0000\u0000so\u0001\u0000\u0000\u0000sp\u0001\u0000\u0000\u0000sq\u0001"+
		"\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000t\u0007\u0001\u0000\u0000"+
		"\u0000uv\u0005-\u0000\u0000v\t\u0001\u0000\u0000\u0000wx\u0005$\u0000"+
		"\u0000xy\u0005\u001b\u0000\u0000yz\u0005$\u0000\u0000z\u000b\u0001\u0000"+
		"\u0000\u0000{|\u0005\u0006\u0000\u0000|\r\u0001\u0000\u0000\u0000}\u0081"+
		"\u0003\u0010\b\u0000~\u0080\u0003\u0010\b\u0000\u007f~\u0001\u0000\u0000"+
		"\u0000\u0080\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u008c\u0001\u0000\u0000"+
		"\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0085\u0005\u0015\u0000"+
		"\u0000\u0085\u0089\u0003\u0010\b\u0000\u0086\u0088\u0003\u0010\b\u0000"+
		"\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000\u0000"+
		"\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008c\u0084\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000"+
		"\u008f\u0094\u0001\u0000\u0000\u0000\u0090\u0091\u0005$\u0000\u0000\u0091"+
		"\u0092\u0005\u0003\u0000\u0000\u0092\u0094\u0005$\u0000\u0000\u0093}\u0001"+
		"\u0000\u0000\u0000\u0093\u0090\u0001\u0000\u0000\u0000\u0094\u000f\u0001"+
		"\u0000\u0000\u0000\u0095\u009d\u0005-\u0000\u0000\u0096\u009d\u0003\u0012"+
		"\t\u0000\u0097\u009d\u0003\u0016\u000b\u0000\u0098\u009d\u0003\u0014\n"+
		"\u0000\u0099\u009d\u0003\n\u0005\u0000\u009a\u009d\u0005\u0006\u0000\u0000"+
		"\u009b\u009d\u0005\b\u0000\u0000\u009c\u0095\u0001\u0000\u0000\u0000\u009c"+
		"\u0096\u0001\u0000\u0000\u0000\u009c\u0097\u0001\u0000\u0000\u0000\u009c"+
		"\u0098\u0001\u0000\u0000\u0000\u009c\u0099\u0001\u0000\u0000\u0000\u009c"+
		"\u009a\u0001\u0000\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d"+
		"\u0011\u0001\u0000\u0000\u0000\u009e\u009f\u0007\u0000\u0000\u0000\u009f"+
		"\u0013\u0001\u0000\u0000\u0000\u00a0\u00a5\u0003\u0016\u000b\u0000\u00a1"+
		"\u00a2\u0007\u0001\u0000\u0000\u00a2\u00a4\u0003\u0016\u000b\u0000\u00a3"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6"+
		"\u0015\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8"+
		"\u00ae\u0003\u0018\f\u0000\u00a9\u00ae\u00032\u0019\u0000\u00aa\u00ae"+
		"\u0003\u001c\u000e\u0000\u00ab\u00ae\u0003\u001e\u000f\u0000\u00ac\u00ae"+
		"\u0003 \u0010\u0000\u00ad\u00a8\u0001\u0000\u0000\u0000\u00ad\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ad\u00aa\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000\u00ae\u0017\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0005\u0004\u0000\u0000\u00b0\u00b4\u0003"+
		"\u0016\u000b\u0000\u00b1\u00b2\u0005\u0004\u0000\u0000\u00b2\u00b4\u0005"+
		"%\u0000\u0000\u00b3\u00af\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b4\u0019\u0001\u0000\u0000\u0000\u00b5\u00ba\u0003\u0016"+
		"\u000b\u0000\u00b6\u00b7\u0007\u0002\u0000\u0000\u00b7\u00b9\u0003\u0016"+
		"\u000b\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001\u0000"+
		"\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bb\u00bf\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bf\u0003\u0016\u000b\u0000\u00be\u00b5\u0001\u0000"+
		"\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00bf\u001b\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0005\u000b\u0000\u0000\u00c1\u00c2\u0005\u0017"+
		"\u0000\u0000\u00c2\u00c3\u0005-\u0000\u0000\u00c3\u00c4\u0005\u0018\u0000"+
		"\u0000\u00c4\u001d\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005\f\u0000\u0000"+
		"\u00c6\u00c7\u0005\u0017\u0000\u0000\u00c7\u00c8\u0005-\u0000\u0000\u00c8"+
		"\u00cb\u0005\u0018\u0000\u0000\u00c9\u00cb\u0005-\u0000\u0000\u00ca\u00c5"+
		"\u0001\u0000\u0000\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u001f"+
		"\u0001\u0000\u0000\u0000\u00cc\u00d5\u0003\"\u0011\u0000\u00cd\u00d5\u0003"+
		"$\u0012\u0000\u00ce\u00d5\u0003&\u0013\u0000\u00cf\u00d5\u0003(\u0014"+
		"\u0000\u00d0\u00d5\u0003*\u0015\u0000\u00d1\u00d5\u0003,\u0016\u0000\u00d2"+
		"\u00d5\u0003.\u0017\u0000\u00d3\u00d5\u00030\u0018\u0000\u00d4\u00cc\u0001"+
		"\u0000\u0000\u0000\u00d4\u00cd\u0001\u0000\u0000\u0000\u00d4\u00ce\u0001"+
		"\u0000\u0000\u0000\u00d4\u00cf\u0001\u0000\u0000\u0000\u00d4\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5!\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0005\u0017\u0000\u0000\u00d7\u00d8\u0003\u0016"+
		"\u000b\u0000\u00d8\u00d9\u0005\u0013\u0000\u0000\u00d9\u00da\u0003\u0016"+
		"\u000b\u0000\u00da\u00db\u0005\u0018\u0000\u0000\u00db#\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0005\u0017\u0000\u0000\u00dd\u00de\u0003\u0016\u000b"+
		"\u0000\u00de\u00df\u0005\u0012\u0000\u0000\u00df\u00e0\u0003\u0016\u000b"+
		"\u0000\u00e0\u00e1\u0005\u0018\u0000\u0000\u00e1%\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0005\u0017\u0000\u0000\u00e3\u00e4\u0003\u0016\u000b\u0000"+
		"\u00e4\u00e5\u0005\u0014\u0000\u0000\u00e5\u00e6\u0003\u0016\u000b\u0000"+
		"\u00e6\u00e7\u0005\u0018\u0000\u0000\u00e7\'\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0005\u0017\u0000\u0000\u00e9\u00ea\u0003\u0016\u000b\u0000\u00ea"+
		"\u00eb\u0005\r\u0000\u0000\u00eb\u00ec\u0003\u0016\u000b\u0000\u00ec\u00ed"+
		"\u0005\u0018\u0000\u0000\u00ed)\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005"+
		"\u0017\u0000\u0000\u00ef\u00f0\u0003\u0016\u000b\u0000\u00f0\u00f1\u0005"+
		"\u000e\u0000\u0000\u00f1\u00f2\u0003\u0016\u000b\u0000\u00f2\u00f3\u0005"+
		"\u0018\u0000\u0000\u00f3+\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u0017"+
		"\u0000\u0000\u00f5\u00f6\u0003\u0016\u000b\u0000\u00f6\u00f7\u0005\u000f"+
		"\u0000\u0000\u00f7\u00f8\u0003\u0016\u000b\u0000\u00f8\u00f9\u0005\u0018"+
		"\u0000\u0000\u00f9-\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005\u0017\u0000"+
		"\u0000\u00fb\u00fc\u0003\u0016\u000b\u0000\u00fc\u00fd\u0005\u0011\u0000"+
		"\u0000\u00fd\u00fe\u0003\u0016\u000b\u0000\u00fe\u00ff\u0005\u0018\u0000"+
		"\u0000\u00ff/\u0001\u0000\u0000\u0000\u0100\u0101\u0005\u0017\u0000\u0000"+
		"\u0101\u0102\u0003\u0016\u000b\u0000\u0102\u0103\u0005\u0010\u0000\u0000"+
		"\u0103\u0104\u0003\u0016\u000b\u0000\u0104\u0105\u0005\u0018\u0000\u0000"+
		"\u01051\u0001\u0000\u0000\u0000\u0106\u010b\u00034\u001a\u0000\u0107\u010b"+
		"\u00036\u001b\u0000\u0108\u010b\u00038\u001c\u0000\u0109\u010b\u0003:"+
		"\u001d\u0000\u010a\u0106\u0001\u0000\u0000\u0000\u010a\u0107\u0001\u0000"+
		"\u0000\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010a\u0109\u0001\u0000"+
		"\u0000\u0000\u010b3\u0001\u0000\u0000\u0000\u010c\u010d\u0005%\u0000\u0000"+
		"\u010d5\u0001\u0000\u0000\u0000\u010e\u010f\u0005!\u0000\u0000\u010f7"+
		"\u0001\u0000\u0000\u0000\u0110\u0111\u0005&\u0000\u0000\u01119\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\u0005$\u0000\u0000\u0113;\u0001\u0000\u0000\u0000"+
		"\u0114\u0115\u0007\u0003\u0000\u0000\u0115=\u0001\u0000\u0000\u0000\u0116"+
		"\u0117\u0006\u001f\uffff\uffff\u0000\u0117\u0118\u0005\u0005\u0000\u0000"+
		"\u0118\u0119\u0003>\u001f\u0000\u0119\u011a\u0005\u0005\u0000\u0000\u011a"+
		"\u0130\u0001\u0000\u0000\u0000\u011b\u011d\u0005\u001c\u0000\u0000\u011c"+
		"\u011e\u0005\u0017\u0000\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d"+
		"\u011e\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f"+
		"\u0121\u0003\u0016\u000b\u0000\u0120\u0122\u0005\u0018\u0000\u0000\u0121"+
		"\u0120\u0001\u0000\u0000\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0001\u0000\u0000\u0000\u0123\u012a\u0005\u0019\u0000\u0000\u0124"+
		"\u0126\u0003@ \u0000\u0125\u0127\u0005 \u0000\u0000\u0126\u0125\u0001"+
		"\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127\u0129\u0001"+
		"\u0000\u0000\u0000\u0128\u0124\u0001\u0000\u0000\u0000\u0129\u012c\u0001"+
		"\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012a\u012b\u0001"+
		"\u0000\u0000\u0000\u012b\u012d\u0001\u0000\u0000\u0000\u012c\u012a\u0001"+
		"\u0000\u0000\u0000\u012d\u012e\u0005\u001a\u0000\u0000\u012e\u0130\u0001"+
		"\u0000\u0000\u0000\u012f\u0116\u0001\u0000\u0000\u0000\u012f\u011b\u0001"+
		"\u0000\u0000\u0000\u0130\u0135\u0001\u0000\u0000\u0000\u0131\u0132\n\u0002"+
		"\u0000\u0000\u0132\u0134\u0003>\u001f\u0003\u0133\u0131\u0001\u0000\u0000"+
		"\u0000\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000"+
		"\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136?\u0001\u0000\u0000\u0000"+
		"\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u0139\u0003B!\u0000\u0139A"+
		"\u0001\u0000\u0000\u0000\u013a\u013e\u0003D\"\u0000\u013b\u013e\u0003"+
		"F#\u0000\u013c\u013e\u0003H$\u0000\u013d\u013a\u0001\u0000\u0000\u0000"+
		"\u013d\u013b\u0001\u0000\u0000\u0000\u013d\u013c\u0001\u0000\u0000\u0000"+
		"\u013eC\u0001\u0000\u0000\u0000\u013f\u0140\u0005\t\u0000\u0000\u0140"+
		"\u0141\u0005\u0017\u0000\u0000\u0141\u0142\u0005-\u0000\u0000\u0142\u0148"+
		"\u0005\u0018\u0000\u0000\u0143\u0144\u0005\t\u0000\u0000\u0144\u0145\u0005"+
		"\u0017\u0000\u0000\u0145\u0146\u0005%\u0000\u0000\u0146\u0148\u0005\u0018"+
		"\u0000\u0000\u0147\u013f\u0001\u0000\u0000\u0000\u0147\u0143\u0001\u0000"+
		"\u0000\u0000\u0148E\u0001\u0000\u0000\u0000\u0149\u014a\u0005\n\u0000"+
		"\u0000\u014a\u014b\u0005\u0017\u0000\u0000\u014b\u014c\u0005-\u0000\u0000"+
		"\u014c\u0152\u0005\u0018\u0000\u0000\u014d\u014e\u0005\n\u0000\u0000\u014e"+
		"\u014f\u0005\u0017\u0000\u0000\u014f\u0150\u0005%\u0000\u0000\u0150\u0152"+
		"\u0005\u0018\u0000\u0000\u0151\u0149\u0001\u0000\u0000\u0000\u0151\u014d"+
		"\u0001\u0000\u0000\u0000\u0152G\u0001\u0000\u0000\u0000\u0153\u0158\u0003"+
		"J%\u0000\u0154\u0158\u0003N\'\u0000\u0155\u0158\u0003P(\u0000\u0156\u0158"+
		"\u0003L&\u0000\u0157\u0153\u0001\u0000\u0000\u0000\u0157\u0154\u0001\u0000"+
		"\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000\u0157\u0156\u0001\u0000"+
		"\u0000\u0000\u0158I\u0001\u0000\u0000\u0000\u0159\u015a\u0005-\u0000\u0000"+
		"\u015a\u015b\u0005\u0016\u0000\u0000\u015b\u015c\u0005-\u0000\u0000\u015c"+
		"K\u0001\u0000\u0000\u0000\u015d\u015e\u0005-\u0000\u0000\u015e\u015f\u0005"+
		"\u0016\u0000\u0000\u015f\u0160\u0005&\u0000\u0000\u0160M\u0001\u0000\u0000"+
		"\u0000\u0161\u0162\u0005-\u0000\u0000\u0162\u0163\u0005\u0016\u0000\u0000"+
		"\u0163\u0164\u0005!\u0000\u0000\u0164O\u0001\u0000\u0000\u0000\u0165\u0166"+
		"\u0005-\u0000\u0000\u0166\u0167\u0005\u0016\u0000\u0000\u0167\u0168\u0005"+
		"$\u0000\u0000\u0168Q\u0001\u0000\u0000\u0000\u001bVaes\u0081\u0089\u008e"+
		"\u0093\u009c\u00a5\u00ad\u00b3\u00ba\u00be\u00ca\u00d4\u010a\u011d\u0121"+
		"\u0126\u012a\u012f\u0135\u013d\u0147\u0151\u0157";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
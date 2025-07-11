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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, QUESTION=7, WS=8, HEADER=9, 
		ALLOW=10, DISALLOW=11, ISTAKEN=12, GETVALUE=13, EQUALS=14, GREATER_THAN=15, 
		LESS_THAN=16, LESS_EQUALS=17, GREATER_EQUALS=18, OR=19, AND=20, XOR=21, 
		PIPE=22, SET=23, LPAREN=24, RPAREN=25, LBRACE=26, RBRACE=27, COLON=28, 
		IF=29, BooleanLiteralExpression=30, TRUE=31, FALSE=32, DoubleLiteralExpression=33, 
		EnumerationLiteralExpression=34, StringLiteralExpression=35, ValueDecision=36, 
		StringDecision=37, NumberDecision=38, EnumerationDecision=39, ENUMERATION=40, 
		BooleanDecision=41, IDENTIFIER=42;
	public static final int
		RULE_csvFile = 0, RULE_hdr = 1, RULE_row = 2, RULE_field = 3, RULE_id = 4, 
		RULE_cardinality = 5, RULE_question = 6, RULE_expression = 7, RULE_unaryExpression = 8, 
		RULE_range = 9, RULE_decisionVisibilityCallExpression = 10, RULE_isTaken = 11, 
		RULE_decisionValueCallExpression = 12, RULE_binaryExpression = 13, RULE_andExpression = 14, 
		RULE_orExpression = 15, RULE_xorExpression = 16, RULE_equalityExpression = 17, 
		RULE_greaterThanExpression = 18, RULE_lessThanExpression = 19, RULE_greaterEqualsExpression = 20, 
		RULE_lessEqualsExpression = 21, RULE_literalExpression = 22, RULE_decisionType = 23, 
		RULE_rule = 24, RULE_action = 25, RULE_valueRestrictionAction = 26, RULE_allows = 27, 
		RULE_disallows = 28, RULE_enForce = 29, RULE_enumEnForce = 30, RULE_stringEnForce = 31, 
		RULE_booleanEnForce = 32, RULE_doubleEnForce = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"csvFile", "hdr", "row", "field", "id", "cardinality", "question", "expression", 
			"unaryExpression", "range", "decisionVisibilityCallExpression", "isTaken", 
			"decisionValueCallExpression", "binaryExpression", "andExpression", "orExpression", 
			"xorExpression", "equalityExpression", "greaterThanExpression", "lessThanExpression", 
			"greaterEqualsExpression", "lessEqualsExpression", "literalExpression", 
			"decisionType", "rule", "action", "valueRestrictionAction", "allows", 
			"disallows", "enForce", "enumEnForce", "stringEnForce", "booleanEnForce", 
			"doubleEnForce"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'\\r'", "'\\n'", "'!'", "'-'", "'\"'", null, null, null, 
			null, null, null, null, "'***REMOVED***'", "'>'", "'<'", "'<='", "'>='", "'||'", 
			"'&&'", "'^'", "'|'", "'='", "'('", "')'", "'{'", "'}'", "':'", "'if'", 
			null, null, null, null, null, null, null, "'String'", "'Double'", null, 
			"'Enumeration'", "'Boolean'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "QUESTION", "WS", "HEADER", 
			"ALLOW", "DISALLOW", "ISTAKEN", "GETVALUE", "EQUALS", "GREATER_THAN", 
			"LESS_THAN", "LESS_EQUALS", "GREATER_EQUALS", "OR", "AND", "XOR", "PIPE", 
			"SET", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "COLON", "IF", "BooleanLiteralExpression", 
			"TRUE", "FALSE", "DoubleLiteralExpression", "EnumerationLiteralExpression", 
			"StringLiteralExpression", "ValueDecision", "StringDecision", "NumberDecision", 
			"EnumerationDecision", "ENUMERATION", "BooleanDecision", "IDENTIFIER"
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
			setState(68);
			hdr();
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				row();
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 7414740955870L) != 0) );
			setState(74);
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
			setState(76);
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
			setState(78);
			field();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la***REMOVED***T__0) {
				{
				{
				setState(79);
				match(T__0);
				setState(80);
				field();
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la***REMOVED***T__1) {
				{
				setState(86);
				match(T__1);
				}
			}

			setState(89);
			match(T__2);
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
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				rule_(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				question();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				decisionType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				cardinality();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				range();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(97);
				decisionVisibilityCallExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(98);
				match(HEADER);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(99);
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
			setState(103);
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
			setState(105);
			match(DoubleLiteralExpression);
			setState(106);
			match(COLON);
			setState(107);
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
			setState(109);
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
		enterRule(_localctx, 14, RULE_expression);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				unaryExpression();
				}
				break;
			case BooleanLiteralExpression:
			case DoubleLiteralExpression:
			case EnumerationLiteralExpression:
			case StringLiteralExpression:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				literalExpression();
				}
				break;
			case ISTAKEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				isTaken();
				}
				break;
			case GETVALUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(114);
				decisionValueCallExpression();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(115);
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
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 16, RULE_unaryExpression);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(118);
				match(T__3);
				setState(119);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(T__3);
				setState(121);
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
	public static class RangeContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(CSVParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(CSVParser.IDENTIFIER, i);
		}
		public List<LiteralExpressionContext> literalExpression() {
			return getRuleContexts(LiteralExpressionContext.class);
		}
		public LiteralExpressionContext literalExpression(int i) {
			return getRuleContext(LiteralExpressionContext.class,i);
		}
		public List<BinaryExpressionContext> binaryExpression() {
			return getRuleContexts(BinaryExpressionContext.class);
		}
		public BinaryExpressionContext binaryExpression(int i) {
			return getRuleContext(BinaryExpressionContext.class,i);
		}
		public List<CardinalityContext> cardinality() {
			return getRuleContexts(CardinalityContext.class);
		}
		public CardinalityContext cardinality(int i) {
			return getRuleContext(CardinalityContext.class,i);
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
		enterRule(_localctx, 18, RULE_range);
		int _la;
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(128);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						setState(124);
						match(IDENTIFIER);
						}
						break;
					case 2:
						{
						setState(125);
						literalExpression();
						}
						break;
					case 3:
						{
						setState(126);
						binaryExpression();
						}
						break;
					case 4:
						{
						setState(127);
						cardinality();
						}
						break;
					}
					}
					setState(130); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 4459266572288L) != 0) );
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(132);
					match(PIPE);
					setState(137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						setState(137);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
						case 1:
							{
							setState(133);
							match(IDENTIFIER);
							}
							break;
						case 2:
							{
							setState(134);
							literalExpression();
							}
							break;
						case 3:
							{
							setState(135);
							binaryExpression();
							}
							break;
						case 4:
							{
							setState(136);
							cardinality();
							}
							break;
						}
						}
						setState(139); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 4459266572288L) != 0) );
					}
					}
					setState(143); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la***REMOVED***PIPE );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(DoubleLiteralExpression);
				setState(146);
				match(T__4);
				setState(147);
				match(DoubleLiteralExpression);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(IDENTIFIER);
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(149);
					match(T__4);
					setState(150);
					match(IDENTIFIER);
					}
					}
					setState(153); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la***REMOVED***T__4 );
				{
				setState(155);
				match(PIPE);
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(160);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						setState(156);
						match(IDENTIFIER);
						}
						break;
					case 2:
						{
						setState(157);
						literalExpression();
						}
						break;
					case 3:
						{
						setState(158);
						binaryExpression();
						}
						break;
					case 4:
						{
						setState(159);
						cardinality();
						}
						break;
					}
					}
					setState(162); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 4459266572288L) != 0) );
				}
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
		public TerminalNode AND() { return getToken(CSVParser.AND, 0); }
		public TerminalNode OR() { return getToken(CSVParser.OR, 0); }
		public TerminalNode EQUALS() { return getToken(CSVParser.EQUALS, 0); }
		public TerminalNode GREATER_THAN() { return getToken(CSVParser.GREATER_THAN, 0); }
		public TerminalNode LESS_THAN() { return getToken(CSVParser.LESS_THAN, 0); }
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
		enterRule(_localctx, 20, RULE_decisionVisibilityCallExpression);
		int _la;
		try {
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				expression();
				setState(167);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 1687552L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)***REMOVED***Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(168);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 22, RULE_isTaken);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				match(ISTAKEN);
				setState(174);
				match(LPAREN);
				setState(175);
				match(IDENTIFIER);
				setState(176);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(ISTAKEN);
				setState(178);
				match(LPAREN);
				setState(179);
				expression();
				setState(180);
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
	public static class DecisionValueCallExpressionContext extends ParserRuleContext {
		public TerminalNode GETVALUE() { return getToken(CSVParser.GETVALUE, 0); }
		public TerminalNode LPAREN() { return getToken(CSVParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(CSVParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 24, RULE_decisionValueCallExpression);
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(GETVALUE);
				setState(185);
				match(LPAREN);
				setState(186);
				match(IDENTIFIER);
				setState(187);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(GETVALUE);
				setState(189);
				match(LPAREN);
				setState(190);
				expression();
				setState(191);
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
		enterRule(_localctx, 26, RULE_binaryExpression);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				andExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				orExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				xorExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(198);
				equalityExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(199);
				greaterThanExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(200);
				lessThanExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(201);
				greaterEqualsExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(202);
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
		enterRule(_localctx, 28, RULE_andExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(LPAREN);
			setState(206);
			expression();
			setState(207);
			match(AND);
			setState(208);
			expression();
			setState(209);
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
		enterRule(_localctx, 30, RULE_orExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(LPAREN);
			setState(212);
			expression();
			setState(213);
			match(OR);
			setState(214);
			expression();
			setState(215);
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
		enterRule(_localctx, 32, RULE_xorExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(LPAREN);
			setState(218);
			expression();
			setState(219);
			match(XOR);
			setState(220);
			expression();
			setState(221);
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
		enterRule(_localctx, 34, RULE_equalityExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(LPAREN);
			setState(224);
			expression();
			setState(225);
			match(EQUALS);
			setState(226);
			expression();
			setState(227);
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
		enterRule(_localctx, 36, RULE_greaterThanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(LPAREN);
			setState(230);
			expression();
			setState(231);
			match(GREATER_THAN);
			setState(232);
			expression();
			setState(233);
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
		enterRule(_localctx, 38, RULE_lessThanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(LPAREN);
			setState(236);
			expression();
			setState(237);
			match(LESS_THAN);
			setState(238);
			expression();
			setState(239);
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
		enterRule(_localctx, 40, RULE_greaterEqualsExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(LPAREN);
			setState(242);
			expression();
			setState(243);
			match(GREATER_EQUALS);
			setState(244);
			expression();
			setState(245);
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
		enterRule(_localctx, 42, RULE_lessEqualsExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(LPAREN);
			setState(248);
			expression();
			setState(249);
			match(LESS_EQUALS);
			setState(250);
			expression();
			setState(251);
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
		public TerminalNode EnumerationLiteralExpression() { return getToken(CSVParser.EnumerationLiteralExpression, 0); }
		public TerminalNode BooleanLiteralExpression() { return getToken(CSVParser.BooleanLiteralExpression, 0); }
		public TerminalNode StringLiteralExpression() { return getToken(CSVParser.StringLiteralExpression, 0); }
		public TerminalNode DoubleLiteralExpression() { return getToken(CSVParser.DoubleLiteralExpression, 0); }
		public TerminalNode IDENTIFIER() { return getToken(CSVParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 44, RULE_literalExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 4459249795072L) != 0)) ) {
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
	public static class DecisionTypeContext extends ParserRuleContext {
		public TerminalNode ValueDecision() { return getToken(CSVParser.ValueDecision, 0); }
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
		enterRule(_localctx, 46, RULE_decisionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 2954937499648L) != 0)) ) {
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_rule, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(258);
				match(T__5);
				setState(259);
				rule_(0);
				setState(260);
				match(T__5);
				}
				break;
			case IF:
				{
				setState(262);
				match(IF);
				setState(264);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(263);
					match(LPAREN);
					}
					break;
				}
				setState(266);
				expression();
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la***REMOVED***RPAREN) {
					{
					setState(267);
					match(RPAREN);
					}
				}

				setState(270);
				match(LBRACE);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 4398046514176L) != 0)) {
					{
					{
					setState(271);
					action();
					setState(273);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la***REMOVED***T__0) {
						{
						setState(272);
						match(T__0);
						}
					}

					}
					}
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(280);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt***REMOVED***1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RuleContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_rule);
					setState(284);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(285);
					rule_(3);
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
		enterRule(_localctx, 50, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
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
		enterRule(_localctx, 52, RULE_valueRestrictionAction);
		try {
			setState(296);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALLOW:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				allows();
				}
				break;
			case DISALLOW:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				disallows();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
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
		enterRule(_localctx, 54, RULE_allows);
		try {
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				match(ALLOW);
				setState(299);
				match(LPAREN);
				setState(300);
				match(IDENTIFIER);
				setState(301);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(302);
				match(ALLOW);
				setState(303);
				match(LPAREN);
				setState(304);
				match(EnumerationLiteralExpression);
				setState(305);
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
		enterRule(_localctx, 56, RULE_disallows);
		try {
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				match(DISALLOW);
				setState(309);
				match(LPAREN);
				setState(310);
				match(IDENTIFIER);
				setState(311);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(312);
				match(DISALLOW);
				setState(313);
				match(LPAREN);
				setState(314);
				match(EnumerationLiteralExpression);
				setState(315);
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
		enterRule(_localctx, 58, RULE_enForce);
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				enumEnForce();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				booleanEnForce();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				doubleEnForce();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(321);
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
		enterRule(_localctx, 60, RULE_enumEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(IDENTIFIER);
			setState(325);
			match(SET);
			setState(326);
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
		enterRule(_localctx, 62, RULE_stringEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(IDENTIFIER);
			setState(329);
			match(SET);
			setState(330);
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
		enterRule(_localctx, 64, RULE_booleanEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(IDENTIFIER);
			setState(333);
			match(SET);
			setState(334);
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
		enterRule(_localctx, 66, RULE_doubleEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(IDENTIFIER);
			setState(337);
			match(SET);
			setState(338);
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
		case 24:
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
		"\u0004\u0001*\u0155\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0001\u0000\u0001"+
		"\u0000\u0004\u0000G\b\u0000\u000b\u0000\f\u0000H\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"R\b\u0002\n\u0002\f\u0002U\t\u0002\u0001\u0002\u0003\u0002X\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003f\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007u\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b{\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u0081"+
		"\b\t\u000b\t\f\t\u0082\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t"+
		"\u008a\b\t\u000b\t\f\t\u008b\u0004\t\u008e\b\t\u000b\t\f\t\u008f\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u0098\b\t\u000b\t\f"+
		"\t\u0099\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00a1\b\t\u000b"+
		"\t\f\t\u00a2\u0003\t\u00a5\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0003\n\u00ac\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b7"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u00c2\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00cc\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0109\b\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u010d\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u0112\b\u0018\u0005\u0018\u0114\b\u0018\n\u0018\f\u0018\u0117\t\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u011b\b\u0018\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u011f\b\u0018\n\u0018\f\u0018\u0122\t\u0018\u0001\u0019\u0001"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u0129\b\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0003\u001b\u0133\b\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0003"+
		"\u001c\u013d\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003"+
		"\u001d\u0143\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001!\u0001!\u0001!\u0001!\u0001!\u0000\u00010\"\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"$&(*,.02468:<>@B\u0000\u0003\u0002\u0000\u000e\u0010\u0013\u0014\u0003"+
		"\u0000\u001e\u001e!#**\u0003\u0000$%\'\'))\u016a\u0000D\u0001\u0000\u0000"+
		"\u0000\u0002L\u0001\u0000\u0000\u0000\u0004N\u0001\u0000\u0000\u0000\u0006"+
		"e\u0001\u0000\u0000\u0000\bg\u0001\u0000\u0000\u0000\ni\u0001\u0000\u0000"+
		"\u0000\fm\u0001\u0000\u0000\u0000\u000et\u0001\u0000\u0000\u0000\u0010"+
		"z\u0001\u0000\u0000\u0000\u0012\u00a4\u0001\u0000\u0000\u0000\u0014\u00ab"+
		"\u0001\u0000\u0000\u0000\u0016\u00b6\u0001\u0000\u0000\u0000\u0018\u00c1"+
		"\u0001\u0000\u0000\u0000\u001a\u00cb\u0001\u0000\u0000\u0000\u001c\u00cd"+
		"\u0001\u0000\u0000\u0000\u001e\u00d3\u0001\u0000\u0000\u0000 \u00d9\u0001"+
		"\u0000\u0000\u0000\"\u00df\u0001\u0000\u0000\u0000$\u00e5\u0001\u0000"+
		"\u0000\u0000&\u00eb\u0001\u0000\u0000\u0000(\u00f1\u0001\u0000\u0000\u0000"+
		"*\u00f7\u0001\u0000\u0000\u0000,\u00fd\u0001\u0000\u0000\u0000.\u00ff"+
		"\u0001\u0000\u0000\u00000\u011a\u0001\u0000\u0000\u00002\u0123\u0001\u0000"+
		"\u0000\u00004\u0128\u0001\u0000\u0000\u00006\u0132\u0001\u0000\u0000\u0000"+
		"8\u013c\u0001\u0000\u0000\u0000:\u0142\u0001\u0000\u0000\u0000<\u0144"+
		"\u0001\u0000\u0000\u0000>\u0148\u0001\u0000\u0000\u0000@\u014c\u0001\u0000"+
		"\u0000\u0000B\u0150\u0001\u0000\u0000\u0000DF\u0003\u0002\u0001\u0000"+
		"EG\u0003\u0004\u0002\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000"+
		"\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000JK\u0005\u0000\u0000\u0001K\u0001\u0001\u0000\u0000\u0000"+
		"LM\u0003\u0004\u0002\u0000M\u0003\u0001\u0000\u0000\u0000NS\u0003\u0006"+
		"\u0003\u0000OP\u0005\u0001\u0000\u0000PR\u0003\u0006\u0003\u0000QO\u0001"+
		"\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000"+
		"ST\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000VX\u0005\u0002\u0000\u0000WV\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0005\u0003\u0000\u0000Z\u0005"+
		"\u0001\u0000\u0000\u0000[f\u00030\u0018\u0000\\f\u0003\b\u0004\u0000]"+
		"f\u0003\f\u0006\u0000^f\u0003.\u0017\u0000_f\u0003\n\u0005\u0000`f\u0003"+
		"\u0012\t\u0000af\u0003\u0014\n\u0000bf\u0005\t\u0000\u0000cf\u0005*\u0000"+
		"\u0000df\u0001\u0000\u0000\u0000e[\u0001\u0000\u0000\u0000e\\\u0001\u0000"+
		"\u0000\u0000e]\u0001\u0000\u0000\u0000e^\u0001\u0000\u0000\u0000e_\u0001"+
		"\u0000\u0000\u0000e`\u0001\u0000\u0000\u0000ea\u0001\u0000\u0000\u0000"+
		"eb\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000ed\u0001\u0000\u0000"+
		"\u0000f\u0007\u0001\u0000\u0000\u0000gh\u0005*\u0000\u0000h\t\u0001\u0000"+
		"\u0000\u0000ij\u0005!\u0000\u0000jk\u0005\u001c\u0000\u0000kl\u0005!\u0000"+
		"\u0000l\u000b\u0001\u0000\u0000\u0000mn\u0005\u0007\u0000\u0000n\r\u0001"+
		"\u0000\u0000\u0000ou\u0003\u0010\b\u0000pu\u0003,\u0016\u0000qu\u0003"+
		"\u0016\u000b\u0000ru\u0003\u0018\f\u0000su\u0003\u001a\r\u0000to\u0001"+
		"\u0000\u0000\u0000tp\u0001\u0000\u0000\u0000tq\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000ts\u0001\u0000\u0000\u0000u\u000f\u0001\u0000"+
		"\u0000\u0000vw\u0005\u0004\u0000\u0000w{\u0005*\u0000\u0000xy\u0005\u0004"+
		"\u0000\u0000y{\u0005\"\u0000\u0000zv\u0001\u0000\u0000\u0000zx\u0001\u0000"+
		"\u0000\u0000{\u0011\u0001\u0000\u0000\u0000|\u0081\u0005*\u0000\u0000"+
		"}\u0081\u0003,\u0016\u0000~\u0081\u0003\u001a\r\u0000\u007f\u0081\u0003"+
		"\n\u0005\u0000\u0080|\u0001\u0000\u0000\u0000\u0080}\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0080\u007f\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u008d\u0001\u0000\u0000\u0000"+
		"\u0084\u0089\u0005\u0016\u0000\u0000\u0085\u008a\u0005*\u0000\u0000\u0086"+
		"\u008a\u0003,\u0016\u0000\u0087\u008a\u0003\u001a\r\u0000\u0088\u008a"+
		"\u0003\n\u0005\u0000\u0089\u0085\u0001\u0000\u0000\u0000\u0089\u0086\u0001"+
		"\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001"+
		"\u0000\u0000\u0000\u008d\u0084\u0001\u0000\u0000\u0000\u008e\u008f\u0001"+
		"\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001"+
		"\u0000\u0000\u0000\u0090\u00a5\u0001\u0000\u0000\u0000\u0091\u0092\u0005"+
		"!\u0000\u0000\u0092\u0093\u0005\u0005\u0000\u0000\u0093\u00a5\u0005!\u0000"+
		"\u0000\u0094\u0097\u0005*\u0000\u0000\u0095\u0096\u0005\u0005\u0000\u0000"+
		"\u0096\u0098\u0005*\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b"+
		"\u00a0\u0005\u0016\u0000\u0000\u009c\u00a1\u0005*\u0000\u0000\u009d\u00a1"+
		"\u0003,\u0016\u0000\u009e\u00a1\u0003\u001a\r\u0000\u009f\u00a1\u0003"+
		"\n\u0005\u0000\u00a0\u009c\u0001\u0000\u0000\u0000\u00a0\u009d\u0001\u0000"+
		"\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u009f\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a4\u0080\u0001\u0000\u0000\u0000\u00a4\u0091\u0001\u0000"+
		"\u0000\u0000\u00a4\u0094\u0001\u0000\u0000\u0000\u00a5\u0013\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0003\u000e\u0007\u0000\u00a7\u00a8\u0007\u0000"+
		"\u0000\u0000\u00a8\u00a9\u0003\u000e\u0007\u0000\u00a9\u00ac\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ac\u0003\u000e\u0007\u0000\u00ab\u00a6\u0001\u0000"+
		"\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u0015\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0005\f\u0000\u0000\u00ae\u00af\u0005\u0018\u0000"+
		"\u0000\u00af\u00b0\u0005*\u0000\u0000\u00b0\u00b7\u0005\u0019\u0000\u0000"+
		"\u00b1\u00b2\u0005\f\u0000\u0000\u00b2\u00b3\u0005\u0018\u0000\u0000\u00b3"+
		"\u00b4\u0003\u000e\u0007\u0000\u00b4\u00b5\u0005\u0019\u0000\u0000\u00b5"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b6\u00ad\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b7\u0017\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b9\u0005\r\u0000\u0000\u00b9\u00ba\u0005\u0018\u0000\u0000\u00ba\u00bb"+
		"\u0005*\u0000\u0000\u00bb\u00c2\u0005\u0019\u0000\u0000\u00bc\u00bd\u0005"+
		"\r\u0000\u0000\u00bd\u00be\u0005\u0018\u0000\u0000\u00be\u00bf\u0003\u000e"+
		"\u0007\u0000\u00bf\u00c0\u0005\u0019\u0000\u0000\u00c0\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c1\u00b8\u0001\u0000\u0000\u0000\u00c1\u00bc\u0001\u0000"+
		"\u0000\u0000\u00c2\u0019\u0001\u0000\u0000\u0000\u00c3\u00cc\u0003\u001c"+
		"\u000e\u0000\u00c4\u00cc\u0003\u001e\u000f\u0000\u00c5\u00cc\u0003 \u0010"+
		"\u0000\u00c6\u00cc\u0003\"\u0011\u0000\u00c7\u00cc\u0003$\u0012\u0000"+
		"\u00c8\u00cc\u0003&\u0013\u0000\u00c9\u00cc\u0003(\u0014\u0000\u00ca\u00cc"+
		"\u0003*\u0015\u0000\u00cb\u00c3\u0001\u0000\u0000\u0000\u00cb\u00c4\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c5\u0001\u0000\u0000\u0000\u00cb\u00c6\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c7\u0001\u0000\u0000\u0000\u00cb\u00c8\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ca\u0001"+
		"\u0000\u0000\u0000\u00cc\u001b\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005"+
		"\u0018\u0000\u0000\u00ce\u00cf\u0003\u000e\u0007\u0000\u00cf\u00d0\u0005"+
		"\u0014\u0000\u0000\u00d0\u00d1\u0003\u000e\u0007\u0000\u00d1\u00d2\u0005"+
		"\u0019\u0000\u0000\u00d2\u001d\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005"+
		"\u0018\u0000\u0000\u00d4\u00d5\u0003\u000e\u0007\u0000\u00d5\u00d6\u0005"+
		"\u0013\u0000\u0000\u00d6\u00d7\u0003\u000e\u0007\u0000\u00d7\u00d8\u0005"+
		"\u0019\u0000\u0000\u00d8\u001f\u0001\u0000\u0000\u0000\u00d9\u00da\u0005"+
		"\u0018\u0000\u0000\u00da\u00db\u0003\u000e\u0007\u0000\u00db\u00dc\u0005"+
		"\u0015\u0000\u0000\u00dc\u00dd\u0003\u000e\u0007\u0000\u00dd\u00de\u0005"+
		"\u0019\u0000\u0000\u00de!\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0018"+
		"\u0000\u0000\u00e0\u00e1\u0003\u000e\u0007\u0000\u00e1\u00e2\u0005\u000e"+
		"\u0000\u0000\u00e2\u00e3\u0003\u000e\u0007\u0000\u00e3\u00e4\u0005\u0019"+
		"\u0000\u0000\u00e4#\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005\u0018\u0000"+
		"\u0000\u00e6\u00e7\u0003\u000e\u0007\u0000\u00e7\u00e8\u0005\u000f\u0000"+
		"\u0000\u00e8\u00e9\u0003\u000e\u0007\u0000\u00e9\u00ea\u0005\u0019\u0000"+
		"\u0000\u00ea%\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\u0018\u0000\u0000"+
		"\u00ec\u00ed\u0003\u000e\u0007\u0000\u00ed\u00ee\u0005\u0010\u0000\u0000"+
		"\u00ee\u00ef\u0003\u000e\u0007\u0000\u00ef\u00f0\u0005\u0019\u0000\u0000"+
		"\u00f0\'\u0001\u0000\u0000\u0000\u00f1\u00f2\u0005\u0018\u0000\u0000\u00f2"+
		"\u00f3\u0003\u000e\u0007\u0000\u00f3\u00f4\u0005\u0012\u0000\u0000\u00f4"+
		"\u00f5\u0003\u000e\u0007\u0000\u00f5\u00f6\u0005\u0019\u0000\u0000\u00f6"+
		")\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u0018\u0000\u0000\u00f8\u00f9"+
		"\u0003\u000e\u0007\u0000\u00f9\u00fa\u0005\u0011\u0000\u0000\u00fa\u00fb"+
		"\u0003\u000e\u0007\u0000\u00fb\u00fc\u0005\u0019\u0000\u0000\u00fc+\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fe\u0007\u0001\u0000\u0000\u00fe-\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0007\u0002\u0000\u0000\u0100/\u0001\u0000\u0000"+
		"\u0000\u0101\u0102\u0006\u0018\uffff\uffff\u0000\u0102\u0103\u0005\u0006"+
		"\u0000\u0000\u0103\u0104\u00030\u0018\u0000\u0104\u0105\u0005\u0006\u0000"+
		"\u0000\u0105\u011b\u0001\u0000\u0000\u0000\u0106\u0108\u0005\u001d\u0000"+
		"\u0000\u0107\u0109\u0005\u0018\u0000\u0000\u0108\u0107\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000"+
		"\u0000\u010a\u010c\u0003\u000e\u0007\u0000\u010b\u010d\u0005\u0019\u0000"+
		"\u0000\u010c\u010b\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u0115\u0005\u001a\u0000"+
		"\u0000\u010f\u0111\u00032\u0019\u0000\u0110\u0112\u0005\u0001\u0000\u0000"+
		"\u0111\u0110\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000"+
		"\u0112\u0114\u0001\u0000\u0000\u0000\u0113\u010f\u0001\u0000\u0000\u0000"+
		"\u0114\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0118\u0001\u0000\u0000\u0000"+
		"\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u0119\u0005\u001b\u0000\u0000"+
		"\u0119\u011b\u0001\u0000\u0000\u0000\u011a\u0101\u0001\u0000\u0000\u0000"+
		"\u011a\u0106\u0001\u0000\u0000\u0000\u011b\u0120\u0001\u0000\u0000\u0000"+
		"\u011c\u011d\n\u0002\u0000\u0000\u011d\u011f\u00030\u0018\u0003\u011e"+
		"\u011c\u0001\u0000\u0000\u0000\u011f\u0122\u0001\u0000\u0000\u0000\u0120"+
		"\u011e\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121"+
		"1\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u00034\u001a\u0000\u01243\u0001\u0000\u0000\u0000\u0125\u0129\u00036"+
		"\u001b\u0000\u0126\u0129\u00038\u001c\u0000\u0127\u0129\u0003:\u001d\u0000"+
		"\u0128\u0125\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000"+
		"\u0128\u0127\u0001\u0000\u0000\u0000\u01295\u0001\u0000\u0000\u0000\u012a"+
		"\u012b\u0005\n\u0000\u0000\u012b\u012c\u0005\u0018\u0000\u0000\u012c\u012d"+
		"\u0005*\u0000\u0000\u012d\u0133\u0005\u0019\u0000\u0000\u012e\u012f\u0005"+
		"\n\u0000\u0000\u012f\u0130\u0005\u0018\u0000\u0000\u0130\u0131\u0005\""+
		"\u0000\u0000\u0131\u0133\u0005\u0019\u0000\u0000\u0132\u012a\u0001\u0000"+
		"\u0000\u0000\u0132\u012e\u0001\u0000\u0000\u0000\u01337\u0001\u0000\u0000"+
		"\u0000\u0134\u0135\u0005\u000b\u0000\u0000\u0135\u0136\u0005\u0018\u0000"+
		"\u0000\u0136\u0137\u0005*\u0000\u0000\u0137\u013d\u0005\u0019\u0000\u0000"+
		"\u0138\u0139\u0005\u000b\u0000\u0000\u0139\u013a\u0005\u0018\u0000\u0000"+
		"\u013a\u013b\u0005\"\u0000\u0000\u013b\u013d\u0005\u0019\u0000\u0000\u013c"+
		"\u0134\u0001\u0000\u0000\u0000\u013c\u0138\u0001\u0000\u0000\u0000\u013d"+
		"9\u0001\u0000\u0000\u0000\u013e\u0143\u0003<\u001e\u0000\u013f\u0143\u0003"+
		"@ \u0000\u0140\u0143\u0003B!\u0000\u0141\u0143\u0003>\u001f\u0000\u0142"+
		"\u013e\u0001\u0000\u0000\u0000\u0142\u013f\u0001\u0000\u0000\u0000\u0142"+
		"\u0140\u0001\u0000\u0000\u0000\u0142\u0141\u0001\u0000\u0000\u0000\u0143"+
		";\u0001\u0000\u0000\u0000\u0144\u0145\u0005*\u0000\u0000\u0145\u0146\u0005"+
		"\u0017\u0000\u0000\u0146\u0147\u0005*\u0000\u0000\u0147=\u0001\u0000\u0000"+
		"\u0000\u0148\u0149\u0005*\u0000\u0000\u0149\u014a\u0005\u0017\u0000\u0000"+
		"\u014a\u014b\u0005#\u0000\u0000\u014b?\u0001\u0000\u0000\u0000\u014c\u014d"+
		"\u0005*\u0000\u0000\u014d\u014e\u0005\u0017\u0000\u0000\u014e\u014f\u0005"+
		"\u001e\u0000\u0000\u014fA\u0001\u0000\u0000\u0000\u0150\u0151\u0005*\u0000"+
		"\u0000\u0151\u0152\u0005\u0017\u0000\u0000\u0152\u0153\u0005!\u0000\u0000"+
		"\u0153C\u0001\u0000\u0000\u0000\u001dHSWetz\u0080\u0082\u0089\u008b\u008f"+
		"\u0099\u00a0\u00a2\u00a4\u00ab\u00b6\u00c1\u00cb\u0108\u010c\u0111\u0115"+
		"\u011a\u0120\u0128\u0132\u013c\u0142";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
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
		StringLiteralExpression=38, ValueDecision=39, StringDecision=40, NumberDecision=41, 
		EnumerationDecision=42, ENUMERATION=43, BooleanDecision=44, SPECIAL_CHAR=45, 
		IDENTIFIER=46;
	public static final int
		RULE_csvFile = 0, RULE_hdr = 1, RULE_row = 2, RULE_field = 3, RULE_id = 4, 
		RULE_cardinality = 5, RULE_question = 6, RULE_expression = 7, RULE_unaryExpression = 8, 
		RULE_range = 9, RULE_rangeItem = 10, RULE_specialCharacter = 11, RULE_subrange = 12, 
		RULE_decisionVisibilityCallExpression = 13, RULE_isTaken = 14, RULE_decisionValueCallExpression = 15, 
		RULE_binaryExpression = 16, RULE_andExpression = 17, RULE_orExpression = 18, 
		RULE_xorExpression = 19, RULE_equalityExpression = 20, RULE_greaterThanExpression = 21, 
		RULE_lessThanExpression = 22, RULE_greaterEqualsExpression = 23, RULE_lessEqualsExpression = 24, 
		RULE_literalExpression = 25, RULE_decisionType = 26, RULE_rule = 27, RULE_action = 28, 
		RULE_valueRestrictionAction = 29, RULE_allows = 30, RULE_disallows = 31, 
		RULE_enForce = 32, RULE_enumEnForce = 33, RULE_stringEnForce = 34, RULE_booleanEnForce = 35, 
		RULE_doubleEnForce = 36;
	private static String[] makeRuleNames() {
		return new String[] {
			"csvFile", "hdr", "row", "field", "id", "cardinality", "question", "expression", 
			"unaryExpression", "range", "rangeItem", "specialCharacter", "subrange", 
			"decisionVisibilityCallExpression", "isTaken", "decisionValueCallExpression", 
			"binaryExpression", "andExpression", "orExpression", "xorExpression", 
			"equalityExpression", "greaterThanExpression", "lessThanExpression", 
			"greaterEqualsExpression", "lessEqualsExpression", "literalExpression", 
			"decisionType", "rule", "action", "valueRestrictionAction", "allows", 
			"disallows", "enForce", "enumEnForce", "stringEnForce", "booleanEnForce", 
			"doubleEnForce"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\r'", "'\\n'", "'!'", "'-'", "'\"'", null, null, null, null, 
			null, null, null, "'***REMOVED***'", "'>'", "'<'", "'<='", "'>='", "'||'", "'&&'", 
			"'^'", "'|'", "'='", "'('", "')'", "'{'", "'}'", "':'", "'if'", "'&'", 
			"'%'", "','", "';'", null, null, null, null, null, null, null, "'String'", 
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
			"EnumerationLiteralExpression", "StringLiteralExpression", "ValueDecision", 
			"StringDecision", "NumberDecision", "EnumerationDecision", "ENUMERATION", 
			"BooleanDecision", "SPECIAL_CHAR", "IDENTIFIER"
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
			setState(74);
			hdr();
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				row();
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 129690824087918L) != 0) );
			setState(80);
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
			setState(82);
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
			setState(84);
			field();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la***REMOVED***SEMICOLON) {
				{
				{
				setState(85);
				match(SEMICOLON);
				setState(86);
				field();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la***REMOVED***T__0) {
				{
				setState(92);
				match(T__0);
				}
			}

			setState(95);
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
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				rule_(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				id();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(99);
				question();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(100);
				decisionType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(101);
				cardinality();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(102);
				range();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(103);
				decisionVisibilityCallExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(104);
				match(HEADER);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(105);
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
			setState(109);
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
			setState(111);
			match(DoubleLiteralExpression);
			setState(112);
			match(COLON);
			setState(113);
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
			setState(115);
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
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				unaryExpression();
				}
				break;
			case BooleanLiteralExpression:
			case DoubleLiteralExpression:
			case EnumerationLiteralExpression:
			case StringLiteralExpression:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				literalExpression();
				}
				break;
			case ISTAKEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(119);
				isTaken();
				}
				break;
			case GETVALUE:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				decisionValueCallExpression();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
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
		enterRule(_localctx, 16, RULE_unaryExpression);
		try {
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(T__2);
				setState(125);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(T__2);
				setState(127);
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
		enterRule(_localctx, 18, RULE_range);
		int _la;
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				rangeItem();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 106046760687944L) != 0)) {
					{
					{
					setState(131);
					rangeItem();
					}
					}
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(137);
					match(PIPE);
					setState(138);
					rangeItem();
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 106046760687944L) != 0)) {
						{
						{
						setState(139);
						rangeItem();
						}
						}
						setState(144);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					}
					setState(147); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la***REMOVED***PIPE );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(DoubleLiteralExpression);
				setState(150);
				match(T__3);
				setState(151);
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
		enterRule(_localctx, 20, RULE_rangeItem);
		try {
			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				specialCharacter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				subrange();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(158);
				cardinality();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(159);
				match(QUESTION);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(160);
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
		enterRule(_localctx, 22, RULE_specialCharacter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 35188390232064L) != 0)) ) {
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
		enterRule(_localctx, 24, RULE_subrange);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			expression();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 1040384L) != 0)) {
				{
				{
				setState(166);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 1040384L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)***REMOVED***Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(167);
				expression();
				}
				}
				setState(172);
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
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				expression();
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 843776L) != 0)) {
					{
					{
					setState(174);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 843776L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)***REMOVED***Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(175);
					expression();
					}
					}
					setState(180);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
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
			setState(184);
			match(ISTAKEN);
			setState(185);
			match(LPAREN);
			setState(186);
			match(IDENTIFIER);
			setState(187);
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
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GETVALUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(GETVALUE);
				setState(190);
				match(LPAREN);
				setState(191);
				match(IDENTIFIER);
				setState(192);
				match(RPAREN);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
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
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				andExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				orExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				xorExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(199);
				equalityExpression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(200);
				greaterThanExpression();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(201);
				lessThanExpression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(202);
				greaterEqualsExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(203);
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
			setState(206);
			match(LPAREN);
			setState(207);
			expression();
			setState(208);
			match(AND);
			setState(209);
			expression();
			setState(210);
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
			setState(212);
			match(LPAREN);
			setState(213);
			expression();
			setState(214);
			match(OR);
			setState(215);
			expression();
			setState(216);
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
			setState(218);
			match(LPAREN);
			setState(219);
			expression();
			setState(220);
			match(XOR);
			setState(221);
			expression();
			setState(222);
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
			setState(224);
			match(LPAREN);
			setState(225);
			expression();
			setState(226);
			match(EQUALS);
			setState(227);
			expression();
			setState(228);
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
			setState(230);
			match(LPAREN);
			setState(231);
			expression();
			setState(232);
			match(GREATER_THAN);
			setState(233);
			expression();
			setState(234);
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
			setState(236);
			match(LPAREN);
			setState(237);
			expression();
			setState(238);
			match(LESS_THAN);
			setState(239);
			expression();
			setState(240);
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
			setState(242);
			match(LPAREN);
			setState(243);
			expression();
			setState(244);
			match(GREATER_EQUALS);
			setState(245);
			expression();
			setState(246);
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
			setState(248);
			match(LPAREN);
			setState(249);
			expression();
			setState(250);
			match(LESS_EQUALS);
			setState(251);
			expression();
			setState(252);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 489626271744L) != 0)) ) {
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
		enterRule(_localctx, 52, RULE_decisionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 23639499997184L) != 0)) ) {
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
		int _startState = 54;
		enterRecursionRule(_localctx, 54, RULE_rule, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(259);
				match(T__4);
				setState(260);
				rule_(0);
				setState(261);
				match(T__4);
				}
				break;
			case IF:
				{
				setState(263);
				match(IF);
				setState(265);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(264);
					match(LPAREN);
					}
					break;
				}
				setState(267);
				expression();
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la***REMOVED***RPAREN) {
					{
					setState(268);
					match(RPAREN);
					}
				}

				setState(271);
				match(LBRACE);
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) ***REMOVED*** 0 && ((1L << _la) & 70368744179200L) != 0)) {
					{
					{
					setState(272);
					action();
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la***REMOVED***SEMICOLON) {
						{
						setState(273);
						match(SEMICOLON);
						}
					}

					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(281);
				match(RBRACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt***REMOVED***1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RuleContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_rule);
					setState(285);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(286);
					rule_(3);
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 56, RULE_action);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
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
		enterRule(_localctx, 58, RULE_valueRestrictionAction);
		try {
			setState(297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ALLOW:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				allows();
				}
				break;
			case DISALLOW:
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				disallows();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(296);
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
		enterRule(_localctx, 60, RULE_allows);
		try {
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				match(ALLOW);
				setState(300);
				match(LPAREN);
				setState(301);
				match(IDENTIFIER);
				setState(302);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(ALLOW);
				setState(304);
				match(LPAREN);
				setState(305);
				match(EnumerationLiteralExpression);
				setState(306);
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
		enterRule(_localctx, 62, RULE_disallows);
		try {
			setState(317);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(DISALLOW);
				setState(310);
				match(LPAREN);
				setState(311);
				match(IDENTIFIER);
				setState(312);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				match(DISALLOW);
				setState(314);
				match(LPAREN);
				setState(315);
				match(EnumerationLiteralExpression);
				setState(316);
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
		enterRule(_localctx, 64, RULE_enForce);
		try {
			setState(323);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(319);
				enumEnForce();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				booleanEnForce();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(321);
				doubleEnForce();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(322);
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
		enterRule(_localctx, 66, RULE_enumEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(IDENTIFIER);
			setState(326);
			match(SET);
			setState(327);
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
		enterRule(_localctx, 68, RULE_stringEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(IDENTIFIER);
			setState(330);
			match(SET);
			setState(331);
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
		enterRule(_localctx, 70, RULE_booleanEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(IDENTIFIER);
			setState(334);
			match(SET);
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
		enterRule(_localctx, 72, RULE_doubleEnForce);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(IDENTIFIER);
			setState(338);
			match(SET);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 27:
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
		"\u0004\u0001.\u0156\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"#\u0007#\u0002$\u0007$\u0001\u0000\u0001\u0000\u0004\u0000M\b\u0000\u000b"+
		"\u0000\f\u0000N\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002X\b\u0002\n\u0002\f\u0002[\t"+
		"\u0002\u0001\u0002\u0003\u0002^\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003l\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007{\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0081"+
		"\b\b\u0001\t\u0001\t\u0005\t\u0085\b\t\n\t\f\t\u0088\t\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u008d\b\t\n\t\f\t\u0090\t\t\u0004\t\u0092\b\t\u000b"+
		"\t\f\t\u0093\u0001\t\u0001\t\u0001\t\u0003\t\u0099\b\t\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00a2\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00a9\b\f\n\f\f\f\u00ac\t"+
		"\f\u0001\r\u0001\r\u0001\r\u0005\r\u00b1\b\r\n\r\f\r\u00b4\t\r\u0001\r"+
		"\u0003\r\u00b7\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00c3\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00cd\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u010a"+
		"\b\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u010e\b\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0003\u001b\u0113\b\u001b\u0005\u001b\u0115\b"+
		"\u001b\n\u001b\f\u001b\u0118\t\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u011c\b\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0120\b\u001b\n\u001b"+
		"\f\u001b\u0123\t\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u012a\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e"+
		"\u0134\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u013e\b\u001f\u0001 "+
		"\u0001 \u0001 \u0001 \u0003 \u0144\b \u0001!\u0001!\u0001!\u0001!\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001"+
		"$\u0001$\u0001$\u0000\u00016%\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFH\u0000"+
		"\u0005\u0003\u0000\u0017\u001b\u001d\u001f--\u0001\u0000\r\u0013\u0002"+
		"\u0000\r\u000f\u0012\u0013\u0002\u0000!!$&\u0003\u0000\'(**,,\u0163\u0000"+
		"J\u0001\u0000\u0000\u0000\u0002R\u0001\u0000\u0000\u0000\u0004T\u0001"+
		"\u0000\u0000\u0000\u0006k\u0001\u0000\u0000\u0000\bm\u0001\u0000\u0000"+
		"\u0000\no\u0001\u0000\u0000\u0000\fs\u0001\u0000\u0000\u0000\u000ez\u0001"+
		"\u0000\u0000\u0000\u0010\u0080\u0001\u0000\u0000\u0000\u0012\u0098\u0001"+
		"\u0000\u0000\u0000\u0014\u00a1\u0001\u0000\u0000\u0000\u0016\u00a3\u0001"+
		"\u0000\u0000\u0000\u0018\u00a5\u0001\u0000\u0000\u0000\u001a\u00b6\u0001"+
		"\u0000\u0000\u0000\u001c\u00b8\u0001\u0000\u0000\u0000\u001e\u00c2\u0001"+
		"\u0000\u0000\u0000 \u00cc\u0001\u0000\u0000\u0000\"\u00ce\u0001\u0000"+
		"\u0000\u0000$\u00d4\u0001\u0000\u0000\u0000&\u00da\u0001\u0000\u0000\u0000"+
		"(\u00e0\u0001\u0000\u0000\u0000*\u00e6\u0001\u0000\u0000\u0000,\u00ec"+
		"\u0001\u0000\u0000\u0000.\u00f2\u0001\u0000\u0000\u00000\u00f8\u0001\u0000"+
		"\u0000\u00002\u00fe\u0001\u0000\u0000\u00004\u0100\u0001\u0000\u0000\u0000"+
		"6\u011b\u0001\u0000\u0000\u00008\u0124\u0001\u0000\u0000\u0000:\u0129"+
		"\u0001\u0000\u0000\u0000<\u0133\u0001\u0000\u0000\u0000>\u013d\u0001\u0000"+
		"\u0000\u0000@\u0143\u0001\u0000\u0000\u0000B\u0145\u0001\u0000\u0000\u0000"+
		"D\u0149\u0001\u0000\u0000\u0000F\u014d\u0001\u0000\u0000\u0000H\u0151"+
		"\u0001\u0000\u0000\u0000JL\u0003\u0002\u0001\u0000KM\u0003\u0004\u0002"+
		"\u0000LK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NL\u0001\u0000"+
		"\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PQ\u0005"+
		"\u0000\u0000\u0001Q\u0001\u0001\u0000\u0000\u0000RS\u0003\u0004\u0002"+
		"\u0000S\u0003\u0001\u0000\u0000\u0000TY\u0003\u0006\u0003\u0000UV\u0005"+
		" \u0000\u0000VX\u0003\u0006\u0003\u0000WU\u0001\u0000\u0000\u0000X[\u0001"+
		"\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000\\^\u0005\u0001\u0000"+
		"\u0000]\\\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_`\u0005\u0002\u0000\u0000`\u0005\u0001\u0000\u0000\u0000"+
		"al\u00036\u001b\u0000bl\u0003\b\u0004\u0000cl\u0003\f\u0006\u0000dl\u0003"+
		"4\u001a\u0000el\u0003\n\u0005\u0000fl\u0003\u0012\t\u0000gl\u0003\u001a"+
		"\r\u0000hl\u0005\b\u0000\u0000il\u0005.\u0000\u0000jl\u0001\u0000\u0000"+
		"\u0000ka\u0001\u0000\u0000\u0000kb\u0001\u0000\u0000\u0000kc\u0001\u0000"+
		"\u0000\u0000kd\u0001\u0000\u0000\u0000ke\u0001\u0000\u0000\u0000kf\u0001"+
		"\u0000\u0000\u0000kg\u0001\u0000\u0000\u0000kh\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000l\u0007\u0001\u0000"+
		"\u0000\u0000mn\u0005.\u0000\u0000n\t\u0001\u0000\u0000\u0000op\u0005$"+
		"\u0000\u0000pq\u0005\u001b\u0000\u0000qr\u0005$\u0000\u0000r\u000b\u0001"+
		"\u0000\u0000\u0000st\u0005\u0006\u0000\u0000t\r\u0001\u0000\u0000\u0000"+
		"u{\u0003\u0010\b\u0000v{\u00032\u0019\u0000w{\u0003\u001c\u000e\u0000"+
		"x{\u0003\u001e\u000f\u0000y{\u0003 \u0010\u0000zu\u0001\u0000\u0000\u0000"+
		"zv\u0001\u0000\u0000\u0000zw\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000"+
		"\u0000zy\u0001\u0000\u0000\u0000{\u000f\u0001\u0000\u0000\u0000|}\u0005"+
		"\u0003\u0000\u0000}\u0081\u0003\u000e\u0007\u0000~\u007f\u0005\u0003\u0000"+
		"\u0000\u007f\u0081\u0005%\u0000\u0000\u0080|\u0001\u0000\u0000\u0000\u0080"+
		"~\u0001\u0000\u0000\u0000\u0081\u0011\u0001\u0000\u0000\u0000\u0082\u0086"+
		"\u0003\u0014\n\u0000\u0083\u0085\u0003\u0014\n\u0000\u0084\u0083\u0001"+
		"\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0091\u0001"+
		"\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"\u0015\u0000\u0000\u008a\u008e\u0003\u0014\n\u0000\u008b\u008d\u0003\u0014"+
		"\n\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000"+
		"\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000"+
		"\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000"+
		"\u0000\u0091\u0089\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000"+
		"\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094\u0099\u0001\u0000\u0000\u0000\u0095\u0096\u0005$\u0000\u0000"+
		"\u0096\u0097\u0005\u0004\u0000\u0000\u0097\u0099\u0005$\u0000\u0000\u0098"+
		"\u0082\u0001\u0000\u0000\u0000\u0098\u0095\u0001\u0000\u0000\u0000\u0099"+
		"\u0013\u0001\u0000\u0000\u0000\u009a\u00a2\u0005.\u0000\u0000\u009b\u00a2"+
		"\u0003\u0016\u000b\u0000\u009c\u00a2\u0003\u000e\u0007\u0000\u009d\u00a2"+
		"\u0003\u0018\f\u0000\u009e\u00a2\u0003\n\u0005\u0000\u009f\u00a2\u0005"+
		"\u0006\u0000\u0000\u00a0\u00a2\u0005\b\u0000\u0000\u00a1\u009a\u0001\u0000"+
		"\u0000\u0000\u00a1\u009b\u0001\u0000\u0000\u0000\u00a1\u009c\u0001\u0000"+
		"\u0000\u0000\u00a1\u009d\u0001\u0000\u0000\u0000\u00a1\u009e\u0001\u0000"+
		"\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a2\u0015\u0001\u0000\u0000\u0000\u00a3\u00a4\u0007\u0000"+
		"\u0000\u0000\u00a4\u0017\u0001\u0000\u0000\u0000\u00a5\u00aa\u0003\u000e"+
		"\u0007\u0000\u00a6\u00a7\u0007\u0001\u0000\u0000\u00a7\u00a9\u0003\u000e"+
		"\u0007\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000"+
		"\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000"+
		"\u0000\u0000\u00ab\u0019\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ad\u00b2\u0003\u000e\u0007\u0000\u00ae\u00af\u0007\u0002"+
		"\u0000\u0000\u00af\u00b1\u0003\u000e\u0007\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b4\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b7\u0003\u000e"+
		"\u0007\u0000\u00b6\u00ad\u0001\u0000\u0000\u0000\u00b6\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b7\u001b\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\u000b"+
		"\u0000\u0000\u00b9\u00ba\u0005\u0017\u0000\u0000\u00ba\u00bb\u0005.\u0000"+
		"\u0000\u00bb\u00bc\u0005\u0018\u0000\u0000\u00bc\u001d\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0005\f\u0000\u0000\u00be\u00bf\u0005\u0017\u0000\u0000"+
		"\u00bf\u00c0\u0005.\u0000\u0000\u00c0\u00c3\u0005\u0018\u0000\u0000\u00c1"+
		"\u00c3\u0005.\u0000\u0000\u00c2\u00bd\u0001\u0000\u0000\u0000\u00c2\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c3\u001f\u0001\u0000\u0000\u0000\u00c4\u00cd"+
		"\u0003\"\u0011\u0000\u00c5\u00cd\u0003$\u0012\u0000\u00c6\u00cd\u0003"+
		"&\u0013\u0000\u00c7\u00cd\u0003(\u0014\u0000\u00c8\u00cd\u0003*\u0015"+
		"\u0000\u00c9\u00cd\u0003,\u0016\u0000\u00ca\u00cd\u0003.\u0017\u0000\u00cb"+
		"\u00cd\u00030\u0018\u0000\u00cc\u00c4\u0001\u0000\u0000\u0000\u00cc\u00c5"+
		"\u0001\u0000\u0000\u0000\u00cc\u00c6\u0001\u0000\u0000\u0000\u00cc\u00c7"+
		"\u0001\u0000\u0000\u0000\u00cc\u00c8\u0001\u0000\u0000\u0000\u00cc\u00c9"+
		"\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cd!\u0001\u0000\u0000\u0000\u00ce\u00cf\u0005"+
		"\u0017\u0000\u0000\u00cf\u00d0\u0003\u000e\u0007\u0000\u00d0\u00d1\u0005"+
		"\u0013\u0000\u0000\u00d1\u00d2\u0003\u000e\u0007\u0000\u00d2\u00d3\u0005"+
		"\u0018\u0000\u0000\u00d3#\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u0017"+
		"\u0000\u0000\u00d5\u00d6\u0003\u000e\u0007\u0000\u00d6\u00d7\u0005\u0012"+
		"\u0000\u0000\u00d7\u00d8\u0003\u000e\u0007\u0000\u00d8\u00d9\u0005\u0018"+
		"\u0000\u0000\u00d9%\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0017\u0000"+
		"\u0000\u00db\u00dc\u0003\u000e\u0007\u0000\u00dc\u00dd\u0005\u0014\u0000"+
		"\u0000\u00dd\u00de\u0003\u000e\u0007\u0000\u00de\u00df\u0005\u0018\u0000"+
		"\u0000\u00df\'\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005\u0017\u0000\u0000"+
		"\u00e1\u00e2\u0003\u000e\u0007\u0000\u00e2\u00e3\u0005\r\u0000\u0000\u00e3"+
		"\u00e4\u0003\u000e\u0007\u0000\u00e4\u00e5\u0005\u0018\u0000\u0000\u00e5"+
		")\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\u0017\u0000\u0000\u00e7\u00e8"+
		"\u0003\u000e\u0007\u0000\u00e8\u00e9\u0005\u000e\u0000\u0000\u00e9\u00ea"+
		"\u0003\u000e\u0007\u0000\u00ea\u00eb\u0005\u0018\u0000\u0000\u00eb+\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ed\u0005\u0017\u0000\u0000\u00ed\u00ee\u0003"+
		"\u000e\u0007\u0000\u00ee\u00ef\u0005\u000f\u0000\u0000\u00ef\u00f0\u0003"+
		"\u000e\u0007\u0000\u00f0\u00f1\u0005\u0018\u0000\u0000\u00f1-\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0005\u0017\u0000\u0000\u00f3\u00f4\u0003\u000e"+
		"\u0007\u0000\u00f4\u00f5\u0005\u0011\u0000\u0000\u00f5\u00f6\u0003\u000e"+
		"\u0007\u0000\u00f6\u00f7\u0005\u0018\u0000\u0000\u00f7/\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0005\u0017\u0000\u0000\u00f9\u00fa\u0003\u000e\u0007"+
		"\u0000\u00fa\u00fb\u0005\u0010\u0000\u0000\u00fb\u00fc\u0003\u000e\u0007"+
		"\u0000\u00fc\u00fd\u0005\u0018\u0000\u0000\u00fd1\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0007\u0003\u0000\u0000\u00ff3\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0007\u0004\u0000\u0000\u01015\u0001\u0000\u0000\u0000\u0102\u0103"+
		"\u0006\u001b\uffff\uffff\u0000\u0103\u0104\u0005\u0005\u0000\u0000\u0104"+
		"\u0105\u00036\u001b\u0000\u0105\u0106\u0005\u0005\u0000\u0000\u0106\u011c"+
		"\u0001\u0000\u0000\u0000\u0107\u0109\u0005\u001c\u0000\u0000\u0108\u010a"+
		"\u0005\u0017\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u0109\u010a"+
		"\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010d"+
		"\u0003\u000e\u0007\u0000\u010c\u010e\u0005\u0018\u0000\u0000\u010d\u010c"+
		"\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f"+
		"\u0001\u0000\u0000\u0000\u010f\u0116\u0005\u0019\u0000\u0000\u0110\u0112"+
		"\u00038\u001c\u0000\u0111\u0113\u0005 \u0000\u0000\u0112\u0111\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0115\u0001\u0000"+
		"\u0000\u0000\u0114\u0110\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000"+
		"\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000"+
		"\u0000\u0000\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000"+
		"\u0000\u0000\u0119\u011a\u0005\u001a\u0000\u0000\u011a\u011c\u0001\u0000"+
		"\u0000\u0000\u011b\u0102\u0001\u0000\u0000\u0000\u011b\u0107\u0001\u0000"+
		"\u0000\u0000\u011c\u0121\u0001\u0000\u0000\u0000\u011d\u011e\n\u0002\u0000"+
		"\u0000\u011e\u0120\u00036\u001b\u0003\u011f\u011d\u0001\u0000\u0000\u0000"+
		"\u0120\u0123\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000"+
		"\u0121\u0122\u0001\u0000\u0000\u0000\u01227\u0001\u0000\u0000\u0000\u0123"+
		"\u0121\u0001\u0000\u0000\u0000\u0124\u0125\u0003:\u001d\u0000\u01259\u0001"+
		"\u0000\u0000\u0000\u0126\u012a\u0003<\u001e\u0000\u0127\u012a\u0003>\u001f"+
		"\u0000\u0128\u012a\u0003@ \u0000\u0129\u0126\u0001\u0000\u0000\u0000\u0129"+
		"\u0127\u0001\u0000\u0000\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u012a"+
		";\u0001\u0000\u0000\u0000\u012b\u012c\u0005\t\u0000\u0000\u012c\u012d"+
		"\u0005\u0017\u0000\u0000\u012d\u012e\u0005.\u0000\u0000\u012e\u0134\u0005"+
		"\u0018\u0000\u0000\u012f\u0130\u0005\t\u0000\u0000\u0130\u0131\u0005\u0017"+
		"\u0000\u0000\u0131\u0132\u0005%\u0000\u0000\u0132\u0134\u0005\u0018\u0000"+
		"\u0000\u0133\u012b\u0001\u0000\u0000\u0000\u0133\u012f\u0001\u0000\u0000"+
		"\u0000\u0134=\u0001\u0000\u0000\u0000\u0135\u0136\u0005\n\u0000\u0000"+
		"\u0136\u0137\u0005\u0017\u0000\u0000\u0137\u0138\u0005.\u0000\u0000\u0138"+
		"\u013e\u0005\u0018\u0000\u0000\u0139\u013a\u0005\n\u0000\u0000\u013a\u013b"+
		"\u0005\u0017\u0000\u0000\u013b\u013c\u0005%\u0000\u0000\u013c\u013e\u0005"+
		"\u0018\u0000\u0000\u013d\u0135\u0001\u0000\u0000\u0000\u013d\u0139\u0001"+
		"\u0000\u0000\u0000\u013e?\u0001\u0000\u0000\u0000\u013f\u0144\u0003B!"+
		"\u0000\u0140\u0144\u0003F#\u0000\u0141\u0144\u0003H$\u0000\u0142\u0144"+
		"\u0003D\"\u0000\u0143\u013f\u0001\u0000\u0000\u0000\u0143\u0140\u0001"+
		"\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0143\u0142\u0001"+
		"\u0000\u0000\u0000\u0144A\u0001\u0000\u0000\u0000\u0145\u0146\u0005.\u0000"+
		"\u0000\u0146\u0147\u0005\u0016\u0000\u0000\u0147\u0148\u0005.\u0000\u0000"+
		"\u0148C\u0001\u0000\u0000\u0000\u0149\u014a\u0005.\u0000\u0000\u014a\u014b"+
		"\u0005\u0016\u0000\u0000\u014b\u014c\u0005&\u0000\u0000\u014cE\u0001\u0000"+
		"\u0000\u0000\u014d\u014e\u0005.\u0000\u0000\u014e\u014f\u0005\u0016\u0000"+
		"\u0000\u014f\u0150\u0005!\u0000\u0000\u0150G\u0001\u0000\u0000\u0000\u0151"+
		"\u0152\u0005.\u0000\u0000\u0152\u0153\u0005\u0016\u0000\u0000\u0153\u0154"+
		"\u0005$\u0000\u0000\u0154I\u0001\u0000\u0000\u0000\u001aNY]kz\u0080\u0086"+
		"\u008e\u0093\u0098\u00a1\u00aa\u00b2\u00b6\u00c2\u00cc\u0109\u010d\u0112"+
		"\u0116\u011b\u0121\u0129\u0133\u013d\u0143";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
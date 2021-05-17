// Generated from org/linqs/psl/parser/antlr/PSL.g4 by ANTLR 4.5
package org.linqs.psl.parser.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, STRING_LITERAL=5, EXPONENT_EXPRESSION=6, 
		LESS_THAN_EQUAL=7, GREATER_THAN_EQUAL=8, EQUAL=9, PLUS=10, MINUS=11, MULT=12, 
		DIV=13, MAX=14, MIN=15, IDENTIFIER=16, NONNEGATIVE_NUMBER=17, PERIOD=18, 
		COMMA=19, COLON=20, NEGATION=21, AMPERSAND=22, PIPE=23, LPAREN=24, RPAREN=25, 
		LBRACE=26, RBRACE=27, LBRACKET=28, RBRACKET=29, SINGLE_QUOTE=30, DOUBLE_QUOTE=31, 
		MOD=32, CARROT=33, WS=34, COMMENT=35, LINE_COMMENT=36, PYTHON_COMMENT=37;
	public static final int
		RULE_program = 0, RULE_pslRule = 1, RULE_pslRulePartial = 2, RULE_predicate = 3, 
		RULE_atom = 4, RULE_term = 5, RULE_variable = 6, RULE_constant = 7, RULE_logicalRule = 8, 
		RULE_weightedLogicalRule = 9, RULE_unweightedLogicalRule = 10, RULE_logicalNegationValue = 11, 
		RULE_logicalConjunctiveValue = 12, RULE_logicalDisjunctiveValue = 13, 
		RULE_logicalConjunctiveExpression = 14, RULE_logicalDisjunctiveExpression = 15, 
		RULE_logicalImplicationExpression = 16, RULE_logicalRuleExpression = 17, 
		RULE_arithmeticRule = 18, RULE_weightedArithmeticRule = 19, RULE_unweightedArithmeticRule = 20, 
		RULE_arithmeticRuleExpression = 21, RULE_linearArithmeticExpression = 22, 
		RULE_linearArithmeticOperand = 23, RULE_arithmeticCoefficientOperand = 24, 
		RULE_summationAtom = 25, RULE_summationVariable = 26, RULE_coefficient = 27, 
		RULE_coefficientMultiplicativeExpression = 28, RULE_coefficientAdditiveExpression = 29, 
		RULE_coefficientExpression = 30, RULE_coefficientOperator = 31, RULE_coefficientFunction = 32, 
		RULE_coefficientFunctionOperator = 33, RULE_filterClause = 34, RULE_booleanValue = 35, 
		RULE_booleanConjunctiveExpression = 36, RULE_booleanDisjunctiveExpression = 37, 
		RULE_booleanExpression = 38, RULE_weightExpression = 39, RULE_not = 40, 
		RULE_and = 41, RULE_or = 42, RULE_then = 43, RULE_impliedBy = 44, RULE_termOperator = 45, 
		RULE_termEqual = 46, RULE_notEqual = 47, RULE_nonSymmetric = 48, RULE_arithmeticRuleRelation = 49, 
		RULE_arithmeticOperator = 50, RULE_linearOperator = 51, RULE_number = 52;
	public static final String[] ruleNames = {
		"program", "pslRule", "pslRulePartial", "predicate", "atom", "term", "variable", 
		"constant", "logicalRule", "weightedLogicalRule", "unweightedLogicalRule", 
		"logicalNegationValue", "logicalConjunctiveValue", "logicalDisjunctiveValue", 
		"logicalConjunctiveExpression", "logicalDisjunctiveExpression", "logicalImplicationExpression", 
		"logicalRuleExpression", "arithmeticRule", "weightedArithmeticRule", "unweightedArithmeticRule", 
		"arithmeticRuleExpression", "linearArithmeticExpression", "linearArithmeticOperand", 
		"arithmeticCoefficientOperand", "summationAtom", "summationVariable", 
		"coefficient", "coefficientMultiplicativeExpression", "coefficientAdditiveExpression", 
		"coefficientExpression", "coefficientOperator", "coefficientFunction", 
		"coefficientFunctionOperator", "filterClause", "booleanValue", "booleanConjunctiveExpression", 
		"booleanDisjunctiveExpression", "booleanExpression", "weightExpression", 
		"not", "and", "or", "then", "impliedBy", "termOperator", "termEqual", 
		"notEqual", "nonSymmetric", "arithmeticRuleRelation", "arithmeticOperator", 
		"linearOperator", "number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'>>'", "'->'", "'<<'", "'<-'", null, null, "'<='", "'>='", "'='", 
		"'+'", "'-'", "'*'", "'/'", "'@Max'", "'@Min'", null, null, "'.'", "','", 
		"':'", null, "'&'", "'|'", "'('", "')'", "'{'", "'}'", "'['", "']'", "'''", 
		"'\"'", "'%'", "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "STRING_LITERAL", "EXPONENT_EXPRESSION", 
		"LESS_THAN_EQUAL", "GREATER_THAN_EQUAL", "EQUAL", "PLUS", "MINUS", "MULT", 
		"DIV", "MAX", "MIN", "IDENTIFIER", "NONNEGATIVE_NUMBER", "PERIOD", "COMMA", 
		"COLON", "NEGATION", "AMPERSAND", "PIPE", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "LBRACKET", "RBRACKET", "SINGLE_QUOTE", "DOUBLE_QUOTE", "MOD", 
		"CARROT", "WS", "COMMENT", "LINE_COMMENT", "PYTHON_COMMENT"
	};
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
	public String getGrammarFileName() { return "PSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PSLParser.EOF, 0); }
		public List<PslRuleContext> pslRule() {
			return getRuleContexts(PslRuleContext.class);
		}
		public PslRuleContext pslRule(int i) {
			return getRuleContext(PslRuleContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				pslRule();
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_LITERAL) | (1L << MINUS) | (1L << MAX) | (1L << MIN) | (1L << IDENTIFIER) | (1L << NONNEGATIVE_NUMBER) | (1L << NEGATION) | (1L << PIPE) | (1L << LPAREN))) != 0) );
			setState(111);
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

	public static class PslRuleContext extends ParserRuleContext {
		public LogicalRuleContext logicalRule() {
			return getRuleContext(LogicalRuleContext.class,0);
		}
		public ArithmeticRuleContext arithmeticRule() {
			return getRuleContext(ArithmeticRuleContext.class,0);
		}
		public PslRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pslRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterPslRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitPslRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitPslRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PslRuleContext pslRule() throws RecognitionException {
		PslRuleContext _localctx = new PslRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pslRule);
		try {
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				logicalRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				arithmeticRule();
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

	public static class PslRulePartialContext extends ParserRuleContext {
		public LogicalRuleContext logicalRule() {
			return getRuleContext(LogicalRuleContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PSLParser.EOF, 0); }
		public ArithmeticRuleContext arithmeticRule() {
			return getRuleContext(ArithmeticRuleContext.class,0);
		}
		public LogicalRuleExpressionContext logicalRuleExpression() {
			return getRuleContext(LogicalRuleExpressionContext.class,0);
		}
		public ArithmeticRuleExpressionContext arithmeticRuleExpression() {
			return getRuleContext(ArithmeticRuleExpressionContext.class,0);
		}
		public List<FilterClauseContext> filterClause() {
			return getRuleContexts(FilterClauseContext.class);
		}
		public FilterClauseContext filterClause(int i) {
			return getRuleContext(FilterClauseContext.class,i);
		}
		public PslRulePartialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pslRulePartial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterPslRulePartial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitPslRulePartial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitPslRulePartial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PslRulePartialContext pslRulePartial() throws RecognitionException {
		PslRulePartialContext _localctx = new PslRulePartialContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pslRulePartial);
		int _la;
		try {
			setState(135);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				logicalRule();
				setState(118);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				arithmeticRule();
				setState(121);
				match(EOF);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				logicalRuleExpression();
				setState(124);
				match(EOF);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(126);
				arithmeticRuleExpression();
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACE) {
					{
					{
					setState(127);
					filterClause();
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133);
				match(EOF);
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

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PSLParser.IDENTIFIER, 0); }
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_predicate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
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

	public static class AtomContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PSLParser.LPAREN, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PSLParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PSLParser.COMMA, i);
		}
		public TermOperatorContext termOperator() {
			return getRuleContext(TermOperatorContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atom);
		int _la;
		try {
			setState(155);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				predicate();
				setState(140);
				match(LPAREN);
				setState(141);
				term();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(142);
					match(COMMA);
					setState(143);
					term();
					}
					}
					setState(148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(149);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				term();
				setState(152);
				termOperator();
				setState(153);
				term();
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

	public static class TermContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_term);
		try {
			setState(159);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				variable();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				constant();
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

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(PSLParser.IDENTIFIER, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
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

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(PSLParser.STRING_LITERAL, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			match(STRING_LITERAL);
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

	public static class LogicalRuleContext extends ParserRuleContext {
		public WeightedLogicalRuleContext weightedLogicalRule() {
			return getRuleContext(WeightedLogicalRuleContext.class,0);
		}
		public UnweightedLogicalRuleContext unweightedLogicalRule() {
			return getRuleContext(UnweightedLogicalRuleContext.class,0);
		}
		public LogicalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLogicalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLogicalRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLogicalRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalRuleContext logicalRule() throws RecognitionException {
		LogicalRuleContext _localctx = new LogicalRuleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logicalRule);
		try {
			setState(167);
			switch (_input.LA(1)) {
			case MINUS:
			case NONNEGATIVE_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				weightedLogicalRule();
				}
				break;
			case STRING_LITERAL:
			case IDENTIFIER:
			case NEGATION:
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				unweightedLogicalRule();
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

	public static class WeightedLogicalRuleContext extends ParserRuleContext {
		public WeightExpressionContext weightExpression() {
			return getRuleContext(WeightExpressionContext.class,0);
		}
		public LogicalRuleExpressionContext logicalRuleExpression() {
			return getRuleContext(LogicalRuleExpressionContext.class,0);
		}
		public TerminalNode EXPONENT_EXPRESSION() { return getToken(PSLParser.EXPONENT_EXPRESSION, 0); }
		public WeightedLogicalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightedLogicalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterWeightedLogicalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitWeightedLogicalRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitWeightedLogicalRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeightedLogicalRuleContext weightedLogicalRule() throws RecognitionException {
		WeightedLogicalRuleContext _localctx = new WeightedLogicalRuleContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_weightedLogicalRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			weightExpression();
			setState(170);
			logicalRuleExpression();
			setState(172);
			_la = _input.LA(1);
			if (_la==EXPONENT_EXPRESSION) {
				{
				setState(171);
				match(EXPONENT_EXPRESSION);
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

	public static class UnweightedLogicalRuleContext extends ParserRuleContext {
		public LogicalRuleExpressionContext logicalRuleExpression() {
			return getRuleContext(LogicalRuleExpressionContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(PSLParser.PERIOD, 0); }
		public UnweightedLogicalRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unweightedLogicalRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterUnweightedLogicalRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitUnweightedLogicalRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitUnweightedLogicalRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnweightedLogicalRuleContext unweightedLogicalRule() throws RecognitionException {
		UnweightedLogicalRuleContext _localctx = new UnweightedLogicalRuleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unweightedLogicalRule);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			logicalRuleExpression();
			setState(175);
			match(PERIOD);
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

	public static class LogicalNegationValueContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public NotContext not() {
			return getRuleContext(NotContext.class,0);
		}
		public LogicalNegationValueContext logicalNegationValue() {
			return getRuleContext(LogicalNegationValueContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PSLParser.RPAREN, 0); }
		public LogicalNegationValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalNegationValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLogicalNegationValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLogicalNegationValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLogicalNegationValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalNegationValueContext logicalNegationValue() throws RecognitionException {
		LogicalNegationValueContext _localctx = new LogicalNegationValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_logicalNegationValue);
		try {
			setState(185);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				atom();
				}
				break;
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				not();
				setState(179);
				logicalNegationValue();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(181);
				match(LPAREN);
				setState(182);
				logicalNegationValue();
				setState(183);
				match(RPAREN);
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

	public static class LogicalConjunctiveValueContext extends ParserRuleContext {
		public LogicalNegationValueContext logicalNegationValue() {
			return getRuleContext(LogicalNegationValueContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PSLParser.LPAREN, 0); }
		public LogicalConjunctiveExpressionContext logicalConjunctiveExpression() {
			return getRuleContext(LogicalConjunctiveExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PSLParser.RPAREN, 0); }
		public LogicalConjunctiveValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalConjunctiveValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLogicalConjunctiveValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLogicalConjunctiveValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLogicalConjunctiveValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalConjunctiveValueContext logicalConjunctiveValue() throws RecognitionException {
		LogicalConjunctiveValueContext _localctx = new LogicalConjunctiveValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_logicalConjunctiveValue);
		try {
			setState(192);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				logicalNegationValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(LPAREN);
				setState(189);
				logicalConjunctiveExpression(0);
				setState(190);
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

	public static class LogicalDisjunctiveValueContext extends ParserRuleContext {
		public LogicalNegationValueContext logicalNegationValue() {
			return getRuleContext(LogicalNegationValueContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PSLParser.LPAREN, 0); }
		public LogicalDisjunctiveExpressionContext logicalDisjunctiveExpression() {
			return getRuleContext(LogicalDisjunctiveExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PSLParser.RPAREN, 0); }
		public LogicalDisjunctiveValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalDisjunctiveValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLogicalDisjunctiveValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLogicalDisjunctiveValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLogicalDisjunctiveValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalDisjunctiveValueContext logicalDisjunctiveValue() throws RecognitionException {
		LogicalDisjunctiveValueContext _localctx = new LogicalDisjunctiveValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_logicalDisjunctiveValue);
		try {
			setState(199);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				logicalNegationValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				match(LPAREN);
				setState(196);
				logicalDisjunctiveExpression(0);
				setState(197);
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

	public static class LogicalConjunctiveExpressionContext extends ParserRuleContext {
		public LogicalConjunctiveValueContext logicalConjunctiveValue() {
			return getRuleContext(LogicalConjunctiveValueContext.class,0);
		}
		public LogicalConjunctiveExpressionContext logicalConjunctiveExpression() {
			return getRuleContext(LogicalConjunctiveExpressionContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public LogicalConjunctiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalConjunctiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLogicalConjunctiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLogicalConjunctiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLogicalConjunctiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalConjunctiveExpressionContext logicalConjunctiveExpression() throws RecognitionException {
		return logicalConjunctiveExpression(0);
	}

	private LogicalConjunctiveExpressionContext logicalConjunctiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalConjunctiveExpressionContext _localctx = new LogicalConjunctiveExpressionContext(_ctx, _parentState);
		LogicalConjunctiveExpressionContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_logicalConjunctiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(202);
			logicalConjunctiveValue();
			}
			_ctx.stop = _input.LT(-1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalConjunctiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalConjunctiveExpression);
					setState(204);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(205);
					and();
					setState(206);
					logicalConjunctiveValue();
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class LogicalDisjunctiveExpressionContext extends ParserRuleContext {
		public LogicalDisjunctiveValueContext logicalDisjunctiveValue() {
			return getRuleContext(LogicalDisjunctiveValueContext.class,0);
		}
		public LogicalDisjunctiveExpressionContext logicalDisjunctiveExpression() {
			return getRuleContext(LogicalDisjunctiveExpressionContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public LogicalDisjunctiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalDisjunctiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLogicalDisjunctiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLogicalDisjunctiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLogicalDisjunctiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalDisjunctiveExpressionContext logicalDisjunctiveExpression() throws RecognitionException {
		return logicalDisjunctiveExpression(0);
	}

	private LogicalDisjunctiveExpressionContext logicalDisjunctiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalDisjunctiveExpressionContext _localctx = new LogicalDisjunctiveExpressionContext(_ctx, _parentState);
		LogicalDisjunctiveExpressionContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_logicalDisjunctiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(214);
			logicalDisjunctiveValue();
			}
			_ctx.stop = _input.LT(-1);
			setState(222);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LogicalDisjunctiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logicalDisjunctiveExpression);
					setState(216);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(217);
					or();
					setState(218);
					logicalDisjunctiveValue();
					}
					} 
				}
				setState(224);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class LogicalImplicationExpressionContext extends ParserRuleContext {
		public LogicalDisjunctiveExpressionContext logicalDisjunctiveExpression() {
			return getRuleContext(LogicalDisjunctiveExpressionContext.class,0);
		}
		public ImpliedByContext impliedBy() {
			return getRuleContext(ImpliedByContext.class,0);
		}
		public LogicalConjunctiveExpressionContext logicalConjunctiveExpression() {
			return getRuleContext(LogicalConjunctiveExpressionContext.class,0);
		}
		public ThenContext then() {
			return getRuleContext(ThenContext.class,0);
		}
		public LogicalImplicationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalImplicationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLogicalImplicationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLogicalImplicationExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLogicalImplicationExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalImplicationExpressionContext logicalImplicationExpression() throws RecognitionException {
		LogicalImplicationExpressionContext _localctx = new LogicalImplicationExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_logicalImplicationExpression);
		try {
			setState(233);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				logicalDisjunctiveExpression(0);
				setState(226);
				impliedBy();
				setState(227);
				logicalConjunctiveExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				logicalConjunctiveExpression(0);
				setState(230);
				then();
				setState(231);
				logicalDisjunctiveExpression(0);
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

	public static class LogicalRuleExpressionContext extends ParserRuleContext {
		public LogicalDisjunctiveExpressionContext logicalDisjunctiveExpression() {
			return getRuleContext(LogicalDisjunctiveExpressionContext.class,0);
		}
		public LogicalImplicationExpressionContext logicalImplicationExpression() {
			return getRuleContext(LogicalImplicationExpressionContext.class,0);
		}
		public LogicalRuleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalRuleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLogicalRuleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLogicalRuleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLogicalRuleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalRuleExpressionContext logicalRuleExpression() throws RecognitionException {
		LogicalRuleExpressionContext _localctx = new LogicalRuleExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_logicalRuleExpression);
		try {
			setState(237);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				logicalDisjunctiveExpression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				logicalImplicationExpression();
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

	public static class ArithmeticRuleContext extends ParserRuleContext {
		public WeightedArithmeticRuleContext weightedArithmeticRule() {
			return getRuleContext(WeightedArithmeticRuleContext.class,0);
		}
		public UnweightedArithmeticRuleContext unweightedArithmeticRule() {
			return getRuleContext(UnweightedArithmeticRuleContext.class,0);
		}
		public ArithmeticRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterArithmeticRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitArithmeticRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitArithmeticRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticRuleContext arithmeticRule() throws RecognitionException {
		ArithmeticRuleContext _localctx = new ArithmeticRuleContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arithmeticRule);
		try {
			setState(241);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239);
				weightedArithmeticRule();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				unweightedArithmeticRule();
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

	public static class WeightedArithmeticRuleContext extends ParserRuleContext {
		public WeightExpressionContext weightExpression() {
			return getRuleContext(WeightExpressionContext.class,0);
		}
		public ArithmeticRuleExpressionContext arithmeticRuleExpression() {
			return getRuleContext(ArithmeticRuleExpressionContext.class,0);
		}
		public TerminalNode EXPONENT_EXPRESSION() { return getToken(PSLParser.EXPONENT_EXPRESSION, 0); }
		public List<FilterClauseContext> filterClause() {
			return getRuleContexts(FilterClauseContext.class);
		}
		public FilterClauseContext filterClause(int i) {
			return getRuleContext(FilterClauseContext.class,i);
		}
		public WeightedArithmeticRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightedArithmeticRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterWeightedArithmeticRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitWeightedArithmeticRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitWeightedArithmeticRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeightedArithmeticRuleContext weightedArithmeticRule() throws RecognitionException {
		WeightedArithmeticRuleContext _localctx = new WeightedArithmeticRuleContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_weightedArithmeticRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			weightExpression();
			setState(244);
			arithmeticRuleExpression();
			setState(246);
			_la = _input.LA(1);
			if (_la==EXPONENT_EXPRESSION) {
				{
				setState(245);
				match(EXPONENT_EXPRESSION);
				}
			}

			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACE) {
				{
				{
				setState(248);
				filterClause();
				}
				}
				setState(253);
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

	public static class UnweightedArithmeticRuleContext extends ParserRuleContext {
		public ArithmeticRuleExpressionContext arithmeticRuleExpression() {
			return getRuleContext(ArithmeticRuleExpressionContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(PSLParser.PERIOD, 0); }
		public List<FilterClauseContext> filterClause() {
			return getRuleContexts(FilterClauseContext.class);
		}
		public FilterClauseContext filterClause(int i) {
			return getRuleContext(FilterClauseContext.class,i);
		}
		public UnweightedArithmeticRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unweightedArithmeticRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterUnweightedArithmeticRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitUnweightedArithmeticRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitUnweightedArithmeticRule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnweightedArithmeticRuleContext unweightedArithmeticRule() throws RecognitionException {
		UnweightedArithmeticRuleContext _localctx = new UnweightedArithmeticRuleContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unweightedArithmeticRule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			arithmeticRuleExpression();
			setState(255);
			match(PERIOD);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACE) {
				{
				{
				setState(256);
				filterClause();
				}
				}
				setState(261);
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

	public static class ArithmeticRuleExpressionContext extends ParserRuleContext {
		public List<LinearArithmeticExpressionContext> linearArithmeticExpression() {
			return getRuleContexts(LinearArithmeticExpressionContext.class);
		}
		public LinearArithmeticExpressionContext linearArithmeticExpression(int i) {
			return getRuleContext(LinearArithmeticExpressionContext.class,i);
		}
		public ArithmeticRuleRelationContext arithmeticRuleRelation() {
			return getRuleContext(ArithmeticRuleRelationContext.class,0);
		}
		public ArithmeticRuleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticRuleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterArithmeticRuleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitArithmeticRuleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitArithmeticRuleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticRuleExpressionContext arithmeticRuleExpression() throws RecognitionException {
		ArithmeticRuleExpressionContext _localctx = new ArithmeticRuleExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_arithmeticRuleExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			linearArithmeticExpression(0);
			setState(263);
			arithmeticRuleRelation();
			setState(264);
			linearArithmeticExpression(0);
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

	public static class LinearArithmeticExpressionContext extends ParserRuleContext {
		public LinearArithmeticOperandContext linearArithmeticOperand() {
			return getRuleContext(LinearArithmeticOperandContext.class,0);
		}
		public LinearArithmeticExpressionContext linearArithmeticExpression() {
			return getRuleContext(LinearArithmeticExpressionContext.class,0);
		}
		public LinearOperatorContext linearOperator() {
			return getRuleContext(LinearOperatorContext.class,0);
		}
		public LinearArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearArithmeticExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLinearArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLinearArithmeticExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLinearArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinearArithmeticExpressionContext linearArithmeticExpression() throws RecognitionException {
		return linearArithmeticExpression(0);
	}

	private LinearArithmeticExpressionContext linearArithmeticExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LinearArithmeticExpressionContext _localctx = new LinearArithmeticExpressionContext(_ctx, _parentState);
		LinearArithmeticExpressionContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_linearArithmeticExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(267);
			linearArithmeticOperand();
			}
			_ctx.stop = _input.LT(-1);
			setState(275);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LinearArithmeticExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_linearArithmeticExpression);
					setState(269);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(270);
					linearOperator();
					setState(271);
					linearArithmeticOperand();
					}
					} 
				}
				setState(277);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class LinearArithmeticOperandContext extends ParserRuleContext {
		public ArithmeticCoefficientOperandContext arithmeticCoefficientOperand() {
			return getRuleContext(ArithmeticCoefficientOperandContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PSLParser.LPAREN, 0); }
		public LinearArithmeticExpressionContext linearArithmeticExpression() {
			return getRuleContext(LinearArithmeticExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PSLParser.RPAREN, 0); }
		public LinearArithmeticOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearArithmeticOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLinearArithmeticOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLinearArithmeticOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLinearArithmeticOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinearArithmeticOperandContext linearArithmeticOperand() throws RecognitionException {
		LinearArithmeticOperandContext _localctx = new LinearArithmeticOperandContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_linearArithmeticOperand);
		try {
			setState(283);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				arithmeticCoefficientOperand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(LPAREN);
				setState(280);
				linearArithmeticExpression(0);
				setState(281);
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

	public static class ArithmeticCoefficientOperandContext extends ParserRuleContext {
		public SummationAtomContext summationAtom() {
			return getRuleContext(SummationAtomContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<CoefficientExpressionContext> coefficientExpression() {
			return getRuleContexts(CoefficientExpressionContext.class);
		}
		public CoefficientExpressionContext coefficientExpression(int i) {
			return getRuleContext(CoefficientExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(PSLParser.DIV, 0); }
		public TerminalNode MULT() { return getToken(PSLParser.MULT, 0); }
		public ArithmeticCoefficientOperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticCoefficientOperand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterArithmeticCoefficientOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitArithmeticCoefficientOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitArithmeticCoefficientOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticCoefficientOperandContext arithmeticCoefficientOperand() throws RecognitionException {
		ArithmeticCoefficientOperandContext _localctx = new ArithmeticCoefficientOperandContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_arithmeticCoefficientOperand);
		int _la;
		try {
			setState(300);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << MAX) | (1L << MIN) | (1L << NONNEGATIVE_NUMBER) | (1L << PIPE) | (1L << LPAREN))) != 0)) {
					{
					setState(285);
					coefficientExpression();
					setState(287);
					_la = _input.LA(1);
					if (_la==MULT) {
						{
						setState(286);
						match(MULT);
						}
					}

					}
				}

				setState(293);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(291);
					summationAtom();
					}
					break;
				case 2:
					{
					setState(292);
					atom();
					}
					break;
				}
				setState(297);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(295);
					match(DIV);
					setState(296);
					coefficientExpression();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				coefficientExpression();
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

	public static class SummationAtomContext extends ParserRuleContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PSLParser.RPAREN, 0); }
		public List<SummationVariableContext> summationVariable() {
			return getRuleContexts(SummationVariableContext.class);
		}
		public SummationVariableContext summationVariable(int i) {
			return getRuleContext(SummationVariableContext.class,i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PSLParser.COMMA, i);
		}
		public SummationAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_summationAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterSummationAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitSummationAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitSummationAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SummationAtomContext summationAtom() throws RecognitionException {
		SummationAtomContext _localctx = new SummationAtomContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_summationAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			predicate();
			setState(303);
			match(LPAREN);
			setState(306);
			switch (_input.LA(1)) {
			case PLUS:
				{
				setState(304);
				summationVariable();
				}
				break;
			case STRING_LITERAL:
			case IDENTIFIER:
				{
				setState(305);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(308);
				match(COMMA);
				setState(311);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(309);
					summationVariable();
					}
					break;
				case STRING_LITERAL:
				case IDENTIFIER:
					{
					setState(310);
					term();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(318);
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

	public static class SummationVariableContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PSLParser.PLUS, 0); }
		public TerminalNode IDENTIFIER() { return getToken(PSLParser.IDENTIFIER, 0); }
		public SummationVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_summationVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterSummationVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitSummationVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitSummationVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SummationVariableContext summationVariable() throws RecognitionException {
		SummationVariableContext _localctx = new SummationVariableContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_summationVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(PLUS);
			setState(321);
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

	public static class CoefficientContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public CoefficientOperatorContext coefficientOperator() {
			return getRuleContext(CoefficientOperatorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PSLParser.LPAREN, 0); }
		public CoefficientExpressionContext coefficientExpression() {
			return getRuleContext(CoefficientExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PSLParser.RPAREN, 0); }
		public CoefficientContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefficient; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterCoefficient(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitCoefficient(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitCoefficient(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoefficientContext coefficient() throws RecognitionException {
		CoefficientContext _localctx = new CoefficientContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_coefficient);
		try {
			setState(329);
			switch (_input.LA(1)) {
			case MINUS:
			case NONNEGATIVE_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				number();
				}
				break;
			case MAX:
			case MIN:
			case PIPE:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				coefficientOperator();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 3);
				{
				setState(325);
				match(LPAREN);
				setState(326);
				coefficientExpression();
				setState(327);
				match(RPAREN);
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

	public static class CoefficientMultiplicativeExpressionContext extends ParserRuleContext {
		public CoefficientContext coefficient() {
			return getRuleContext(CoefficientContext.class,0);
		}
		public CoefficientMultiplicativeExpressionContext coefficientMultiplicativeExpression() {
			return getRuleContext(CoefficientMultiplicativeExpressionContext.class,0);
		}
		public TerminalNode MULT() { return getToken(PSLParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(PSLParser.DIV, 0); }
		public CoefficientMultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefficientMultiplicativeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterCoefficientMultiplicativeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitCoefficientMultiplicativeExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitCoefficientMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoefficientMultiplicativeExpressionContext coefficientMultiplicativeExpression() throws RecognitionException {
		return coefficientMultiplicativeExpression(0);
	}

	private CoefficientMultiplicativeExpressionContext coefficientMultiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CoefficientMultiplicativeExpressionContext _localctx = new CoefficientMultiplicativeExpressionContext(_ctx, _parentState);
		CoefficientMultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_coefficientMultiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(332);
			coefficient();
			}
			_ctx.stop = _input.LT(-1);
			setState(342);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(340);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new CoefficientMultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_coefficientMultiplicativeExpression);
						setState(334);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(335);
						match(MULT);
						setState(336);
						coefficient();
						}
						break;
					case 2:
						{
						_localctx = new CoefficientMultiplicativeExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_coefficientMultiplicativeExpression);
						setState(337);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(338);
						match(DIV);
						setState(339);
						coefficient();
						}
						break;
					}
					} 
				}
				setState(344);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class CoefficientAdditiveExpressionContext extends ParserRuleContext {
		public CoefficientMultiplicativeExpressionContext coefficientMultiplicativeExpression() {
			return getRuleContext(CoefficientMultiplicativeExpressionContext.class,0);
		}
		public CoefficientAdditiveExpressionContext coefficientAdditiveExpression() {
			return getRuleContext(CoefficientAdditiveExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PSLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PSLParser.MINUS, 0); }
		public CoefficientAdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefficientAdditiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterCoefficientAdditiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitCoefficientAdditiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitCoefficientAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoefficientAdditiveExpressionContext coefficientAdditiveExpression() throws RecognitionException {
		return coefficientAdditiveExpression(0);
	}

	private CoefficientAdditiveExpressionContext coefficientAdditiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CoefficientAdditiveExpressionContext _localctx = new CoefficientAdditiveExpressionContext(_ctx, _parentState);
		CoefficientAdditiveExpressionContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_coefficientAdditiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(346);
			coefficientMultiplicativeExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(356);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(354);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new CoefficientAdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_coefficientAdditiveExpression);
						setState(348);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(349);
						match(PLUS);
						setState(350);
						coefficientMultiplicativeExpression(0);
						}
						break;
					case 2:
						{
						_localctx = new CoefficientAdditiveExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_coefficientAdditiveExpression);
						setState(351);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(352);
						match(MINUS);
						setState(353);
						coefficientMultiplicativeExpression(0);
						}
						break;
					}
					} 
				}
				setState(358);
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

	public static class CoefficientExpressionContext extends ParserRuleContext {
		public CoefficientAdditiveExpressionContext coefficientAdditiveExpression() {
			return getRuleContext(CoefficientAdditiveExpressionContext.class,0);
		}
		public CoefficientExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefficientExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterCoefficientExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitCoefficientExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitCoefficientExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoefficientExpressionContext coefficientExpression() throws RecognitionException {
		CoefficientExpressionContext _localctx = new CoefficientExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_coefficientExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			coefficientAdditiveExpression(0);
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

	public static class CoefficientOperatorContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() { return getTokens(PSLParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(PSLParser.PIPE, i);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public CoefficientFunctionContext coefficientFunction() {
			return getRuleContext(CoefficientFunctionContext.class,0);
		}
		public CoefficientOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefficientOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterCoefficientOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitCoefficientOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitCoefficientOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoefficientOperatorContext coefficientOperator() throws RecognitionException {
		CoefficientOperatorContext _localctx = new CoefficientOperatorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_coefficientOperator);
		try {
			setState(366);
			switch (_input.LA(1)) {
			case PIPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				match(PIPE);
				setState(362);
				variable();
				setState(363);
				match(PIPE);
				}
				break;
			case MAX:
			case MIN:
				enterOuterAlt(_localctx, 2);
				{
				setState(365);
				coefficientFunction();
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

	public static class CoefficientFunctionContext extends ParserRuleContext {
		public CoefficientFunctionOperatorContext coefficientFunctionOperator() {
			return getRuleContext(CoefficientFunctionOperatorContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(PSLParser.LBRACKET, 0); }
		public List<CoefficientExpressionContext> coefficientExpression() {
			return getRuleContexts(CoefficientExpressionContext.class);
		}
		public CoefficientExpressionContext coefficientExpression(int i) {
			return getRuleContext(CoefficientExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PSLParser.COMMA, 0); }
		public TerminalNode RBRACKET() { return getToken(PSLParser.RBRACKET, 0); }
		public TerminalNode LPAREN() { return getToken(PSLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PSLParser.RPAREN, 0); }
		public CoefficientFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefficientFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterCoefficientFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitCoefficientFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitCoefficientFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoefficientFunctionContext coefficientFunction() throws RecognitionException {
		CoefficientFunctionContext _localctx = new CoefficientFunctionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_coefficientFunction);
		try {
			setState(382);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				coefficientFunctionOperator();
				setState(369);
				match(LBRACKET);
				setState(370);
				coefficientExpression();
				setState(371);
				match(COMMA);
				setState(372);
				coefficientExpression();
				setState(373);
				match(RBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(375);
				coefficientFunctionOperator();
				setState(376);
				match(LPAREN);
				setState(377);
				coefficientExpression();
				setState(378);
				match(COMMA);
				setState(379);
				coefficientExpression();
				setState(380);
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

	public static class CoefficientFunctionOperatorContext extends ParserRuleContext {
		public TerminalNode MAX() { return getToken(PSLParser.MAX, 0); }
		public TerminalNode MIN() { return getToken(PSLParser.MIN, 0); }
		public CoefficientFunctionOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_coefficientFunctionOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterCoefficientFunctionOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitCoefficientFunctionOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitCoefficientFunctionOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CoefficientFunctionOperatorContext coefficientFunctionOperator() throws RecognitionException {
		CoefficientFunctionOperatorContext _localctx = new CoefficientFunctionOperatorContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_coefficientFunctionOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			_la = _input.LA(1);
			if ( !(_la==MAX || _la==MIN) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class FilterClauseContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PSLParser.LBRACE, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PSLParser.COLON, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PSLParser.RBRACE, 0); }
		public FilterClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filterClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterFilterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitFilterClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitFilterClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FilterClauseContext filterClause() throws RecognitionException {
		FilterClauseContext _localctx = new FilterClauseContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_filterClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(LBRACE);
			setState(387);
			variable();
			setState(388);
			match(COLON);
			setState(389);
			booleanExpression();
			setState(390);
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

	public static class BooleanValueContext extends ParserRuleContext {
		public LogicalNegationValueContext logicalNegationValue() {
			return getRuleContext(LogicalNegationValueContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PSLParser.LPAREN, 0); }
		public BooleanExpressionContext booleanExpression() {
			return getRuleContext(BooleanExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PSLParser.RPAREN, 0); }
		public BooleanValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterBooleanValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitBooleanValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitBooleanValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanValueContext booleanValue() throws RecognitionException {
		BooleanValueContext _localctx = new BooleanValueContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_booleanValue);
		try {
			setState(397);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(392);
				logicalNegationValue();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(393);
				match(LPAREN);
				setState(394);
				booleanExpression();
				setState(395);
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

	public static class BooleanConjunctiveExpressionContext extends ParserRuleContext {
		public BooleanValueContext booleanValue() {
			return getRuleContext(BooleanValueContext.class,0);
		}
		public BooleanConjunctiveExpressionContext booleanConjunctiveExpression() {
			return getRuleContext(BooleanConjunctiveExpressionContext.class,0);
		}
		public AndContext and() {
			return getRuleContext(AndContext.class,0);
		}
		public BooleanConjunctiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanConjunctiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterBooleanConjunctiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitBooleanConjunctiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitBooleanConjunctiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanConjunctiveExpressionContext booleanConjunctiveExpression() throws RecognitionException {
		return booleanConjunctiveExpression(0);
	}

	private BooleanConjunctiveExpressionContext booleanConjunctiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanConjunctiveExpressionContext _localctx = new BooleanConjunctiveExpressionContext(_ctx, _parentState);
		BooleanConjunctiveExpressionContext _prevctx = _localctx;
		int _startState = 72;
		enterRecursionRule(_localctx, 72, RULE_booleanConjunctiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(400);
			booleanValue();
			}
			_ctx.stop = _input.LT(-1);
			setState(408);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanConjunctiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_booleanConjunctiveExpression);
					setState(402);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(403);
					and();
					setState(404);
					booleanValue();
					}
					} 
				}
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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

	public static class BooleanDisjunctiveExpressionContext extends ParserRuleContext {
		public BooleanConjunctiveExpressionContext booleanConjunctiveExpression() {
			return getRuleContext(BooleanConjunctiveExpressionContext.class,0);
		}
		public BooleanDisjunctiveExpressionContext booleanDisjunctiveExpression() {
			return getRuleContext(BooleanDisjunctiveExpressionContext.class,0);
		}
		public OrContext or() {
			return getRuleContext(OrContext.class,0);
		}
		public BooleanDisjunctiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanDisjunctiveExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterBooleanDisjunctiveExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitBooleanDisjunctiveExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitBooleanDisjunctiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanDisjunctiveExpressionContext booleanDisjunctiveExpression() throws RecognitionException {
		return booleanDisjunctiveExpression(0);
	}

	private BooleanDisjunctiveExpressionContext booleanDisjunctiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		BooleanDisjunctiveExpressionContext _localctx = new BooleanDisjunctiveExpressionContext(_ctx, _parentState);
		BooleanDisjunctiveExpressionContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_booleanDisjunctiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(412);
			booleanConjunctiveExpression(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(420);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new BooleanDisjunctiveExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_booleanDisjunctiveExpression);
					setState(414);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(415);
					or();
					setState(416);
					booleanConjunctiveExpression(0);
					}
					} 
				}
				setState(422);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BooleanExpressionContext extends ParserRuleContext {
		public BooleanDisjunctiveExpressionContext booleanDisjunctiveExpression() {
			return getRuleContext(BooleanDisjunctiveExpressionContext.class,0);
		}
		public BooleanExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterBooleanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitBooleanExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitBooleanExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExpressionContext booleanExpression() throws RecognitionException {
		BooleanExpressionContext _localctx = new BooleanExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_booleanExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			booleanDisjunctiveExpression(0);
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

	public static class WeightExpressionContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PSLParser.COLON, 0); }
		public WeightExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weightExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterWeightExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitWeightExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitWeightExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WeightExpressionContext weightExpression() throws RecognitionException {
		WeightExpressionContext _localctx = new WeightExpressionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_weightExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			number();
			setState(426);
			match(COLON);
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

	public static class NotContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(PSLParser.NEGATION, 0); }
		public NotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotContext not() throws RecognitionException {
		NotContext _localctx = new NotContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(NEGATION);
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

	public static class AndContext extends ParserRuleContext {
		public List<TerminalNode> AMPERSAND() { return getTokens(PSLParser.AMPERSAND); }
		public TerminalNode AMPERSAND(int i) {
			return getToken(PSLParser.AMPERSAND, i);
		}
		public AndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AndContext and() throws RecognitionException {
		AndContext _localctx = new AndContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_and);
		try {
			setState(433);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				match(AMPERSAND);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				match(AMPERSAND);
				setState(432);
				match(AMPERSAND);
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

	public static class OrContext extends ParserRuleContext {
		public List<TerminalNode> PIPE() { return getTokens(PSLParser.PIPE); }
		public TerminalNode PIPE(int i) {
			return getToken(PSLParser.PIPE, i);
		}
		public OrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrContext or() throws RecognitionException {
		OrContext _localctx = new OrContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_or);
		try {
			setState(438);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				match(PIPE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				match(PIPE);
				setState(437);
				match(PIPE);
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

	public static class ThenContext extends ParserRuleContext {
		public ThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitThen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitThen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThenContext then() throws RecognitionException {
		ThenContext _localctx = new ThenContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_then);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class ImpliedByContext extends ParserRuleContext {
		public ImpliedByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impliedBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterImpliedBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitImpliedBy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitImpliedBy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImpliedByContext impliedBy() throws RecognitionException {
		ImpliedByContext _localctx = new ImpliedByContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_impliedBy);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class TermOperatorContext extends ParserRuleContext {
		public TermEqualContext termEqual() {
			return getRuleContext(TermEqualContext.class,0);
		}
		public NotEqualContext notEqual() {
			return getRuleContext(NotEqualContext.class,0);
		}
		public NonSymmetricContext nonSymmetric() {
			return getRuleContext(NonSymmetricContext.class,0);
		}
		public TermOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterTermOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitTermOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitTermOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermOperatorContext termOperator() throws RecognitionException {
		TermOperatorContext _localctx = new TermOperatorContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_termOperator);
		try {
			setState(447);
			switch (_input.LA(1)) {
			case EQUAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(444);
				termEqual();
				}
				break;
			case MINUS:
			case NEGATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
				notEqual();
				}
				break;
			case MOD:
			case CARROT:
				enterOuterAlt(_localctx, 3);
				{
				setState(446);
				nonSymmetric();
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

	public static class TermEqualContext extends ParserRuleContext {
		public List<TerminalNode> EQUAL() { return getTokens(PSLParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(PSLParser.EQUAL, i);
		}
		public TermEqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termEqual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterTermEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitTermEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitTermEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermEqualContext termEqual() throws RecognitionException {
		TermEqualContext _localctx = new TermEqualContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_termEqual);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(EQUAL);
			setState(450);
			match(EQUAL);
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

	public static class NotEqualContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(PSLParser.NEGATION, 0); }
		public TerminalNode EQUAL() { return getToken(PSLParser.EQUAL, 0); }
		public TerminalNode MINUS() { return getToken(PSLParser.MINUS, 0); }
		public NotEqualContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notEqual; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterNotEqual(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitNotEqual(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitNotEqual(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NotEqualContext notEqual() throws RecognitionException {
		NotEqualContext _localctx = new NotEqualContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_notEqual);
		try {
			setState(455);
			switch (_input.LA(1)) {
			case NEGATION:
				enterOuterAlt(_localctx, 1);
				{
				setState(452);
				match(NEGATION);
				setState(453);
				match(EQUAL);
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(454);
				match(MINUS);
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

	public static class NonSymmetricContext extends ParserRuleContext {
		public TerminalNode MOD() { return getToken(PSLParser.MOD, 0); }
		public TerminalNode CARROT() { return getToken(PSLParser.CARROT, 0); }
		public NonSymmetricContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonSymmetric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterNonSymmetric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitNonSymmetric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitNonSymmetric(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonSymmetricContext nonSymmetric() throws RecognitionException {
		NonSymmetricContext _localctx = new NonSymmetricContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_nonSymmetric);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			_la = _input.LA(1);
			if ( !(_la==MOD || _la==CARROT) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class ArithmeticRuleRelationContext extends ParserRuleContext {
		public TerminalNode LESS_THAN_EQUAL() { return getToken(PSLParser.LESS_THAN_EQUAL, 0); }
		public TerminalNode GREATER_THAN_EQUAL() { return getToken(PSLParser.GREATER_THAN_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(PSLParser.EQUAL, 0); }
		public ArithmeticRuleRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticRuleRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterArithmeticRuleRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitArithmeticRuleRelation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitArithmeticRuleRelation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticRuleRelationContext arithmeticRuleRelation() throws RecognitionException {
		ArithmeticRuleRelationContext _localctx = new ArithmeticRuleRelationContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_arithmeticRuleRelation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LESS_THAN_EQUAL) | (1L << GREATER_THAN_EQUAL) | (1L << EQUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class ArithmeticOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PSLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PSLParser.MINUS, 0); }
		public TerminalNode MULT() { return getToken(PSLParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(PSLParser.DIV, 0); }
		public ArithmeticOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterArithmeticOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitArithmeticOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitArithmeticOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticOperatorContext arithmeticOperator() throws RecognitionException {
		ArithmeticOperatorContext _localctx = new ArithmeticOperatorContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_arithmeticOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(461);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULT) | (1L << DIV))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class LinearOperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PSLParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PSLParser.MINUS, 0); }
		public LinearOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterLinearOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitLinearOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitLinearOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinearOperatorContext linearOperator() throws RecognitionException {
		LinearOperatorContext _localctx = new LinearOperatorContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_linearOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			} else {
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NONNEGATIVE_NUMBER() { return getToken(PSLParser.NONNEGATIVE_NUMBER, 0); }
		public TerminalNode MINUS() { return getToken(PSLParser.MINUS, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PSLListener ) ((PSLListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PSLVisitor ) return ((PSLVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(465);
				match(MINUS);
				}
			}

			setState(468);
			match(NONNEGATIVE_NUMBER);
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
			return logicalConjunctiveExpression_sempred((LogicalConjunctiveExpressionContext)_localctx, predIndex);
		case 15:
			return logicalDisjunctiveExpression_sempred((LogicalDisjunctiveExpressionContext)_localctx, predIndex);
		case 22:
			return linearArithmeticExpression_sempred((LinearArithmeticExpressionContext)_localctx, predIndex);
		case 28:
			return coefficientMultiplicativeExpression_sempred((CoefficientMultiplicativeExpressionContext)_localctx, predIndex);
		case 29:
			return coefficientAdditiveExpression_sempred((CoefficientAdditiveExpressionContext)_localctx, predIndex);
		case 36:
			return booleanConjunctiveExpression_sempred((BooleanConjunctiveExpressionContext)_localctx, predIndex);
		case 37:
			return booleanDisjunctiveExpression_sempred((BooleanDisjunctiveExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logicalConjunctiveExpression_sempred(LogicalConjunctiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logicalDisjunctiveExpression_sempred(LogicalDisjunctiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean linearArithmeticExpression_sempred(LinearArithmeticExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean coefficientMultiplicativeExpression_sempred(CoefficientMultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean coefficientAdditiveExpression_sempred(CoefficientAdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean booleanConjunctiveExpression_sempred(BooleanConjunctiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean booleanDisjunctiveExpression_sempred(BooleanDisjunctiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u01d9\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\3\2\6\2n\n\2\r\2\16\2o\3\2\3\2\3\3\3\3\5\3v\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0083\n\4\f\4\16\4"+
		"\u0086\13\4\3\4\3\4\5\4\u008a\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7\6\u0093"+
		"\n\6\f\6\16\6\u0096\13\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009e\n\6\3\7\3\7"+
		"\5\7\u00a2\n\7\3\b\3\b\3\t\3\t\3\n\3\n\5\n\u00aa\n\n\3\13\3\13\3\13\5"+
		"\13\u00af\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00bc\n"+
		"\r\3\16\3\16\3\16\3\16\3\16\5\16\u00c3\n\16\3\17\3\17\3\17\3\17\3\17\5"+
		"\17\u00ca\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00d3\n\20\f\20"+
		"\16\20\u00d6\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00df\n\21"+
		"\f\21\16\21\u00e2\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00ec"+
		"\n\22\3\23\3\23\5\23\u00f0\n\23\3\24\3\24\5\24\u00f4\n\24\3\25\3\25\3"+
		"\25\5\25\u00f9\n\25\3\25\7\25\u00fc\n\25\f\25\16\25\u00ff\13\25\3\26\3"+
		"\26\3\26\7\26\u0104\n\26\f\26\16\26\u0107\13\26\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30\u0114\n\30\f\30\16\30\u0117\13"+
		"\30\3\31\3\31\3\31\3\31\3\31\5\31\u011e\n\31\3\32\3\32\5\32\u0122\n\32"+
		"\5\32\u0124\n\32\3\32\3\32\5\32\u0128\n\32\3\32\3\32\5\32\u012c\n\32\3"+
		"\32\5\32\u012f\n\32\3\33\3\33\3\33\3\33\5\33\u0135\n\33\3\33\3\33\3\33"+
		"\5\33\u013a\n\33\7\33\u013c\n\33\f\33\16\33\u013f\13\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u014c\n\35\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u0157\n\36\f\36\16\36\u015a\13\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u0165\n\37\f\37\16"+
		"\37\u0168\13\37\3 \3 \3!\3!\3!\3!\3!\5!\u0171\n!\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0181\n\"\3#\3#\3$\3$\3$\3$\3$"+
		"\3$\3%\3%\3%\3%\3%\5%\u0190\n%\3&\3&\3&\3&\3&\3&\3&\7&\u0199\n&\f&\16"+
		"&\u019c\13&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u01a5\n\'\f\'\16\'\u01a8\13"+
		"\'\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\5+\u01b4\n+\3,\3,\3,\5,\u01b9\n,\3-\3"+
		"-\3.\3.\3/\3/\3/\5/\u01c2\n/\3\60\3\60\3\60\3\61\3\61\3\61\5\61\u01ca"+
		"\n\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\5\66\u01d5\n\66\3\66"+
		"\3\66\3\66\2\t\36 .:<JL\67\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$"+
		"&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhj\2\t\3\2\20\21\3\2\3\4\3\2"+
		"\5\6\3\2\"#\3\2\t\13\3\2\f\17\3\2\f\r\u01d5\2m\3\2\2\2\4u\3\2\2\2\6\u0089"+
		"\3\2\2\2\b\u008b\3\2\2\2\n\u009d\3\2\2\2\f\u00a1\3\2\2\2\16\u00a3\3\2"+
		"\2\2\20\u00a5\3\2\2\2\22\u00a9\3\2\2\2\24\u00ab\3\2\2\2\26\u00b0\3\2\2"+
		"\2\30\u00bb\3\2\2\2\32\u00c2\3\2\2\2\34\u00c9\3\2\2\2\36\u00cb\3\2\2\2"+
		" \u00d7\3\2\2\2\"\u00eb\3\2\2\2$\u00ef\3\2\2\2&\u00f3\3\2\2\2(\u00f5\3"+
		"\2\2\2*\u0100\3\2\2\2,\u0108\3\2\2\2.\u010c\3\2\2\2\60\u011d\3\2\2\2\62"+
		"\u012e\3\2\2\2\64\u0130\3\2\2\2\66\u0142\3\2\2\28\u014b\3\2\2\2:\u014d"+
		"\3\2\2\2<\u015b\3\2\2\2>\u0169\3\2\2\2@\u0170\3\2\2\2B\u0180\3\2\2\2D"+
		"\u0182\3\2\2\2F\u0184\3\2\2\2H\u018f\3\2\2\2J\u0191\3\2\2\2L\u019d\3\2"+
		"\2\2N\u01a9\3\2\2\2P\u01ab\3\2\2\2R\u01ae\3\2\2\2T\u01b3\3\2\2\2V\u01b8"+
		"\3\2\2\2X\u01ba\3\2\2\2Z\u01bc\3\2\2\2\\\u01c1\3\2\2\2^\u01c3\3\2\2\2"+
		"`\u01c9\3\2\2\2b\u01cb\3\2\2\2d\u01cd\3\2\2\2f\u01cf\3\2\2\2h\u01d1\3"+
		"\2\2\2j\u01d4\3\2\2\2ln\5\4\3\2ml\3\2\2\2no\3\2\2\2om\3\2\2\2op\3\2\2"+
		"\2pq\3\2\2\2qr\7\2\2\3r\3\3\2\2\2sv\5\22\n\2tv\5&\24\2us\3\2\2\2ut\3\2"+
		"\2\2v\5\3\2\2\2wx\5\22\n\2xy\7\2\2\3y\u008a\3\2\2\2z{\5&\24\2{|\7\2\2"+
		"\3|\u008a\3\2\2\2}~\5$\23\2~\177\7\2\2\3\177\u008a\3\2\2\2\u0080\u0084"+
		"\5,\27\2\u0081\u0083\5F$\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084"+
		"\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2"+
		"\2\2\u0087\u0088\7\2\2\3\u0088\u008a\3\2\2\2\u0089w\3\2\2\2\u0089z\3\2"+
		"\2\2\u0089}\3\2\2\2\u0089\u0080\3\2\2\2\u008a\7\3\2\2\2\u008b\u008c\7"+
		"\22\2\2\u008c\t\3\2\2\2\u008d\u008e\5\b\5\2\u008e\u008f\7\32\2\2\u008f"+
		"\u0094\5\f\7\2\u0090\u0091\7\25\2\2\u0091\u0093\5\f\7\2\u0092\u0090\3"+
		"\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0097\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u0098\7\33\2\2\u0098\u009e\3"+
		"\2\2\2\u0099\u009a\5\f\7\2\u009a\u009b\5\\/\2\u009b\u009c\5\f\7\2\u009c"+
		"\u009e\3\2\2\2\u009d\u008d\3\2\2\2\u009d\u0099\3\2\2\2\u009e\13\3\2\2"+
		"\2\u009f\u00a2\5\16\b\2\u00a0\u00a2\5\20\t\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a0\3\2\2\2\u00a2\r\3\2\2\2\u00a3\u00a4\7\22\2\2\u00a4\17\3\2\2\2\u00a5"+
		"\u00a6\7\7\2\2\u00a6\21\3\2\2\2\u00a7\u00aa\5\24\13\2\u00a8\u00aa\5\26"+
		"\f\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\23\3\2\2\2\u00ab\u00ac"+
		"\5P)\2\u00ac\u00ae\5$\23\2\u00ad\u00af\7\b\2\2\u00ae\u00ad\3\2\2\2\u00ae"+
		"\u00af\3\2\2\2\u00af\25\3\2\2\2\u00b0\u00b1\5$\23\2\u00b1\u00b2\7\24\2"+
		"\2\u00b2\27\3\2\2\2\u00b3\u00bc\5\n\6\2\u00b4\u00b5\5R*\2\u00b5\u00b6"+
		"\5\30\r\2\u00b6\u00bc\3\2\2\2\u00b7\u00b8\7\32\2\2\u00b8\u00b9\5\30\r"+
		"\2\u00b9\u00ba\7\33\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b3\3\2\2\2\u00bb"+
		"\u00b4\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bc\31\3\2\2\2\u00bd\u00c3\5\30\r"+
		"\2\u00be\u00bf\7\32\2\2\u00bf\u00c0\5\36\20\2\u00c0\u00c1\7\33\2\2\u00c1"+
		"\u00c3\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c2\u00be\3\2\2\2\u00c3\33\3\2\2"+
		"\2\u00c4\u00ca\5\30\r\2\u00c5\u00c6\7\32\2\2\u00c6\u00c7\5 \21\2\u00c7"+
		"\u00c8\7\33\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c4\3\2\2\2\u00c9\u00c5\3"+
		"\2\2\2\u00ca\35\3\2\2\2\u00cb\u00cc\b\20\1\2\u00cc\u00cd\5\32\16\2\u00cd"+
		"\u00d4\3\2\2\2\u00ce\u00cf\f\3\2\2\u00cf\u00d0\5T+\2\u00d0\u00d1\5\32"+
		"\16\2\u00d1\u00d3\3\2\2\2\u00d2\u00ce\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\37\3\2\2\2\u00d6\u00d4\3\2\2"+
		"\2\u00d7\u00d8\b\21\1\2\u00d8\u00d9\5\34\17\2\u00d9\u00e0\3\2\2\2\u00da"+
		"\u00db\f\3\2\2\u00db\u00dc\5V,\2\u00dc\u00dd\5\34\17\2\u00dd\u00df\3\2"+
		"\2\2\u00de\u00da\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1!\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e4\5 \21\2"+
		"\u00e4\u00e5\5Z.\2\u00e5\u00e6\5\36\20\2\u00e6\u00ec\3\2\2\2\u00e7\u00e8"+
		"\5\36\20\2\u00e8\u00e9\5X-\2\u00e9\u00ea\5 \21\2\u00ea\u00ec\3\2\2\2\u00eb"+
		"\u00e3\3\2\2\2\u00eb\u00e7\3\2\2\2\u00ec#\3\2\2\2\u00ed\u00f0\5 \21\2"+
		"\u00ee\u00f0\5\"\22\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2\u00f0%\3"+
		"\2\2\2\u00f1\u00f4\5(\25\2\u00f2\u00f4\5*\26\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f2\3\2\2\2\u00f4\'\3\2\2\2\u00f5\u00f6\5P)\2\u00f6\u00f8\5,\27\2\u00f7"+
		"\u00f9\7\b\2\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fd\3\2"+
		"\2\2\u00fa\u00fc\5F$\2\u00fb\u00fa\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe)\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100"+
		"\u0101\5,\27\2\u0101\u0105\7\24\2\2\u0102\u0104\5F$\2\u0103\u0102\3\2"+
		"\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"+\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\5.\30\2\u0109\u010a\5d\63\2"+
		"\u010a\u010b\5.\30\2\u010b-\3\2\2\2\u010c\u010d\b\30\1\2\u010d\u010e\5"+
		"\60\31\2\u010e\u0115\3\2\2\2\u010f\u0110\f\3\2\2\u0110\u0111\5h\65\2\u0111"+
		"\u0112\5\60\31\2\u0112\u0114\3\2\2\2\u0113\u010f\3\2\2\2\u0114\u0117\3"+
		"\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116/\3\2\2\2\u0117\u0115"+
		"\3\2\2\2\u0118\u011e\5\62\32\2\u0119\u011a\7\32\2\2\u011a\u011b\5.\30"+
		"\2\u011b\u011c\7\33\2\2\u011c\u011e\3\2\2\2\u011d\u0118\3\2\2\2\u011d"+
		"\u0119\3\2\2\2\u011e\61\3\2\2\2\u011f\u0121\5> \2\u0120\u0122\7\16\2\2"+
		"\u0121\u0120\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u011f"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0128\5\64\33\2"+
		"\u0126\u0128\5\n\6\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128\u012b"+
		"\3\2\2\2\u0129\u012a\7\17\2\2\u012a\u012c\5> \2\u012b\u0129\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012f\3\2\2\2\u012d\u012f\5> \2\u012e\u0123\3\2\2"+
		"\2\u012e\u012d\3\2\2\2\u012f\63\3\2\2\2\u0130\u0131\5\b\5\2\u0131\u0134"+
		"\7\32\2\2\u0132\u0135\5\66\34\2\u0133\u0135\5\f\7\2\u0134\u0132\3\2\2"+
		"\2\u0134\u0133\3\2\2\2\u0135\u013d\3\2\2\2\u0136\u0139\7\25\2\2\u0137"+
		"\u013a\5\66\34\2\u0138\u013a\5\f\7\2\u0139\u0137\3\2\2\2\u0139\u0138\3"+
		"\2\2\2\u013a\u013c\3\2\2\2\u013b\u0136\3\2\2\2\u013c\u013f\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013d\3\2"+
		"\2\2\u0140\u0141\7\33\2\2\u0141\65\3\2\2\2\u0142\u0143\7\f\2\2\u0143\u0144"+
		"\7\22\2\2\u0144\67\3\2\2\2\u0145\u014c\5j\66\2\u0146\u014c\5@!\2\u0147"+
		"\u0148\7\32\2\2\u0148\u0149\5> \2\u0149\u014a\7\33\2\2\u014a\u014c\3\2"+
		"\2\2\u014b\u0145\3\2\2\2\u014b\u0146\3\2\2\2\u014b\u0147\3\2\2\2\u014c"+
		"9\3\2\2\2\u014d\u014e\b\36\1\2\u014e\u014f\58\35\2\u014f\u0158\3\2\2\2"+
		"\u0150\u0151\f\4\2\2\u0151\u0152\7\16\2\2\u0152\u0157\58\35\2\u0153\u0154"+
		"\f\3\2\2\u0154\u0155\7\17\2\2\u0155\u0157\58\35\2\u0156\u0150\3\2\2\2"+
		"\u0156\u0153\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159"+
		"\3\2\2\2\u0159;\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c\b\37\1\2\u015c"+
		"\u015d\5:\36\2\u015d\u0166\3\2\2\2\u015e\u015f\f\4\2\2\u015f\u0160\7\f"+
		"\2\2\u0160\u0165\5:\36\2\u0161\u0162\f\3\2\2\u0162\u0163\7\r\2\2\u0163"+
		"\u0165\5:\36\2\u0164\u015e\3\2\2\2\u0164\u0161\3\2\2\2\u0165\u0168\3\2"+
		"\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167=\3\2\2\2\u0168\u0166"+
		"\3\2\2\2\u0169\u016a\5<\37\2\u016a?\3\2\2\2\u016b\u016c\7\31\2\2\u016c"+
		"\u016d\5\16\b\2\u016d\u016e\7\31\2\2\u016e\u0171\3\2\2\2\u016f\u0171\5"+
		"B\"\2\u0170\u016b\3\2\2\2\u0170\u016f\3\2\2\2\u0171A\3\2\2\2\u0172\u0173"+
		"\5D#\2\u0173\u0174\7\36\2\2\u0174\u0175\5> \2\u0175\u0176\7\25\2\2\u0176"+
		"\u0177\5> \2\u0177\u0178\7\37\2\2\u0178\u0181\3\2\2\2\u0179\u017a\5D#"+
		"\2\u017a\u017b\7\32\2\2\u017b\u017c\5> \2\u017c\u017d\7\25\2\2\u017d\u017e"+
		"\5> \2\u017e\u017f\7\33\2\2\u017f\u0181\3\2\2\2\u0180\u0172\3\2\2\2\u0180"+
		"\u0179\3\2\2\2\u0181C\3\2\2\2\u0182\u0183\t\2\2\2\u0183E\3\2\2\2\u0184"+
		"\u0185\7\34\2\2\u0185\u0186\5\16\b\2\u0186\u0187\7\26\2\2\u0187\u0188"+
		"\5N(\2\u0188\u0189\7\35\2\2\u0189G\3\2\2\2\u018a\u0190\5\30\r\2\u018b"+
		"\u018c\7\32\2\2\u018c\u018d\5N(\2\u018d\u018e\7\33\2\2\u018e\u0190\3\2"+
		"\2\2\u018f\u018a\3\2\2\2\u018f\u018b\3\2\2\2\u0190I\3\2\2\2\u0191\u0192"+
		"\b&\1\2\u0192\u0193\5H%\2\u0193\u019a\3\2\2\2\u0194\u0195\f\3\2\2\u0195"+
		"\u0196\5T+\2\u0196\u0197\5H%\2\u0197\u0199\3\2\2\2\u0198\u0194\3\2\2\2"+
		"\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019bK\3"+
		"\2\2\2\u019c\u019a\3\2\2\2\u019d\u019e\b\'\1\2\u019e\u019f\5J&\2\u019f"+
		"\u01a6\3\2\2\2\u01a0\u01a1\f\3\2\2\u01a1\u01a2\5V,\2\u01a2\u01a3\5J&\2"+
		"\u01a3\u01a5\3\2\2\2\u01a4\u01a0\3\2\2\2\u01a5\u01a8\3\2\2\2\u01a6\u01a4"+
		"\3\2\2\2\u01a6\u01a7\3\2\2\2\u01a7M\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a9"+
		"\u01aa\5L\'\2\u01aaO\3\2\2\2\u01ab\u01ac\5j\66\2\u01ac\u01ad\7\26\2\2"+
		"\u01adQ\3\2\2\2\u01ae\u01af\7\27\2\2\u01afS\3\2\2\2\u01b0\u01b4\7\30\2"+
		"\2\u01b1\u01b2\7\30\2\2\u01b2\u01b4\7\30\2\2\u01b3\u01b0\3\2\2\2\u01b3"+
		"\u01b1\3\2\2\2\u01b4U\3\2\2\2\u01b5\u01b9\7\31\2\2\u01b6\u01b7\7\31\2"+
		"\2\u01b7\u01b9\7\31\2\2\u01b8\u01b5\3\2\2\2\u01b8\u01b6\3\2\2\2\u01b9"+
		"W\3\2\2\2\u01ba\u01bb\t\3\2\2\u01bbY\3\2\2\2\u01bc\u01bd\t\4\2\2\u01bd"+
		"[\3\2\2\2\u01be\u01c2\5^\60\2\u01bf\u01c2\5`\61\2\u01c0\u01c2\5b\62\2"+
		"\u01c1\u01be\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c0\3\2\2\2\u01c2]\3"+
		"\2\2\2\u01c3\u01c4\7\13\2\2\u01c4\u01c5\7\13\2\2\u01c5_\3\2\2\2\u01c6"+
		"\u01c7\7\27\2\2\u01c7\u01ca\7\13\2\2\u01c8\u01ca\7\r\2\2\u01c9\u01c6\3"+
		"\2\2\2\u01c9\u01c8\3\2\2\2\u01caa\3\2\2\2\u01cb\u01cc\t\5\2\2\u01ccc\3"+
		"\2\2\2\u01cd\u01ce\t\6\2\2\u01cee\3\2\2\2\u01cf\u01d0\t\7\2\2\u01d0g\3"+
		"\2\2\2\u01d1\u01d2\t\b\2\2\u01d2i\3\2\2\2\u01d3\u01d5\7\r\2\2\u01d4\u01d3"+
		"\3\2\2\2\u01d4\u01d5\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d7\7\23\2\2"+
		"\u01d7k\3\2\2\2/ou\u0084\u0089\u0094\u009d\u00a1\u00a9\u00ae\u00bb\u00c2"+
		"\u00c9\u00d4\u00e0\u00eb\u00ef\u00f3\u00f8\u00fd\u0105\u0115\u011d\u0121"+
		"\u0123\u0127\u012b\u012e\u0134\u0139\u013d\u014b\u0156\u0158\u0164\u0166"+
		"\u0170\u0180\u018f\u019a\u01a6\u01b3\u01b8\u01c1\u01c9\u01d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
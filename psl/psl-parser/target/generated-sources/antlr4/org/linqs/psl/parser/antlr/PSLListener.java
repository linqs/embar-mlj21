// Generated from org/linqs/psl/parser/antlr/PSL.g4 by ANTLR 4.5
package org.linqs.psl.parser.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PSLParser}.
 */
public interface PSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PSLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PSLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PSLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#pslRule}.
	 * @param ctx the parse tree
	 */
	void enterPslRule(PSLParser.PslRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#pslRule}.
	 * @param ctx the parse tree
	 */
	void exitPslRule(PSLParser.PslRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#pslRulePartial}.
	 * @param ctx the parse tree
	 */
	void enterPslRulePartial(PSLParser.PslRulePartialContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#pslRulePartial}.
	 * @param ctx the parse tree
	 */
	void exitPslRulePartial(PSLParser.PslRulePartialContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(PSLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(PSLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(PSLParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(PSLParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(PSLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(PSLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(PSLParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(PSLParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(PSLParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(PSLParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#logicalRule}.
	 * @param ctx the parse tree
	 */
	void enterLogicalRule(PSLParser.LogicalRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#logicalRule}.
	 * @param ctx the parse tree
	 */
	void exitLogicalRule(PSLParser.LogicalRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#weightedLogicalRule}.
	 * @param ctx the parse tree
	 */
	void enterWeightedLogicalRule(PSLParser.WeightedLogicalRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#weightedLogicalRule}.
	 * @param ctx the parse tree
	 */
	void exitWeightedLogicalRule(PSLParser.WeightedLogicalRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#unweightedLogicalRule}.
	 * @param ctx the parse tree
	 */
	void enterUnweightedLogicalRule(PSLParser.UnweightedLogicalRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#unweightedLogicalRule}.
	 * @param ctx the parse tree
	 */
	void exitUnweightedLogicalRule(PSLParser.UnweightedLogicalRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#logicalNegationValue}.
	 * @param ctx the parse tree
	 */
	void enterLogicalNegationValue(PSLParser.LogicalNegationValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#logicalNegationValue}.
	 * @param ctx the parse tree
	 */
	void exitLogicalNegationValue(PSLParser.LogicalNegationValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#logicalConjunctiveValue}.
	 * @param ctx the parse tree
	 */
	void enterLogicalConjunctiveValue(PSLParser.LogicalConjunctiveValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#logicalConjunctiveValue}.
	 * @param ctx the parse tree
	 */
	void exitLogicalConjunctiveValue(PSLParser.LogicalConjunctiveValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#logicalDisjunctiveValue}.
	 * @param ctx the parse tree
	 */
	void enterLogicalDisjunctiveValue(PSLParser.LogicalDisjunctiveValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#logicalDisjunctiveValue}.
	 * @param ctx the parse tree
	 */
	void exitLogicalDisjunctiveValue(PSLParser.LogicalDisjunctiveValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#logicalConjunctiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalConjunctiveExpression(PSLParser.LogicalConjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#logicalConjunctiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalConjunctiveExpression(PSLParser.LogicalConjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#logicalDisjunctiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalDisjunctiveExpression(PSLParser.LogicalDisjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#logicalDisjunctiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalDisjunctiveExpression(PSLParser.LogicalDisjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#logicalImplicationExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalImplicationExpression(PSLParser.LogicalImplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#logicalImplicationExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalImplicationExpression(PSLParser.LogicalImplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#logicalRuleExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalRuleExpression(PSLParser.LogicalRuleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#logicalRuleExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalRuleExpression(PSLParser.LogicalRuleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#arithmeticRule}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticRule(PSLParser.ArithmeticRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#arithmeticRule}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticRule(PSLParser.ArithmeticRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#weightedArithmeticRule}.
	 * @param ctx the parse tree
	 */
	void enterWeightedArithmeticRule(PSLParser.WeightedArithmeticRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#weightedArithmeticRule}.
	 * @param ctx the parse tree
	 */
	void exitWeightedArithmeticRule(PSLParser.WeightedArithmeticRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#unweightedArithmeticRule}.
	 * @param ctx the parse tree
	 */
	void enterUnweightedArithmeticRule(PSLParser.UnweightedArithmeticRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#unweightedArithmeticRule}.
	 * @param ctx the parse tree
	 */
	void exitUnweightedArithmeticRule(PSLParser.UnweightedArithmeticRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#arithmeticRuleExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticRuleExpression(PSLParser.ArithmeticRuleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#arithmeticRuleExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticRuleExpression(PSLParser.ArithmeticRuleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#linearArithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterLinearArithmeticExpression(PSLParser.LinearArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#linearArithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitLinearArithmeticExpression(PSLParser.LinearArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#linearArithmeticOperand}.
	 * @param ctx the parse tree
	 */
	void enterLinearArithmeticOperand(PSLParser.LinearArithmeticOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#linearArithmeticOperand}.
	 * @param ctx the parse tree
	 */
	void exitLinearArithmeticOperand(PSLParser.LinearArithmeticOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#arithmeticCoefficientOperand}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticCoefficientOperand(PSLParser.ArithmeticCoefficientOperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#arithmeticCoefficientOperand}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticCoefficientOperand(PSLParser.ArithmeticCoefficientOperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#summationAtom}.
	 * @param ctx the parse tree
	 */
	void enterSummationAtom(PSLParser.SummationAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#summationAtom}.
	 * @param ctx the parse tree
	 */
	void exitSummationAtom(PSLParser.SummationAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#summationVariable}.
	 * @param ctx the parse tree
	 */
	void enterSummationVariable(PSLParser.SummationVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#summationVariable}.
	 * @param ctx the parse tree
	 */
	void exitSummationVariable(PSLParser.SummationVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#coefficient}.
	 * @param ctx the parse tree
	 */
	void enterCoefficient(PSLParser.CoefficientContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#coefficient}.
	 * @param ctx the parse tree
	 */
	void exitCoefficient(PSLParser.CoefficientContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#coefficientMultiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterCoefficientMultiplicativeExpression(PSLParser.CoefficientMultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#coefficientMultiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitCoefficientMultiplicativeExpression(PSLParser.CoefficientMultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#coefficientAdditiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterCoefficientAdditiveExpression(PSLParser.CoefficientAdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#coefficientAdditiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitCoefficientAdditiveExpression(PSLParser.CoefficientAdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#coefficientExpression}.
	 * @param ctx the parse tree
	 */
	void enterCoefficientExpression(PSLParser.CoefficientExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#coefficientExpression}.
	 * @param ctx the parse tree
	 */
	void exitCoefficientExpression(PSLParser.CoefficientExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#coefficientOperator}.
	 * @param ctx the parse tree
	 */
	void enterCoefficientOperator(PSLParser.CoefficientOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#coefficientOperator}.
	 * @param ctx the parse tree
	 */
	void exitCoefficientOperator(PSLParser.CoefficientOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#coefficientFunction}.
	 * @param ctx the parse tree
	 */
	void enterCoefficientFunction(PSLParser.CoefficientFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#coefficientFunction}.
	 * @param ctx the parse tree
	 */
	void exitCoefficientFunction(PSLParser.CoefficientFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#coefficientFunctionOperator}.
	 * @param ctx the parse tree
	 */
	void enterCoefficientFunctionOperator(PSLParser.CoefficientFunctionOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#coefficientFunctionOperator}.
	 * @param ctx the parse tree
	 */
	void exitCoefficientFunctionOperator(PSLParser.CoefficientFunctionOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#filterClause}.
	 * @param ctx the parse tree
	 */
	void enterFilterClause(PSLParser.FilterClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#filterClause}.
	 * @param ctx the parse tree
	 */
	void exitFilterClause(PSLParser.FilterClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void enterBooleanValue(PSLParser.BooleanValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#booleanValue}.
	 * @param ctx the parse tree
	 */
	void exitBooleanValue(PSLParser.BooleanValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#booleanConjunctiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanConjunctiveExpression(PSLParser.BooleanConjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#booleanConjunctiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanConjunctiveExpression(PSLParser.BooleanConjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#booleanDisjunctiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanDisjunctiveExpression(PSLParser.BooleanDisjunctiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#booleanDisjunctiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanDisjunctiveExpression(PSLParser.BooleanDisjunctiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(PSLParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(PSLParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#weightExpression}.
	 * @param ctx the parse tree
	 */
	void enterWeightExpression(PSLParser.WeightExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#weightExpression}.
	 * @param ctx the parse tree
	 */
	void exitWeightExpression(PSLParser.WeightExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#not}.
	 * @param ctx the parse tree
	 */
	void enterNot(PSLParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#not}.
	 * @param ctx the parse tree
	 */
	void exitNot(PSLParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#and}.
	 * @param ctx the parse tree
	 */
	void enterAnd(PSLParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#and}.
	 * @param ctx the parse tree
	 */
	void exitAnd(PSLParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#or}.
	 * @param ctx the parse tree
	 */
	void enterOr(PSLParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#or}.
	 * @param ctx the parse tree
	 */
	void exitOr(PSLParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#then}.
	 * @param ctx the parse tree
	 */
	void enterThen(PSLParser.ThenContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#then}.
	 * @param ctx the parse tree
	 */
	void exitThen(PSLParser.ThenContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#impliedBy}.
	 * @param ctx the parse tree
	 */
	void enterImpliedBy(PSLParser.ImpliedByContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#impliedBy}.
	 * @param ctx the parse tree
	 */
	void exitImpliedBy(PSLParser.ImpliedByContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void enterTermOperator(PSLParser.TermOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#termOperator}.
	 * @param ctx the parse tree
	 */
	void exitTermOperator(PSLParser.TermOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#termEqual}.
	 * @param ctx the parse tree
	 */
	void enterTermEqual(PSLParser.TermEqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#termEqual}.
	 * @param ctx the parse tree
	 */
	void exitTermEqual(PSLParser.TermEqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#notEqual}.
	 * @param ctx the parse tree
	 */
	void enterNotEqual(PSLParser.NotEqualContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#notEqual}.
	 * @param ctx the parse tree
	 */
	void exitNotEqual(PSLParser.NotEqualContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#nonSymmetric}.
	 * @param ctx the parse tree
	 */
	void enterNonSymmetric(PSLParser.NonSymmetricContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#nonSymmetric}.
	 * @param ctx the parse tree
	 */
	void exitNonSymmetric(PSLParser.NonSymmetricContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#arithmeticRuleRelation}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticRuleRelation(PSLParser.ArithmeticRuleRelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#arithmeticRuleRelation}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticRuleRelation(PSLParser.ArithmeticRuleRelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticOperator(PSLParser.ArithmeticOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticOperator(PSLParser.ArithmeticOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#linearOperator}.
	 * @param ctx the parse tree
	 */
	void enterLinearOperator(PSLParser.LinearOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#linearOperator}.
	 * @param ctx the parse tree
	 */
	void exitLinearOperator(PSLParser.LinearOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PSLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(PSLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link PSLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(PSLParser.NumberContext ctx);
}
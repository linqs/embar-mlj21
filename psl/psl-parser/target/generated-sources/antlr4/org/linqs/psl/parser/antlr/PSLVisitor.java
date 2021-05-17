// Generated from org/linqs/psl/parser/antlr/PSL.g4 by ANTLR 4.5
package org.linqs.psl.parser.antlr;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PSLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PSLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#pslRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPslRule(PSLParser.PslRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#pslRulePartial}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPslRulePartial(PSLParser.PslRulePartialContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(PSLParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(PSLParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(PSLParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(PSLParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(PSLParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#logicalRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalRule(PSLParser.LogicalRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#weightedLogicalRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightedLogicalRule(PSLParser.WeightedLogicalRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#unweightedLogicalRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnweightedLogicalRule(PSLParser.UnweightedLogicalRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#logicalNegationValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalNegationValue(PSLParser.LogicalNegationValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#logicalConjunctiveValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalConjunctiveValue(PSLParser.LogicalConjunctiveValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#logicalDisjunctiveValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalDisjunctiveValue(PSLParser.LogicalDisjunctiveValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#logicalConjunctiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalConjunctiveExpression(PSLParser.LogicalConjunctiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#logicalDisjunctiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalDisjunctiveExpression(PSLParser.LogicalDisjunctiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#logicalImplicationExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalImplicationExpression(PSLParser.LogicalImplicationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#logicalRuleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalRuleExpression(PSLParser.LogicalRuleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#arithmeticRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticRule(PSLParser.ArithmeticRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#weightedArithmeticRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightedArithmeticRule(PSLParser.WeightedArithmeticRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#unweightedArithmeticRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnweightedArithmeticRule(PSLParser.UnweightedArithmeticRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#arithmeticRuleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticRuleExpression(PSLParser.ArithmeticRuleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#linearArithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinearArithmeticExpression(PSLParser.LinearArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#linearArithmeticOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinearArithmeticOperand(PSLParser.LinearArithmeticOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#arithmeticCoefficientOperand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticCoefficientOperand(PSLParser.ArithmeticCoefficientOperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#summationAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSummationAtom(PSLParser.SummationAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#summationVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSummationVariable(PSLParser.SummationVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#coefficient}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefficient(PSLParser.CoefficientContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#coefficientMultiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefficientMultiplicativeExpression(PSLParser.CoefficientMultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#coefficientAdditiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefficientAdditiveExpression(PSLParser.CoefficientAdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#coefficientExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefficientExpression(PSLParser.CoefficientExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#coefficientOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefficientOperator(PSLParser.CoefficientOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#coefficientFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefficientFunction(PSLParser.CoefficientFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#coefficientFunctionOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoefficientFunctionOperator(PSLParser.CoefficientFunctionOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#filterClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilterClause(PSLParser.FilterClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#booleanValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanValue(PSLParser.BooleanValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#booleanConjunctiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanConjunctiveExpression(PSLParser.BooleanConjunctiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#booleanDisjunctiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanDisjunctiveExpression(PSLParser.BooleanDisjunctiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(PSLParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#weightExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWeightExpression(PSLParser.WeightExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(PSLParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(PSLParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(PSLParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#then}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThen(PSLParser.ThenContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#impliedBy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImpliedBy(PSLParser.ImpliedByContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#termOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermOperator(PSLParser.TermOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#termEqual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermEqual(PSLParser.TermEqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#notEqual}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(PSLParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#nonSymmetric}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonSymmetric(PSLParser.NonSymmetricContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#arithmeticRuleRelation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticRuleRelation(PSLParser.ArithmeticRuleRelationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#arithmeticOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticOperator(PSLParser.ArithmeticOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#linearOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLinearOperator(PSLParser.LinearOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link PSLParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(PSLParser.NumberContext ctx);
}
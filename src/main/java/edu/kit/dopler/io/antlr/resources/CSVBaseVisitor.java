package edu.kit.dopler.io.antlr.resources;
// Generated from CSV.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

***REMOVED****
 * This class provides an empty implementation of {@link CSVVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 ***REMOVED***
@SuppressWarnings("CheckReturnValue")
public class CSVBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements CSVVisitor<T> {
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitCsvFile(CSVParser.CsvFileContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitHdr(CSVParser.HdrContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitRow(CSVParser.RowContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitField(CSVParser.FieldContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitId(CSVParser.IdContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitCardinality(CSVParser.CardinalityContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitQuestion(CSVParser.QuestionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitRange(CSVParser.RangeContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitRangeItem(CSVParser.RangeItemContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitSpecialCharacter(CSVParser.SpecialCharacterContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitSubrange(CSVParser.SubrangeContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitExpression(CSVParser.ExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitUnaryExpression(CSVParser.UnaryExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitDecisionVisibilityCallExpression(CSVParser.DecisionVisibilityCallExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitIsTaken(CSVParser.IsTakenContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitDecisionValueCallExpression(CSVParser.DecisionValueCallExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitBinaryExpression(CSVParser.BinaryExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitAndExpression(CSVParser.AndExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitOrExpression(CSVParser.OrExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitXorExpression(CSVParser.XorExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitEqualityExpression(CSVParser.EqualityExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitGreaterThanExpression(CSVParser.GreaterThanExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitLessThanExpression(CSVParser.LessThanExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitGreaterEqualsExpression(CSVParser.GreaterEqualsExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitLessEqualsExpression(CSVParser.LessEqualsExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitLiteralExpression(CSVParser.LiteralExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitEnumerationLiteralExpression(CSVParser.EnumerationLiteralExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitBooleanLiteralExpression(CSVParser.BooleanLiteralExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitStringLiteralExpression(CSVParser.StringLiteralExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitDoubleLiteralExpression(CSVParser.DoubleLiteralExpressionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitDecisionType(CSVParser.DecisionTypeContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitRule(CSVParser.RuleContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitAction(CSVParser.ActionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitValueRestrictionAction(CSVParser.ValueRestrictionActionContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitAllows(CSVParser.AllowsContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitDisallows(CSVParser.DisallowsContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitEnForce(CSVParser.EnForceContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitEnumEnForce(CSVParser.EnumEnForceContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitStringEnForce(CSVParser.StringEnForceContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitBooleanEnForce(CSVParser.BooleanEnForceContext ctx) { return visitChildren(ctx); }
	***REMOVED****
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 ***REMOVED***
	@Override public T visitDoubleEnForce(CSVParser.DoubleEnForceContext ctx) { return visitChildren(ctx); }
}
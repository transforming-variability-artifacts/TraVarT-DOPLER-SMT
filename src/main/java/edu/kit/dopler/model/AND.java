/**
 * This class extends the abstract class binary expression with a boolean "AND" between the left and the right expression
 *
 *
 */

package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.stream.Stream;

public class AND extends BinaryExpression{


    public AND(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() throws EvaluationException {
        if(getLeftExpression() instanceof BooleanLiteralExpression && getRightExpression() instanceof DecisionValueCallExpression){
            boolean left = ((BooleanLiteralExpression) getLeftExpression()).getLiteral();
            boolean right = (boolean) ((DecisionValueCallExpression) getRightExpression()).getValue().getValue();
            return left && right;
        }
        else if(getLeftExpression() instanceof DecisionValueCallExpression && getRightExpression() instanceof BooleanLiteralExpression){
            boolean left = (boolean) ((DecisionValueCallExpression) getLeftExpression()).getValue().getValue();
            boolean right = ((BooleanLiteralExpression) getRightExpression()).getLiteral();
            return left && right;
        }
        else if (getLeftExpression() instanceof  BooleanLiteralExpression && getRightExpression() instanceof  BooleanLiteralExpression){
            boolean right = ((BooleanLiteralExpression) getRightExpression()).getLiteral();
            boolean left = ((BooleanLiteralExpression) getLeftExpression()).getLiteral();
            return left && right;
        } else if (getLeftExpression() instanceof  BinaryExpression && getRightExpression() instanceof BinaryExpression) {
            return getLeftExpression().evaluate() && getRightExpression().evaluate();
        } else {
            throw new EvaluationException("Only Boolean Values Supported");
        }


    }

    /**
     * The boolean AND can be encoded to the SMT Encoding by simply adding (and (leftExpression) (rightExpression))
     *
     * @param builder the stream builder, where the condition is added
     */
    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecision) {
        builder.add("(and ");
        getLeftExpression().toSMTStream(builder, callingDecision);
        getRightExpression().toSMTStream(builder, callingDecision);
        builder.add(")");


    }


}

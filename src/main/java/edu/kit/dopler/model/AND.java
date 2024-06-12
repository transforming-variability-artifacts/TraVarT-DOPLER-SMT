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
        return getLeftExpression().evaluate() && getRightExpression().evaluate();
    }


    /**
     * The boolean AND can be encoded to the SMT Encoding by simply adding (and (leftExpression) (rightExpression))
     *
     * @param builder the stream builder, where the condition is added
     */
    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        builder.add("(and ");
        getLeftExpression().toSMTStream(builder, callingDecisionConst);
        getRightExpression().toSMTStream(builder, callingDecisionConst);
        builder.add(")");
    }


}

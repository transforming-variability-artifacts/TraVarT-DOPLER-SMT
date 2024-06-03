package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.stream.Stream;

public class XOR extends BinaryExpression{
    public XOR(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() throws EvaluationException {
        return getLeftExpression().evaluate() ^ getRightExpression().evaluate();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        builder.add("(distinct ");
        getLeftExpression().toSMTStream(builder, callingDecisionConst);
        getRightExpression().toSMTStream(builder, callingDecisionConst);
        builder.add(")");
    }
}

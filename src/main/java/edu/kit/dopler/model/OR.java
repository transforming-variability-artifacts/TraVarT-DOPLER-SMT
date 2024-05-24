package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.stream.Stream;

public class OR extends BinaryExpression{


    public OR(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() throws EvaluationException {
        return getLeftExpression().evaluate() || getRightExpression().evaluate();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(or");
        getLeftExpression().toSMTStream(builder);
        getRightExpression().toSMTStream(builder);
        builder.add(")");
    }


}

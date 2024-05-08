package edu.kit.dopler.model;

import java.util.stream.Stream;

public class LessThan extends BinaryExpression{
    public LessThan(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {
        return false;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(<");
        getLeftExpression().toSMTStream(builder);
        getRightExpression().toSMTStream(builder);
        builder.add(")");
    }
}

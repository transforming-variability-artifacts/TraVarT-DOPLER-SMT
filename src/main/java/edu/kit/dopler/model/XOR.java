package edu.kit.dopler.model;

import java.util.stream.Stream;

public class XOR extends BinaryExpression{
    public XOR(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {
        return getLeftExpression().evaluate() ^ getRightExpression().evaluate();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(distinct");
        getLeftExpression().toSMTStream(builder);
        getRightExpression().toSMTStream(builder);
        builder.add(")");
    }
}

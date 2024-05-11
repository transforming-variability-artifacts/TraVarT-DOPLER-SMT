package edu.kit.dopler.model;

import java.util.stream.Stream;

public class GreatherThan extends BinaryExpression{

    public GreatherThan(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {

        double left = ((DoubleLiteralExpression) getLeftExpression()).getLiteral();
        double right = ((DoubleLiteralExpression) getRightExpression()).getLiteral();

        return left > right;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(>");
        getLeftExpression().toSMTStream(builder);
        getRightExpression().toSMTStream(builder);
        builder.add(")");
    }
}

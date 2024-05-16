package edu.kit.dopler.model;

import java.util.stream.Stream;

public class Equals extends BinaryExpression{


    public Equals(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {
        return getLeftExpression() == getRightExpression();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {

    }
}

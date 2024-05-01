package edu.kit.dopler.model;

public class GreatherThan extends BinaryExpression{

    public GreatherThan(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {
        return false;
    }
}

package edu.kit.dopler.model;

public class LessThan extends BinaryExpression{
    public LessThan(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {
        return false;
    }
}

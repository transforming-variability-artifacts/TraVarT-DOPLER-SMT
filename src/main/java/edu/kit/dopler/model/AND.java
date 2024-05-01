package edu.kit.dopler.model;

public class AND extends BinaryExpression{


    public AND(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {
        return getLeftExpression().evaluate() && getRightExpression().evaluate();
    }
}

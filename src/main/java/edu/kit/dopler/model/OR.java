package edu.kit.dopler.model;

public class OR extends BinaryExpression{


    public OR(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {
        return getLeftExpression().evaluate() || getRightExpression().evaluate();
    }
}

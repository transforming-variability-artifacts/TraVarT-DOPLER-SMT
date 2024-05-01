package edu.kit.dopler.model;

public class XOR extends BinaryExpression{
    public XOR(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {
        return getLeftExpression().evaluate() ^ getRightExpression().evaluate();
    }
}

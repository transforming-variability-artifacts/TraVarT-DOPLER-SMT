package edu.kit.dopler.model;

import java.util.Objects;

public abstract class BinaryExpression extends Expression{


    private IExpression leftExpression;
    private IExpression rightExpression;

    public BinaryExpression(IExpression leftExpression, IExpression rightExpression) {
        this.leftExpression = Objects.requireNonNull(leftExpression);
        this.rightExpression = Objects.requireNonNull(rightExpression);
    }


    public IExpression getLeftExpression() {
        return leftExpression;
    }

    public void setLeftExpression(IExpression leftExpression) {
        this.leftExpression = leftExpression;
    }

    public IExpression getRightExpression() {
        return rightExpression;
    }

    public void setRightExpression(IExpression rightExpression) {
        this.rightExpression = rightExpression;
    }
}

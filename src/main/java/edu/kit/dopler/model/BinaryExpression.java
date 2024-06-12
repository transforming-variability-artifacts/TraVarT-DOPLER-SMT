/**
 * This is the abstract class to implement the basic features of a binary expression, which extends the basic Expression
 * A binary expression always has a left and a right expression which are combined by a binary operator like OR, AND, Equals etc.
 *
 */

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

package edu.kit.dopler.model;

public abstract class UnaryExpression extends Expression{



    private IExpression child;

    public UnaryExpression(IExpression child) {
        this.child = child;
    }

    public IExpression getChild() {
        return child;
    }

    public void setChild(IExpression child) {
        this.child = child;
    }

}

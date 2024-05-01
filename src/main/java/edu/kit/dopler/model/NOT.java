package edu.kit.dopler.model;

public class NOT extends UnaryExpression{

    public NOT(IExpression child) {
        super(child);
    }


    @Override
    public boolean evaluate() {
        return !getChild().evaluate();
    }
}

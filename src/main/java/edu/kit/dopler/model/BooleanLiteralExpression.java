package edu.kit.dopler.model;

public class BooleanLiteralExpression extends LiteralExpression{



    private boolean literal = false;

    @Override
    public boolean evaluate() {
        return literal;
    }


    public boolean getLiteral() {
        return literal;
    }

    public void setLiteral(boolean literal) {
        this.literal = literal;
    }
}

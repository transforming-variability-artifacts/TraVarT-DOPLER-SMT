package edu.kit.dopler.model;

public class DoubleLiteralExpression extends LiteralExpression{

    private double literal = 0.0;


    @Override
    public boolean evaluate() {
        return false;
    }

    public double getLiteral() {
        return literal;
    }

    public void setLiteral(double literal) {
        this.literal = literal;
    }
}

package edu.kit.dopler.model;

import java.util.stream.Stream;

public class StringLiteralExpression extends LiteralExpression{

    private String literal;

    public StringLiteralExpression(String literal) {
        this.literal = literal;
    }


    @Override
    public boolean evaluate() {
        return false;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {

    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }
}

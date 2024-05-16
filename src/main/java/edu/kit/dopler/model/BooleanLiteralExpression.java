package edu.kit.dopler.model;

import java.util.stream.Stream;

public class BooleanLiteralExpression extends LiteralExpression{



    private boolean literal;

    public BooleanLiteralExpression(boolean literal){
        this.literal = literal;
    }

    @Override
    public boolean evaluate() {
        return literal;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(" + literal + ")");
    }


    public boolean getLiteral() {
        return literal;
    }

    public void setLiteral(boolean literal) {
        this.literal = literal;
    }
}

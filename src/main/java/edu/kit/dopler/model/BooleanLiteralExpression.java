package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.InvalidTypeInLiteralExpressionCheckException;

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


    @Override
    boolean equalsForLiteralExpressions(IValue<?> value) throws InvalidTypeInLiteralExpressionCheckException {
        if(value instanceof BooleanValue){
            return literal == ((BooleanValue) value).getValue();
        }else {
            throw new InvalidTypeInLiteralExpressionCheckException("Parameter was not of Type StringValue in Equals");
        }

    }
}

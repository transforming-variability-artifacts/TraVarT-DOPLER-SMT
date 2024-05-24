package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.InvalidTypeInLiteralExpressionCheckException;

import java.util.stream.Stream;

public class DoubleLiteralExpression extends LiteralExpression{

    private double literal = 0.0;

    public DoubleLiteralExpression(double literal){
        this.literal = literal;
    }

    @Override
    public boolean evaluate() {
        return literal >= 1.0;
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        //not yet implemented
    }

    public double getLiteral() {
        return literal;
    }

    public void setLiteral(double literal) {
        this.literal = literal;
    }



    @Override
    boolean equalsForLiteralExpressions(IValue<?> value) throws InvalidTypeInLiteralExpressionCheckException {
        if(value instanceof DoubleValue){
            return literal == ((DoubleValue) value).getValue();
        }else {
            throw new InvalidTypeInLiteralExpressionCheckException("Parameter was not of Type StringValue in Equals");
        }

    }
}

package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.InvalidTypeInLiteralExpressionCheckException;

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
    public void toSMTStream(Stream.Builder<String> builder, String callingDecisionConst) {
        builder.add("\"" + literal + "\"");
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }


    /**
     * This methode is implemented for every LiteralExpression to check the equality in the EQUALS expression
     * @param value the value which need to be compared to the literal
     * @return returns a boolean if the values are equal
     * @throws InvalidTypeInLiteralExpressionCheckException is thrown when the value is not of type StringValue
     */
    @Override
    boolean equalsForLiteralExpressions(IValue<?> value) throws InvalidTypeInLiteralExpressionCheckException {
       if(value instanceof StringValue){
           return literal.equals(value.getValue());
       }else {
           throw new InvalidTypeInLiteralExpressionCheckException("Parameter was not of Type StringValue in Equals");
       }

    }
}

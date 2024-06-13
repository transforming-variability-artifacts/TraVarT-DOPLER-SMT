package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;

import java.util.stream.Stream;

public class XOR extends BinaryExpression{
    public XOR(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() throws EvaluationException {
        if(getLeftExpression() instanceof BooleanLiteralExpression && getRightExpression() instanceof DecisionValueCallExpression){
            boolean left = ((BooleanLiteralExpression) getLeftExpression()).getLiteral();
            boolean right = (boolean) ((DecisionValueCallExpression) getRightExpression()).getValue().getValue();
            return left ^ right;
        }
        else if(getLeftExpression() instanceof DecisionValueCallExpression && getRightExpression() instanceof BooleanLiteralExpression){
            boolean left = (boolean) ((DecisionValueCallExpression) getLeftExpression()).getValue().getValue();
            boolean right = ((BooleanLiteralExpression) getRightExpression()).getLiteral();
            return left ^ right;
        }
        else if (getLeftExpression() instanceof  BooleanLiteralExpression && getRightExpression() instanceof  BooleanLiteralExpression){
            boolean right = ((BooleanLiteralExpression) getRightExpression()).getLiteral();
            boolean left = ((BooleanLiteralExpression) getLeftExpression()).getLiteral();
            return left ^ right;
        }else {
            throw new EvaluationException("Only Boolean Values Supported");
        }


    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecision) {
        if(getLeftExpression() instanceof BooleanLiteralExpression || getLeftExpression() instanceof DecisionValueCallExpression || getRightExpression() instanceof DecisionValueCallExpression || getRightExpression() instanceof BooleanLiteralExpression){
            builder.add("(xor ");
            getLeftExpression().toSMTStream(builder, callingDecision);
            getRightExpression().toSMTStream(builder, callingDecision);
            builder.add(")");
        }

    }

}

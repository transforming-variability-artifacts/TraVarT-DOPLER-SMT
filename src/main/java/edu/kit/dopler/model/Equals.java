package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.EvaluationException;
import edu.kit.dopler.exceptions.InvalidTypeInLiteralExpressionCheckException;

import java.util.stream.Stream;

public class Equals extends BinaryExpression{


    public Equals(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() throws EvaluationException {

        try {
            if(getLeftExpression() instanceof LiteralExpression && getRightExpression() instanceof DecisionValueCallExpression){
                IValue<?> right = ((DecisionValueCallExpression) getRightExpression()).getValue();
                return ((LiteralExpression) getLeftExpression()).equalsForLiteralExpressions(right);
            }
            if(getLeftExpression() instanceof DecisionValueCallExpression && getRightExpression() instanceof LiteralExpression){
                IValue<?> left = ((DecisionValueCallExpression) getLeftExpression()).getValue();
                return ((LiteralExpression) getRightExpression()).equalsForLiteralExpressions(left);
            }


            return getLeftExpression() == getRightExpression();
        }catch (InvalidTypeInLiteralExpressionCheckException e){
            throw new EvaluationException(e);
        }


    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder, String callingDecision) {

        if(getRightExpression() instanceof DecisionValueCallExpression){
            builder.add("(and");
            IDecision<?> decision = ((DecisionValueCallExpression) getRightExpression()).getDecision();
            builder.add("(= " + decision.toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")"); // checks that the decision also needs to be taken because of the encoding
            builder.add("(= ");
            getLeftExpression().toSMTStream(builder, callingDecision);
            getRightExpression().toSMTStream(builder, callingDecision);
            builder.add(")");
            builder.add(")"); // closing and
        }
        if(getLeftExpression() instanceof DecisionValueCallExpression){
            builder.add("(and");
            IDecision<?> decision = ((DecisionValueCallExpression) getLeftExpression()).getDecision();
            builder.add("(= " + decision.toStringConstforSMT() + "_TAKEN_POST" + " " + "true" + ")"); // checks that the decision also needs to be taken because of the encoding
            builder.add("(= ");
            getLeftExpression().toSMTStream(builder, callingDecision);
            getRightExpression().toSMTStream(builder, callingDecision);
            builder.add(")");
            builder.add(")"); // closing and
        }else{
            builder.add("(= ");
            getLeftExpression().toSMTStream(builder, callingDecision);
            getRightExpression().toSMTStream(builder, callingDecision);
            builder.add(")");
        }









    }
}

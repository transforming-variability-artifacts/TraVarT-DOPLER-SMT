package edu.kit.dopler.model;

import java.util.stream.Stream;

public class Equals extends BinaryExpression{


    public Equals(IExpression leftExpression, IExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public boolean evaluate() {


        if(getLeftExpression() instanceof DoubleLiteralExpression && getRightExpression() instanceof DecisionValueCallExpression){
            double left = ((DoubleLiteralExpression) getLeftExpression()).getLiteral();
            double right = (double) ((DecisionValueCallExpression) getRightExpression()).getValue().getValue();
            return left == right;
        }
        if(getLeftExpression() instanceof DecisionValueCallExpression && getRightExpression() instanceof DoubleLiteralExpression){
            double left = (double) ((DecisionValueCallExpression) getLeftExpression()).getValue().getValue();
            double right = ((DoubleLiteralExpression) getRightExpression()).getLiteral();
            return left == right;
        }


        return getLeftExpression() == getRightExpression();
    }

    @Override
    public void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(=");
        getLeftExpression().toSMTStream(builder);
        getRightExpression().toSMTStream(builder);
        builder.add(")");
    }
}

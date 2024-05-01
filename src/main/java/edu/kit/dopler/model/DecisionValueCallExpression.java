package edu.kit.dopler.model;

public class DecisionValueCallExpression extends DecisionCallExpression{


    public DecisionValueCallExpression(IDecisionType decision) {
        super(decision);
    }


    @Override
    public boolean evaluate() {
        return false;
    }
}

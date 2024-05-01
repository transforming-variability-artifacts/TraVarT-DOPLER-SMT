package edu.kit.dopler.model;

public abstract class DecisionCallExpression extends Expression{



    private IDecisionType decision;

    public DecisionCallExpression(IDecisionType decision) {
        this.decision = decision;
    }
}

package edu.kit.dopler.model;

public abstract class DecisionCallExpression extends Expression{



    private IDecision decision;

    public DecisionCallExpression(IDecision decision) {
        this.decision = decision;
    }


    public IDecision getDecision() {
        return decision;
    }
}

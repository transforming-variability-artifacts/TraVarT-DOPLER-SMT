package edu.kit.dopler.model;

public abstract class ValueRestrictionAction extends Action{

    private final IDecision decisionType;


    public ValueRestrictionAction(IDecision decisionType) {
        this.decisionType = decisionType;
    }


    public IDecision getDecisionType() {
        return decisionType;
    }
}

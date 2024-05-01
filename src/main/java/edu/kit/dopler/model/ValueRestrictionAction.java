package edu.kit.dopler.model;

public abstract class ValueRestrictionAction extends Action{

    private IDecisionType decisionType;


    public ValueRestrictionAction(IDecisionType decisionType) {
        this.decisionType = decisionType;
    }
}

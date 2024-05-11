package edu.kit.dopler.model;

public class DisAllows extends ValueRestrictionAction{

    AbstractValue disAllowValue;

    public DisAllows(IDecision decisionType, AbstractValue disAllowValue) {
        super(decisionType);
        this.disAllowValue = disAllowValue;
    }

    @Override
    public void execute() {
        Range range = getDecisionType().getRange();
        if(range.contains(disAllowValue)){
            range.remove(disAllowValue);
            getDecisionType().setRange(range);
        }
    }
}

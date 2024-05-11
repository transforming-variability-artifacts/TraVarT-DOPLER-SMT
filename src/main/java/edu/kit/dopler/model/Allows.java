package edu.kit.dopler.model;

public class Allows extends ValueRestrictionAction{


    private AbstractValue allowedValue;

    public Allows(IDecision decisionType, AbstractValue allowedValue) {
        super(decisionType);
        this.allowedValue = allowedValue;
    }

    @Override
    public void execute() {
        try {
            Range range = getDecisionType().getRange();
            range.add(allowedValue);
            getDecisionType().setRange(range);
        }catch(Exception e){

        }
    }
}

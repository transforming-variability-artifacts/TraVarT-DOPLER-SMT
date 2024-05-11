package edu.kit.dopler.model;

public class Enforce extends ValueRestrictionAction{

    private AbstractValue value;

    public Enforce(final IDecision decisionType, final AbstractValue value) {
        super(decisionType);
        this.value = value;
    }

    @Override
    public void execute() {
        try{
            getDecisionType().setValue(value);
        }catch (Exception e){

        }


    }
}

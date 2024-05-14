package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.stream.Stream;

public class Allows extends ValueRestrictionAction{


    private AbstractValue allowedValue;

    public Allows(IDecision decisionType, AbstractValue allowedValue) {
        super(decisionType);
        this.allowedValue = allowedValue;
    }

    @Override
    public void execute() throws ActionExecutionException {
        try {
            Range range = getDecisionType().getRange();
            range.add(allowedValue);
            getDecisionType().setRange(range);
        }catch(Exception e){
            throw new ActionExecutionException(e);
        }
    }

    @Override
    void toSMTStream(Stream.Builder<String> builder) {

    }
}

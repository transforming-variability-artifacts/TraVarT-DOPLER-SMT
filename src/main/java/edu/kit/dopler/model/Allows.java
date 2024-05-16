package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.stream.Stream;

public class Allows extends ValueRestrictionAction{


    private final IValue<?> allowedValue;

    public Allows(IDecision<?> decision, IValue<?> allowedValue) {
        super(decision);
        this.allowedValue = allowedValue;
    }

    @Override
    public void execute() throws ActionExecutionException {
        try {
            Range range = getDecision().getRange();
            range.add(allowedValue);
            getDecision().setRange(range);
        }catch(Exception e){
            throw new ActionExecutionException(e);
        }
    }

    @Override
    void toSMTStream(Stream.Builder<String> builder) {

    }
}

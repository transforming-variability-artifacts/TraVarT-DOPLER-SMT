package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

import java.util.stream.Stream;

public class Enforce extends ValueRestrictionAction{

    private final IValue<?> value;

    public Enforce(final IDecision decision, final IValue<?> value) {
        super(decision);
        this.value = value;
    }

    @Override
    public void execute() throws ActionExecutionException {
        try{
            switch (getDecision().getDecisionType()){
                case BOOLEAN:
                    IDecision<Boolean> booleanIDecision = (IDecision<Boolean>) getDecision();
                    IValue<Boolean> booleanIValue = (IValue<Boolean>) value;
                    booleanIDecision.setValue(booleanIValue);
                case STRING:
            }
            getDecision().setTaken(true);
        }catch (Exception e){
            throw new ActionExecutionException(e);
        }


    }

    @Override
    void toSMTStream(Stream.Builder<String> builder) {
        builder.add("(= " +  "POST_" + getDecision().toStringConstforSMT() + " " + value.toString());
    }
}

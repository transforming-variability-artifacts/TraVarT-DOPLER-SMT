package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

public class NumberEnforce extends Enforce{


    public NumberEnforce(IDecision<?> decision, IValue<?> value) {
        super(decision, value);
    }

    @Override
    public void execute() throws ActionExecutionException {
        try{
            NumberDecision numberDecision = (NumberDecision) getDecision();
            DoubleValue doubleValue = (DoubleValue) getValue();
            numberDecision.setValue(doubleValue);
            getDecision().setTaken(true);
        }catch (Exception e){
            throw new ActionExecutionException(e);
        }


    }


}

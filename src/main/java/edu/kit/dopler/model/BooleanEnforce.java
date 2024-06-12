/**
 * Because the Enforce Action is possible with every decision type and the decision are generic
 * we needed to add an abstract enforce class to then specialise them into the different decision type enforces
 *
 */


package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

public class BooleanEnforce extends Enforce{


    public BooleanEnforce(BooleanDecision decision, IValue<Boolean> value) {
        super(decision, value);
    }


    @Override
    public void execute() throws ActionExecutionException {
        try{
            BooleanDecision booleanIDecision = (BooleanDecision) getDecision();
            BooleanValue booleanIValue = (BooleanValue) getValue();
            booleanIDecision.setValue(booleanIValue);
            getDecision().setTaken(true);
        }catch (Exception e){
            throw new ActionExecutionException(e);
        }


    }


}

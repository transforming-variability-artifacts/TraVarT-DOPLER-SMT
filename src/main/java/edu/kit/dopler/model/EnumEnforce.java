package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

public class EnumEnforce extends Enforce{


    public EnumEnforce(IDecision<?> decision, IValue<?> value) {
        super(decision, value);
    }

    @Override
    public void execute() throws ActionExecutionException {
        try{
            EnumerationDecision enumerationDecision = (EnumerationDecision) getDecision();
            StringValue enumerationValue = (StringValue) getValue();
            enumerationDecision.setValue(enumerationValue);
            getDecision().setTaken(true);
        }catch (Exception e){
            throw new ActionExecutionException(e);
        }


    }

}

/**
 * Because the Enforce Action is possible with every decision type and the decision are generic
 * we needed to add an abstract enforce class to then specialise them into the different decision type enforces
 *
 */

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

/**
 * Because the Enforce Action is possible with every decision type and the decision are generic
 * we needed to add an abstract enforce class to then specialise them into the different decision type enforces
 *
 */

package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.ActionExecutionException;

public class NumberEnforce extends Enforce {

	public NumberEnforce(IDecision<?> decision, IValue<?> value) {
		super(decision, value);
	}

	@Override
	public void execute() throws ActionExecutionException {
		try {
			NumberDecision numberDecision = (NumberDecision) getDecision();
			DoubleValue doubleValue = (DoubleValue) getValue();
			numberDecision.setValue(doubleValue);
			getDecision().setTaken(true);
		} catch (Exception e) {
			throw new ActionExecutionException(e);
		}

	}

}

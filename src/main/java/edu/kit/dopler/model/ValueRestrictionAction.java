package edu.kit.dopler.model;

public abstract class ValueRestrictionAction extends Action {

	private final IDecision<?> decision;

	public ValueRestrictionAction(IDecision<?> decision) {
		this.decision = decision;
	}

	public IDecision<?> getDecision() {
		return decision;
	}

}

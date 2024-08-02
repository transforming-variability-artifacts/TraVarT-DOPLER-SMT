package edu.kit.dopler.common;

import java.util.Set;
import java.util.stream.Collectors;

import edu.kit.dopler.model.*;
import edu.kit.dopler.model.Decision.DecisionType;

public final class DoplerUtils {

	private DoplerUtils() {

	}

	public static EnumerationLiteral getEnumerationliteral(final Dopler dm, final IValue enumString){
		for(Object o : dm.getEnumSet()){
			Enumeration enumeration = (Enumeration) o;
			for(EnumerationLiteral enumerationLiteral: enumeration.getEnumerationLiterals()){

				if(enumerationLiteral.getValue().equals(enumString.getValue())){
					return enumerationLiteral;
				}
			}
		}
		return null;
	}

	public static IDecision getDecision(final Dopler dm, final String displayId) {
		for (Object o : dm.getDecisions()) {
			IDecision decision = (IDecision) o;
			if (decision.getDisplayId().equals(displayId)) {
				return decision;
			}
		}
		return null;
	}
	
	public static Set<? super IDecision<?>> getBooleanDecisions(final Dopler dm) {
		return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.BOOLEAN)).collect(Collectors.toSet());
	}
	

	public static Set<? super IDecision<?>> getEnumerationDecisions(final Dopler dm) {
		return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.ENUM)).collect(Collectors.toSet());
	}
	
	public static Set<? super IDecision<?>> getNumberDecisions(final Dopler dm) {
		return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.NUMBER)).collect(Collectors.toSet());
	}
	

	public static Set<? super IDecision<?>> getStringDecisions(final Dopler dm) {
		return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.STRING)).collect(Collectors.toSet());
	}
}

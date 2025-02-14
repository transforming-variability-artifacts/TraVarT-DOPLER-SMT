/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 *
 * Contributors: 
 * 	@author Fabian Eger
 * 	@author Kevin Feichtinger
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.common;

import java.util.Set;
import java.util.stream.Collectors;

import edu.kit.dopler.model.Decision;
import edu.kit.dopler.model.Decision.DecisionType;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.Enumeration;
import edu.kit.dopler.model.EnumerationLiteral;
import edu.kit.dopler.model.IDecision;
import edu.kit.dopler.model.IValue;

public final class DoplerUtils {

	private DoplerUtils() { }

	@SuppressWarnings("rawtypes")
	public static EnumerationLiteral getEnumerationliteral(final Dopler dm, final IValue enumString) {
		for (final Object o : dm.getEnumSet()) {
			final Enumeration enumeration = (Enumeration) o;
			for (final EnumerationLiteral enumerationLiteral : enumeration.getEnumerationLiterals()) {
				if (enumerationLiteral.getValue().equals(enumString.getValue())) {
					return enumerationLiteral;
				}
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	public static IDecision getDecision(final Dopler dm, final String displayId) {
		for (final Object o : dm.getDecisions()) {
			final IDecision decision = (IDecision) o;
			if (decision.getDisplayId().equals(displayId)) {
				return decision;
			}
		}
		return null;
	}

	public static Set<IDecision> getBooleanDecisions(final Dopler dm) {
		return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.BOOLEAN))
				.collect(Collectors.toSet());
	}

	public static Set<IDecision> getEnumerationDecisions(final Dopler dm) {
		return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.ENUM))
				.collect(Collectors.toSet());
	}

	public static Set<IDecision> getNumberDecisions(final Dopler dm) {
		return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.NUMBER))
				.collect(Collectors.toSet());
	}

	public static Set<IDecision> getStringDecisions(final Dopler dm) {
		return dm.getDecisions().stream().filter(d -> ((Decision<?>) d).getDecisionType().equals(DecisionType.STRING))
				.collect(Collectors.toSet());
	}
}

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
 *  @author David Kowal
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.model;

import edu.kit.dopler.exceptions.InvalidCardinalityException;
import edu.kit.dopler.exceptions.ValidityConditionException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class EnumerationDecision extends Decision<String> {

	private Enumeration enumeration;
	private int minCardinality;
	private int maxCardinality;
	private final AbstractValue<String> value;
	private final Set<EnumerationLiteral> disAllowed;

	public EnumerationDecision(String displayId, String question, String description, IExpression visibilityCondition,
			Set<Rule> rules, Enumeration enumeration, int minCardinality, int maxCardinality) {
		super(displayId, question, description, visibilityCondition, rules, DecisionType.ENUM);
		this.enumeration = enumeration;
		this.minCardinality = minCardinality;
		this.maxCardinality = maxCardinality;
		value = new StringValue("null");
		disAllowed = new HashSet<>();
	}

	@Override
	public String getStandardValue() {
		return "null";
	}

	@Override
	public IValue<String> getValue() {
		return value;
	}

	@Override
	public void setValue(IValue<String> value) throws ValidityConditionException {
		String v = Objects.requireNonNull(value.getValue());
		if (inRange(v) && allowed(v)) {
			this.value.setValue(v);
			setTaken(true);
		} else {
			throw new ValidityConditionException("Value: " + v + " not in Range");
		}
	}

	@Override
	public void setDefaultValueInSMT(Stream.Builder<String> builder) {
		builder.add("(and");
		for (EnumerationLiteral enumerationLiteral : enumeration.getEnumerationLiterals()) {
			builder.add("(= " + toStringConstforSMT() + "_" + toStringConstforSMT() + "_"
					+ enumerationLiteral.getValue() + "_POST" + " " + "false" + ")");
		}
		builder.add(")");
	}
	
	public void setEnumeration(Enumeration enumeration) {
		this.enumeration = enumeration;
	}
	
	public void setCardinality(int minCardinality, int maxCardinality) throws InvalidCardinalityException {
		if(minCardinality < 0 ) {
			throw new InvalidCardinalityException("min cardinality is negative" + minCardinality);
		} else if ( minCardinality > maxCardinality) {
			throw new InvalidCardinalityException("min cardinality: " + minCardinality + "is bigger than max cardinality: " + maxCardinality);
		} else {
			this.minCardinality = minCardinality;
			this.maxCardinality = maxCardinality;
		}
	}

	private boolean inRange(String value) {
		return enumeration.enumerationLiterals.stream()
				.anyMatch(enumerationLiteral -> enumerationLiteral.getValue().equals(value));
	}

	private boolean allowed(String value) {
		return disAllowed.stream().noneMatch(enumerationLiteral -> enumerationLiteral.getValue().equals(value));
	}

	public void addDissallowed(EnumerationLiteral literal) {
		disAllowed.add(literal);
	}

	public void removeDissallowed(EnumerationLiteral literal) {
		disAllowed.remove(literal);
	}

	public Enumeration getEnumeration() {
		return enumeration;
	}

	public int getMaxCardinality() {
		return maxCardinality;
	}

	public int getMinCardinality() {
		return minCardinality;
	}
}

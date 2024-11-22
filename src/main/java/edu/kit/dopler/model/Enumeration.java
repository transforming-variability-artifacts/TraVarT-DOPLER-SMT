/*******************************************************************************
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
 * All rights reserved
 *******************************************************************************/
package edu.kit.dopler.model;

import java.util.HashSet;
import java.util.Set;

public class Enumeration {

	Set<EnumerationLiteral> enumerationLiterals = new HashSet<>();

	public Enumeration(Set<EnumerationLiteral> enumerationLiterals) {
		this.enumerationLiterals = enumerationLiterals;
	}

	public void addEnumLiteral(EnumerationLiteral enumLiteral) {
		enumerationLiterals.add(enumLiteral);
	}

	public Set<EnumerationLiteral> getEnumerationLiterals() {
		return enumerationLiterals;
	}
}

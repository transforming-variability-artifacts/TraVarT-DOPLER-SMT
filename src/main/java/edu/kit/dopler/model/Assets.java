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

import java.util.Collections;
import java.util.Set;

public class Assets {

	public Assets(String description, IExpression inclusionCondition) {
		this.description = description;
		this.inclusionCondition = inclusionCondition;
	}

	private String description;
	private IExpression inclusionCondition;
	private Set<Assets> assets = Collections.emptySet();

	void setDescription(String description) {
		this.description = description;
	}

	String getDescription() {
		return description;
	}

	public void setInclusionCondition(IExpression inclusionCondition) {
		this.inclusionCondition = inclusionCondition;
	}

	IExpression getInclusionCondition() {
		return inclusionCondition;
	}

	public Set<Assets> getAssets() {
		return assets;
	}

	public void setAssets(Set<Assets> assets) {
		this.assets = assets;
	}

}

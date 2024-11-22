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

import java.util.Objects;

public abstract class BinaryExpression extends Expression {

	private IExpression leftExpression;
	private IExpression rightExpression;

	public BinaryExpression(IExpression leftExpression, IExpression rightExpression) {
		this.leftExpression = Objects.requireNonNull(leftExpression);
		this.rightExpression = Objects.requireNonNull(rightExpression);
	}

	public IExpression getLeftExpression() {
		return leftExpression;
	}

	public void setLeftExpression(IExpression leftExpression) {
		this.leftExpression = leftExpression;
	}

	public IExpression getRightExpression() {
		return rightExpression;
	}

	public void setRightExpression(IExpression rightExpression) {
		this.rightExpression = rightExpression;
	}
}

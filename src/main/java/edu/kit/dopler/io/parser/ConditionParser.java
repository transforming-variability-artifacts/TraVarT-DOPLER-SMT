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
package edu.kit.dopler.io.parser;

import java.util.Arrays;
import java.util.Objects;

import edu.kit.dopler.common.DoplerUtils;
import edu.kit.dopler.exceptions.ParserException;
import edu.kit.dopler.model.AND;
import edu.kit.dopler.model.BooleanLiteralExpression;
import edu.kit.dopler.model.DecisionValueCallExpression;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.DoubleLiteralExpression;
import edu.kit.dopler.model.Enforce;
import edu.kit.dopler.model.EnumerationLiteral;
import edu.kit.dopler.model.EnumeratorLiteralExpression;
import edu.kit.dopler.model.Equals;
import edu.kit.dopler.model.GreatherThan;
import edu.kit.dopler.model.IDecision;
import edu.kit.dopler.model.IExpression;
import edu.kit.dopler.model.IsTaken;
import edu.kit.dopler.model.LessThan;
import edu.kit.dopler.model.LiteralExpression;
import edu.kit.dopler.model.NOT;
import edu.kit.dopler.model.OR;
import edu.kit.dopler.model.StringLiteralExpression;
import edu.kit.dopler.model.StringValue;

@SuppressWarnings("rawtypes")
public class ConditionParser {

	private static final String CONDITION_REGEX = "(?<=\\.)|(?=\\.)|((?<=\\=)|(?=\\=)|(?<=\\<)|(?=\\<)|(?<=\\>)|(?=\\>))|((?<=\\|\\|)|(?=\\|\\|))|((?<=&&)|(?=&&))|((?<=!)|(?=!))|((?<=\\()|(?=\\())|((?<=\\))|(?=\\)))";

	private static final String EOF = "EOF";

	private static final String NOT = "!";
	private static final String OR = "||";
	private static final String AND = "&&";
	private static final String GREATER = ">";
	private static final String LESS = "<";
	private static final String EQUAL = "=";
	private static final String OPENING_PARENTHESE = "(";
	private static final String CLOSING_PARENTHESE = ")";
	private static final String CLOSING_CURRLY_PARENTHESE = "}";
	private static final String DECISION_VALUE_DELIMITER = ".";
	private static final String GET_VALUE_Function = "getValue";

	private static final String TRUE = "true";
	private static final String FALSE = "false";

	private String[] input;
	private int index = 0;
	private String symbol;

	private boolean isTaken = false;
	private final boolean isSelected = false;
	private boolean isEquals = false;

	private final Dopler dm;

	public ConditionParser(final Dopler dm) {
		this.dm = Objects.requireNonNull(dm);
	}

	public IExpression parse(final String str) throws ParserException {
		Objects.requireNonNull(str);
		isTaken = false;
		index = 0;
		isEquals = false;
		input = Arrays.stream(str.split(CONDITION_REGEX)).map(String::trim).filter(s -> !s.isEmpty() && !s.isBlank())
				.toArray(String[]::new);
		//System.out.println(Arrays.toString(input));
		if (input.length > 0) {
			return parseCondition();
		}
		return new BooleanLiteralExpression(true);
	}

	private IExpression parseCondition() throws ParserException {
		IExpression v = term();
		while (symbol.equals(OR)) {

			final IExpression r = term();
			v = new OR(v, r);
		}

		return v;
	}

	private IExpression term() throws ParserException {
		IExpression v = comperator();
		while (symbol.equals(AND)) {
			final IExpression r = comperator();
			v = new AND(v, r);
		}
		return v;
	}

	private IExpression comperator() throws ParserException {
		IExpression v = factor();

		while (symbol.equals(EQUAL) || symbol.equals(GREATER) || symbol.equals(LESS)) {
			final String first = symbol;
			nextSymbol();
			final String second = symbol;
			if (first.equals(EQUAL) && second.equals(EQUAL)) {
				final IExpression r =  getValueLiteral(v);
				v = new Equals(v, r);
			} else if (first.equals(GREATER) && second.equals(EQUAL)) {
				final IExpression r =  getValueLiteral(v);
				v = new AND(new GreatherThan(v, r), new Equals(v, r));
			} else if (first.equals(LESS) && second.equals(EQUAL)) {
				nextSymbol();
				final IExpression r =  getValueLiteral(v);
				v = new AND(new LessThan(v, r), new Equals(v, r));
			} else if (first.equals(GREATER)) {
				// second is operand
				IExpression value = null;
				if (RulesParser.isDoubleRangeValue(symbol)) {
					value = new DoubleLiteralExpression(Double.parseDouble(symbol));
				} else if (RulesParser.isStringRangeValue(dm, symbol)) {
					value = new StringLiteralExpression(symbol);
				} else {
					throw new ParserException(
							"The value of comparison \"" + v + " > " + symbol + "\" could not be parsed.");
				}
				v = new GreatherThan(v, value);
			} else if (first.equals(LESS)) {
				// second is operand
				IExpression value = null;
				if (RulesParser.isDoubleRangeValue(symbol)) {
					value = new DoubleLiteralExpression(Double.parseDouble(symbol));
				} else if (RulesParser.isStringRangeValue(dm, symbol)) {
					value = new StringLiteralExpression(symbol);
				} else {
					throw new ParserException(
							"The value of comparison \"" + v + " < " + symbol + "\" could not be parsed.");
				}
				v = new LessThan(v, value);
			}
		}
		return v;
	}

	private IExpression getValueLiteral(IExpression v) throws ParserException {
		if (symbol.equalsIgnoreCase(TRUE)) {
			v = new BooleanLiteralExpression(true);
		} else if (symbol.equalsIgnoreCase(FALSE)) {
			v = new BooleanLiteralExpression(false);
		} else {
			if (RulesParser.isDoubleRangeValue(symbol)) {
				v = new DoubleLiteralExpression(Double.parseDouble(symbol));
			} else if (RulesParser.isStringRangeValue(dm, symbol)) {
				v = new StringLiteralExpression(symbol);
			} else {
				throw new ParserException("Unkown value type!");
			}
			nextSymbol();
		}
		return v;
	}

	private IExpression factor() throws ParserException {
		nextSymbol();
		IExpression v = null;

		if (symbol.equals(CLOSING_CURRLY_PARENTHESE)) {
			nextSymbol();
		}
		if (symbol.equals(EOF)) {
			v = new BooleanLiteralExpression(true);
		} else if (symbol.equals(NOT)) {
			final IExpression f = factor();
			v = new NOT(f);
		} else if (symbol.equals(OPENING_PARENTHESE)) {
			v = parseCondition();
			nextSymbol(); // we don't care about )
		} else if (symbol.equals(IsTaken.FUNCTION_NAME)) {
			nextSymbol();
			isTaken = true;
			if (symbol.equals(OPENING_PARENTHESE)) {
				v = parseCondition();
			}
		} else if (symbol.equals(CLOSING_PARENTHESE)) {
			//		} else if (symbol.equals(IsSelectedFunction.FUNCTION_NAME)) {
			//			nextSymbol();
			//			isSelected = true;
			//			if (symbol.equals(OPENING_PARENTHESE)) {
			//				v = parseCondition();
			//				nextSymbol(); // we don't care about )
			//			}
			//		} else if (symbol.equals(GET_VALUE_Function)) {
			//			nextSymbol();
			//			if (symbol.equals(OPENING_PARENTHESE)) {
			//				nextSymbol();
			//				IDecision d = DoplerUtils.getDecision(dm, symbol);
			//				v = new DecisionValueCallExpression(d);
			//
			//				}
		} else if (symbol.equals(Enforce.FUNCTION_NAME)) {
			throw new ParserException("We need to deal with the different types of enforces here");
		} else if (symbol.equalsIgnoreCase(TRUE)) {
			v = new BooleanLiteralExpression(true);
		} else if (symbol.equalsIgnoreCase(FALSE)) {
			v = new BooleanLiteralExpression(false);
		} else if (RulesParser.isDoubleRangeValue(symbol)) {
			v = new DoubleLiteralExpression(Double.parseDouble(symbol));
			nextSymbol();
		} else if (RulesParser.isStringRangeValue(dm, symbol)) {
			v = new EnumeratorLiteralExpression(DoplerUtils.getEnumerationliteral(dm,new StringValue(symbol)));
			nextSymbol();
		} else { // decision
			final IDecision d = DoplerUtils.getDecision(dm, symbol);
			nextSymbol();
			if (symbol.equals(DECISION_VALUE_DELIMITER)) {
				nextSymbol();
				if (isEquals){
					v = new EnumeratorLiteralExpression(DoplerUtils.getEnumerationliteral(dm,new StringValue(symbol)));
				}else {
					v = new Equals(new DecisionValueCallExpression(d),new EnumeratorLiteralExpression(DoplerUtils.getEnumerationliteral(dm,new StringValue(symbol))));

				}
			} else if (symbol.equals(EOF)) {
				v = new Equals(new DecisionValueCallExpression(d),new BooleanLiteralExpression(true));
			} else if (isTaken) {
				v = new IsTaken(d);
				isTaken = false;
				nextSymbol();
				//			} else if (isSelected || symbol.equals(CLOSING_PARENTHESE)) {
				//				v = new IsSelected(d);
				//			} else if (d != null) {
				//				v = new IsSelectedFunction(d);
			} else if (symbol.equals(EQUAL)) {
				nextSymbol();
				if (symbol.equals(EQUAL)) {
					isEquals = true;
					v = new Equals(new DecisionValueCallExpression(d), factor());
				}
			} else if (symbol.equals(CLOSING_PARENTHESE)) {
				v = new Equals(new DecisionValueCallExpression(d),new BooleanLiteralExpression(true));
			} else if (symbol.equals(OR)) {
				v = new OR(new DecisionValueCallExpression(d),parseCondition());
			} else if (symbol.equals(LESS)) {
				v = new LessThan(new DecisionValueCallExpression(d), factor());
			} else if (symbol.equals(GREATER)) {
				v = new GreatherThan(new DecisionValueCallExpression(d), factor());
			} else {
				throw new ParserException("unknown function/decision for symbol " + symbol);
			}
		}
		return v;
	}

	private static LiteralExpression getLiteralExpression(final IDecision d, final String symbol) {
		LiteralExpression literalExpression;
		switch (d.getDecisionType().toString()) {
		case "Boolean":
			final boolean Boolliteral = Boolean.parseBoolean(symbol);
			literalExpression = new BooleanLiteralExpression(Boolliteral);
			break;
		case "Double":
			final double doubleLiteral = Double.parseDouble(symbol);
			literalExpression = new DoubleLiteralExpression(doubleLiteral);
			break;
		case "Enumeration":
			final EnumerationLiteral literal = new EnumerationLiteral(symbol);
			literalExpression = new EnumeratorLiteralExpression(literal);
			// TODO get the real Enumeration Literal instead of creating it here
			break;
		case "String":
			final String stringliteral = symbol;
			literalExpression = new StringLiteralExpression(stringliteral);
			break;
		default:
			literalExpression = new BooleanLiteralExpression(true);
		}
		return literalExpression;
	}

	private void nextSymbol() {
		if (index == input.length) {
			symbol = EOF;
		} else {
			symbol = input[index++];
		}
	}
}

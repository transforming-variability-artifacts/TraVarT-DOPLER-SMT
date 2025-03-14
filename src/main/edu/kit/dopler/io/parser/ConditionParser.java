/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 * <p>
 * Contributors:
 *    @author Fabian Eger
 *    @author Kevin Feichtinger
 * <p>
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.io.parser;

import edu.kit.dopler.common.DoplerUtils;
import edu.kit.dopler.exceptions.ParserException;
import edu.kit.dopler.model.*;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

public class ConditionParser {

	private static final Pattern PATTERN = Pattern.compile(
			"(?<=\\.)|(?=\\.)|((?<=\\=)|(?=\\=)|(?<=\\<)|(?=\\<)|(?<=\\>)|(?=\\>))|((?<=\\|\\|)|(?=\\|\\|))|((?<=&&)|" +
					"(?=&&))|((?<=!)|(?=!))|((?<=\\()|(?=\\())|((?<=\\))|(?=\\)))");

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
	private static final String TRUE = "true";
	private static final String FALSE = "false";

	private final Dopler dm;

	private String[] input;
	private int index;
	private String symbol;
	private boolean isTaken;
	private boolean isEquals;

	public ConditionParser(Dopler dm) {
		this.dm = Objects.requireNonNull(dm);
		input = null;
		index = 0;
		symbol = null;
		isTaken = false;
		isEquals = false;
	}

	public IExpression parse(String str) throws ParserException {
		Objects.requireNonNull(str);
		isTaken = false;
		index = 0;
		isEquals = false;
		input = Arrays.stream(PATTERN.split(str)).map(String::trim).filter(s -> !s.isEmpty() && !s.isBlank())
				.toArray(String[]::new);

		return parseOr();
	}

	private IExpression parseOr() throws ParserException {
		IExpression v = parseAnd();

		if (symbol.equals(OR)) {
			v = new OR(v, parseOr());
		}

		return v;
	}

	private IExpression parseAnd() throws ParserException {
		IExpression v = parseComparator();

		if (symbol.equals(AND)) {
			v = new AND(v, parseAnd());
		}

		return v;
	}

	private IExpression parseComparator() throws ParserException {
		IExpression v = parseUnit();

		while (symbol.equals(EQUAL) || symbol.equals(GREATER) || symbol.equals(LESS)) {
			String first = symbol;
			nextSymbol();
			String second = symbol;
			if (first.equals(EQUAL) && second.equals(EQUAL)) {
				IExpression r = getValueLiteral();
				v = new Equals(v, r);
			} else if (first.equals(GREATER) && second.equals(EQUAL)) {
				IExpression r = getValueLiteral();
				v = new AND(new GreatherThan(v, r), new Equals(v, r));
			} else if (first.equals(LESS) && second.equals(EQUAL)) {
				nextSymbol();
				IExpression r = getValueLiteral();
				v = new AND(new LessThan(v, r), new Equals(v, r));
			} else if (first.equals(GREATER)) {
				// second is operand
				IExpression value;
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
				IExpression value;
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

	private IExpression parseUnit() throws ParserException {
		nextSymbol();
		IExpression v = null;

		if (symbol.equals(CLOSING_CURRLY_PARENTHESE)) {
			nextSymbol();
		}

		if (symbol.equals(EOF)) {
			v = new BooleanLiteralExpression(true);
		} else if (symbol.equals(NOT)) {
			v = new NOT(parseUnit());
		} else if (symbol.equals(OPENING_PARENTHESE)) {
			v = parseOr();
			nextSymbol(); // we don't care about )
		} else if (symbol.equals(IsTaken.FUNCTION_NAME)) {
			nextSymbol();
			isTaken = true;
			if (symbol.equals(OPENING_PARENTHESE)) {
				v = parseOr();
			}
		} else if (symbol.equals(CLOSING_PARENTHESE)) {
			//Should not happen
			throw new ParserException("Closing parentheses not expected");
		} else if (symbol.equals(Enforce.FUNCTION_NAME)) {
			throw new ParserException("We need to deal with the different types of enforces here");
		} else if (symbol.toLowerCase(Locale.ROOT).equals(TRUE)) {
			v = new BooleanLiteralExpression(true);
		} else if (symbol.toLowerCase(Locale.ROOT).equals(FALSE)) {
			v = new BooleanLiteralExpression(false);
		} else if (RulesParser.isDoubleRangeValue(symbol)) {
			v = new DoubleLiteralExpression(Double.parseDouble(symbol));
			nextSymbol();
		} else if (RulesParser.isStringRangeValue(dm, symbol)) {
			v = new EnumeratorLiteralExpression(DoplerUtils.getEnumerationliteral(dm, new StringValue(symbol)));
			nextSymbol();
		} else if ("getValue".equals(symbol)) {
			//covers 'getValue(decision) = enumValue'
			nextSymbol();
			nextSymbol();
			IDecision<?> decision = DoplerUtils.getDecision(dm, symbol);
			nextSymbol();
			nextSymbol();

			if (symbol.equals(EQUAL)) {
				nextSymbol();
				if (TRUE.equals(symbol)) {
					v = new Equals(new DecisionValueCallExpression(decision), new BooleanLiteralExpression(true));
					nextSymbol();
				} else {
					v = new Equals(new DecisionValueCallExpression(decision), new EnumeratorLiteralExpression(
							DoplerUtils.getEnumerationliteral(dm, new StringValue(symbol))));
					nextSymbol();
				}
			}
		} else {
			IDecision<?> decision = DoplerUtils.getDecision(dm, symbol);
			nextSymbol();
			//covers 'decision.enumValue'
			if (symbol.equals(DECISION_VALUE_DELIMITER)) {
				nextSymbol();
				if (isEquals) {
					v = new EnumeratorLiteralExpression(DoplerUtils.getEnumerationliteral(dm, new StringValue(symbol)));
					nextSymbol();
				} else {
					v = new Equals(new DecisionValueCallExpression(decision), new EnumeratorLiteralExpression(
							DoplerUtils.getEnumerationliteral(dm, new StringValue(symbol))));
					nextSymbol();
				}
			} else if (symbol.equals(EOF)) {
				v = new Equals(new DecisionValueCallExpression(decision), new BooleanLiteralExpression(true));
			} else if (isTaken) {
				v = new IsTaken(decision);
				isTaken = false;
				nextSymbol();
			} else if (symbol.equals(EQUAL)) {
				nextSymbol();
				if (symbol.equals(EQUAL)) {
					isEquals = true;
					v = new Equals(new DecisionValueCallExpression(decision), parseUnit());
				}
			} else if (symbol.equals(LESS)) {
				v = new LessThan(new DecisionValueCallExpression(decision), parseUnit());
			} else if (symbol.equals(GREATER)) {
				v = new GreatherThan(new DecisionValueCallExpression(decision), parseUnit());
			} else {
				v = new Equals(new DecisionValueCallExpression(decision), new BooleanLiteralExpression(true));
			}
		}

		return v;
	}

	private IExpression getValueLiteral() throws ParserException {
		IExpression v;
		if (symbol.toLowerCase(Locale.ROOT).equals(TRUE)) {
			v = new BooleanLiteralExpression(true);
		} else if (symbol.toLowerCase(Locale.ROOT).equals(FALSE)) {
			v = new BooleanLiteralExpression(false);
		} else if (RulesParser.isDoubleRangeValue(symbol)) {
			v = new DoubleLiteralExpression(Double.parseDouble(symbol));
			nextSymbol();
		} else if (RulesParser.isStringRangeValue(dm, symbol)) {
			v = new StringLiteralExpression(symbol);
			nextSymbol();
		} else {
			throw new ParserException("Unkown value type!");
		}
		return v;
	}

	private void nextSymbol() {
		if (index == input.length) {
			symbol = EOF;
		} else {
			symbol = input[index];
			index = index + 1;
		}
	}
}
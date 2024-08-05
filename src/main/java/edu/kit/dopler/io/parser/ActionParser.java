/*******************************************************************************
 * TODO: explanation what the class does
 *  
 *  @author Kevin Feichtinger
 *  
 * Copyright 2023 Johannes Kepler University Linz
 * LIT Cyber-Physical Systems Lab
 * All rights reserved
 *******************************************************************************/
package edu.kit.dopler.io.parser;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import edu.kit.dopler.common.DoplerUtils;
import edu.kit.dopler.exceptions.InvalidActionException;
import edu.kit.dopler.exceptions.ParserException;
import edu.kit.dopler.model.*;

public class ActionParser {

	private static final int NECESSARY_ELEMENTS_FOR_ACTION = 2;

	private static final String REGEX = "(?<=\\.)|(?=\\.)|(?<=\\=)|(?=\\=)|((?<=\\()|(?=\\())|((?<=\\))|(?=\\)))";

	private static final String EOF = "EOF";

	private static final String ASSIGN = "=";
	private static final String DECISION_VALUE_DELIMITER = ".";
	private static final String OPEN_PARENTHESE = "(";
	private static final String CLOSING_PARENTHESE = ")";

	private static final String TRUE = "true";
	private static final String FALSE = "false";

	private String[] input;
	private int index = 0;
	private String symbol;

	private final Dopler dm;
	private final Queue<Object> actionElements = new LinkedList<>();

	public ActionParser(final Dopler decisions) {
		dm = Objects.requireNonNull(decisions);
	}

	public IAction parse(final String str) throws ParserException {
		Objects.requireNonNull(str);
		index = 0;
		input = Arrays.stream(str.split(REGEX)).map(String::trim).filter(s -> !s.isEmpty() && !s.isBlank())
				.toArray(String[]::new);
		//System.out.println(Arrays.toString(input));
		if (input.length > 0) {
			return parseAction();
		}
		throw new ParserException("No action found in String " + str);
	}

	private IAction parseAction() throws InvalidActionException {
		IAction action = null;
		boolean isAssign = false;
		boolean isAllowFunction = false;
		boolean isDisAllowFunction = false;
		nextSymbol();
		while (!symbol.equals(EOF)) {
			if (symbol.equals(OPEN_PARENTHESE) || symbol.equals(CLOSING_PARENTHESE)
					|| symbol.equals(DECISION_VALUE_DELIMITER)) {
				nextSymbol();
				continue;
			}
			if (symbol.equals(TRUE)) {
				actionElements.add(new BooleanValue(true));
			} else if (symbol.equals(FALSE)) {
				actionElements.add(new BooleanValue(false));
			} else if (symbol.equals(ASSIGN)) {
				isAssign = true;
				Object left = actionElements.remove();
				if (left instanceof StringValue) {
					IDecision d = DoplerUtils.getDecision(dm, ((StringValue) left).getValue());
					actionElements.add(d);
				} else {
					actionElements.add(left);
				}

			} else if (symbol.equals(Allows.FUNCTION_NAME)) {
				isAllowFunction = true;
			} else if (symbol.equals(DisAllows.FUNCTION_NAME)) {
				isDisAllowFunction = true;
			} else if (symbol.equals("enforce")) {
				isAssign = true;
			} else if (RulesParser.isDoubleRangeValue(symbol)) {
				actionElements.add(new DoubleValue(Double.parseDouble(symbol)));
			} else if (RulesParser.isStringRangeValue(dm, symbol)) {
				actionElements.add(new StringValue(symbol));
			} else { // decision
				IDecision d = DoplerUtils.getDecision(dm, symbol);
				actionElements.add(d);
			}
			if (actionElements.size() == NECESSARY_ELEMENTS_FOR_ACTION) {

				if (isAssign) {
					Object left = actionElements.remove();
					Object right = actionElements.remove();
					if (!(left instanceof IDecision)) {
						throw new InvalidActionException("Lefthand operand is not a valid decision.");
					}
                    action = switch (((IDecision<?>) left).getDecisionType().toString()) {
                        case "Boolean" -> new BooleanEnforce((BooleanDecision) left, (IValue<Boolean>) right);
                        case "Double" -> new NumberEnforce((IDecision<?>) left, (IValue<?>) right);
                        case "Enumeration" -> new EnumEnforce((IDecision<?>) left, (IValue<?>) new StringValue(DoplerUtils.getEnumerationliteral(dm, (IValue) right).getValue()));
                        case "String" -> new StringEnforce((IDecision<?>) left, (IValue<?>) right);
                        default -> action;
                    };

				} else if (isAllowFunction) {
					Object left = actionElements.remove();
					Object right = actionElements.remove();

					if (left instanceof IDecision && right instanceof AbstractValue) {
						action = new Allows((IDecision) left, (AbstractValue) right);
					}
				} else if (isDisAllowFunction) {
					Object left = actionElements.remove();
					Object right = actionElements.remove();
					if (left instanceof IDecision && right instanceof AbstractValue) {
						action = new DisAllows((IDecision) left, (AbstractValue) right);
					}
				}
			}
			nextSymbol();
		}
		return action;
	}

	private void nextSymbol() {
		if (index == input.length) {
			symbol = EOF;
		} else {
			symbol = input[index++];
		}
	}
}
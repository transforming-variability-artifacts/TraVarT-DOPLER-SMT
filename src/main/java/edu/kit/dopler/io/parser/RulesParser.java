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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import edu.kit.dopler.common.DoplerUtils;
import edu.kit.dopler.exceptions.NoActionInRuleException;
import edu.kit.dopler.exceptions.ParserException;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.EnumerationDecision;
import edu.kit.dopler.model.EnumerationLiteral;
import edu.kit.dopler.model.IAction;
import edu.kit.dopler.model.IDecision;
import edu.kit.dopler.model.IExpression;
import edu.kit.dopler.model.Rule;

public class RulesParser {

	private static final String NO_ACTION_IN_RULE = "A rule must have at least one action to perform!";

	private final Dopler dm;

	public RulesParser(final Dopler decisions) {
		this.dm = Objects.requireNonNull(decisions);
	}

	public static boolean isDoubleRangeValue(final String symbol) {
		try {
			Double.parseDouble(symbol);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static boolean isStringRangeValue(final Dopler dm, final String symbol) {
		for (Object obj : DoplerUtils.getEnumerationDecisions(dm)) {
			EnumerationDecision enumDecision = (EnumerationDecision) obj;
			// add the value for a enum decision
			for (EnumerationLiteral literal : enumDecision.getEnumeration().getEnumerationLiterals()) {
				if (literal.getValue().equals(symbol)) {
					return true;
				}
			}
		}
		return false;
	}

	public Set<Rule> parse(final IDecision decision, final String[] csvRuleSplit) throws ParserException {
		Objects.requireNonNull(decision);
		Objects.requireNonNull(csvRuleSplit);
		Set<Rule> rules = new HashSet<>();
		assert csvRuleSplit != null && csvRuleSplit.length > 0;
		for (String csvRule : csvRuleSplit) {
			// Split to condition and actions
			String[] ruleParts = Arrays.stream(csvRule.split("\\{")).map(String::trim)
					.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
			if (ruleParts.length < 2) {
				throw new NoActionInRuleException(NO_ACTION_IN_RULE);
			}
			// get condition from first part
			ConditionParser conditionParser = new ConditionParser(dm);
			IExpression condition = conditionParser.parse(ruleParts[0]);
			// derive actions from the second part
			String[] csvActions = Arrays.stream(ruleParts[1].split(";|}")).map(String::trim)
					.filter(s -> !s.isEmpty() && !s.isBlank()).toArray(String[]::new);
			Set<IAction> actions = new HashSet<>();
			for (String csvAction : csvActions) {
				ActionParser actionParser = new ActionParser(dm);
				IAction action = actionParser.parse(csvAction);
				actions.add(action);
			}
			Rule rule = new Rule(condition, actions);
			rules.add(rule);
		}
		return rules;
	}
}

package edu.kit.dopler.io.antlr;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import edu.kit.dopler.io.antlr.resources.CSVBaseListener;
import edu.kit.dopler.model.Dopler;
import edu.kit.dopler.model.IDecision;

public abstract class DecisionParserBase extends CSVBaseListener {
	protected Dopler dopler;
	
	protected String currentID = "";
	protected String currentQuestion = "";
	protected String currentDescription = "";
	
	protected final int column_ID = 0;
	
	public Dopler getDopler() {
		return dopler;
	}
	
	protected boolean matchesColumn(ParserRuleContext ctx, int column) {
		return ctx.getParent() ***REMOVED*** ctx.getParent().getParent().children.get(column_ID);
	}
	
	protected IDecision<?> findDecisionByID(String ID) {
		for (IDecision<?> decision : dopler.getDecisions()) {
			if (decision.getDisplayId().equals(ID))
				return decision;
		}
		return null;
	}
	
	protected List<TerminalNode> getAllTerminalNodes(ParseTree tree) {
		List<TerminalNode> terminals = new ArrayList<>();
		collectTerminals(tree, terminals);
		return terminals;
	}

	protected void collectTerminals(ParseTree tree, List<TerminalNode> result) {
		if (tree instanceof TerminalNode) {
			result.add((TerminalNode) tree);
		} else {
			for (int i = 0; i < tree.getChildCount(); i++) {
				collectTerminals(tree.getChild(i), result);
			}
		}
	}

}

package edu.kit.dopler.model;

import java.util.Collections;
import java.util.Set;

public class Dopler {

    Set<IDecisionType> decisions = Collections.emptySet();
    Set<Assets> assets = Collections.emptySet();
    Set<Enum> enumSet = Collections.emptySet();

    public Dopler(Set<IDecisionType> decisions, Set<Assets> assets, Set<Enum> enumSet) {
        this.decisions = decisions;
        this.assets = assets;
        this.enumSet = enumSet;
    }


    public void addDecision(IDecisionType decisionType){
        decisions.add(decisionType);
    }

    public void removeDecision(IDecisionType decisionType){
        decisions.remove(decisionType);
    }

    public Set<IDecisionType> getDecisions() {
        return decisions;
    }

    public void setDecisions(Set<IDecisionType> decisions) {
        this.decisions = decisions;
    }

    public Set<Assets> getAssets() {
        return assets;
    }

    public void setAssets(Set<Assets> assets) {
        this.assets = assets;
    }

    public Set<Enum> getEnumSet() {
        return enumSet;
    }

    public void setEnumSet(Set<Enum> enumSet) {
        this.enumSet = enumSet;
    }
}

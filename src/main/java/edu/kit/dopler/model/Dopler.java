package edu.kit.dopler.model;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

public class Dopler {

    Set<IDecision> decisions = Collections.emptySet();
    Set<Assets> assets = Collections.emptySet();
    Set<Enum> enumSet = Collections.emptySet();

    public Dopler(Set<IDecision> decisions, Set<Assets> assets, Set<Enum> enumSet) {
        this.decisions = decisions;
        this.assets = assets;
        this.enumSet = enumSet;
    }


    public void addDecision(IDecision decisionType){
        decisions.add(decisionType);
    }

    public void removeDecision(IDecision decisionType){
        decisions.remove(decisionType);
    }

    public Set<IDecision> getDecisions() {
        return decisions;
    }

    public void setDecisions(Set<IDecision> decisions) {
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

    public Stream<String> toSMTStream(){
        Stream.Builder<String> builder = Stream.builder();
        // open question on assert per decision ? or only one assert
        for (IDecision decisionType: decisions){
            builder.add("(assert");
            decisionType.toSMTStream(builder);
            builder.add(")");
        }

        return  builder.build();
    }
}

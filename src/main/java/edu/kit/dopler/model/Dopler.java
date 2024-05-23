package edu.kit.dopler.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

public class Dopler {

    Set<? super IDecision<?>> decisions;
    Set<Assets> assets = Collections.emptySet();
    Set<Enum> enumSet = Collections.emptySet();

    public Dopler(Set<IDecision<?>> decisions, Set<Assets> assets, Set<Enum> enumSet) {
        this.decisions = decisions;
        this.assets = assets;
        this.enumSet = enumSet;
    }


    public void addDecision(IDecision<?> decisionType){
        decisions.add(decisionType);
    }

    public void removeDecision(IDecision<?> decisionType){
        decisions.remove(decisionType);
    }

    public Set<? super IDecision<?>> getDecisions() {
        return decisions;
    }

    public void setDecisions(Set<IDecision<?>> decisions) {
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

        createConstants(builder);


        Object[] decisionsArray = decisions.toArray();
        for (int i = 0; i < decisions.size(); i++){
            IDecision<?> decision1 = (IDecision<?>) decisionsArray[i];

            builder.add("(assert");
            decision1.toSMTStream(builder);
            builder.add(")");
            int checkLastVariable = i + 1;
            if(checkLastVariable < decisions.size()) {

                IDecision<?> decision2 = (IDecision<?>) decisionsArray[i + 1];
                builder.add("(assert (and ");
                for (Object decision : decisions) {
                    IDecision<?> decision3 = (IDecision<?>) decision;

                    builder.add("(= " + decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_POST " + decision2.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_PRE");

                    builder.add(")");
                }
                builder.add("))");
            }

        }

        return  builder.build();
    }

    public void createConstants(Stream.Builder<String> builder){
        for (Object decision: decisions){
            IDecision<?> decision1 = (IDecision<?>) decision;
            for(Object decision2: decisions){
                IDecision<?> decision3 = (IDecision<?>) decision2;
                String type = "";
                switch (decision1.getDecisionType()){
                    case BOOLEAN -> type = "bool";
                    case NUMBER -> type = "double";
                    case STRING, ENUM -> type = "String";
                }

                builder.add("(declare-const "+ decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() +  "_PRE " + type + ")");
                builder.add("(declare-const "  + decision1.toStringConstforSMT() +  "_" + decision3.toStringConstforSMT() +  "_POST " + type + ")");
            }

        }
    }
}

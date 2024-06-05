package edu.kit.dopler.model;

import java.util.*;
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

    public Stream.Builder<String> toSMTStream(){
        Stream.Builder<String> builder = Stream.builder();

        createConstants(builder);
        createEndConstants(builder);
        createAssertForEnumDecisions(builder);

        Comparator<Object> comparator = new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
               Decision<?> decision1 = (Decision<?>) o1;
               Decision<?> decision2 = (Decision<?>) o2;


                return  decision1.getId() -  decision2.getId();
            }
        };

        Object[] decisionsArray = decisions.stream().sorted(comparator).toArray();
        for (int i = 0; i < decisions.size(); i++){
            IDecision<?> decision1 = (IDecision<?>) decisionsArray[i];

            builder.add("(assert");
            decision1.toSMTStream(builder, decisions.size());
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
            }else {
                builder.add("(assert (and");
                for (Object decision : decisions) {
                    IDecision<?> decision3 = (IDecision<?>) decision;

                    builder.add("(= " + decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_POST " + "END" + "_" + decision3.toStringConstforSMT());

                    builder.add(")");
                }
                builder.add("))");
            }

        }
       return builder;
    }

    public void createAssertForEnumDecisions(Stream.Builder<String> builder){
        Optional<IDecision<?>> optional = (Optional<IDecision<?>>) decisions.stream().findFirst();
        if(optional.isPresent()){
            IDecision<?> decision = optional.get();
            for (Object decision1: decisions){
                IDecision<?> decision2 = (IDecision<?>) decision1;
                if (decision2.getDecisionType() == Decision.DecisionType.ENUM){
                    EnumerationDecision enumerationDecision = (EnumerationDecision) decision2;
                    builder.add("(assert");
                    builder.add("(xor ");
                    for (EnumerationLiteral enumerationLiteral : enumerationDecision.getEnumeration().enumerationLiterals) {
                        builder.add( "(= " + decision.toStringConstforSMT() + "_" + enumerationDecision.toStringConstforSMT() + "_PRE"  + enumerationLiteral.getSMTValue() + ")");
                    }
                    builder.add(")"); //end xor
                    builder.add(")"); //end assert



                }

            }
        }


    }

    public void createConstants(Stream.Builder<String> builder){
        for (Object decision: decisions){
            IDecision<?> decision1 = (IDecision<?>) decision;
            //builder.add("(declare-const "+ decision1.toStringConstforSMT() +  "_TAKEN_PRE " + "bool" + ")");
            builder.add("(declare-const "+ decision1.toStringConstforSMT() +  "_TAKEN_POST " + "bool" + ")");
            for(Object decision2: decisions){
                IDecision<?> decision3 = (IDecision<?>) decision2;
                String type = "";
                switch (decision3.getDecisionType()){
                    case BOOLEAN -> type = "bool";
                    case NUMBER -> type = "double";
                    case STRING, ENUM -> type = "String";
                }

                builder.add("(declare-const "+ decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() +  "_PRE " + type + ")");
                builder.add("(declare-const "  + decision1.toStringConstforSMT() +  "_" + decision3.toStringConstforSMT() +  "_POST " + type + ")");
            }
        }


    }


    public void createEndConstants(Stream.Builder<String> builder){

        for(Object decision: decisions){
            IDecision<?> decision3 = (IDecision<?>) decision;
            String type = "";
            switch (decision3.getDecisionType()){
                case BOOLEAN -> type = "bool";
                case NUMBER -> type = "double";
                case STRING, ENUM -> type = "String";
            }

            builder.add("(declare-const "+ "END" + "_" + decision3.toStringConstforSMT() + " " + type + ")");
        }
    }

}

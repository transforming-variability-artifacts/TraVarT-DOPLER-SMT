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
            decision1.toSMTStream(builder, decisions);
            builder.add(")");

            int checkLastVariable = i + 1;
            if(checkLastVariable < decisions.size()) {

                IDecision<?> decision2 = (IDecision<?>) decisionsArray[i + 1];

                builder.add("(assert (and ");
                for (Object decision : decisions) {
                    IDecision<?> decision3 = (IDecision<?>) decision;
                    if(decision3.getDecisionType() == Decision.DecisionType.ENUM){
                        EnumerationDecision enumerationDecision = (EnumerationDecision) decision3;
                        for (EnumerationLiteral enumerationLiteral : enumerationDecision.getEnumeration().enumerationLiterals) {
                            builder.add("(= " + decision1.toStringConstforSMT() + "_" + enumerationDecision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + "_POST " + decision2.toStringConstforSMT() + "_" + enumerationDecision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + "_PRE");

                            builder.add(")");
                        }


                    }else {
                        builder.add("(= " + decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_POST " + decision2.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_PRE");

                        builder.add(")");
                    }
                }
                builder.add("))");
            }else {
                builder.add("(assert (and");
                for (Object decision : decisions) {
                    IDecision<?> decision3 = (IDecision<?>) decision;
                    if(decision3.getDecisionType() == Decision.DecisionType.ENUM){
                        EnumerationDecision enumerationDecision = (EnumerationDecision) decision3;
                        for (EnumerationLiteral enumerationLiteral : enumerationDecision.getEnumeration().enumerationLiterals) {
                            builder.add("(= " + decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + "_POST " + "END" + "_" + decision3.toStringConstforSMT() + "_" + enumerationLiteral.getValue());

                            builder.add(")");
                        }


                    }else {

                        builder.add("(= " + decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_POST " + "END" + "_" + decision3.toStringConstforSMT());

                        builder.add(")");
                    }
                }
                builder.add("))");
            }

        }
        createAssertForEnumDecisions(builder);
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
                    builder.add("(and");
                    builder.add("(>= ");
                    builder.add("(+");
                    for (EnumerationLiteral enumerationLiteral : enumerationDecision.getEnumeration().enumerationLiterals) {
                        builder.add("(ite");
                        builder.add( "(= " + decision.toStringConstforSMT() + "_" + enumerationDecision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + "_PRE" + " " + "true"  + ")");
                        builder.add("1");
                        builder.add("0");
                        builder.add(")"); // closing ite
                    }
                    builder.add(")"); //end +
                    builder.add(String.valueOf(enumerationDecision.getMinCardinality()));
                    builder.add(")"); //end <=


                    builder.add("(<= ");
                    builder.add("(+");
                    for (EnumerationLiteral enumerationLiteral : enumerationDecision.getEnumeration().enumerationLiterals) {
                        builder.add("(ite");
                        builder.add( "(= " + decision.toStringConstforSMT() + "_" + enumerationDecision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + "_PRE" + " " + "true"  + ")");
                        builder.add("1");
                        builder.add("0");
                        builder.add(")"); // closing ite
                    }
                    builder.add(")"); //end +
                    builder.add(String.valueOf(enumerationDecision.getMaxCardinality()));
                    builder.add(")"); //end >=

                    builder.add(")"); //end and
                    builder.add(")"); //end assert



                }

            }
        }


    }

    public void createConstants(Stream.Builder<String> builder){
        for (Object decision: decisions){
            IDecision<?> selectedDecisions = (IDecision<?>) decision;
            //builder.add("(declare-const "+ decision1.toStringConstforSMT() +  "_TAKEN_PRE " + "bool" + ")");
            builder.add("(declare-const "+ selectedDecisions.toStringConstforSMT() +  "_TAKEN_POST " + "bool" + ")");
            for(Object decision2: decisions){
                IDecision<?> decision3 = (IDecision<?>) decision2;
                String type = "";

                if(decision3.getDecisionType() == Decision.DecisionType.ENUM){

                    createEnumConstants(selectedDecisions, (EnumerationDecision) decision3,builder);

                }else{
                    switch (decision3.getDecisionType()){
                        case BOOLEAN -> type = "bool";
                        case NUMBER -> type = "double";
                        case STRING -> type = "String";
                    }

                    builder.add("(declare-const "+ selectedDecisions.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() +  "_PRE " + type + ")");
                    builder.add("(declare-const "  + selectedDecisions.toStringConstforSMT() +  "_" + decision3.toStringConstforSMT() +  "_POST " + type + ")");
                }


            }
        }


    }


    public void createEnumConstants(IDecision<?> selectedDecisions, EnumerationDecision decision, Stream.Builder<String> builder){

        for (EnumerationLiteral enumerationLiteral : decision.getEnumeration().enumerationLiterals){

            builder.add("(declare-const " + selectedDecisions.toStringConstforSMT() + "_" + decision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() +   "_PRE " + "bool" + ")");
            builder.add("(declare-const "  + selectedDecisions.toStringConstforSMT() +  "_" + decision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() +   "_POST " + "bool"  + ")");

        }
    }

    public void createEnumEndConstants(EnumerationDecision decision, Stream.Builder<String> builder){

        for (EnumerationLiteral enumerationLiteral : decision.getEnumeration().enumerationLiterals){

            builder.add("(declare-const "+ "END" + "_" + decision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + " " + "bool" + ")");
        }
    }


    public void createEndConstants(Stream.Builder<String> builder){

        for(Object decision: decisions){
            IDecision<?> decision3 = (IDecision<?>) decision;
            String type = "";

            if(decision3.getDecisionType() == Decision.DecisionType.ENUM){

                createEnumEndConstants((EnumerationDecision) decision3, builder);

            }else {

                switch (decision3.getDecisionType()) {
                    case BOOLEAN -> type = "bool";
                    case NUMBER -> type = "double";
                    case STRING -> type = "String";
                }

                builder.add("(declare-const " + "END" + "_" + decision3.toStringConstforSMT() + " " + type + ")");
            }
        }
    }


    public void createGetValueOFEndConstants(Stream.Builder<String> builder){
        builder.add("(get-value");
        builder.add("(");
        for(Object decision: decisions){
            IDecision<?> decision3 = (IDecision<?>) decision;
            String type = "";

            builder.add(" "+ decision3.toStringConstforSMT() +  "_TAKEN_POST "  + " ");

            if(decision3.getDecisionType() == Decision.DecisionType.ENUM){
                EnumerationDecision enumerationDecision = (EnumerationDecision) decision3;

                for (EnumerationLiteral enumerationLiteral :  enumerationDecision.getEnumeration().enumerationLiterals){

                    builder.add(" "+ "END" + "_" + decision3.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + " ");
                }

            }else {

                builder.add(" " + "END" + "_" + decision3.toStringConstforSMT() + " ");
            }
        }

        builder.add(")");
        builder.add(")"); // end get-value
    }


}

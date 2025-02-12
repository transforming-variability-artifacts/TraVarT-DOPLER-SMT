/*******************************************************************************
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
 * All rights reserved
 *******************************************************************************/
package edu.kit.dopler.model;

import java.util.*;
import java.util.stream.Stream;

public class Dopler {

    Set<IDecision<?>> decisions;
    Set<Assets> assets;
    Set<Enumeration> enumSet;
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public Dopler() {
    	this(new HashSet<>(), new HashSet<>(), new HashSet<>(), "");
    }

    public Dopler(Set<IDecision<?>> decisions, Set<Assets> assets, Set<Enumeration> enumSet, String name) {
        this.decisions = decisions;
        this.assets = assets;
        this.enumSet = enumSet;
        this.name = name;
    }

    public void addDecision(IDecision<?> decisionType){
        decisions.add(decisionType);
    }

    public void removeDecision(IDecision<?> decisionType){
        decisions.remove(decisionType);
    }

    public Set<IDecision<?>> getDecisions() {
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

    public Set<Enumeration> getEnumSet() {
        return enumSet;
    }

    public void setEnumSet(Set<Enumeration> enumSet) {
        this.enumSet = enumSet;
    }

    public void addEnum(Enumeration e){
        this.enumSet.add(e);
    }

    /**
     * Creates a Stream of the DOPLER model in an SMT Encoding
     *
     */
    public Stream.Builder<String> toSMTStream(){
        Stream.Builder<String> builder = Stream.builder();

        //creates all the constant needed for the encoding
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


            // build an assert for every decision
            builder.add("(assert");
            decision1.toSMTStream(builder, decisions);
            builder.add(")"); // closing assert

            int checkLastVariable = i + 1;

            if(checkLastVariable < decisions.size()) {

                IDecision<?> decision2 = (IDecision<?>) decisionsArray[i + 1];
                // matches the POST const of the decision to the PRE Const of the next decision
                builder.add("(assert (and ");
                for (Object decision : decisions) {
                    IDecision<?> decision3 = (IDecision<?>) decision;

                    // the enum decision needs to be handled different because there exist a bool const for every enum value
                    if(decision3.getDecisionType() == Decision.DecisionType.ENUM){
                        EnumerationDecision enumerationDecision = (EnumerationDecision) decision3;
                        for (EnumerationLiteral enumerationLiteral : enumerationDecision.getEnumeration().enumerationLiterals) {

                            builder.add("(= " + decision1.toStringConstforSMT() + "_" + enumerationDecision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + "_POST " + decision2.toStringConstforSMT() + "_" + enumerationDecision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + "_PRE" + ")");

                        }

                    }else {

                        builder.add("(= " + decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_POST " + decision2.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_PRE" + ")");

                    }
                }
                builder.add("))"); //closing and,assert
            }else {

                // matches the POST const of the last decision to the end constants
                builder.add("(assert (and");
                for (Object decision : decisions) {
                    IDecision<?> decision3 = (IDecision<?>) decision;


                    // the enum decision needs to be handled different because there exist a bool const for every enum value
                    if(decision3.getDecisionType() == Decision.DecisionType.ENUM){
                        EnumerationDecision enumerationDecision = (EnumerationDecision) decision3;
                        for (EnumerationLiteral enumerationLiteral : enumerationDecision.getEnumeration().enumerationLiterals) {

                            builder.add("(= " + decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + "_POST " + "END" + "_" + decision3.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + ")");

                        }
                    }else {

                        builder.add("(= " + decision1.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() + "_POST " + "END" + "_" + decision3.toStringConstforSMT() + ")");

                    }
                }
                builder.add("))"); //closing and,assert
            }

        }
        // create the asserts for the enumeration that there in the range from minCardinality and maxCardinality
        createAssertForEnumDecisions(builder);
       return builder;
    }

    /**
     * creates asserts in SMT Encoding for the enumeration so the taken enums match the max and min cardinality
     *  (assert (>= (+ (ite (= enum_const true) 1 0)  (ite (= enum_const2 true) 1 0) ... ) minCardinality) )
     */
    public void createAssertForEnumDecisions(Stream.Builder<String> builder){
        Optional<IDecision<?>> optional = (Optional<IDecision<?>>) decisions.stream().findFirst();
        if(optional.isPresent()){
            IDecision<?> decision = optional.get();
            for (Object decision1: decisions){
                IDecision<?> decision2 = (IDecision<?>) decision1;
                if (decision2.getDecisionType() == Decision.DecisionType.ENUM){
                    EnumerationDecision enumerationDecision = (EnumerationDecision) decision2;
                    builder.add("(assert");
                    builder.add("(ite ");
                    builder.add("(= " +  enumerationDecision.toStringConstforSMT() + "_TAKEN_POST" + " true)");
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
                    builder.add("(= true true)"); //else of ite
                    builder.add(")"); // end ite
                    builder.add(")"); //end assert



                }

            }
        }


    }


    /**
     *
     * Creates the constant needed for the encoding for every decision
     * Every decision has a bool Taken variable -> (declare-const DECISION_1_TAKEN_POST bool)
     * and every decision has a pre and post const for every decision
     * (declare-const DECISION_2_DECISION_1_PRE bool)
     * (declare-const DECISION_2_DECISION_1_POST bool)
     * (declare-const DECISION_2_DECISION_2_PRE double)
     * (declare-const DECISION_2_DECISION_2_POST double)
     * .....
     */
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
                        case NUMBER -> type = "Real";
                        case STRING -> type = "String";
                    }

                    builder.add("(declare-const "+ selectedDecisions.toStringConstforSMT() + "_" + decision3.toStringConstforSMT() +  "_PRE " + type + ")");
                    builder.add("(declare-const "  + selectedDecisions.toStringConstforSMT() +  "_" + decision3.toStringConstforSMT() +  "_POST " + type + ")");
                }


            }
        }


    }

    /**
     * EnumDecision need special constants because their enum value is added to the constant name and there are of the type bool
     * (declare-const DECISION_2_DECISION_0_Salami_PRE bool)
     * (declare-const DECISION_2_DECISION_0_Salami_POST bool)
     * (declare-const DECISION_2_DECISION_0_Mozzarella_PRE bool)
     * (declare-const DECISION_2_DECISION_0_Mozzarella_POST bool)
     */
    public void createEnumConstants(IDecision<?> selectedDecisions, EnumerationDecision decision, Stream.Builder<String> builder){

        for (EnumerationLiteral enumerationLiteral : decision.getEnumeration().enumerationLiterals){

            builder.add("(declare-const " + selectedDecisions.toStringConstforSMT() + "_" + decision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() +   "_PRE " + "bool" + ")");
            builder.add("(declare-const "  + selectedDecisions.toStringConstforSMT() +  "_" + decision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() +   "_POST " + "bool"  + ")");

        }
    }


    /**
     * This methode creates the end constants for the decision type enum
     * This const can be read out of the Solver for a valid config, if the problem is SAT
     * (declare-const END_DECISION_0_Salami bool)
     * (declare-const END_DECISION_0_Mozzarella bool)
     */
    public void createEnumEndConstants(EnumerationDecision decision, Stream.Builder<String> builder){

        for (EnumerationLiteral enumerationLiteral : decision.getEnumeration().enumerationLiterals){

            builder.add("(declare-const "+ "END" + "_" + decision.toStringConstforSMT() + "_" + enumerationLiteral.getValue() + " " + "bool" + ")");
        }
    }

    /**
     * This methode creates the end constants for all decision types except enums
     * This const can be read out of the Solver for a valid config, if the problem is SAT
     * (declare-const END_DECISION_1 bool)
     * (declare-const END_DECISION_2 double)
     */
    public void createEndConstants(Stream.Builder<String> builder){

        for(Object decision: decisions){
            IDecision<?> decision3 = (IDecision<?>) decision;
            String type = "";

            if(decision3.getDecisionType() == Decision.DecisionType.ENUM){

                createEnumEndConstants((EnumerationDecision) decision3, builder);

            }else {

                switch (decision3.getDecisionType()) {
                    case BOOLEAN -> type = "bool";
                    case NUMBER -> type = "Real";
                    case STRING -> type = "String";
                }

                builder.add("(declare-const " + "END" + "_" + decision3.toStringConstforSMT() + " " + type + ")");
            }
        }
    }


    /**
     * Adds a get-value phrase to the encoding, which retrieves a valid config of the end and taken const from the solver if the encoding is sat
     *
     * (get-value ( DECISION_1_TAKEN_POST END_DECISION_1  DECISION_2_TAKEN_POST END_DECISION_2 ... ))
     *
     */
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

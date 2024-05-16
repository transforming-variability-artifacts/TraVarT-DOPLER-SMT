package edu.kit.dopler.model;

import java.util.HashSet;
import java.util.Set;

public class Enumeration {

    Set<EnumerationLiteral> enumerationLiterals = new HashSet<>();


    public Enumeration(Set<EnumerationLiteral> enumerationLiterals) {
        this.enumerationLiterals = enumerationLiterals;
    }

    public void addEnumLiteral(EnumerationLiteral enumLiteral){
        enumerationLiterals.add(enumLiteral);
    }

    public Set<EnumerationLiteral> getEnumerationLiterals() {
        return enumerationLiterals;
    }
}

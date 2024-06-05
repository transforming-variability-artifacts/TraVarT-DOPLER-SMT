package edu.kit.dopler.model;

public class EnumerationLiteral {

    private final String value;


    public EnumerationLiteral(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getSMTValue() {
        return "\"" + value + "\"";
    }
}

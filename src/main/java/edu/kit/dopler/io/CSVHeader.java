package edu.kit.dopler.io;

import java.util.Arrays;

public enum CSVHeader {
	ID("ID"), QUESTION("Question"), TYPE("Type"), RANGE("Range"), CARDINALITY("Cardinality"), RULES("Constraint/Rule"),
	VISIBLITY("Visible/relevant if");

	private String header;

	public static String[] stringArray() {
		return Arrays.stream(CSVHeader.values()).map(CSVHeader::toString).toArray(String[]::new);
	}

	CSVHeader(String header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return header;
	}
}

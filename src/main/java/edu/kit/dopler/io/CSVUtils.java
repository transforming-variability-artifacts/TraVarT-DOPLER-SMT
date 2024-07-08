package edu.kit.dopler.io;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVFormat.Builder;

public final class CSVUtils {
	
	private CSVUtils() {
		
	}

	public static final char DELIMITER = ';';

	public static CSVFormat createCSVFormat() {
		Builder builder = CSVFormat.EXCEL.builder();
		builder.setDelimiter(DELIMITER);
		builder.setHeader(CSVHeader.stringArray());
		builder.setSkipHeaderRecord(true);
		return builder.build();
	}
}

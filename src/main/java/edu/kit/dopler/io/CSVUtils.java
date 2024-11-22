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
package edu.kit.dopler.io;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVFormat.Builder;

public final class CSVUtils {
	
	private CSVUtils() { }

	public static final char DELIMITER = ';';

	public static CSVFormat createCSVFormat() {
		Builder builder = CSVFormat.EXCEL.builder();
		builder.setDelimiter(DELIMITER);
		builder.setHeader(CSVHeader.stringArray());
		builder.setSkipHeaderRecord(true);
		return builder.build();
	}
}

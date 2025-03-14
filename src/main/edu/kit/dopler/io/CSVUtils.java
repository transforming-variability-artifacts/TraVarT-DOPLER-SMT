/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
 * This Source Code Form is subject to the terms of the Mozilla
 * Public License, v. 2.0. If a copy of the MPL was not distributed
 * with this file, You can obtain one at
 * https://mozilla.org/MPL/2.0/.
 * <p>
 * Contributors:
 *    @author Fabian Eger
 *    @author Kevin Feichtinger
 * <p>
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.io;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVFormat.Builder;

import java.util.Arrays;

public final class CSVUtils {

	private static final char DELIMITER = ';';

	private CSVUtils() {
	}

	public static CSVFormat createCSVFormat(boolean skipHeader) {
		Builder builder = CSVFormat.EXCEL.builder();
		builder.setDelimiter(DELIMITER);
		builder.setHeader(stringArray());
		builder.setSkipHeaderRecord(skipHeader);
		return builder.build();
	}

	private static String[] stringArray() {
		return Arrays.stream(CSVHeader.values()).map(CSVHeader::toString).toArray(String[]::new);
	}
}
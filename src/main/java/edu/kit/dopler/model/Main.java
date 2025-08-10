/*******************************************************************************
 * SPDX-License-Identifier: MPL-2.0
 *
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
 *******************************************************************************/
package edu.kit.dopler.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import edu.kit.dopler.exceptions.NotSupportedVariabilityTypeException;
import edu.kit.dopler.io.DecisionModelReader;
import edu.kit.dopler.io.antlr.CSVDoplerListener;
import edu.kit.dopler.io.antlr.resources.CSVLexer;
import edu.kit.dopler.io.antlr.resources.CSVParser;

public class Main {

	public static void main(final String[] args) throws NotSupportedVariabilityTypeException, IOException {		
		CharStream input = CharStreams.fromFileName("issue.csv");
		CSVLexer lexer = new CSVLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CSVParser parser = new CSVParser(tokens);
		
		ParseTree tree = parser.csvFile();
		
		ParseTreeWalker walker = new ParseTreeWalker();
		CSVDoplerListener listener = new CSVDoplerListener();
		walker.walk(listener, tree);
		
		Dopler dopler = listener.getDopler();
		
		
		final DecisionModelReader decisionModelReader = new DecisionModelReader();
//		final Dopler dopler = decisionModelReader
//				.read(Path.of(System.getProperty("user.dir") + "/modelEval/product_chesspiece.csv"));
		final Set<? extends IDecision<?>> decisions = dopler.getDecisions();

		dopler.toSMTStream().build().forEach(System.out::println);
		try {
			final Stream.Builder<String> builder = dopler.toSMTStream();

			System.out.println(getAmountOfConfigs(dopler));

			// builder.add("(assert (= DECISION_1_TAKEN_POST true))");
			builder.add("(check-sat)");
			dopler.createGetValueOFEndConstants(builder);
			// builder.add("(get-model)");
			// builder.add("(get-value (END_DECISION_0 DECISION_0_TAKEN_POST END_DECISION_1
			// DECISION_1_TAKEN_POST END_DECISION_2 DECISION_2_TAKEN_POST END_DECISION_3
			// DECISION_3_TAKEN_POST END_DECISION_4 DECISION_4_TAKEN_POST ))");
			builder.add("(exit)");
			final Stream<String> stream = builder.build();
			final Scanner scanner = satSolver(stream);
			if (scanner == null) {
				throw new Exception();
			}
			while (scanner.hasNextLine()) {
				// System.out.println(scanner.nextLine());
			}

		} catch (final Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Gets the smt stream of the dopler model and adds the comment (check-sat) and
	 * then calls the satSolver with the stream
	 *
	 * @param builder Stream Builder of the DOPLER MODEL which should be fed into
	 *                the solver
	 * @return True if the encoding is sat or false if the encoding is unsat
	 * @throws Exception
	 */
	static boolean checkSat(final Stream.Builder<String> builder) throws Exception {

		// needs to be added to retrieve sat/unsat from the solver
		builder.add("(check-sat)");
		// builder.add("(get-model)");
		builder.add("(exit)");
		final Stream<String> stream = builder.build();
		final Scanner scanner = satSolver(stream);
		if (scanner == null) {
			throw new Exception();
		}
		while (scanner.hasNextLine()) {
			final String line = scanner.nextLine();
			if (line.equals("sat")) {
				return true;
			}
			if (line.equals("unsat")) {
				return false;
			}
		}
		throw new Exception();
	}

	static int getAmountOfConfigs(final Dopler dopler) {
		final int amount = getAmountOfConfigs(dopler, dopler.toSMTStream());
		System.out.println(amount);
		return amount;
	}

	static int getAmountOfConfigs(final Dopler dopler, final String asserts) {
		final Stream.Builder<String> builder = dopler.toSMTStream();
		builder.add(asserts);
		final int amount = getAmountOfConfigs(dopler, builder);
		System.out.println(amount);
		return amount;
	}

	private static int getAmountOfConfigs(final Dopler dopler, Stream.Builder<String> builder) {
		int amount = 0;
		final boolean isSAT = true;
		String asserts = "";
		// builder.add("(assert (= DECISION_2_TAKEN_POST true))");
		// builder.add("(assert (= DECISION_0_TAKEN_POST true))");
		// builder.add("(assert (= DECISION_1_TAKEN_POST true))");
		do {
			builder.add(asserts);
			builder.add("(check-sat)");
			dopler.createGetValueOFEndConstants(builder);
			final Stream<String> stream = builder.build();
			final Scanner scanner = satSolver(stream);
			builder = dopler.toSMTStream();

			while (scanner.hasNextLine()) {
				final String line = scanner.nextLine();
				if (line.equals("unsat")) {
					return amount;
				}
				if (line.equals("sat")) {

					asserts += "(assert (not (and";
					amount++;

				} else if (line.equals(" ")) {

				} else {
					System.out.println(line);
					final String[] result = line.split("[\\(\\)]");

					if (result.length == 3) {

						if (!result[2].contains("DECISION")) {
							asserts += "(= " + result[1] + " (" + result[2] + "))";
						} else {
							asserts += "(= " + result[2] + ")";
						}

					} else if (result.length == 4) {
						asserts += "(= " + result[1] + " (" + result[2] + "(" + result[3] + ")))";
					} else {
						asserts += "(= " + result[1] + ")";
					}
				}
			}
			asserts += ")))";

			System.out.println(amount);
		} while (true);

	}

	/**
	 * Starts a Process of the local Z3 Solver and feeds him the SMT Encoding Stream
	 *
	 * @param stream SMT Encoding
	 * @return Output of the Solver
	 */
	static Scanner satSolver(final Stream<String> stream) {

		final String[] command = { "/Documents/z3/z3/build/z3", "-in", "-smt2" };

		final ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("../../Documents/z3/z3/build/z3", "-in", "-smt2");
		Process process;
		try {
			process = processBuilder.start();

			final OutputStream stdin = process.getOutputStream(); // <- Eh?
			final InputStream stdout = process.getInputStream();

			final BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
			final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));

			stream.forEach(a -> {
				try {
					writer.write(a);
					writer.newLine();
				} catch (final IOException e) {
					throw new RuntimeException(e);
				}
			});
			writer.flush();
			writer.close();
			final Scanner scanner = new Scanner(stdout);

			return scanner;
		} catch (final IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}

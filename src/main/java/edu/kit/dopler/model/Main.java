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
 *  @author David Kowal
 *
 * Copyright 2024 Karlsruhe Institute of Technology (KIT)
 * KASTEL - Dependability of Software-intensive Systems
 *******************************************************************************/
package edu.kit.dopler.model;

import de.ovgu.featureide.fm.core.JavaLogger;
import de.ovgu.featureide.fm.core.Logger;
import de.ovgu.featureide.fm.core.analysis.cnf.LiteralSet;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.analysis.cnf.generator.configuration.AllConfigurationGenerator;
import de.ovgu.featureide.fm.core.base.IFeatureModel;
import de.ovgu.featureide.fm.core.base.impl.CoreFactoryWorkspaceLoader;
import de.ovgu.featureide.fm.core.base.impl.DefaultFeatureModelFactory;
import de.ovgu.featureide.fm.core.base.impl.FMFactoryManager;
import de.ovgu.featureide.fm.core.base.impl.MultiFeatureModelFactory;
import de.ovgu.featureide.fm.core.cli.CLIFunctionManager;
import de.ovgu.featureide.fm.core.cli.ConfigurationGenerator;
import de.ovgu.featureide.fm.core.io.FileSystem;
import de.ovgu.featureide.fm.core.io.JavaFileSystem;
import de.ovgu.featureide.fm.core.io.uvl.UVLFeatureModelFormat;
import de.ovgu.featureide.fm.core.job.LongRunningCore;
import de.ovgu.featureide.fm.core.job.LongRunningWrapper;
import edu.kit.dopler.exceptions.NotSupportedVariabilityTypeException;
import edu.kit.dopler.io.DecisionModelReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import edu.kit.dopler.exceptions.NotSupportedVariabilityTypeException;
import edu.kit.dopler.io.DoplerModelWriter;
import edu.kit.dopler.io.DoplerModelWriter;
import edu.kit.dopler.io.antlr.DoplerDecisionCreator;
import edu.kit.dopler.io.antlr.DoplerExpressionParser;
import edu.kit.dopler.io.antlr.resources.DoplerLexer;
import edu.kit.dopler.io.antlr.resources.DoplerParser;

public class Main {

	public static void main(final String[] args) throws NotSupportedVariabilityTypeException, IOException {		
		// ANTLR Setup
		// Input file, JSON or CSV
		String fileName = "dm_dopler.json";
		CharStream input = CharStreams.fromFileName(fileName);
		DoplerLexer lexer = new DoplerLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DoplerParser parser = new DoplerParser(tokens);
		
		// Create parse tree
		ParseTree tree = parser.document();
		ParseTreeWalker walker = new ParseTreeWalker();
		
		// Walk through both listeners, first to create the decisions, second to create the expressions
		DoplerDecisionCreator decisionCreator = new DoplerDecisionCreator(fileName);
		walker.walk(decisionCreator, tree);
		DoplerExpressionParser expressionParser = new DoplerExpressionParser(decisionCreator.getDopler());
		walker.walk(expressionParser, tree);
		
		// Extract Dopler Model
		Dopler dopler = expressionParser.getDopler();
		
		// Write Dopler Model in csv and json
		DoplerModelWriter dmw = new DoplerModelWriter();
		dmw.writeCSV(dopler, Paths.get("output_dm_dopler.csv"));
		dmw.writeJson(dopler, Paths.get("output_dm_dopler.json"));
		

		dopler.toSMTStream().build().forEach(System.out::println);
		try {

			long startTime = System.nanoTime();
			final Stream.Builder<String> builder = dopler.toSMTStream();

			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;
			System.out.println("SMT DOPLER encoding needed: " + duration+ "ms");  //divide by 1000000 to get milliseconds.

			 startTime = System.nanoTime();
             getAmountOfConfigs(dopler);
             checkForAnomalies(dopler);
			 endTime = System.nanoTime();
			 duration = (endTime - startTime) / 1000000;
			System.out.println("SMT DOPLER needed: " + duration  + "ms");  //divide by 1000000 to get milliseconds.
            
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

	public static int getFeatureIDConfigs(Path filePath) throws IOException {
		FileSystem.INSTANCE = new JavaFileSystem();
		LongRunningWrapper.INSTANCE = new LongRunningCore();
		Logger.logger = new JavaLogger();

		FMFactoryManager.getInstance().addExtension(DefaultFeatureModelFactory.getInstance());
		FMFactoryManager.getInstance().addExtension(MultiFeatureModelFactory.getInstance());
		FMFactoryManager.getInstance().setWorkspaceLoader(new CoreFactoryWorkspaceLoader());

		CLIFunctionManager.getInstance().addExtension(new ConfigurationGenerator());

		String content = Files.readString(filePath);
		IFeatureModel featureIdeFm = new MultiFeatureModelFactory().create();
		UVLFeatureModelFormat format = new UVLFeatureModelFormat();
		format.read(featureIdeFm, content);

		FeatureModelFormula formula = new FeatureModelFormula(featureIdeFm);
		List<LiteralSet> configs = LongRunningWrapper.runMethod(new AllConfigurationGenerator(formula.getCNF()));
		return configs.size();

	}


	static int getAmountOfConfigs(final Dopler dopler) {
		final int amount = getAmountOfConfigs(dopler, dopler.toSMTStream());
		System.out.println("SMT DOPLER variants: " + amount);
		return amount;
	}

	static int getAmountOfConfigs(final Dopler dopler, final String asserts) {
		final Stream.Builder<String> builder = dopler.toSMTStream();
		builder.add(asserts);
		final int amount = getAmountOfConfigs(dopler, builder);
		System.out.println(amount);
		return amount;
	}

	static int getAmountOfConfigsUVLSMT(final String encoding, final String asserts) {
		final Stream.Builder<String> builder = Stream.builder();
		builder.add(encoding);
		//System.out.println(encoding);
		final int amount = getAmountOfConfigsUVLSMT(encoding, builder);
		System.out.println("UVL variants: " + amount);
		return amount;
	}

	static void checkForAnomalies(final Dopler dopler) {
		Stream.Builder<String> builder = dopler.toSMTStream();
		checkForDeadDecision(dopler, builder);
		builder = dopler.toSMTStream();
		checkForFalseOptionalDecisions(dopler,builder);

	}
	private static void checkForFalseOptionalDecisions(final Dopler doplerModel, Stream.Builder<String> builder){
		builder.add("(check-sat)");
		builder.add("(get-model)");


		final Stream<String> stream = builder.build();
		final Scanner scanner = satSolver(stream);


		while (true) {
            builder = doplerModel.toSMTStream();
			assert scanner != null;
			if (!scanner.hasNextLine()) break;

			final String line = scanner.nextLine();
			if (line.equals("unsat")) {
				System.out.println("Void DM");
				return;
			} else if(line.contains("(define-fun END")){
				String[] newLine = line.split("\\s+");
				String nextLine = scanner.nextLine();
				builder.add("(assert (= " + newLine[2]+ " " + "false" + "))");
				builder.add("(check-sat)");
				builder.add("(get-model)");
				final Stream<String> deadDecisionStream = builder.build();
				final Scanner scannerDeadDecision = satSolver(deadDecisionStream);
				while (scannerDeadDecision.hasNextLine()) {
					final String deadDecisionLine = scannerDeadDecision.nextLine();
					//System.out.println(deadDecisionLine);
					if (deadDecisionLine.equals("unsat")) {
						System.out.println("False Optional Decision Value: " + newLine[2]);
						break;
					} else if (deadDecisionLine.equals("sat")) {
						break;
					}

				}

			}
		}


	}

	private static void checkForDeadDecision(final Dopler doplerModel, Stream.Builder<String> builder){
		builder.add("(check-sat)");
		builder.add("(get-model)");


		final Stream<String> stream = builder.build();
		final Scanner scanner = satSolver(stream);


		while (true) {
            builder = doplerModel.toSMTStream();
            assert scanner != null;
            if (!scanner.hasNextLine()) break;

            final String line = scanner.nextLine();
			if (line.equals("unsat")) {
				System.out.println("Void DM");
				return;
			} else if(line.contains("(define-fun END")){
				String[] newLine = line.split("\\s+");
				String nextLine = scanner.nextLine();
				//System.out.println("Check for Feature: " +  newLine[2]);
				builder.add("(assert (= " + newLine[2]+ " " + "true" + "))");
				builder.add("(check-sat)");
				builder.add("(get-model)");
				final Stream<String> deadDecisionStream = builder.build();

				final Scanner scannerDeadDecision = satSolver(deadDecisionStream);
				while (scannerDeadDecision.hasNextLine()) {
					final String deadDecisionLine = scannerDeadDecision.nextLine();
					//System.out.println(deadDecisionLine);
					if (deadDecisionLine.equals("unsat")) {
						System.out.println("Dead Decision Value: " + newLine[2]);
						break;
					} else if (deadDecisionLine.equals("sat")) {

					}


				}

			}
		}


	}


	private static int getAmountOfConfigsUVLSMT(final String encoding, Stream.Builder<String> builder) {
		int amount = 0;
		final boolean isSAT = true;
		String asserts = "";


		do {
			builder.add(asserts);
			//builder.add("(minimize (+ (ite DECISION_0_TAKEN_POST 1 0) (ite DECISION_1_TAKEN_POST 1 0) ) )")
			builder.add("(check-sat)");
			builder.add("(get-model)");

			final Stream<String> stream = builder.build();
			final Scanner scanner = satSolver(stream);
			builder = Stream.builder();
			builder.add(encoding);

			while (scanner.hasNextLine()) {

				final String line = scanner.nextLine();
				if (line.equals("unsat")) {
					return amount;
				}
				if (line.equals("sat")) {

					asserts += "(assert (not (and";
					amount++;
					System.out.println(amount);

				} else if (line.equals(" ")) {

				} else if(line.contains("(define-fun")){
					String[] newLine = line.split("\\s+");
					String nextLine = scanner.nextLine();
					String[] value = nextLine.split("\\)");
					//System.out.println(newLine[2]);
					asserts += "(= " + newLine[2]+ " " + value[0] + ")";
				}
			}
			asserts += ")))";
		} while (true);

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
			//builder.add("(minimize (+ (ite DECISION_0_TAKEN_POST 1 0) (ite DECISION_1_TAKEN_POST 1 0) ) )");
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
					//System.out.println(line);
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
		processBuilder.command("../z3/build/z3", "-in", "-smt2");
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


	/**
	 * Starts a Process of the local Z3 Solver and feeds him the SMT Encoding Stream
	 *
	 * @param stream SMT Encoding
	 * @return Output of the Solver
	 */
	static Scanner satSolverWithoutSMT(final Stream<String> stream) {

		final String[] command = { "/Documents/z3/z3/build/z3"};

		final ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command("../../z3/z3/build/z3");
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

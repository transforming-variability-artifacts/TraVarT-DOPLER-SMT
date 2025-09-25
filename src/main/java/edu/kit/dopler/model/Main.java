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

import static edu.kit.dopler.common.DoplerUtils.readDOPLERModelFromFile;
import static edu.kit.dopler.common.SolverUtils.checkForAnomalies;

public class Main {

	public static void main(final String[] args) throws NotSupportedVariabilityTypeException, IOException {
        anomalieAnalysisOfAllModels();
	}


    static void anomalieAnalysisOfAllModels() {

        Path startDirectory = Paths.get(System.getProperty("user.dir") + "/VariabilityEval/BoolCSV/");


        try {

            Files.walk(startDirectory).filter(Files::isRegularFile)
                    .filter(path -> {
                String fileName = path.getFileName().toString().toLowerCase();
                return fileName.endsWith(".json") || fileName.endsWith(".csv");
            })
                    .forEach(path -> {
                System.out.println(path.toString());
                Dopler dopler = null;
                try {
                    dopler = readDOPLERModelFromFile(path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                long startTime = System.nanoTime();
                final Stream.Builder<String> builder = dopler.toSMTStream();

                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000;

                startTime = System.nanoTime();
                // getAmountOfConfigs(dopler);
                checkForAnomalies(dopler);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println("SMT DOPLER Anomalie needed: " + duration + "ms");  //divide by 1000000 to get milliseconds.
            });
        } catch (IOException e) {


        }

    }




}

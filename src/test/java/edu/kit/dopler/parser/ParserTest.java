package edu.kit.dopler.parser;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static edu.kit.dopler.common.DoplerUtils.readDOPLERModelFromFile;

public class ParserTest extends TestCase {

    @Test(expected = IOException.class)
    public void testParseOfAllDM() {

        Path dir = Paths.get("modelCSVs/");

        try (Stream<Path> stream = Files.walk(dir)) {

            stream.filter(Files::isRegularFile).forEach(file -> {
                System.out.println("Parse file " + file.getFileName().toString());

                try {
                    assertNotNull(readDOPLERModelFromFile(file));
                    // TODO Assert For Command Line Prints from the Parser
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

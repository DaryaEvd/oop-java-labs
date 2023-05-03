package tests.commands;

import myCalculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class DefinitionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(null);
    }

    @Test
    void checkDefinition() {
        Calculator calculator = new Calculator("/home/dasha/IdeaProjects/task2/src/tests/commands/filesForTests/testDefinition.txt");
        calculator.calculate();
        assertEquals("" + "Command error: You are not define a variable to number\n" +
                        "Command error: You are not define a variable to number\n" +
                        "Command error: You've already defined 'A' variable\n"
                , outContent.toString());
    }

}

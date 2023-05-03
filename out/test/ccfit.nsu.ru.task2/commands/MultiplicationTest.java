package tests.commands;
//https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
import myCalculator.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {
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
    void checkDivision() {
        Calculator calculator = new Calculator("./src/tests/commands/filesForTests/testMultiplication.txt");
        calculator.calculate();

        assertEquals("15000.0\n" +
                "Command error: Stack is empty\n" +
                "Command error: Not enough arguments on stack\n", outContent.toString());

    }

}
package tests.commands;

//https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

import myCalculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

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
        Calculator calculator = new Calculator("./src/tests/commands/filesForTests/testDivision.txt");
        calculator.calculate();

        assertEquals("1.5\n" +
                "Command error: Stack is empty\n" +
                "Command error: Not enough arguments on stack\n", outContent.toString());

    }
}
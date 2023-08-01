package tests.commands;
//https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
import myCalculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class AdditionTest {
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
    void checkAddition() {
        Calculator calculator = new Calculator("./src/tests/commands/filesForTests/testAddition.txt");
        calculator.calculate();

        assertEquals("250.0\n" +
                "Command error: Stack is empty\n" +
                "Command error: Not enough arguments on stack\n", outContent.toString());

    }

}

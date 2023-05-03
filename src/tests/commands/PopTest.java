package tests.commands;

import myCalculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {

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
    void checkPop() {
        Calculator calculator = new Calculator("/home/dasha/IdeaProjects/task2/src/tests/commands/filesForTests/testPop.txt");
        calculator.calculate();
        assertEquals("Command error: Stack is empty\n" + "89.0\n" + "Command error: Stack is empty\n", outContent.toString());
    }
}
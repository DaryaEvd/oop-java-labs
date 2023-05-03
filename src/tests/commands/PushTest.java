package tests.commands;

import myCalculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

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
        Calculator calculator = new Calculator("/home/dasha/IdeaProjects/task2/src/tests/commands/filesForTests/testPush.txt");
        calculator.calculate();
        assertEquals("Command error: Incorrect amount of arguments in 'PUSH' cmd\n" +
                "Command error: You're trying to push undefined var 'A'\n", outContent.toString());
    }
}

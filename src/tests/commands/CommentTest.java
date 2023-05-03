package tests.commands;

import myCalculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {
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
    void checkComment() {
        Calculator calculator = new Calculator("/home/dasha/IdeaProjects/task2/src/tests/commands/filesForTests/testComment.txt");
        calculator.calculate();
        assertEquals("It's my stack: " + "[123.0, 789.0, 31.75]\n", outContent.toString());
    }

}

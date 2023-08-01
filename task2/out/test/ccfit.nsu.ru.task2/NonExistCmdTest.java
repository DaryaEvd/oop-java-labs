import myCalculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NonExistCmdTest {
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
    void checkNonExistingCmd() {
        Calculator calculator = new Calculator("./src/tests/fileFolderTest/testNonExistCmd.txt");
        calculator.calculate();

        assertEquals("Exception in input line: Such command 'define' doesn't exist\n" +
                "Exception in input line: Such command 'DEfine' doesn't exist\n" +
                "Exception in input line: Such command '++' doesn't exist\n" +
                "Exception in input line: Such command 'QWERTY' doesn't exist\n" +
                "Exception in input line: Such command 'U9D9P9' doesn't exist\n", outContent.toString());
    }
}
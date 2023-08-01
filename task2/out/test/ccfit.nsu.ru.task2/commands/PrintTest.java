import myCalculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {

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
    void checkPrint() {
        Calculator calculator = new Calculator("./src/tests/commands/filesForTests/testPrint.txt");
        calculator.calculate();
        assertEquals("Command error: Stack is empty\n" + "99.0\n" + "1.0\n", outContent.toString());

    }
}
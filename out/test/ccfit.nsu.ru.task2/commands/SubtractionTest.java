import myCalculator.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class SubtractionTest {

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
    void checkSubtraction() {
        Calculator calculator = new Calculator("./src/tests/commands/filesForTests/testSubtraction.txt");
        calculator.calculate();
        assertEquals("-50.0\n" +
                "Command error: Stack is empty\n" +
                "Command error: Not enough arguments on stack\n", outContent.toString());

    }
}

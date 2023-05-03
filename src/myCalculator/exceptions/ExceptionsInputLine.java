package myCalculator.exceptions;

public class ExceptionsInputLine extends RuntimeException {
    public ExceptionsInputLine(String message) {
        super("Exception in Input line: " + message);
    }
}

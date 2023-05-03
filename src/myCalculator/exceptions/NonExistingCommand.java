package myCalculator.exceptions;

public class NonExistingCommand extends ExceptionsInputLine {
    public NonExistingCommand(String msg) {
        super("Such command '" + msg + "' doesn't exist");
    }
}

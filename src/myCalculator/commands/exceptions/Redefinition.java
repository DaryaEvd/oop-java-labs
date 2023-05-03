package myCalculator.commands.exceptions;

public class Redefinition extends ExceptionCommands {
    public Redefinition(String message) {
        super("You've already defined '" + message + "' variable");
    }
}

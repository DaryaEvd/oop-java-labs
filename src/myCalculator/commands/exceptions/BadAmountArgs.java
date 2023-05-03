package myCalculator.commands.exceptions;

public class BadAmountArgs extends ExceptionCommands{
    public BadAmountArgs(String message) {
        super("Incorrect amount of arguments in '" + message + "' cmd");
    }
}

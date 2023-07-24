package myCalculator.commands.exceptions;

public class BadAmountArgs extends ExceptionCommands{
    public BadAmountArgs(String command) {
        super("Incorrect amount of arguments in '" + command + "' cmd");
    }
}

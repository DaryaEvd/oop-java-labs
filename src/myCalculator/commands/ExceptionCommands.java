package myCalculator.commands;

public class ExceptionCommands extends Exception{
    public ExceptionCommands (String message) {
        super("Command error: " + message);
    }
}

package myCalculator.commands.exceptions;

public class Redefinition extends ExceptionCommands {
    public Redefinition(String var) {
        super("You've already defined '" + var + "' variable");
    }
}

package myCalculator.commands.exceptions;

public class UndefinedVariable extends ExceptionCommands {
    public UndefinedVariable(String var) {
        super("You're trying to push undefined var '" + var + "'");
    }
}

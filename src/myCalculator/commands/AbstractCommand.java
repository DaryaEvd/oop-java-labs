package myCalculator.commands;

import myCalculator.Context;

public abstract class AbstractCommand {
    protected Context context;
    protected String [] arguments;

    public AbstractCommand(Context context, String [] arguments) {
       this.context = context;
       this.arguments = arguments;
    }

    public abstract void apply() throws ExceptionCommands;

}

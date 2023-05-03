package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.ExceptionCommands;

public abstract class AbstractCommand {
    protected Context context;
    protected String [] arguments;

    public AbstractCommand(Context context, String [] arguments) {
       this.context = context;
       this.arguments = arguments;
    }

    public abstract void apply() throws ExceptionCommands;

     boolean isAlphabetical(String str) {
        return str.matches("[a-zA-Z]+");
     }

}

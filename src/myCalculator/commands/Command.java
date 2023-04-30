package myCalculator.commands;

import myCalculator.Context;

public abstract class Command {
    protected Context context;
    protected String [] arguments;

    public Command(Context context, String [] arguments) {
       this.context = context;
       this.arguments = arguments;
    }

    public abstract void apply();

}

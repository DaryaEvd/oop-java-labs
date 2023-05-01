package myCalculator.commands;

import myCalculator.Context;

public class Push extends Command {
    public Push(Context context, String [] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("it's push");

        Double number = context.getVariable().get(arguments[1]);

        context.getMyStack().push(number);

    }
}

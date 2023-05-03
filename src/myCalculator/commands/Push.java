package myCalculator.commands;

import myCalculator.Context;

public class Push extends AbstractCommand {
    public Push(Context context, String [] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        if(context.containsVar(arguments[1])) {
            Double number = context.getVariable().get(arguments[1]);

            context.getMyStack().push(number);
        }
        else {
            Double number = Double.parseDouble(arguments[1]);

            context.getMyStack().push(number);
        }
    }
}

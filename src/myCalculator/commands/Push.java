package myCalculator.commands;

import myCalculator.Context;

public class Push extends Command {
    public Push(Context context, String [] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("it's push");

        System.out.println("args is: " + arguments[1]);

        if(context.containsArg(arguments[1])) {
            Double number = context.getVariable().get(arguments[1]);
            System.out.println("number is: " + number);

            context.getMyStack().push(number);
        }
        else {
            Double number = Double.parseDouble(arguments[1]);
            System.out.println("number: " + number);

            context.getMyStack().push(number);
        }
    }
}

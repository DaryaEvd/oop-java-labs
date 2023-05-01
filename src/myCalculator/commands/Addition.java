package myCalculator.commands;

import myCalculator.Context;

public class Addition extends Command {
    public Addition(Context context, String [] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        var number1 = context.getMyStack().pop();
        System.out.println("numer1: " + number1);

        var number2 = context.getMyStack().pop();
        System.out.println("number2: " + number2);


        context.getMyStack().push(number1 + number2);
    }
}

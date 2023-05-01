package myCalculator.commands;

import myCalculator.Context;

public class Subtraction extends Command {
    public Subtraction(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("It's Subtraction");

        Double number1 = context.getMyStack().pop();

        Double number2 = context.getMyStack().pop();

        Double res = number1 - number2;

        context.getMyStack().push(res);
    }
}

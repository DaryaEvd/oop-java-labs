package myCalculator.commands;

import myCalculator.Context;

public class Multiplication extends Command {

    public Multiplication(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("it's multiplication");

        Double number1 = context.getMyStack().pop();
        Double number2 = context.getMyStack().pop();

        Double res = number1 * number2;

        context.getMyStack().push(res);

    }
}

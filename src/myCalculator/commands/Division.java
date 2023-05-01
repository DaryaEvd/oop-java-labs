package myCalculator.commands;

import myCalculator.Context;

public class Division extends Command {
    public Division(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("It's dividion");

        Double number1 = context.getMyStack().pop();
        Double number2 = context.getMyStack().pop();

        Double result = number1 / number2;

        context.getMyStack().push(result);
    }
}

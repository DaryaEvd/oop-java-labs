package myCalculator.commands;

import myCalculator.Context;

public class Sqrt extends AbstractCommand {
    public Sqrt(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("It's sqrt");

        Double numToSqrt = context.getMyStack().pop();

        Double res = Math.sqrt(numToSqrt);

        context.getMyStack().push(res);
    }
}

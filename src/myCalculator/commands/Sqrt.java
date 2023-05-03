package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.InsufficientArgsAmount;

public class Sqrt extends AbstractCommand {
    public Sqrt(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws ExceptionCommands {
        if(context.getMyStack().size() == 0) {
            throw new InsufficientArgsAmount();
        }

        Double numToSqrt = context.getMyStack().pop();
        Double res = Math.sqrt(numToSqrt);

        context.getMyStack().push(res);
    }
}

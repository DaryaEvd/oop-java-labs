package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.EmptyStack;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.InsufficientArgsAmountOnStack;
import myCalculator.commands.exceptions.SqrtNegative;

public class Sqrt extends AbstractCommand {
    public Sqrt(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws ExceptionCommands {
        if(context.getMyStack().size() == 0) {
            throw new EmptyStack();
        }

        Double numToSqrt = context.getMyStack().pop();
        if(numToSqrt < 0) {
            throw new SqrtNegative();
        }

        Double res = Math.sqrt(numToSqrt);

        context.getMyStack().push(res);
    }
}

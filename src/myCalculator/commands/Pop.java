package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.InsufficientArgsAmountOnStack;

public class Pop extends AbstractCommand {
    public Pop(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws ExceptionCommands {
        if(context.getMyStack().size() < 1) {
            throw new InsufficientArgsAmountOnStack();
        }

        context.getMyStack().pop();
    }
}

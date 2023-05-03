package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.InsufficientArgsAmount;

public class Pop extends AbstractCommand {
    public Pop(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws ExceptionCommands {
        if(context.getMyStack().size() < 1) {
            throw new InsufficientArgsAmount();
        }

        context.getMyStack().pop();
    }
}

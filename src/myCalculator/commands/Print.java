package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.InsufficientArgsAmountOnStack;

public class Print extends AbstractCommand {

    public Print(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws ExceptionCommands {

        if(context.getMyStack().size() == 0) {
            throw new InsufficientArgsAmountOnStack();
        }
        Double resToPrint = context.getMyStack().peek();

        System.out.println(resToPrint);

    }
}

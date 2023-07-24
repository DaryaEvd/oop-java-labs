package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.EmptyStack;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.InsufficientArgsAmountOnStack;

public abstract class AbstractBinOperation extends AbstractCommand{
    public AbstractBinOperation(Context context, String[] arguments) {
        super(context, arguments);
    }

    public void makeBinOperation(Double num1, Double num2) throws ExceptionCommands {

    }

    @Override
    public void apply() throws ExceptionCommands {
        if(context.getMyStack().size() == 1) {
            throw new InsufficientArgsAmountOnStack();
        }
        else if(context.getMyStack().size() == 0) {
            throw new EmptyStack();
        }

        Double num1 = context.getMyStack().pop();
        Double num2 = context.getMyStack().pop();

        makeBinOperation(num1, num2);
    }
}

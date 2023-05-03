package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.DivByZero;
import myCalculator.commands.exceptions.ExceptionCommands;

public class Division extends AbstractBinOperation {
    public Division(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void makeBinOperation(Double num1, Double num2) throws ExceptionCommands {
        if(num2 == 0) {
            throw new DivByZero();
        }
        context.getMyStack().push(num1 / num2);
    }
}

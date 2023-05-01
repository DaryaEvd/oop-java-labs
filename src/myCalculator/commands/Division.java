package myCalculator.commands;

import myCalculator.Context;

public class Division extends AbstractBinOperation {
    public Division(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void makeBinOperation(Double num1, Double num2) {
        context.getMyStack().push(num1 / num2);
    }
}

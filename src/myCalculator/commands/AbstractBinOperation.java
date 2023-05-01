package myCalculator.commands;

import myCalculator.Context;

public abstract class AbstractBinOperation extends AbstractCommand{
    public AbstractBinOperation(Context context, String[] arguments) {
        super(context, arguments);
    }

    public void makeBinOperation(Double num1, Double num2) {

    }

    @Override
    public void apply() {
       Double num1 = context.getMyStack().pop();
       Double num2 = context.getMyStack().pop();

       makeBinOperation(num1, num2);
    }
}

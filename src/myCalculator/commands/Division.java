package myCalculator.commands;

import myCalculator.Context;

public class Division extends AbstractBinOperation {
    public Division(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void makeBinOperation(Double num1, Double num2)  {

        if(num2 == 0) {
            System.out.println("Division by zero :(");
        }
        context.getMyStack().push(num1 / num2);
    }
}

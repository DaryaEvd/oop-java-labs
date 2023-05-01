package myCalculator.commands;

import myCalculator.Context;

public class Print extends AbstractCommand {

    public Print(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        Double resToPrint = context.getMyStack().peek();

        System.out.println(resToPrint);

    }
}

package myCalculator.commands;

import myCalculator.Context;

public class Print extends Command {

    public Print(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("it's print");

        Double resToPrint = context.getMyStack().peek();

        System.out.println(resToPrint);


    }
}

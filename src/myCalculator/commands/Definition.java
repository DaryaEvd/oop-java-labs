package myCalculator.commands;

import myCalculator.Context;

public class Definition extends Command {
    public Definition(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("It's definition");
        Double numberToDefine = (double) 0;

        numberToDefine = Double.parseDouble(arguments[2]);

        context.getVariable().put(arguments[1], numberToDefine);


    }
}

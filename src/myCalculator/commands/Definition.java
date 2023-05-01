package myCalculator.commands;

import myCalculator.Context;

public class Definition extends AbstractCommand {
    public Definition(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        Double numberToDefine = Double.parseDouble(arguments[2]);

        context.getVariable().put(arguments[1], numberToDefine);

    }
}

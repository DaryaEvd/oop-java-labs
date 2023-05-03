package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.BadAmountArgs;

public class Definition extends AbstractCommand {
    public Definition(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws BadAmountArgs {
        if(arguments.length != 3) {
            throw new BadAmountArgs("DEFINE");
        }

        Double numberToDefine = Double.parseDouble(arguments[2]);

        context.getVariable().put(arguments[1], numberToDefine);

    }
}

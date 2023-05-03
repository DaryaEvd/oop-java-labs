package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.BadAmountArgs;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.Redefinition;

public class Definition extends AbstractCommand {
    public Definition(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws ExceptionCommands {
        if(arguments.length != 3) {
            throw new BadAmountArgs("DEFINE");
        }

        Double numberToDefine = Double.parseDouble(arguments[2]);

        if(context.containsVar(arguments[1])) {
          throw new Redefinition(arguments[1]);
        }
        context.getVariable().put(arguments[1], numberToDefine);

    }
}

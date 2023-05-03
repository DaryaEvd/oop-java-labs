package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.BadAmountArgs;
import myCalculator.commands.exceptions.BadDefinition;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.Redefinition;

public class Definition extends AbstractCommand {
    public Definition(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws ExceptionCommands {
        if(arguments.length != 3) {
            throw new BadAmountArgs(arguments[0]);
        }
        Double numberToDefine = 0.0;
        try {
            numberToDefine = Double.parseDouble(arguments[2]);
        } catch (NumberFormatException e) {
            throw new BadDefinition();
        }

        if(context.containsVar(arguments[1])) {
          throw new Redefinition(arguments[1]);
        }
        context.getVariable().put(arguments[1], numberToDefine);

    }

}

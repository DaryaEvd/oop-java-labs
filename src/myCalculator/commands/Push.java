package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.UndefinedVariable;

public class Push extends AbstractCommand {
    public Push(Context context, String [] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws ExceptionCommands {
        if(context.containsVar(arguments[1])) {
            Double number = context.getVariable().get(arguments[1]);

            context.getMyStack().push(number);
        }
        else {

            if(isAlphabetical(arguments[1])) {
               throw new UndefinedVariable (arguments[1]);
            }

           Double number = Double.parseDouble(arguments[1]);
           context.getMyStack().push(number);
        }
    }
}

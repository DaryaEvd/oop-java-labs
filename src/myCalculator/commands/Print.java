package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.commands.exceptions.InsufficientArgsAmount;

public class Print extends AbstractCommand {

    public Print(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() throws ExceptionCommands {

        if(context.getMyStack().size() == 0) {
            throw new InsufficientArgsAmount();
        }
        Double resToPrint = context.getMyStack().peek();

        System.out.println(resToPrint);

    }
}

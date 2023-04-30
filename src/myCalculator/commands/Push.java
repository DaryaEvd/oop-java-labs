package myCalculator.commands;

import myCalculator.Context;
import myCalculator.commands.Command;

import java.util.List;

public class Push extends Command {
    public Push(Context context, String [] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("it's push");

        context.getMyStack().push()
    }
}

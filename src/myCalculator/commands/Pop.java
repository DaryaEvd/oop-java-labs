package myCalculator.commands;

import myCalculator.Context;

public class Pop extends AbstractCommand {
    public Pop(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        context.getMyStack().pop();
    }
}

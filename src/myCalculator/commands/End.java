package myCalculator.commands;

import myCalculator.Context;

public class End extends AbstractCommand {
    public End(Context context, String [] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("It's the end of computing");
    }

}

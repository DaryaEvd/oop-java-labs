package myCalculator.commands;

import myCalculator.Context;

public class Stop extends Command{
    public Stop(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("help pls oaoaoaoo");
    }
}

package myCalculator.commands;

import myCalculator.Context;

public class Comment extends Command {
    public Comment(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.println("it's comment");
    }
}

package myCalculator.commands;

import myCalculator.Context;

import java.util.Arrays;

public class Comment extends AbstractCommand {
    public Comment(Context context, String[] arguments) {
        super(context, arguments);
    }

    @Override
    public void apply() {
        System.out.print("it's my stack: ");

        System.out.println(Arrays.toString(context.getMyStack().toArray()));

    }
}

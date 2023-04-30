package myCalculator.commands;

import myCalculator.commands.Command;

public class Comment implements Command {
    @Override
    public void apply() {
        System.out.println("it's comment");
    }
}

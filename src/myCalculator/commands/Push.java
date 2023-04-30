package myCalculator.commands;

import myCalculator.commands.Command;

public class Push implements Command {
    @Override
    public void apply() {
        System.out.println("it's push");
    }
}

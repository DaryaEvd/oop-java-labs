package myCalculator.commands;

import myCalculator.commands.Command;

public class Subtraction implements Command {
    @Override
    public void apply() {
        System.out.println("It's Subtraction");
    }
}

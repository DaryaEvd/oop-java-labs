package myCalculator.commands;

import myCalculator.commands.Command;

public class Sqrt implements Command {
    @Override
    public void apply() {
        System.out.println("It's sqrt");
    }
}

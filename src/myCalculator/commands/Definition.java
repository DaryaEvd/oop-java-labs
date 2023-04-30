package myCalculator.commands;

import myCalculator.commands.Command;

public class Definition implements Command {
    @Override
    public void apply() {
        System.out.println("It's definition");
    }
}

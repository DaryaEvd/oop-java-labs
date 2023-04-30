package myCalculator.commands;

import myCalculator.commands.Command;

public class Multiplication implements Command {

    @Override
    public void apply() {
        System.out.println("it's multiplication");
    }
}

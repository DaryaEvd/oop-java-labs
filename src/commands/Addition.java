package commands;

public class Addition implements Command {

    @Override
    public void apply() {
        System.out.println("it's addition");
    }
}

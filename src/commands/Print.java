package commands;

public class Print implements Command{

    @Override
    public void apply() {
        System.out.println("it's print");
    }
}

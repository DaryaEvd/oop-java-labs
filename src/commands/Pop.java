package commands;

public class Pop implements Command{
    @Override
    public void apply() {
        System.out.println("it's pop");
    }
}

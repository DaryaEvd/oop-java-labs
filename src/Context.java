import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Context {
    Stack<Double> myStack;
    Map<String, Double> variables;

    public Context() {
        myStack = new Stack<>();
        variables = new HashMap<>();
    }

}

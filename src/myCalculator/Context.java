package myCalculator;

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

    public Stack<Double> getMyStack() {
        return myStack;
    }

    public Double getVariable(String currVar) {
        if(!variables.containsKey(currVar)) {
            System.out.println("No var in map");
            //TODO: add exception
        }
        return variables.get(currVar);
    }
}

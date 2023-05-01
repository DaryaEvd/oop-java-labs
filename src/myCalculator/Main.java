package myCalculator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Calculator calculator;

        if (args.length != 0) {
            System.out.println("I have a file");
            String inputPathExpression = args[0];
            calculator = new Calculator(inputPathExpression);
        } else {
            calculator = new Calculator();
        }

        calculator.calculate();
    }
}
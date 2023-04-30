package myCalculator;

public class Main {
    public static void main(String[] args)  {
        Factory.Calculator calculator;

        if (args.length != 0) {
            String inputPathExpression = args[0];
            calculator = new Factory.Calculator(inputPathExpression);
        } else {
            calculator = new Factory.Calculator();
        }

        calculator.calculate();
    }
}
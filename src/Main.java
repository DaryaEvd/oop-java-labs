
public class Main {
    public static void main(String[] args)  {
        Calculator calculator;

        if (args.length != 0) {
            String inputPathExpression = args[0];
            calculator = new Calculator(inputPathExpression);
        } else {
            calculator = new Calculator();
        }

        calculator.calculate();
    }
}
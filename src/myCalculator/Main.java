package myCalculator;

import java.util.logging.*;

public class Main {

    private static final Logger logger = Logger.getLogger("MyLog");

    public static void main(String[] args) {
        logger.setUseParentHandlers(false);

        Calculator calculator;

        FileHandler fh;
        try {
            fh = new FileHandler("/home/dasha/IdeaProjects/task2/myLog/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info("Logger initialized");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception :: ", e);
        }

        if(args.length > 1) {
            logger.log(Level.WARNING, "Too many args");
        }
        else {
            if (args.length != 0) {
                String inputPathExpression = args[0];
                calculator = new Calculator(inputPathExpression);
            } else {
                calculator = new Calculator();
            }

            calculator.calculate();
        }

        logger.info("End of successful work");

    }
}
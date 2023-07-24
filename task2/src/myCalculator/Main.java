package myCalculator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        try {
            logManager.readConfiguration(new FileInputStream("myLog/logging.properties"));
            logger.log(Level.INFO, "Logger initialized");
        } catch (IOException e) {
//            throw new RuntimeException(e);
            logger.log(Level.SEVERE, "Can't load logging file :( ");
        }

        Calculator calculator;
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

            //use 'STOP' to stop computations
            calculator.calculate();
        }

        logger.log(Level.FINE, "End of successful work!");

    }
}
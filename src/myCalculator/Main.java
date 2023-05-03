package myCalculator;

//import java.util.logging.LogManager;
import myCalculator.commands.exceptions.ExceptionCommands;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class Main {

    private final static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Calculator calculator;

        FileHandler fh;
        try {
            fh = new FileHandler("/home/dasha/IdeaProjects/task2/src/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info("Logger initialized");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Exception :: ", e);
        }
//        try {
//            InputStream stream = Main.class.getClassLoader().
//                    getResourceAsStream("logging.properties");
//            LogManager.getLogManager().readConfiguration(stream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        LogManager logManager = LogManager.getLogManager();

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

        logger.log(Level.FINE, "Successful work");

    }
}
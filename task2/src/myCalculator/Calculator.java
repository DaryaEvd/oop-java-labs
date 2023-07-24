package myCalculator;
import myCalculator.commands.AbstractCommand;
import myCalculator.commands.exceptions.ExceptionCommands;
import myCalculator.exceptions.ExceptionsInputLine;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calculator {
    private final BufferedReader inputReader;

    private final Factory factory;

    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    public Calculator() {
        factory = new Factory();
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Calculator(String pathToFile) {
        factory = new Factory();
        try {
            inputReader = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(pathToFile))));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Input file not found");
            throw new RuntimeException(e);
        }
    }

    public void calculate() {
        logger.log(Level.INFO, "Start reading input");

        String readingStr;
        while (true) {
            try {
                if ((readingStr = inputReader.readLine()) == null) {
                    logger.log(Level.INFO, "The end of input");
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(readingStr.equals("STOP")) {
                logger.log(Level.FINE, "End of successful work!");
                return;
            }
            interpret(readingStr);

            logger.log(Level.INFO, "Stop reading input");
        }
    }

    public void interpret(String args) {
        String [] line = args.split(" ");

        try {
            AbstractCommand cmd = factory.registerCommand(line);
            assert cmd != null;
            cmd.apply();
        } catch (ExceptionCommands | ExceptionsInputLine e) {
            System.out.println(e.getMessage());
            logger.log(Level.WARNING, e.getMessage());
        }
        catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
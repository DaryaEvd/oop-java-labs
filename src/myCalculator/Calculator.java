package myCalculator;
import myCalculator.commands.AbstractCommand;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.System.exit;

public class Calculator {
    private final BufferedReader inputReader;

    private final Factory factory;

    public Calculator() {
        factory = new Factory();
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Calculator(String pathToFile) {
        factory = new Factory();
        try {
            inputReader = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(pathToFile))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculate()  {
        String readingStr;
        while (true) {
            try {
                if ((readingStr = inputReader.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(readingStr.equals("EXITCALC")) {
                return;
            }

            interpret(readingStr);
        }
    }

    public void interpret(String args) {
        String [] line = args.split(" ");

//        AbstractCommand cmd = null;
        try {
            AbstractCommand cmd = factory.registerCommand(line);
            assert cmd != null;
            cmd.apply();
        } catch (ClassNotFoundException e) {
            System.out.println("Class '" + args + "' not found in this calc");
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
//            System.out.println(e.getMessage());
            System.out.println("Cant find this cmd: " + args);

        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
            System.out.println(e.getMessage());
        }
    }
}
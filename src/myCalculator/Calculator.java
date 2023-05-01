package myCalculator;
import myCalculator.commands.AbstractCommand;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    public void calculate() throws IOException {
//        System.out.println("я кулькулатка");
        String readingStr;
//        try {
            while ((readingStr = inputReader.readLine()) != null ) {
//                String [] line = readingStr.split("\\s+");
//                System.out.println("line to interpret: " + Arrays.toString(line));
//                interpret(line);
                if(readingStr.equals("EXITCALC")) {
                    return;
                }

                try {
                    interpret(readingStr);
//                System.out.println("heheheh");
                }
                catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException |
                       InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

            }
//        }

    }

    public void interpret(String args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String [] line = args.split(" ");
        System.out.println("command (1st arg) is: " + line[0]);
        if(line.length > 1) {
            System.out.println("command (2nd arg) is: " + line[1]);
        }
        AbstractCommand cmd = factory.registerCommand(line);
        System.out.println("cmd is: " + cmd);
            cmd.apply();

//        System.out.println("i am interpret");
    }
}
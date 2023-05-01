package myCalculator;
import myCalculator.commands.Command;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private File output;
    private String currLine;
    private final BufferedReader inputReader;

    private final Context context;
    private final Factory factory;

    public Calculator() {
        context = new Context();
        factory = new Factory();
        inputReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Calculator(String pathToFile) {
        context = new Context();
        factory = new Factory();
        try {
            inputReader = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(pathToFile))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculate()  {
        System.out.println("я кулькулатка");
        String readingStr;
        try {
            while ((readingStr = inputReader.readLine()) != null ) {
//                String [] line = readingStr.split("\\s+");
//                System.out.println("line to interpret: " + Arrays.toString(line));
//                interpret(line);

                interpret(readingStr);
                System.out.println("heheheh");

            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void interpret(String args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String [] line = args.split(" ");
        System.out.println("command (1st arg) is: " + line[0]);
        if(line.length > 1) {
            System.out.println("command (2nd arg) is: " + line[1]);
        }
        Command cmd = factory.registerCommand(line);
//        System.out.println("cmd is: " + cmd);
        cmd.apply();
        System.out.println("i am interpret");
    }
}
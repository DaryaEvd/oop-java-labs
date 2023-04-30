package myCalculator;

import myCalculator.commands.Command;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Factory {
    private final Map<String, String> creatorsCmd;
    Command cmd;

    public Factory() {
        creatorsCmd = new HashMap<>();
        readCmdsFromFile();
    }
    private void readCmdsFromFile()  {
        String pathToInputExprFile = "myCalculator/commandContainer.txt";
//        InputStream test = Factory.class.getResourceAsStream(pathToInputExprFile);
//        assert test != null;
//        System.out.println("path:" + test);

        try (InputStream configFile = Factory.class.getResourceAsStream(pathToInputExprFile)) {
            assert configFile != null;
            try (InputStreamReader reader = new InputStreamReader(configFile);
                 BufferedReader buffRead = new BufferedReader(reader)) {
                   String currLine;
                   while((currLine = buffRead.readLine()) != null) {
                        String [] dataInCurrStr = currLine.split(" ");
//                       System.out.println(dataInCurrStr[0]);
//                       System.out.println(dataInCurrStr[1]);
                        creatorsCmd.put(dataInCurrStr[0], dataInCurrStr[1]);
                   }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("я фабрика");
    }
    public Command registerCommand(String cmdName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> currCmdClass = Class.forName("myCalculator.commands." + creatorsCmd.get(cmdName));

//        System.out.println("curr cmd to register is: " + "commands." + creatorsCmd.get(cmdName));

        if(currCmdClass.getDeclaredConstructor().newInstance() instanceof Command) {
           cmd = (Command) currCmdClass.getDeclaredConstructor().newInstance();
            System.out.println("declared cmd: " + cmd);
        }

        return cmd;
    }

    public static class Calculator {
        private File output;
        private String currLine;
        private final BufferedReader inputRader;

        private final Context context;
        private final Factory factory;

        public Calculator() {
            context = new Context();
            factory = new Factory();
            inputRader = new BufferedReader(new InputStreamReader(System.in));
        }

        public Calculator(String pathToFile) {
            context = new Context();
            factory = new Factory();
            try {
                inputRader = new BufferedReader(new InputStreamReader(Files.newInputStream(Path.of(pathToFile))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void calculate()  {
            System.out.println("я кулькулатка");
                    String readingStr;
            List<String> input;
            try {
                while ((readingStr = inputRader.readLine()) != null ) {
                    String [] line = readingStr.split("\\s+");
                    System.out.println("line to interpret: " + Arrays.toString(line));
                    interpret(line);
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

        public void interpret(String [] line) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            System.out.println("command (1st arg) is: " + line[0]);
            if(line.length > 1) {
                System.out.println("command (2nd arg) is: " + line[1]);
            }
            Command cmd = factory.registerCommand(line[0]);
    //        cmd.apply();
            System.out.println("i am interpret");
        }
    }
}

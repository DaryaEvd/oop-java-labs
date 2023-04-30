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
        String pathToInputExprFile = "commandContainer.txt";
        InputStream test = Factory.class.getResourceAsStream(pathToInputExprFile);
        assert test != null;
        System.out.println("path:" + test);

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
}

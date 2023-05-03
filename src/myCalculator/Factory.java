package myCalculator;

import myCalculator.commands.AbstractCommand;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Factory {
    private final Context context = new Context();

    private final Map<String, String> creatorsCmd;
    AbstractCommand cmd;

    public Factory() {
        creatorsCmd = new HashMap<>();
        readCmdsFromFile();
    }
    private void readCmdsFromFile()  {
        String pathToInputExprFile = "commandContainer.txt";
        InputStream test = Factory.class.getResourceAsStream(pathToInputExprFile);
        assert test != null;

        try (InputStream configFile = Factory.class.getResourceAsStream(pathToInputExprFile)) {
            assert configFile != null;
            try (InputStreamReader reader = new InputStreamReader(configFile);
                 BufferedReader buffRead = new BufferedReader(reader)) {
                   String currLine;
                   while((currLine = buffRead.readLine()) != null) {
                        String [] dataInCurrStr = currLine.split(" ");
                        creatorsCmd.put(dataInCurrStr[0], dataInCurrStr[1]);
                   }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public AbstractCommand registerCommand(String [] cmdName) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> currCmdClass = Class.forName(creatorsCmd.get(cmdName[0]));

        if(currCmdClass.getDeclaredConstructor(Context.class, cmdName.getClass()).
                newInstance(context, cmdName) instanceof AbstractCommand) {

           cmd = (AbstractCommand) currCmdClass.getDeclaredConstructor(Context.class, cmdName.getClass()).
                   newInstance(context, cmdName);
        }

        return cmd;
    }
}

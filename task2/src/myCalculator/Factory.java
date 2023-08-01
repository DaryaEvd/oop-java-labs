package myCalculator;

import myCalculator.commands.AbstractCommand;
import myCalculator.exceptions.NonExistingCommand;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factory {
    private final Context context = new Context();

    private final Map<String, String> creatorsCmd;
    AbstractCommand cmd;

    private static final Logger logger = Logger.getLogger(Calculator.class.getName());
    public Factory() {
        creatorsCmd = new HashMap<>();
        readCmdsFromFile();
    }
    private void readCmdsFromFile()  {
        logger.log(Level.INFO, "Start reading commands from file, containing them");

        String pathToInputExprFile = "commandContainer.txt";
        InputStream test = Factory.class.getResourceAsStream(pathToInputExprFile);
        assert test != null;

        logger.log(Level.INFO, "Start creating commands");
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
            logger.log(Level.SEVERE, "Can't find file with commands");
            throw new RuntimeException(e);
        }

        logger.log(Level.FINE, "Commands from file were registered");
    }

    public AbstractCommand registerCommand(String [] cmdName) throws
            InvocationTargetException, InstantiationException, IllegalAccessException {

        try {
            Class <?> currCmdClass = Class.forName(creatorsCmd.get(cmdName[0]));
            if(currCmdClass.getDeclaredConstructor(Context.class, cmdName.getClass()).
                    newInstance(context, cmdName) instanceof AbstractCommand) {

                cmd = (AbstractCommand) currCmdClass.getDeclaredConstructor(Context.class, cmdName.getClass()).
                        newInstance(context, cmdName);

                logger.log(Level.FINE, "Registered cmd '" + cmd + "'");
            }
        } catch (ClassNotFoundException | NoSuchMethodException | NullPointerException e) {
            throw new NonExistingCommand(cmdName[0]);
        }

        return cmd;
    }
}

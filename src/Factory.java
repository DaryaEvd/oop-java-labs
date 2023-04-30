import commands.Command;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Factory {
    private Map<String, String> creatorsCmd;
    Command cmd;

    public Factory() {
        creatorsCmd = new HashMap<>();
        readCmdsFromFile();
    }
    private void readCmdsFromFile()  {
        String pathToInputExprFile = "/home/dasha/IdeaProjects/task2/src/inputExpression.txt";
        try (InputStream configFile = Factory.class.getResourceAsStream(pathToInputExprFile)) {
            assert configFile != null;
            try (InputStreamReader reader = new InputStreamReader(configFile);
                 BufferedReader buffRead = new BufferedReader(reader)) {
                {
                   List<String> listOfCmds = new ArrayList<>();
                   String currLine;
                   while((currLine = buffRead.readLine()) != null) {
                        String [] dataInCurrStr = currLine.split(" ");
                        creatorsCmd.put(dataInCurrStr[0], dataInCurrStr[1]);
                   }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Command registerCommand(String cmdName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> currCmdClass = Class.forName(creatorsCmd.get(cmdName));

        if(currCmdClass.getDeclaredConstructor().newInstance() instanceof Command) {
           cmd = (Command) currCmdClass.getDeclaredConstructor().newInstance();
        }

        return cmd;
    }

}

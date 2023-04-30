import commands.Command;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.*;

public class Factory {
    private final Map<String, String> creatorsCmd;

    public Factory() {
        creatorsCmd = new HashMap<>();
        readCmdsFromFile();
    }
    private void readCmdsFromFile()  {
        String pathToInputExprFile = "commandContainer.txt";
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
//    public Command registerCommand(String cmdName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class<?> currCmdClass = Class.forName(creatorsCmd.get(cmdName));
//
////        if(currCmdClass.getDeclaredConstructor().newInstance() instanceof Command) {
////           cmd = (Command) currCmdClass.getDeclaredConstructor().newInstance();
////        }
////
////        return cmd;
//
//
//    }

}

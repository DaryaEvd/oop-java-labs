import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length != 0) {
            String inputExpr = args[0];
            parseArgsFromTextFile(inputExpr);
        }

    }

    static boolean checkIsNumber(String stringToCheck) {
        try { Double number = Double.parseDouble(stringToCheck); }
        catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    static boolean checkIsCommand(String stringToCheck) {

    }

    private static void parseArgsFromTextFile(String inputExpr) throws IOException {
        try(Reader input = new FileReader(inputExpr);
            BufferedReader bufferedReader = new BufferedReader(input)) {
           String currString;
           String [] dataInCurrString;

           while((currString = bufferedReader.readLine()) != null) {
              dataInCurrString = currString.split(" ");
              for(int i = 0; i < dataInCurrString.length; i++) {
                  if(checkIsNumber(dataInCurrString[i])) {

                  }
                  else if(checkIsCommand(dataInCurrString[i])) {

                  }
                  else {
                      System.out.println("bad input"); //TODO: add exception
                  }
              }
           }
        }
    }
}
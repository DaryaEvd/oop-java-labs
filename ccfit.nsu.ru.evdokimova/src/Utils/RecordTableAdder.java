package Utils;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecordTableAdder {
    private static final Logger logger = Logger.getLogger(RecordTableAdder.class.getName());
    String name;
    public void addRecordToTable(int score) {
        name = JOptionPane.showInputDialog(null, "Enter your name");

        do {
            if(!isValidInputFromUser(name)) {
                JOptionPane.showMessageDialog(null, "Your input is bad. Try again");
                logger.log(Level.WARNING, "Name input is bad");
            }
            name = JOptionPane.showInputDialog(null, "Enter your name");
        } while(!isValidInputFromUser(name));

        logger.log(Level.INFO, "Name entered");
        String newRecord = name + " " + score + "\n";
        new MyWriter("./ccfit.nsu.ru.evdokimova/src/Files/leaders.txt")
                .writeFile(newRecord);
    }

    private boolean isValidInputFromUser(String input) {
        return isValidAmountOfSpaces(input) && isValidAmountOfSymbols(input) && !input.isBlank();
    }

    private boolean isValidAmountOfSymbols(String input) {
        return input.length() <= 20;
    }

    private boolean isValidAmountOfSpaces(String input) {
        int amountSpaces = 0;
        for(int i = 0; i < input.length(); i++){
            if(Character.isWhitespace(input.charAt(i))) {
                amountSpaces++;
            }
        }
        return amountSpaces == 0;
    }
}

package Utils;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecordTableAdder {
    private static final Logger logger = Logger.getLogger(RecordTableAdder.class.getName());

    public void addRecordToTable(RecordTableAdder table, int score) {
        String name = JOptionPane.showInputDialog("Enter your name");
        logger.log(Level.INFO, "Name entered");
        String newRecord = name + " " + score + "\n";
        new MyWriter("./ccfit.nsu.ru.evdokimova/src/Files/leaders.txt")
                .writeFile(newRecord);
    }
}

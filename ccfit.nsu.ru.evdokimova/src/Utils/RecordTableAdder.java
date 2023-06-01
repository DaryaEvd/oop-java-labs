package Utils;

import javax.swing.*;

public class RecordTableAdder {
    public void addRecordToTable(RecordTableAdder table, int score) {
        String name = JOptionPane.showInputDialog("Enter your name");
        String newRecord = name + " " + score + "\n";
        new MyWriter("/home/dasha/IdeaProjects/task3/ccfit.nsu.ru.evdokimova/src/Files/leaders.txt")
                .writeFile(newRecord);
    }
}

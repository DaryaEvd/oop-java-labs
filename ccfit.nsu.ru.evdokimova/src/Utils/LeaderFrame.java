package Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeaderFrame extends JFrame {

    private DefaultTableModel tableModel;

    public LeaderFrame(File filename) {
        setTitle("clown");

        setSize(new Dimension(300, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        initModel(filename);

        JTable leaderTable = new JTable(tableModel);
        add(leaderTable);

        setVisible(true);
    }

    public void initModel(File filename) {
        tableModel = new DefaultTableModel();

        tableModel.addColumn("Name");
        tableModel.addColumn("Scores");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                tableModel.addRow(new Object[]{parts[0], parts[1]});
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

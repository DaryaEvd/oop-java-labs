package Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

public class LeaderFrame extends JFrame {

    private DefaultTableModel tableModel;

    public LeaderFrame(File filename) {
        setTitle("Records Table");

        setSize(new Dimension(300, 600));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initModel(filename);

        JTable leaderTable = new JTable(tableModel);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
        sorter.setComparator(1, Comparator.naturalOrder());
        leaderTable.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(leaderTable);
        getContentPane().add(scrollPane);
        pack();

        setLocationRelativeTo(null);
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

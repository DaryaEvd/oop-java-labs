package Utils;

import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeaderFrame  {

    private DefaultTableModel tableModel;

    public LeaderFrame(File filename) {
////        setTitle("Records Table");
//
//        setSize(new Dimension(300, 600));
////        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//        initModel(filename);
//        JTable leaderTable = new JTable(tableModel);
//
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tableModel);
//        sorter.setComparator(1, Comparator.naturalOrder());
//        leaderTable.setRowSorter(sorter);
//
//        JScrollPane scrollPane = new JScrollPane(leaderTable);
////        getContentPane().add(scrollPane);
//
//        add(scrollPane);
//
////        setLocationRelativeTo(null);
//
//        setVisible(true);
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

                String name = parts[0];
                int score = Integer.parseInt(parts[1]);
                tableModel.addRow((new Object[] {name, score}));
                //                tableModel.addRow(new Object[]{parts[0], parts[1]});
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

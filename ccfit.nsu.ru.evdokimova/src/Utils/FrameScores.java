package Utils;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrameScores extends JFrame {

    private static final Logger logger = Logger.getLogger((FrameScores.class.getName()));

    JPanel scoresPanel;

    HashMap<String, Integer> storeByFrequency;

    HashMap<String, Integer> sortedByFrequency;

    public FrameScores(File filename) {
        super("Hight Scores");

        scoresPanel = new JPanel();
        scoresPanel.setLayout(new BoxLayout(scoresPanel, BoxLayout.Y_AXIS));

        sortedByFrequency = new HashMap<>();

        writeToPanel(filename);
        logger.log(Level.INFO, "Writed to panel");

        this.setSize(300, 690);
        this.add(scoresPanel, BorderLayout.CENTER);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    private void writeToPanel(File filename) {
        try(Reader input = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(input)) {
            String currString;
            String[] arrayOfAllStrings;

            while ((currString = bufferedReader.readLine()) != null) {
                arrayOfAllStrings = currString.split("\n");
                for (String currLine : arrayOfAllStrings) {
                    JLabel line = new JLabel();
                    line.setFont(new Font("Serif", Font.BOLD, 20));
                    line.setText(currLine);

                    scoresPanel.add(line);
                    scoresPanel.setVisible(true);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

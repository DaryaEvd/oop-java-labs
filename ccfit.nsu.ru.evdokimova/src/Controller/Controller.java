package Controller;

import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements ActionListener {
    private static final Logger logger = Logger.getLogger((Controller.class.getName()));

    Model model;
    public Controller(Model model) {
        this.model = model;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Exit")) {
            logger.log(Level.INFO, "Clicked on 'Exit'");
            System.exit(0);
        }
        else if(e.getActionCommand().equals("About")) {
            logger.log(Level.INFO, "Clicked on 'About'");

            UIManager.put("OptionPane.minimumSize", new Dimension(300, 300));

            ArrayList<String> allText = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("./ccfit.nsu.ru.evdokimova/src/Files/about.txt"))) {
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    allText.add(line);
                }
                JOptionPane.showMessageDialog(null, allText.toString()
                        .replace("[", "").replace("]", "")
                        .replace(", ", System.lineSeparator())
                    );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
        else if(e.getActionCommand().equals("NewGame")) {
            logger.log(Level.INFO, "Clicked on 'NewGame'");

        }
        else if(e.getActionCommand().equals("Scores")) {
            logger.log(Level.INFO, "Clicked on 'Scores'");
        }
        else if(e.getActionCommand().equals("Pause")) {
            logger.log(Level.INFO, "Clicked on 'Pause'");
        }
    }
}

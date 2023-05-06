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

public class Controller implements ActionListener {
    Model model;
    public Controller(Model model) {
        this.model = model;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
        else if(e.getActionCommand().equals("About")) {
            System.out.println("about");
            UIManager.put("OptionPane.minimumSize", new Dimension(300, 300));

            ArrayList<String> allText = new ArrayList<String>();
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
        else if(e.getActionCommand().equals("New Game")) {
            System.out.println("new gamee");
        }
        else if(e.getActionCommand().equals("Hight Scores")) {
            System.out.println("scores");
        }
        else if(e.getActionCommand().equals("Pause")) {
            System.out.println("Pause");
        }
    }
}

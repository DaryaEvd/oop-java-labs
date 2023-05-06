package Controller;

import Model.Model;
import View.AboutPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    Model model;
    public Controller(Model model) {
        this.model = model;
    }

    JPanel aboutPanel = new AboutPanel(100, 100);

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
        else if(e.getActionCommand().equals("About")) {
            System.out.println("about");
            AboutPanel panel = new AboutPanel(100, 100);
            panel.showMsg();

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

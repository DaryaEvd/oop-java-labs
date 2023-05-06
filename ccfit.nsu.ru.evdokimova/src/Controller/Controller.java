package Controller;

import Model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    Model model;
    public Controller(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand() == "Exit") {
            System.exit(0);
        }
        else if(e.getActionCommand() == "About") {
            System.out.println("sadkfjaksdfjaskdfjas");
        }
    }
}

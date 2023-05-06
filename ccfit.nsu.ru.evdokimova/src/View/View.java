package View;

import Controller.Controller;
import Model.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class View {
    private Model model;

    private Controller controller;
    public View(Model model, Controller controller) {
        this.model = model;
//        this.controller = controller;
//        this.eventListener = eventListener;
        this.controller = controller;
        createGUI();
    }
//    public View() {
//       createGUI();
//
//    }

    private void createGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Tetris game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 700);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);

        Container containerWithButtons = frame.getContentPane();
        containerWithButtons.setLayout(new FlowLayout());
        addButtonsToContainer(containerWithButtons);

        frame.setVisible(true);

    }

    private void addButtonsToContainer(Container containerWithButtons) {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(controller);
        containerWithButtons.add(exitButton);

        JButton aboutButton = new JButton("About");
        aboutButton.addActionListener(controller);
        containerWithButtons.add(aboutButton);

        JButton newGameButton = new JButton("New Game");
        containerWithButtons.add(newGameButton);

        JButton hightScoresButton = new JButton("Hight Scores");
        containerWithButtons.add(hightScoresButton);

        JButton pauseButton = new JButton("Pause");
        containerWithButtons.add(pauseButton);

        exitButton.setPreferredSize(hightScoresButton.getPreferredSize());
        aboutButton.setPreferredSize(hightScoresButton.getPreferredSize());
        newGameButton.setPreferredSize(hightScoresButton.getPreferredSize());
        pauseButton.setPreferredSize(hightScoresButton.getPreferredSize());
    }

}

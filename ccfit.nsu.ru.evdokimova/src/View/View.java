package View;

import Controller.Controller;
import Model.Model;

import javax.swing.*;
import java.awt.*;


public class View {
    private Model model;
    private Controller controller;

    public View(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;
        createGUI();
    }
//    public View() {
//       createGUI();
//
//    }

    private final JFrame frame = new JFrame();

    private void createGUI() {
        initFrame(frame);

        Container containerWithButtons = frame.getContentPane();
        containerWithButtons.setLayout(new FlowLayout());
        addButtonsToContainer(containerWithButtons);

        frame.setVisible(true);
    }

    private void initFrame(JFrame frame) {
        frame.setTitle("Tetris game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 700);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
    }

    private void addButtonsToContainer(Container containerWithButtons) {
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(controller);
        containerWithButtons.add(exitButton);

        JButton aboutButton = new JButton("About");
        aboutButton.addActionListener(controller);
        containerWithButtons.add(aboutButton);

        JButton newGameButton = new JButton("NewGame");
        newGameButton.addActionListener(controller);
        containerWithButtons.add(newGameButton);

        JButton hightScoresButton = new JButton("Scores");
        hightScoresButton.addActionListener(controller);
        containerWithButtons.add(hightScoresButton);

        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(controller);
        containerWithButtons.add(pauseButton);

//        exitButton.setPreferredSize(newGameButton.getPreferredSize());
//        aboutButton.setPreferredSize(newGameButton.getPreferredSize());
//        hightScoresButton.setPreferredSize(newGameButton.getPreferredSize());
//        pauseButton.setPreferredSize(newGameButton.getPreferredSize());
    }

}

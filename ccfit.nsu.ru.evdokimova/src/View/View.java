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

        JMenuBar menuBar = new JMenuBar();
        JMenu hehe = new JMenu("hehehe");

        menuBar.add(hehe);
        frame.setJMenuBar(menuBar);

//        Container containerWithButtons = frame.getContentPane();
//        containerWithButtons.setLayout(new FlowLayout());
//        addButtonsToContainer(containerWithButtons);
//
//        JPanel fieldOfGame = new JPanel();
//        initFieldsGame(fieldOfGame);
//
//        frame.add(fieldOfGame);

        frame.setVisible(true);
    }

    private void initFieldsGame(JPanel fieldOfGame) {
        fieldOfGame.setSize(300, 300);
//        fieldOfGame.setLocale(null);
        fieldOfGame.setBorder(BorderFactory.createLineBorder(Color.RED));
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

    }

}

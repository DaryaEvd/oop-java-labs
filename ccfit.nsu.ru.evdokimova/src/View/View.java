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
        initMenuBar(menuBar);
//        JMenu hehe = new JMenu("hehehe");
//
//        menuBar.add(hehe);
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

    private void initMenuBar(JMenuBar menuBar) {
        JMenu exitButton = new JMenu("Exit");
        exitButton.addActionListener(controller);
        menuBar.add(exitButton);

        JMenu aboutButton = new JMenu("About");
        aboutButton.addActionListener(controller);
        menuBar.add(aboutButton);

        JMenu newGameButton = new JMenu("NewGame");
        newGameButton.addActionListener(controller);
        menuBar.add(newGameButton);

        JMenu hightScoresButton = new JMenu("Scores");
        hightScoresButton.addActionListener(controller);
        menuBar.add(hightScoresButton);

        JMenu pauseButton = new JMenu("Pause");
        pauseButton.addActionListener(controller);
        menuBar.add(pauseButton);
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


}

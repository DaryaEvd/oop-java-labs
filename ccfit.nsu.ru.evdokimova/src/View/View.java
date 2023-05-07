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
//        JMenuItem hehe = new JMenuItem("hehehe");
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
        JMenuItem exitButton = new JMenuItem("Exit");
        exitButton.addActionListener(controller);
        menuBar.add(exitButton);

        JMenuItem aboutButton = new JMenuItem("About");
        aboutButton.addActionListener(controller);
        menuBar.add(aboutButton);

        JMenuItem newGameButton = new JMenuItem("NewGame");
        newGameButton.addActionListener(controller);
        menuBar.add(newGameButton);

        JMenuItem hightScoresButton = new JMenuItem("Scores");
        hightScoresButton.addActionListener(controller);
        menuBar.add(hightScoresButton);

        JMenuItem pauseButton = new JMenuItem("Pause");
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

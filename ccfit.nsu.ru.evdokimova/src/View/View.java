package View;

import Controller.Controller;
import Model.Model;

import javax.swing.*;
import java.awt.*;


public class View {
    private Model model;
    private final Controller controller;

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
    private final JMenuBar menuBar = new JMenuBar();
//    private final JPanel fieldOfGame = new JPanel(new GridBagLayout());

    JPanel panelGame  = new JPanel();
    Field field;

    private void createGUI() {
        initFrame(frame);
        initMenuBar(menuBar);
        frame.setJMenuBar(menuBar);

//        field = new Field(24, 10);
//        frame.add(field);
       launchPanelGame();
        frame.add(panelGame);

        frame.setVisible(true);
    }

    private void launchPanelGame() {
       field = new Field(24, 10);
       field.setPreferredSize(new Dimension(10 * 4 , 10 * 5));
       panelGame.add(field);
    }

    private void initFrame(JFrame frame) {
        frame.setTitle("Tetris game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 700);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
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

}
package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.*;

public class View {
//    private Model model;
    private final Controller controller;

    public View( Controller controller) {
//        this.model = model;
        this.controller = controller;
        createGUI();
    }

//    public View() {
//       createGUI();
//
//    }

    private final JFrame frame = new JFrame();
    private final JMenuBar menuBar = new JMenuBar();

//    private Cell [][] cells;

    JLabel center = new JLabel("center clown", CENTER);
//    private DrawGame drawGame;
    private void createGUI() {
        initFrame(frame);

        initMenuBar(menuBar);
        frame.setJMenuBar(menuBar);

        center.setOpaque(true);
        center.setBackground(Color.BLACK);
        initLevoPravo();

//        cells = new Cell[Constants.GRID_COLUMNS][Constants.GRID_ROWS];

//        center.add(cells, BorderLayout.CENTER);

        initCells();

        frame.add(center, BorderLayout.CENTER);

        frame.setVisible(true);
    //        frame.add(center, BorderLayout.CENTER);
    }
    private void initCells() {
        for(int x = 0; x < Constants.GRID_COLUMNS; x++) {
            for(int y = 0; y < Constants.GRID_ROWS; y++) {
                Cell cells = new Cell(x, y);
                center.add(cells);
            }
        }
    }
    private void initLevoPravo() {
        JLabel levo = new JLabel("leviy clown", CENTER);
        levo.setOpaque(true);
        levo.setBackground(Color.red);
        frame.add(levo, BorderLayout.WEST);

        JLabel pravo = new JLabel("praviy clown", CENTER);
        pravo.setOpaque(true);
        pravo.setBackground(Color.ORANGE);
        frame.add(pravo, BorderLayout.EAST);
    }



    private void initFrame(JFrame frame) {
        frame.setTitle("Tetris game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 700);
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
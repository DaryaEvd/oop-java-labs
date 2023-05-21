package View;

import Controller.Controller;
import Model.Model;
import Model.Coord;
import Tetris.Observer;
import Tetris.Subject;
//import Model.Mapa;
//import Model.MovingFigure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.SwingConstants.*;

public class View implements Observer {
//    private Model model;
    private final Controller controller;
//    MovingFigure fly;

    public View(Controller controller, Model model) {
//        this.model = model;
        this.controller = controller;

        createGUI();

//        addFigure();

        frame.addKeyListener(new MyKeyListener());

//        MyTime myTime = new MyTime();
//        Timer timer = new Timer(300, myTime);
//        timer.start();
    }

    private Cell [][] boxes;


    private final JFrame frame = new JFrame();
    private final JMenuBar menuBar = new JMenuBar();

    JLabel center = new JLabel("center clown", CENTER);
//    private DrawGame drawGame;
    private void createGUI() {
        initFrame(frame);

        initMenuBar(menuBar);
        frame.setJMenuBar(menuBar);

        center.setOpaque(true);
        center.setBackground(Color.LIGHT_GRAY);
        center.setLayout(new GridLayout(Constants.GRID_ROWS,
                Constants.GRID_COLUMNS, 1, 1));
        initLevoPravo();

        boxes = new Cell[Constants.GRID_ROWS][Constants.GRID_COLUMNS]; //TODO:

        initCells();

        frame.add(center, BorderLayout.CENTER);

        frame.setVisible(true);
    }
    private void initCells() {
        for(int x = 0; x < Constants.GRID_ROWS; x++) {
            for(int y = 0; y < Constants.GRID_COLUMNS; y++) {
                boxes[x][y] = new Cell(x, y);
                center.add(boxes[x][y]);
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

    @Override
    public void update() {

    }

    @Override
    public void setSubject(Subject sub) {

    }


    class MyKeyListener extends KeyAdapter implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("KOOOOOOOOOOT");
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
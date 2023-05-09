package View;

import Controller.Controller;
import Model.Coord;
import Model.Figure;
import Model.MovingFigure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javax.swing.SwingConstants.*;

public class View {
//    private Model model;
    private final Controller controller;
    MovingFigure fly;

    public View( Controller controller) {
//        this.model = model;
        this.controller = controller;
        createGUI();

        addFigure();

        frame.addKeyListener(new MyKeyListener());
    }


    private Cell [][] boxes;

    public void addFigure() {
        fly = new MovingFigure();
//        figure = Figure.getRandomFigure();
//        coords = new Coord(9, 5);
        showFigure();
//        showFigure(figure, coords, 1);
    }

//    public View() {
//       createGUI(); //
//    }

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
//
    public void showFigure() {
        showFigure(1);
    }

    public void hideFihure() {
        showFigure(0);
    }
    private void showFigure(int color) {
        for(Coord coord : fly.getFigure().dots){
            setBoxColor(fly.getCoords().x + coord.x,
                    fly.getCoords().y + coord.y, color);
        }
    }
//
    void setBoxColor(int x, int y, int color) {
        if(x < 0 || x >= Constants.GRID_ROWS) {
        }
         if(y < 0 || y >= Constants.GRID_COLUMNS) {
        }
        else {
            boxes[x][y].setColor(color);
        }
    }
//
//    private void turnFigure() {
//        Figure rotated = figure.turnRight();
//        if(canMoveFigure(rotated,0, 0)) { //TODO: what?
//            figure = rotated;
//            return;
//        }
//        else if(canMoveFigure(rotated, 1, 0)) {
//            figure = rotated;
//            moveFigure(1, 0);
//        }
//        else if(canMoveFigure(rotated, -1, 0)) {
//            figure = rotated;
//            moveFigure(-1, 0);
//        }
//        else if(canMoveFigure(rotated, 0, -1)) {
//           figure = rotated;
//           moveFigure(0, -1);
//        }
////        figure = figure.turnRight();
//    }
//    private boolean canMoveFigure(Figure figure, int dx, int dy) {
//        if(coords.x + dx + figure.leftTop.x < 0) {
//            return false;
//        }
//
//        if(coords.x + dx + figure.bottom.x  >= Constants.GRID_ROWS) {
//            return false;
//        }
//
//        if(coords.y + dy + figure.leftTop.y < 0) {
//            return false;
//        }
//
//        if(coords.y + dy + figure.bottom.y >= Constants.GRID_COLUMNS) {
//            return false;
//        }
//
//        return true;
//
//    }
//
//    public void moveFigure(int dx, int dy) {
//        if(canMoveFigure(figure, dx, dy)) {
//            coords = coords.plus(dx, dy);
//        }
//    }

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


    class MyKeyListener extends KeyAdapter implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("KOOOOOOOOOOT");

            hideFihure();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> {
                     fly.moveFigure(0, -1);
                }
                case KeyEvent.VK_UP -> {
                    fly.moveFigure(-1, 0);
                }
                case KeyEvent.VK_RIGHT -> {
                    fly.moveFigure(0, 1);
                }
                case KeyEvent.VK_DOWN -> {
                    fly.moveFigure(1, 0);
                }
                case KeyEvent.VK_SPACE -> {
                    fly.turnFigure();
                }
                default -> {
//                    throw new IllegalStateException("Unexpected value: " + e.getKeyCode());
                }
            }
            showFigure();
//
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
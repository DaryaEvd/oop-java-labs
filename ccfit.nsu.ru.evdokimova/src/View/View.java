package View;

import Controller.Controller;
import Model.Coord;
import Model.Figure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import static javax.swing.SwingConstants.*;

public class View {
//    private Model model;
    private final Controller controller;

    public View( Controller controller) {
//        this.model = model;
        this.controller = controller;
        createGUI();

//        showFigure(Figure.I2, new Coord(5, 5));
//        showFigure(Figure.T4, new Coord(3, 4));
        addFigure();

    frame.addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("hahaha CLOOOOOOOOOOOOOOWN");
//            showFigure(Figure.I1, new Coord(5, 5), 0);
//            showFigure(Figure.I1, new Coord(5, 4), 1);
            hideFihure();
//            showFigure();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT -> {
//                    coords = new Coord(coords.x, coords.y - 1);
                    System.out.println("left");
                    moveFigure(0, -1);
                }
                case KeyEvent.VK_UP -> {
//                    coords = new Coord(coords.x - 1, coords.y);
                    moveFigure(-1, 0);
                }
                case KeyEvent.VK_RIGHT -> {
//                    coords = new Coord(coords.x, coords.y + 1);
                    moveFigure(0, 1);
                }
                case KeyEvent.VK_DOWN -> {
//                    coords = new Coord(coords.x + 1, coords.y );
                    moveFigure(1, 0);
                }

                default -> throw new IllegalStateException("Unexpected value: " + e.getKeyCode());
            }
            showFigure();
//            showFigure(figure, coords, 1);
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    });


//        addKeyListener(new KeyAdapter());
//        showFigure(Figure.I1, new Coord(5, 5), 1);

    }


    private Cell [][] boxes;
    private Figure figure;
    private Coord coords;

    public void addFigure() {
        figure = Figure.getRandomFigure();
        coords = new Coord(9, 5);
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

    public void showFigure() {
        showFigure(figure, coords, 1);
    }

    public void hideFihure() {
        showFigure(figure, coords, 0);
    }
    private void showFigure(Figure figure, Coord at, int color) {
        for(Coord coord : figure.dots){
            setBoxColor(at.x + coord.x , at.y + coord.y, color);
        }
    }

    void setBoxColor(int x, int y, int color) {
        if(x < 0 || x >= Constants.GRID_ROWS) {
        }
         if(y < 0 || y >= Constants.GRID_COLUMNS) {
        }
        else {
            boxes[x][y].setColor(color);
        }
    }

    private boolean canMoveFigure(int dx, int dy) {
        if(coords.x + dx + figure.leftTop.x < 0) {
            return false;
        }

        if(coords.x + dx + figure.bottom.x  >= Constants.GRID_ROWS) {
            return false;
        }

        if(coords.y + dy + figure.leftTop.y < 0) {
            return false;
        }

        if(coords.y + dy + figure.bottom.y >= Constants.GRID_COLUMNS) {
            return false;
        }

        return true;

        //TODO: think about signature
    }

    private void moveFigure(int dx, int dy) {
        if(canMoveFigure(dx, dy)) {
            coords = coords.plus(dx, dy);
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
    class KeyAdapter extends java.awt.event.KeyAdapter implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("KOOOOOOOOOOT");
//            showFigure(Figure.I1, new Coord(5, 5), 0);
//            showFigure(Figure.I1, new Coord(4, 5), 1);
//            showFigure(Figure.I2, new Coord(5, 5));
//            showFigure(Figure.T4, new Coord(3, 4));
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}
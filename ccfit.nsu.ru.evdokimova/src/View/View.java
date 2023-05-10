package View;

import Controller.Controller;
import Model.Coord;
import Model.Figure;
import Model.Mapa;
import Model.MovingFigure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.SwingConstants.*;

public class View implements Mapa {
//    private Model model;
    private final Controller controller;
    MovingFigure fly;

    public View( Controller controller) {
//        this.model = model;
        this.controller = controller;
        createGUI();

        addFigure();

        frame.addKeyListener(new MyKeyListener());

        MyTime myTime = new MyTime();
        Timer timer = new Timer(300, myTime);
        timer.start();
    }

    private Cell [][] boxes;


    public void addFigure() {
        fly = new MovingFigure(this);
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

    public int getBoxColor(int x, int y) {
        if(x < 0 || x >= Constants.GRID_ROWS) {
            return -1;
        }
        if(y < 0 || y >= Constants.GRID_COLUMNS) {
            return -1;
        }
        return boxes[x][y].getColor();
    }

    private void moveFly(int dx, int dy) {
       hideFihure();
       fly.moveFigure(dx, dy);
       showFigure();
    }

    private void turnFly(int direction) {
        hideFihure();
        fly.turnFigure(direction);
        showFigure();
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
//                     fly.moveFigure(0, -1);
                    moveFly(0, -1);
                }
                case KeyEvent.VK_RIGHT -> {
//                    fly.moveFigure(0, 1);
                    moveFly(0, 1);
                }
                case KeyEvent.VK_DOWN -> {
//                    fly.turnFigure(2);
//                    turnFly(2);
                    moveFly(1, 0);
                }
                case KeyEvent.VK_UP -> {
//                    fly.turnFigure(1);
                    turnFly(1);
                }
                case KeyEvent.VK_U -> {
//                    fly.moveFigure(-1, 0);
                    moveFly(-1, 0);
                }
//                case KeyEvent.VK_SPACE -> {
//                    fly.turnFigure();
//                }
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


    class MyTime implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
//            fly.moveFigure(0, 1);
            moveFly(1, 0);

            if(fly.isLanded()){

//                fly = new MovingFigure();
                showFigure(2);

                stripLines();

                addFigure();
            }
        }
    }

    public void stripLines() {
        for(int y = Constants.GRID_ROWS - 1; y >= 0; y--) {
            if(isFullLine(y)) {
                dropLine(y);
            }
        }
    }

    private void dropLine(int y) {
        for(int moveY = y - 1; moveY >= 0; moveY--) {
            for(int x = 0; x < Constants.GRID_COLUMNS; x++) {
                setBoxColor(x, moveY - 1, getBoxColor(x, moveY ));
            }
        }

        for(int x = 0; x < Constants.GRID_COLUMNS; x++) {
            setBoxColor(x, 0, 0);
        }
    }

    private boolean isFullLine(int y) {
        for(int x = 0; x < Constants.GRID_COLUMNS; x++) {
            if(getBoxColor(x, y) != 2) {
                return false;
            }
        }
        return true;
    }
}
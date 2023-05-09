package View;

import Controller.Controller;
import Model.Coord;
import Model.Figure;

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

        showFigure(Figure.I1, new Coord(5, 5));
//        showFigure(Figure.I2, new Coord(5, 5));
    }


//    public View() {
//       createGUI(); //
//    }

    private final JFrame frame = new JFrame();
    private final JMenuBar menuBar = new JMenuBar();

    private Cell [][] boxes;

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

        boxes = new Cell[Constants.GRID_COLUMNS][Constants.GRID_ROWS]; //TODO:

        initCells();

        frame.add(center, BorderLayout.CENTER);


        frame.setVisible(true);
    }
    private void initCells() {
        for(int x = 0; x < Constants.GRID_ROWS; x++) {
            for(int y = 0; y < Constants.GRID_COLUMNS; y++) {
                boxes[y][x] = new Cell(x, y);
                center.add(boxes[y][x]);
            }
        }

//        for(int x = 0; x < Constants.GRID_COLUMNS; x++) {
//            for(int y = 0; y < Constants.GRID_ROWS; y++) {
//                boxes[x][y] = new Cell(x, y);
//                center.add(boxes[x][y]);
//
//            }
//        }
    }

    public void showFigure(Figure figure, Coord at) {
        for(Coord coord : figure.dots){
            setBoxColor(at.x + coord.x , at.y + coord.y, 1);
        }
    }

    void setBoxColor(int x, int y, int color) {
        if(x < 0 || x >= Constants.GRID_COLUMNS) {
        }
        else if(y < 0 || y > Constants.GRID_ROWS) {
        }
        else {
            boxes[x][y].setColor(color);
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
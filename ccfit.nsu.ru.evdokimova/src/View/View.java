package View;

import Controller.Controller;
import Model.Model;
import Utils.ColorsConstants;
import Utils.Observer;
import Utils.RecordTableAdder;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View implements Runnable, Observer {
    private static final Logger logger = Logger.getLogger(View.class.getName());
    private final Model model;
    private final Controller controller;

    public final JFrame frame;

    private final GameField gameField;

    private final JMenuBar menuBar = new JMenuBar();

    private final JPanel scorePanel = new JPanel();

    private final JLabel scores = new JLabel();
    private final JPanel leftSide = new JPanel();

    public View(Model model, Controller controller) {
        this.model = model;
        this.controller = controller;

        frame = new JFrame();
        initFrame(frame);

        frame.addKeyListener(controller);
        gameField = new GameField();

        initMenuBar();
        initStatisticPanel();
        initLeftSide();
    }

    private void initFrame(JFrame frame) {
        frame.setTitle("Tetris game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 692);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);
    }

    private void initMenuBar() {
        menuBar.add(Box.createHorizontalGlue());

        JMenuItem exitButton = new JMenuItem();
        exitButton.setText("Exit");
        exitButton.setForeground(ColorsConstants.TEXT_COLOR_MENU);
        exitButton.addActionListener(controller);
        menuBar.add(exitButton);

        JMenuItem aboutButton = new JMenuItem();
        aboutButton.setText("About");
        aboutButton.setForeground(ColorsConstants.TEXT_COLOR_MENU);
        aboutButton.addActionListener(controller);
        menuBar.add(aboutButton);

        JMenuItem newGameButton = new JMenuItem();
        newGameButton.setText("New Game");
        newGameButton.setForeground(ColorsConstants.TEXT_COLOR_MENU);
        newGameButton.addActionListener(controller);
        menuBar.add(newGameButton);

        JMenuItem highScoresButton = new JMenuItem();
        highScoresButton.setText("Scores");
        highScoresButton.setForeground(ColorsConstants.TEXT_COLOR_MENU);
        highScoresButton.addActionListener(controller);
        menuBar.add(highScoresButton);

        JMenuItem pauseButton = new JMenuItem();
        pauseButton.setText("Pause");
        pauseButton.setForeground(ColorsConstants.TEXT_COLOR_MENU);
        pauseButton.addActionListener(controller);
        menuBar.add(pauseButton);

        JMenuItem continueButton = new JMenuItem( );
        continueButton.setText("Continue");
        continueButton.setForeground(ColorsConstants.TEXT_COLOR_MENU);
        continueButton.addActionListener(controller);
        menuBar.add(continueButton);
    }

    private void initStatisticPanel() {
        scorePanel.setPreferredSize(
                new Dimension(100, 692));
        scorePanel.setBackground(Color.LIGHT_GRAY);

        scores.setText("Score: " + model.getScores());
        scores.setForeground(Color.BLACK);
        scorePanel.add(scores);
    }

    private void initLeftSide() {
        leftSide.setPreferredSize(scorePanel.getPreferredSize());
        leftSide.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void updateEvent() {
        switch (model.getCurrState()) {
            case IN_GAME -> {
                gameField.updateCellsField(model.getGameField());
                scores.setText("Scores: " + model.getScores());
                logger.log(Level.INFO, "Continue game");
            }
            case IN_THE_END -> {
                JOptionPane.showMessageDialog(null, "That's end");
                RecordTableAdder table = new RecordTableAdder();
                table.addRecordToTable(model.getScores());
                model.initNewModel();
                logger.log(Level.INFO, "Finished game and started new");
            }
            case IN_PAUSE -> {
                logger.log(Level.INFO, "Game in pause");
            }
        }
    }

    @Override
    public void run() {
        frame.setJMenuBar(menuBar);

        frame.add(scorePanel, BorderLayout.EAST);
        frame.add(leftSide, BorderLayout.WEST);
        frame.add(gameField, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

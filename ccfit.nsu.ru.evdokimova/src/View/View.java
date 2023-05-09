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

    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();

//    private DrawGame drawGame;
    private void createGUI() {
        initFrame(frame);

        initMenuBar(menuBar);
        frame.setJMenuBar(menuBar);

//        drawGame = new DrawGame();
//        frame.add(drawGame);

//        panel.setSize(100, 400);
//        panel.setBackground(Color.BLUE);
//
//        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
//        frame.add(panel, BorderLayout.EAST);
//
//        panel2.setSize(100, 500);
//        panel2.setBackground(Color.YELLOW);
//
//        frame.add(panel2, BorderLayout.WEST);

        JLabel center = new JLabel("center clown", CENTER);
//        center.setSize(150, 600);
//        center.setPreferredSize(new Dimension(100, 400));
//        center.setHorizontalAlignment(CENTER);
        center.setOpaque(true);
        center.setBackground(Color.BLACK);
        frame.add(center, BorderLayout.CENTER);

        JLabel levo = new JLabel("leviy clown", CENTER);
        levo.setOpaque(true);
        levo.setBackground(Color.red);
        frame.add(levo, BorderLayout.WEST);

        JLabel pravo = new JLabel("praviy clown", CENTER);
        pravo.setOpaque(true);
        pravo.setBackground(Color.ORANGE);
        frame.add(pravo, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private void initFrame(JFrame frame) {
        frame.setTitle("Tetris game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(500, 700);
//        frame.setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
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
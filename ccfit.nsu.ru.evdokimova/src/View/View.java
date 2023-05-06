package View;

import javax.swing.*;
import java.awt.*;

public class View {
    public View() {
       createGUI();

    }

    private void createGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Tetris game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 700);
        frame.setResizable(false);

        frame.setLocationRelativeTo(null);

        Container containerWithButtons = frame.getContentPane();
        containerWithButtons.setLayout(new FlowLayout());
        addButtonsToContainer(containerWithButtons);


        frame.setVisible(true);

    }

    private void addButtonsToContainer(Container containerWithButtons) {
        JButton exitButton = new JButton("Exit");
        containerWithButtons.add(exitButton);

        JButton aboutButton = new JButton("About");
        containerWithButtons.add(aboutButton);

        JButton newGameButton = new JButton("New Game");
        containerWithButtons.add(newGameButton);

        JButton hightScoresButton = new JButton("Hight Scores");
        containerWithButtons.add(hightScoresButton);

        JButton pauseButton = new JButton("Pause");
        containerWithButtons.add(pauseButton);

        exitButton.setPreferredSize(hightScoresButton.getPreferredSize());
        aboutButton.setPreferredSize(hightScoresButton.getPreferredSize());
        newGameButton.setPreferredSize(hightScoresButton.getPreferredSize());
        pauseButton.setPreferredSize(hightScoresButton.getPreferredSize());
    }

}

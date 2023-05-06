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

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        addButtons(panel);

        frame.getContentPane().add(panel);

        frame.setVisible(true);

    }

    private void addButtons(JPanel panel) {
        JButton northButton = new JButton("North");
        panel.add(northButton, BorderLayout.NORTH);

        JButton button = new JButton("HAHAHA");
        panel.add(button, BorderLayout.SOUTH);
    }

}

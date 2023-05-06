package View;

import javax.swing.*;

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

        frame.setVisible(true);

    }

}

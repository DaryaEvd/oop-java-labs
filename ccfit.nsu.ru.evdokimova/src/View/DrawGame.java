package View;

import javax.swing.*;
import java.awt.*;

public class DrawGame extends JLabel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.ORANGE);

        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
              g.drawRect(i * 32, j * 32, 32, 32);
            }
        }

        repaint();
    }
}

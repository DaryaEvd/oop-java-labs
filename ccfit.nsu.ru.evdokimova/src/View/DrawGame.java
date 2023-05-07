package View;

import javax.swing.*;
import java.awt.*;

public class DrawGame extends JLabel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);

        for(int i = 0; i < Constants.GRID_COLUMNS; i++) {
            for (int j = 0; j < Constants.GRID_ROWS; j++) {
              g.drawRect(i * Constants.CELL_SIZE + Constants.OFFSET_X_AXIS,
                      j * Constants.CELL_SIZE + Constants.OFFSET_Y_AXIS,
                      Constants.CELL_SIZE, Constants.CELL_SIZE);
            }
        }

        repaint();
    }
}

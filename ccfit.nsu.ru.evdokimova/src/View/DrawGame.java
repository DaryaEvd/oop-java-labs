package View;

import Model.Conversion;
import Model.Game;

import javax.swing.*;
import java.awt.*;

public class DrawGame extends JLabel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Game.currBlock.getColor());
        for(int i = 0; i < Game.currBlock.getBounds()[Game.currBlock.getRotation()].length; i++) {
            for(int j = 0; j < Game.currBlock.getBounds()[Game.currBlock.getRotation()][i].length; j++) {
                if(Game.currBlock.getBounds()[Game.currBlock.getRotation()][i][j] == 1) {

                    g.fillRect(Conversion.cellToCoord(Game.currBlock.getX() + i),
                               Conversion.cellToCoord(Game.currBlock.getY() + j),
                            Constants.CELL_SIZE, Constants.CELL_SIZE);
                }
            }
        }

        g.setColor(Color.BLACK);
        for(int i = 0; i < Constants.GRID_COLUMNS; i++) {
            for (int j = 0; j < Constants.GRID_ROWS; j++) {
              g.drawRect(i * Constants.CELL_SIZE //+ Constants.OFFSET_X_AXIS
                      ,j * Constants.CELL_SIZE //+ Constants.OFFSET_Y_AXIS
                      ,Constants.CELL_SIZE, Constants.CELL_SIZE);
            }
        }

        repaint();
    }
}

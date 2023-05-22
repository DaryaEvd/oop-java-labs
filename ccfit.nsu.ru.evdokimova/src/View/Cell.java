package View;

import Model.Figures.S;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    private int color;
    public int getColor() {
        return color;
    }
    public Cell(int x, int y) {
//        color = 0;
        setBounds(x * Constants.CELL_SIZE, y * Constants.CELL_SIZE,
                Constants.CELL_SIZE, Constants.CELL_SIZE);
        setBackground(Constants.COLORS[0]);
    }

    public Color setColor(int numberColor) {
        switch (numberColor) {
            case ColorsConstants.I_COLOR -> {
                return Color.CYAN;
            }
            case ColorsConstants.J_COLOR -> {
                return Color.BLUE;
            }
            case ColorsConstants.L_COLOR -> {
                return Color.ORANGE;
            }
            case ColorsConstants.O_COLOR -> {
                return Color.YELLOW;
            }
            case ColorsConstants.S_COLOR -> {
                return Color.GREEN;
            }
            case ColorsConstants.T_COLOR -> {
                return Color.MAGENTA;
            }
            case ColorsConstants.Z_COLOR -> {
                return Color.RED;
            }
            default -> {
                return Color.WHITE;
            }

        }
    }
}

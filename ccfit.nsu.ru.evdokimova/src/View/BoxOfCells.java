package View;

import javax.swing.*;
import java.awt.*;

public class BoxOfCells extends JPanel {
    public BoxOfCells(int x, int y) {
        setBounds(x * Constants.CELL_SIZE, y * Constants.CELL_SIZE,
                Constants.CELL_SIZE, Constants.CELL_SIZE);
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
    }
}

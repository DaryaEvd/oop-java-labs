package View;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    public Cell(int x, int y) {
        setBounds(x * Constants.CELL_SIZE, y * Constants.CELL_SIZE,
                    Constants.CELL_SIZE, Constants.CELL_SIZE);
        setBackground(Color.CYAN);
    }
}

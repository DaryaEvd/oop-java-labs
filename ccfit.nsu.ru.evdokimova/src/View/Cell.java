package View;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {
    public Cell() {
        this.setSize(Constants.CELL_SIZE, Constants.CELL_SIZE);

        this.setBackground(Color.ORANGE);
    }
}

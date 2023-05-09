package View;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {

    public Cell(int x, int y) {
        setBounds(x * Constants.CELL_SIZE, y * Constants.CELL_SIZE,
                Constants.CELL_SIZE, Constants.CELL_SIZE);
        setBackground(Color.BLACK);
    }

    public void setColor(int number) {
        if(number == 0) {
            setBackground(Color.YELLOW);
        }
        else {
            setBackground(Color.BLUE);
        }

    }
}

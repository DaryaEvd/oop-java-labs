package View;

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

    public void setColor(int numberColor) {
        this.color = numberColor;

        if(numberColor >= 0 && numberColor < Constants.COLORS.length) {
            setBackground(Constants.COLORS[numberColor]);
        }

//        if(numberColor == 0) {
////            setBackground(Color.YELLOW);
//            setBackground(Color.BLACK);
//        }
//        else {
//            setBackground(Color.BLUE);
//        }

    }
}

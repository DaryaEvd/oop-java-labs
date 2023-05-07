package View;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {

    private int girdRows;
    private int gridColumns;


    private Cell[][] boardGrid;

    public Field(int columns, int rows) {
       super(new GridLayout(columns, rows, 0, 0));

       this.gridColumns = columns;
       this.girdRows = rows;

       boardGrid = new Cell[24][10];
       for(int i = 0; i < boardGrid.length; i++) {
           for(int j = 0; j < boardGrid[i].length; j++) {
               boardGrid[i][j] = new Cell(Color.MAGENTA, 20);
               this.add(boardGrid[i][j]);
           }
       }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(0,0,50,50);
    }
}

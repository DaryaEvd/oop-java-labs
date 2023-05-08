package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GridField extends JPanel {

    private static final Logger logger = Logger.getLogger((Controller.class.getName()));

   private Cell[][] field;

   public GridField() {
       generateField();

       logger.log(Level.INFO, "Finished genrating field");
   }

    private void generateField() {
        logger.log(Level.INFO, "Generating gield ...");

       this.setSize(Constants.GRID_COLUMNS * Constants.CELL_SIZE
               , Constants.GRID_ROWS * Constants.CELL_SIZE);

       this.setLayout(new GridLayout(Constants.GRID_ROWS
               , Constants.GRID_COLUMNS
               , 1, 1
               ));

       field = new Cell[Constants.GRID_ROWS][Constants.GRID_COLUMNS];
       for(int row = 0; row < Constants.GRID_ROWS; row++) {
          for(int column = 0; column < Constants.GRID_COLUMNS; column++) {
              field[row][column] = new Cell();
              this.add(field[row][column]);
              setVisible(true);
          }
       }
    }
}

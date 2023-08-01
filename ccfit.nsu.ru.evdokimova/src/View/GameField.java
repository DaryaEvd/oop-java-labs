package View;

import Utils.ColorsConstants;
import Utils.Constants;

import javax.swing.*;
import java.awt.*;

public class GameField extends JPanel {

    private final Cell[][] cellsField;

    public GameField() {
        this.setSize(Constants.WIDTH * Constants.CELL_SIZE,
                Constants.HEIGHT * Constants.CELL_SIZE);
        this.setLayout(new GridLayout(
                Constants.HEIGHT, Constants.WIDTH, 1, 1));

        cellsField = new Cell[Constants.HEIGHT][Constants.WIDTH];
        for (int x = 0; x < Constants.HEIGHT; ++x) {
            for (int y = 0; y < Constants.WIDTH; ++y) {
                cellsField[x][y] = new Cell();
                this.add(cellsField[x][y]);
            }
        }
    }

    public void updateCellsField(Color[][] gameField) {
        for (int x = 4; x < Constants.ADDITIONAL_HEIGHT; ++x) {
            for (int y = 0; y < Constants.WIDTH; ++y) {
                cellsField[x - 4][y].setBackground(gameField[x][y]);
            }
        }
    }

    private static class Cell extends JPanel {
        public Cell () {
            this.setSize(Constants.CELL_SIZE, Constants.CELL_SIZE);
            this.setBackground(ColorsConstants.CELL_COLOR);
        }
    }

}

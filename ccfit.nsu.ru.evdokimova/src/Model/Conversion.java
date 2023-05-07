package Model;

import View.Constants;

public class Conversion {
    public static int cellToCoord(int cell) {
        return cell * Constants.CELL_SIZE;
    }
    public static int coordToCell(int coord) {
        return coord / Constants.CELL_SIZE;
    }
}

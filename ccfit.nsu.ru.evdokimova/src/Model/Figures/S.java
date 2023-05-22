package Model.Figures;

import Model.Coord;
import View.ColorsConstants;

import java.awt.*;
import java.util.ArrayList;

public class S extends Tetromino {
    public S() {
        colorOfFigure = ColorsConstants.S_COLOR;

        coordList = new ArrayList<>(4);
        coordList.add(new Coord(0, 1));
        coordList.add(new Coord(0, 2));
        coordList.add(new Coord(1, 0));
        coordList.add(new Coord(1, 1));
    }
}

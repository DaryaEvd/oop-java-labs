package Model.Figures;

import Model.Coord;
import View.ColorsConstants;

import java.awt.*;
import java.util.ArrayList;

public class I extends Tetromino {
    public I() {
        colorOfFigure = ColorsConstants.I_COLOR;

        coordList = new ArrayList<>(4);
        coordList.add(new Coord(2, 0));
        coordList.add(new Coord(2, 1));
        coordList.add(new Coord(2, 2));
        coordList.add(new Coord(2, 3));
    }
}

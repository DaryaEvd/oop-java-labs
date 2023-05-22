package Model.Figures;

import Model.Coord;
import View.ColorsConstants;

import java.awt.*;
import java.util.ArrayList;

public class J extends Tetromino {
    public J() {
        colorOfFigure = ColorsConstants.J_COLOR;

        coordList = new ArrayList<>(4);
        coordList.add(new Coord(0, 1));
        coordList.add(new Coord(1, 1));
        coordList.add(new Coord(2, 1));
        coordList.add(new Coord(0, 2));
    }
}

package Model.Figures;

import Model.Coord;

import java.awt.*;
import java.util.ArrayList;

public class L extends Tetromino {
    public L() {
        colorOfFigure = Color.ORANGE;

        coordList = new ArrayList<>(4);
        coordList.add(new Coord(0, 1));
        coordList.add(new Coord(1, 0));
        coordList.add(new Coord(2, 0));
        coordList.add(new Coord(2, 1));

    }
}

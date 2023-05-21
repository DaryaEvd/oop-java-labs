package Model.Figures;

import Model.Coord;

import java.awt.*;
import java.util.ArrayList;

public class T extends Tetromino {

    public T() {
        colorOfFigure = Color.MAGENTA;

        coordList = new ArrayList<>(4);
        coordList.add(new Coord(0, 0));
        coordList.add(new Coord(1, 1));
        coordList.add(new Coord(0, 2));
        coordList.add(new Coord(1, 1));
    }
}

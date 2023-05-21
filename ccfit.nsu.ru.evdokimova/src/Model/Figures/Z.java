package Model.Figures;

import Model.Coord;

import java.awt.*;
import java.util.ArrayList;

public class Z extends Tetromino {
    public Z() {
        colorOfFigure = Color.RED;

        coordList = new ArrayList<>(4);
        coordList.add(new Coord(0, 0));
        coordList.add(new Coord(0, 1));
        coordList.add(new Coord(1, 1));
        coordList.add(new Coord(1, 2));

    }
}

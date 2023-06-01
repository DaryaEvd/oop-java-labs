package Model.Figures;


import Utils.ColorsConstants;

import java.util.ArrayList;

import static Utils.Constants.CAPACITY_ARRAY;

public class O extends Tetromino {

    public O() {
        colorTetromino = ColorsConstants.O_COLOR;
        blockCoord = new Coordinates(1, 4);

        coordsList = new ArrayList<>(CAPACITY_ARRAY);
        coordsList.add(new Coordinates(1, 1));
        coordsList.add(new Coordinates(1, 2));
        coordsList.add(new Coordinates(2, 1));
        coordsList.add(new Coordinates(2, 2));
    }

    // аналогично I
    // в принципе пока её вообще можно и не поворачивать
    @Override
    protected Coordinates mapCoords(Coordinates curCoords) {
//        return new Coords(curCoords.getY(), -curCoords.getX() + 3);
        return curCoords;
    }
}
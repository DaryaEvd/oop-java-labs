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

    @Override
    protected Coordinates rotateCoords(Coordinates curCoords) {
        return curCoords;
    }
}
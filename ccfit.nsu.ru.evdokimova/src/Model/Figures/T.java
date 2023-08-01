package Model.Figures;


import Utils.ColorsConstants;

import java.util.ArrayList;

import static Utils.Constants.CAPACITY_ARRAY;

public class T extends Tetromino {
    public T() {
        colorTetromino = ColorsConstants.T_COLOR;
        blockCoord = new Coordinates(2, 4);

        coordsList = new ArrayList<>(CAPACITY_ARRAY);
        coordsList.add(new Coordinates(0, 1));
        coordsList.add(new Coordinates(1, 0));
        coordsList.add(new Coordinates(1, 1));
        coordsList.add(new Coordinates(1, 2));
    }

    @Override
    protected Coordinates rotateCoords(Coordinates curCoords) {
        return new Coordinates(curCoords.getY(), -curCoords.getX() + 2);
    }
}
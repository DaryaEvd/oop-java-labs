package Model.Figures;

import Utils.ColorsConstants;

import java.util.ArrayList;

import static Utils.Constants.CAPACITY_ARRAY;

public class I extends Tetromino {

    public I() {
        colorTetromino = ColorsConstants.I_COLOR;
        blockCoord = new Coordinates(1, 4);

        coordsList = new ArrayList<>(CAPACITY_ARRAY);
        coordsList.add(new Coordinates(2, 0));
        coordsList.add(new Coordinates(2, 1));
        coordsList.add(new Coordinates(2, 2));
        coordsList.add(new Coordinates(2, 3));
    }

    @Override
    protected Coordinates mapCoords(Coordinates curCoords) {
        return new Coordinates(curCoords.getY(), -curCoords.getX() + 3);
    }

}
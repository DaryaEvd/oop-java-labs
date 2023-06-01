package Model.Figures;

import Utils.ColorsConstants;

import java.util.ArrayList;

import static Utils.Constants.CAPACITY_ARRAY;

public class Z extends Tetromino {

    public Z() {
        colorTetromino = ColorsConstants.Z_COLOR;

        blockCoord = new Coordinates(2, 4);

        coordsList = new ArrayList<>(CAPACITY_ARRAY);
        coordsList.add(new Coordinates(1, 0));
        coordsList.add(new Coordinates(1, 1));
        coordsList.add(new Coordinates(2, 1));
        coordsList.add(new Coordinates(2, 2));
    }

    @Override
    protected Coordinates mapCoords(Coordinates curCoords) {
        return new Coordinates(curCoords.getY(), -curCoords.getX() + 2);
    }
}

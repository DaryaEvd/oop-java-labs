package Model.Figures;

import Utils.ColorsConstants;
import Utils.Constants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Tetromino {
    protected List<Coordinates> coordsList;
    protected Coordinates blockCoord;
    protected Color colorTetromino;
    private enum TetrominoType {
        I, J, L, O, S, T, Z
    }

    public static Tetromino generateNewFigure() {
        TetrominoType newFigureType = TetrominoType.values()
                                    [(int) (Math.random() * 7)];
        switch (newFigureType) {
            case J -> { return new J(); }
            case L -> { return new L(); }
            case O -> { return new O(); }
            case S -> { return new S(); }
            case T -> { return new T(); }
            case Z -> { return new Z(); }
            default -> { return new I(); }
        }
    }

    protected void clearFigure(Color[][] curGameField) {
        for (Coordinates square : coordsList) {
            curGameField[blockCoord.getX() + square.getX()][blockCoord.getY() + square.getY()]
                    = ColorsConstants.EMPTY_CELL;
        }
    }

    protected void drawNewFigurePlacement(Color[][] curGameField) {
        for (Coordinates square : coordsList) {
            curGameField[blockCoord.getX() + square.getX()]
                    [blockCoord.getY() + square.getY()] =
                        colorTetromino;
        }
    }

    protected abstract Coordinates mapCoords(Coordinates curCoords);

    public boolean rotateRight(Color[][] curGameField) {
        clearFigure(curGameField);
        boolean canRotateRight = true;

        List<Coordinates> newInBoxCoords = new ArrayList<>(4);
        for (Coordinates square : coordsList) {
            Coordinates mapped = mapCoords(square);
            if (blockCoord.getX() + mapped.getX() >= Constants.ADDITIONAL_HEIGHT ||
                    blockCoord.getY() + mapped.getY() >= Constants.WIDTH ||
                    blockCoord.getY() + mapped.getY() < 0 ||
                    !curGameField[blockCoord.getX() + mapped.getX()][blockCoord.getY() + mapped.getY()]
                            .equals(ColorsConstants.EMPTY_CELL)) {
                canRotateRight = false;
                break;
            } else {
                newInBoxCoords.add(mapped);
            }
        }

        if (canRotateRight) {
            coordsList = newInBoxCoords;
        }
        drawNewFigurePlacement(curGameField);

        return canRotateRight;
    }
    public boolean goDown(Color[][] curGameField) {
        clearFigure(curGameField);
        boolean canSlideDown = true;

        for (Coordinates square : coordsList) {
            if (blockCoord.getX() + square.getX() + 1 >= Constants.ADDITIONAL_HEIGHT ||
                    !curGameField[blockCoord.getX() + square.getX() + 1][blockCoord.getY() + square.getY()]
                            .equals(ColorsConstants.EMPTY_CELL)) {
                canSlideDown = false;
                break;
            }
        }

        if (canSlideDown) {
            blockCoord.setX(blockCoord.getX() + 1);
            blockCoord.setY(blockCoord.getY());
        }
        drawNewFigurePlacement(curGameField);
        return canSlideDown;
    }

    public boolean goLeft(Color[][] currField) {
        clearFigure(currField);
        boolean canMoveLeft = true;

        for (Coordinates square : coordsList) {
            if (blockCoord.getY() + square.getY() - 1 < 0 ||
                    !currField[blockCoord.getX() + square.getX()][blockCoord.getY() + square.getY() - 1]
                            .equals(ColorsConstants.EMPTY_CELL)) {
                canMoveLeft = false;
                break;
            }
        }

        if (canMoveLeft) {
            blockCoord.setX(blockCoord.getX());
            blockCoord.setY(blockCoord.getY() - 1);
        }
        drawNewFigurePlacement(currField);

        return canMoveLeft;
    }
    public boolean goRight(Color[][] currField) {
        clearFigure(currField);
        boolean canMoveRight = true;

        for (Coordinates square : coordsList) {
            if (blockCoord.getY() + square.getY() + 1 >= Constants.WIDTH ||
                    !currField[blockCoord.getX() + square.getX()]
                            [blockCoord.getY() + square.getY() + 1]
                            .equals(ColorsConstants.EMPTY_CELL)) {
                canMoveRight = false;
                break;
            }
        }

        if (canMoveRight) {
            blockCoord.setX(blockCoord.getX());
            blockCoord.setY(blockCoord.getY() + 1);
        }
        drawNewFigurePlacement(currField);

        return canMoveRight;
    }

    public List<Coordinates> getTetrominoCoordsFromField() {
        List<Coordinates> onFieldCoords = new ArrayList<>(4);
        for (Coordinates square : coordsList) {
            onFieldCoords.add(new Coordinates(blockCoord.getX() + square.getX(),
                    blockCoord.getY() + square.getY()));
        }
        return onFieldCoords;
    }
}

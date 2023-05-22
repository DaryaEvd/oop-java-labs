package Model.Figures;

import Model.Coord;

import java.awt.*;
import java.util.List;

public abstract class Tetromino {

    public int colorOfFigure;
    public List<Coord> coordList;

    public Coord blockCoord;

    private enum Figure {
        I, J, L, O, S, T, Z
    }

    public static Tetromino generateRandomFigure() {
        Figure figure = Figure.values()[(int) (Math.random() * 7)];
        switch (figure) {
            case I -> {
                return new I();
            }
            case J -> {
                return new J();
            }
            case L -> {
                return new L();
            }
            case O -> {
                return new O();
            }
            case S -> {
                return new S();
            }
            case T -> {
                return new T();
            }
            case Z -> {
                return new Z();
            }
            default -> {
                return null;
            } //or mb null idk
        }
    }

    public void clearFigure(int[][] currField) {
         for(Coord square : coordList ) {
            currField[blockCoord.getX() + square.getX()]
                    [blockCoord.getY() + square.getY()] =
                                colorOfFigure;
         }
    }

    public void drawNewFigurePlacement(int[][] currField) {
        for(Coord square : coordList) {
            currField[blockCoord.getX() + square.getX()]
                    [blockCoord.y + square.getY()] =
                        colorOfFigure;
        }
    }

    public boolean MoveLeft(int[][] currField) {
        clearFigure(currField);

        boolean canMoveLeft = true;

        for(Coord square : coordList) {
           if((((blockCoord.getY() + square.getY()) - 1) < 0) ||
                   (currField[blockCoord.getX() + square.getX()]
                           [blockCoord.getY() + square.getY() - 1] )
            != -1)     {
               canMoveLeft = false;
               break;
           }
        }

        return canMoveLeft;
    }


}

package Model.Figures;

import Model.Coord;
import View.Constants;

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

    public boolean moveLeft(int[][] currField) {
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

        if(canMoveLeft) {
            blockCoord.setX(blockCoord.getX());
            blockCoord.setY(blockCoord.getY() - 1);
        }

        drawNewFigurePlacement(currField);

        return canMoveLeft;
    }

    public boolean moveRight(int[][] currField) {
        clearFigure(currField);

        boolean canMoveRight = true;

        for(Coord squqre : coordList) {
           if(blockCoord.getY() + squqre.getY() + 1 >= Constants.GRID_COLUMNS ||
                currField[blockCoord.getX() + squqre.getX()]
                    [blockCoord.getY() + squqre.getX() + 1] != -1) {
               canMoveRight = false;
               break;
           }
        }

        if(canMoveRight) {
            blockCoord.setX(blockCoord.getX());
            blockCoord.setY(blockCoord.getY() + 1);
        }

        drawNewFigurePlacement(currField);

        return canMoveRight;
    }

    public boolean moveDown(int [][] currField) {
        clearFigure(currField);

        boolean canMoveDown = true;

        for(Coord square : coordList) {
            if(blockCoord.getX() + square.getX() + 1 >= Constants.GRID_ROWS ||
                currField[blockCoord.getX() + square.getX() + 1]
                        [blockCoord.getY() + square.getY()] != -1) {
                    canMoveDown = false;
                    break;
                }
        }
       if(canMoveDown) {
           blockCoord.setX(blockCoord.getX() + 1);
           blockCoord.setY(blockCoord.getY());
       }

       drawNewFigurePlacement(currField);

       return canMoveDown;
    }

}

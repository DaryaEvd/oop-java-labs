package Model.Figures;

import Model.Coord;

import java.awt.*;
import java.util.List;

public abstract class Tetromino {

    public Color colorOfFigure;
    public List<Coord> coordList;


    private enum Figure {
        I, J, L, O, S, T, Z
    }

    public static Tetromino generateRandomFigure() {
        Figure figure = Figure.values()[(int)(Math.random() * 7)];
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
            default -> {return new I();} //or mb null idk
        }

    }
}

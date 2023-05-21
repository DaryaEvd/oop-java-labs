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
//            case 1 -> J;
//            case 2 -> L;
//            case 3 -> O;
//            case 4 -> S;
//            case 5 -> T;
//            case 6 -> Z;
            default -> {return null;} //or mb null idk
        }

    }
}

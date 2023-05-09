package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

public enum Figure {
    I1 (0, 1,    1, 1,   2, 1,   3, 1) // oooo
    , I2 (  1, 0,
                    1, 1,
                    1, 2,
                    1, 3)
    , J1 (   1, 0,
                    1, 1,
            2, 0,   1, 2)
    , J2 ()
    , L, O, S, T, Z;

    private List<Coord> dot;

    Figure (int ... coords) {
        dot = new ArrayList<Coord>();
        for(int j = 0; j < coords.length; j += 2) {
            dot.add(new Coord(coords[j], coords[j + 1]));

        }
    }

    public Figure turnLeft() {
        System.out.println("left");
    }

    public Figure turnRight() {
        System.out.println("right");
    }
}

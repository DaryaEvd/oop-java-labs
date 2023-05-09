package Model;

public class Coord {
    public final int x;
    public final int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coord plus(int dx, int dy) {
        return new Coord(x + dx, y + dy);
    }
}

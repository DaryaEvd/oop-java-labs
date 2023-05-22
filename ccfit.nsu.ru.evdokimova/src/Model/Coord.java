package Model;

public class Coord {


    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
     public Coord plus(int dx, int dy) {
        return new Coord(x + dx, y + dy);
    }
}

package Model;

import View.Constants;
import View.View;

public class MovingFigure {
    private Figure figure;
    private Coord coords;

    private boolean landed = false;
    private int tics = 2;

    Mapa mapa;
    public boolean isLanded() {
        return landed;
    }

    public boolean canPlaceFigure() {
       return canMoveFigure(figure, 0, 0);
    }
    public MovingFigure(Mapa map) {
        this.mapa = map;
        figure = Figure.getRandomFigure();
        coords = new Coord( -figure.leftTop.y, Constants.GRID_COLUMNS / 2 - 2  );
         //TODO: mozhet bit '-figure.leftTop.y - figure.bottom.y - 1 ' ?

        landed = false;
    }

    public Figure getFigure() {
        return figure;
    }

    public Coord getCoords() {
        return coords;
    }

    public void turnFigure(int direction) {
        Figure rotated = direction == 1 ? figure.turnRight() : figure.turnLeft();

        if(canMoveFigure(rotated,0, 0)) { //TODO: what?
            figure = rotated;
            return;
        }
        else if(canMoveFigure(rotated, 1, 0)) {
            figure = rotated;
            moveFigure(1, 0);
        }
        else if(canMoveFigure(rotated, -1, 0)) {
            figure = rotated;
            moveFigure(-1, 0);
        }
        else if(canMoveFigure(rotated, 0, -1)) {
            figure = rotated;
            moveFigure(0, -1);
        }

//        figure = figure.turnRight();
    }
    private boolean canMoveFigure(Figure figure, int dx, int dy) {
        if(coords.x + dx + figure.leftTop.x < 0) {
            System.out.println("1");
            return false;
        }

        if(coords.x + dx + figure.bottom.x  >= Constants.GRID_ROWS) {
            System.out.println("2");
            return false;
        }

        if(coords.y + dy + figure.leftTop.y < 0) {
            System.out.println("3");
            return false;
        }

        if(coords.y + dy + figure.bottom.y >= Constants.GRID_COLUMNS) {
            System.out.println("4");
            return false;
        }

        for(Coord dot : figure.dots) {
            if(mapa.getBoxColor(coords.x + dot.x + dx,
                    coords.y + dot.y + dy) != 0) {
                System.out.println("ZDEC!!!");
               return false;
            }
        }

        return true;

    }

    public void moveFigure(int dx, int dy) {
        if(canMoveFigure(figure, dx, dy)) {
            coords = coords.plus(dx, dy);
        }

        else if (dx == 1) { // error was here dx = 0
           if(tics > 0) {
               tics--;
           }
           else{
               landed = true;
           }
        }
    }
}

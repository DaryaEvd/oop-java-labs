package Model;

import View.Constants;

public class MovingFigure {
    private Figure figure;
    private Coord coords;

    public MovingFigure() {
        figure = Figure.getRandomFigure();
        coords = new Coord( -figure.leftTop.y, Constants.GRID_COLUMNS / 2 - 2  );
         //TODO: mozhet bit '-figure.leftTop.y - figure.bottom.y - 1 ' ?
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
            return false;
        }

        if(coords.x + dx + figure.bottom.x  >= Constants.GRID_ROWS) {
            return false;
        }

        if(coords.y + dy + figure.leftTop.y < 0) {
            return false;
        }

        if(coords.y + dy + figure.bottom.y >= Constants.GRID_COLUMNS) {
            return false;
        }

        return true;

    }

    public void moveFigure(int dx, int dy) {
        if(canMoveFigure(figure, dx, dy)) {
            coords = coords.plus(dx, dy);
        }
    }
}

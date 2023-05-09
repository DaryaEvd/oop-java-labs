//package Model;
//
//import View.Constants;
//
//public class MovingFigure {
//
//    private Figure figure;
//    private Coord coords;
//
//
//    public void showFigure() {
//        showFigure(figure, coords, 1);
//    }
//
//    public void hideFihure() {
//        showFigure(figure, coords, 0);
//    }
//    private void showFigure(Figure figure, Coord at, int color) {
//        for(Coord coord : figure.dots){
//            setBoxColor(at.x + coord.x , at.y + coord.y, color);
//        }
//    }
//
//    void setBoxColor(int x, int y, int color) {
//        if(x < 0 || x >= Constants.GRID_ROWS) {
//        }
//        if(y < 0 || y >= Constants.GRID_COLUMNS) {
//        }
//        else {
//            boxes[x][y].setColor(color);
//        }
//    }
//
//    private void turnFigure() {
//        Figure rotated = figure.turnRight();
//        if(canMoveFigure(rotated,0, 0)) { //TODO: what?
//            figure = rotated;
//            return;
//        }
//        else if(canMoveFigure(rotated, 1, 0)) {
//            figure = rotated;
//            moveFigure(1, 0);
//        }
//        else if(canMoveFigure(rotated, -1, 0)) {
//            figure = rotated;
//            moveFigure(-1, 0);
//        }
//        else if(canMoveFigure(rotated, 0, -1)) {
//            figure = rotated;
//            moveFigure(0, -1);
//        }
////        figure = figure.turnRight();
//    }
//    private boolean canMoveFigure(Figure figure, int dx, int dy) {
//        if(coords.x + dx + figure.leftTop.x < 0) {
//            return false;
//        }
//
//        if(coords.x + dx + figure.bottom.x  >= Constants.GRID_ROWS) {
//            return false;
//        }
//
//        if(coords.y + dy + figure.leftTop.y < 0) {
//            return false;
//        }
//
//        if(coords.y + dy + figure.bottom.y >= Constants.GRID_COLUMNS) {
//            return false;
//        }
//
//        return true;
//
//    }
//
//    private void moveFigure(int dx, int dy) {
//        if(canMoveFigure(figure, dx, dy)) {
//            coords = coords.plus(dx, dy);
//        }
//    }
//
//}

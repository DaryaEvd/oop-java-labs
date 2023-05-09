package Model;

import View.Constants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovingFigure {
    private Figure figure;
    private Coord coords;

    public MovingFigure() {
        figure = Figure.getRandomFigure();
        coords = new Coord( -figure.leftTop.y, Constants.GRID_COLUMNS / 2 - 2);
    }

    public Figure getFigure() {
        return figure;
    }

    public Coord getCoords() {
        return coords;
    }



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

//    void setBoxColor(int x, int y, int color) {
//        if(x < 0 || x >= Constants.GRID_ROWS) {
//        }
//        if(y < 0 || y >= Constants.GRID_COLUMNS) {
//        }
//        else {
//            boxes[x][y].setColor(color);
//        }
//    }

    public void turnFigure() {
        Figure rotated = figure.turnRight();
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
//
//    class MyKeyListener extends KeyAdapter implements KeyListener {
//        @Override
//        public void keyTyped(KeyEvent e) {
//
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//            System.out.println("KOOOOOOOOOOT");
//
//            hideFihure();
//            switch (e.getKeyCode()) {
//                case KeyEvent.VK_LEFT -> {
//                    moveFigure(0, -1);
//                }
//                case KeyEvent.VK_UP -> {
//                    moveFigure(-1, 0);
//                }
//                case KeyEvent.VK_RIGHT -> {
//                    moveFigure(0, 1);
//                }
//                case KeyEvent.VK_DOWN -> {
//                    moveFigure(1, 0);
//                }
//                case KeyEvent.VK_SPACE -> {
//                    turnFigure();
//                }
//                default -> {
////                    throw new IllegalStateException("Unexpected value: " + e.getKeyCode());
//                }
//            }
//            showFigure();
////
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//
//        }
//    }

}

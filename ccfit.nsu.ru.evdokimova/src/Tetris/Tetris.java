package Tetris;

import Model.Coord;
import Model.Figure;
import View.View;
import Controller.Controller;

public class Tetris {
//    private final Model model;
    private final View view;
    private final Controller controller = new Controller();
    public Tetris() {
//        Game.currBlock = new Block();
//        Game.block.add(Game.currBlock);
//        Game.nextBlock= new Block();
//        this.model = new Model();
        this.view = new View(controller);

        view.showFigure(Figure.I1, new Coord(5, 5));
    }

    public void startGame() {

//        GameLoop loop = new GameLoop();
//        loop.start();
    }
}

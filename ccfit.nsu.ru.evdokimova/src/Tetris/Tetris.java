package Tetris;

import Model.Coord;
import Model.Figure;
import Model.Model;
import View.View;
import Controller.Controller;

public class Tetris {
    private final Model model;
    private final View view;
    private final Controller controller = new Controller();
    public Tetris() {
        /*
         model is subject
        and
         Views are observers that can register to get notified of any change to the model.

         */

//        Game.currBlock = new Block();
//        Game.block.add(Game.currBlock);
//        Game.nextBlock= new Block();
//        this.model = new Model();
        this.view = new View(controller);
        this.model = new Model();


//        view.showFigure(Figure.I1, new Coord(5, 5), 1);
    }

    public void startGame() {

//        GameLoop loop = new GameLoop();
//        loop.start();
    }
}

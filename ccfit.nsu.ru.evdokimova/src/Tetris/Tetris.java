package Tetris;

import Model.Coord;
import Model.Model;
import View.View;
import Controller.Controller;

public class Tetris {
    private  Model model;
    private  View view;
   private  Controller controller;
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

        model = new Model(); //независимая часть, которая ничего не знает ни о контроллере, ни о представлпени
        controller = new Controller(model); // точкой входа в программу является контроллер
        view = new View(controller, model);

        model.register(view);

//        view.showFigure(Figure.I1, new Coord(5, 5), 1);
    }

    public void startGame() {

//        GameLoop loop = new GameLoop();
//        loop.start();
    }
}

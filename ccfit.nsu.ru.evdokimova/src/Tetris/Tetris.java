package Tetris;

import Model.Block;
import Model.Game;
import Model.Model;
import Model.Model.*;
import View.View;
import Controller.Controller;

public class Tetris {
    private final Model model;
    private final View view;
    private final Controller controller = new Controller();
    public Tetris() {
//        Game.currBlock = new Block();
//        Game.block.add(Game.currBlock);
//        Game.nextBlock= new Block();
        this.model = new Model();
        this.view = new View( controller);
    }

    public void startGame() {

//        GameLoop loop = new GameLoop();
//        loop.start();
    }
}

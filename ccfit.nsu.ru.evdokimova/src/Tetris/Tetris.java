package Tetris;

import Model.Model;
import View.View;
import Controller.Controller;

public class Tetris {
    private final Model model = new Model();
    private final View view;
    private final Controller controller = new Controller(model);
    public Tetris() {
        this.view = new View(model, controller);
    }

    public void startGame() {
    }
}

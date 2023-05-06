package Tetris;

import Model.Model;
import View.View;
import Controller.Controller;

public class Tetris {
    private final Model model;
    private final View view;
    private final Controller controller;
    public Tetris() {
        this.model = new Model();
        this.view = new View();
        this.controller = new Controller();
    }

    public void startGame() {
    }
}

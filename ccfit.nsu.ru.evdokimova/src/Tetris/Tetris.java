package Tetris;

import Model.Coord;
import Model.Model;
import View.View;
import Controller.Controller;

import java.util.Timer;

public class Tetris {
    private  Model model;
    private  View view;
   private  Controller controller;

   private static Timer timer;
    public Tetris() {
        /*
         model is subject
        and
         Views are observers that can register to get notified of any change to the model.
         */

        model = new Model(); //независимая часть, которая ничего не знает ни о контроллере, ни о представлпени
        controller = new Controller(model); // точкой входа в программу является контроллер
        view = new View(controller, model);

        model.register(view);

    }

    public void startGame() {
        model.createNewGame();

        timer = new Timer(); //!?!??!

    }
}

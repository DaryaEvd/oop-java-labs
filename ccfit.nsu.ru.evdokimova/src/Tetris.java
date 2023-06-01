import Controller.Controller;
import Model.Model;
import Utils.Constants;
import View.View;

import javax.swing.*;

public class Tetris implements Runnable {
    private static Tetris instance;
    private static Controller controller;

    private Tetris() { }

    public static Tetris getInstance() {
        if (instance == null) {
            instance = new Tetris();
        }
        return instance;
    }

    @Override
    public void run() {
        Model model = new Model();
        controller = new Controller(model);
        View view = new View(model, controller);
        model.register(view);

        javax.swing.SwingUtilities.invokeLater(view);

        model.initNewModel();
        Timer timer = new Timer(Constants.TIMER_DELAY, e -> controller.handleTimerRequest());
        timer.start();
    }
}
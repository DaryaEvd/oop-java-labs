import Controller.Controller;
import Model.Model;
import Utils.Constants;
import View.View;

import javax.swing.*;

public class Tetris {

    public Tetris() {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(model, controller);
        model.register(view);

        javax.swing.SwingUtilities.invokeLater(view);

        model.initNewModel();
        Timer timer = new Timer(Constants.TIMER_DELAY, e -> controller.handleTimerRequest());
        timer.start();
    }

}
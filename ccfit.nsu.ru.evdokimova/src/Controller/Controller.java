package Controller;

import Model.*;
import Utils.FrameScores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements ActionListener, KeyListener {
    private static final Logger logger = Logger.getLogger((Controller.class.getName()));

    private final Model model;

    public Controller(Model model) {
        this.model = model;
    }

    @Override
    public synchronized void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Exit")) {
            logger.log(Level.INFO, "Clicked on 'Exit'");
            System.exit(0);
        }
        else if(e.getActionCommand().equals("About")) {
            logger.log(Level.INFO, "Clicked on 'About'");
            model.setModelState(State.IN_PAUSE);

            UIManager.put("OptionPane.minimumSize", new Dimension(300, 300));

            ArrayList<String> allText = new ArrayList<>();
            try (BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("./ccfit.nsu.ru.evdokimova/src/Files/about.txt"))) {
                String line;
                while((line = bufferedReader.readLine()) != null) {
                    allText.add(line);
                }
                int resultOfClicking = JOptionPane.showConfirmDialog(null, allText.toString()
                        .replace("[", "").replace("]", "")
                        .replace(", ", System.lineSeparator()),
                        "About", JOptionPane.YES_NO_OPTION
                );
                if((resultOfClicking == JOptionPane.OK_OPTION) || (resultOfClicking == JOptionPane.NO_OPTION)
                    || (resultOfClicking == JOptionPane.CLOSED_OPTION)) {
                    logger.log(Level.INFO, "Read msg and chosed OK/NO/CLOSED option");
                    model.setModelState(State.IN_GAME);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(e.getActionCommand().equals("New Game")) {
            logger.log(Level.INFO, "Clicked on 'New Game'");
            model.initNewModel();
        }
        else if(e.getActionCommand().equals("Scores")) {
            logger.log(Level.INFO, "Clicked on 'Scores'");

            model.setModelState(State.IN_PAUSE);
            FrameScores scoreFrame = new FrameScores(new File("./ccfit.nsu.ru.evdokimova/src/Files/leaders.txt"));
            scoreFrame.setVisible(true);
            scoreFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }
        else if(e.getActionCommand().equals("Pause")) {
            logger.log(Level.INFO, "Clicked on 'Pause'");
            model.setModelState(State.IN_PAUSE);
        }
        else if(e.getActionCommand().equals("Continue")) {
            logger.log(Level.INFO, "Clicked on 'Continue'");
            model.setModelState(State.IN_GAME);
        }
    }


    @Override
    public synchronized void keyTyped(KeyEvent e) { }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN -> model.handleRequest(Command.GO_DOWN);
            case KeyEvent.VK_UP -> model.handleRequest(Command.DO_ROTATION);
            case KeyEvent.VK_LEFT -> model.handleRequest(Command.GO_LEFT);
            case KeyEvent.VK_RIGHT -> model.handleRequest(Command.GO_RIGHT);
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) { }

    public synchronized void handleTimerRequest() {
        model.handleRequest(Command.GO_DOWN);
    }
}
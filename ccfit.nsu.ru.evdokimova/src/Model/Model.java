package Model;


import Model.Figures.Tetromino;
import Tetris.Observer;
import Tetris.Subject;
import View.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Model.Figures.Tetromino.generateRandomFigure;

public class Model implements Subject {
    private static final Logger logger = Logger.getLogger(Model.class.getName());
    private List<Observer> observers;
    private int [][] gameField;
    private int[] addedCellsInLine;

    private GameState curGameState;
    private Tetromino tetromino;

    public Model() {
        observers = new ArrayList<>();
        gameField = new int[Constants.GRID_ROWS][Constants.GRID_COLUMNS];
        addedCellsInLine = new int[Constants.GRID_COLUMNS];
    }

    private void generateField() {
        for(int i = 0; i < Constants.GRID_ROWS; i++) {
            Arrays.fill(gameField[i], -1);
        }

    }

    @Override
    public void register(Observer obj) {
        if(obj == null) {
            throw new NullPointerException("Null observer");
        }
        if(!observers.contains(obj)) { //!!!!!!!!
            observers.add(obj);
        }
    }


    public void createNewGame() {
         generateField();
         tetromino = generateRandomFigure();
         for(int i = 0; i < Constants.GRID_COLUMNS; i++) {
             addedCellsInLine[i] = 0;
         }
         notifyObservers();
    }
    @Override
    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for(Observer obj : observers) {
           obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return null;
    }

    public void handleRequest(CommandState command) {
       if(curGameState.equals(GameState.GAME_OVER) || curGameState.equals((GameState.PAUSE))) {
            return;
       }

       boolean modelHasChanged = false;

       switch (command) {
           case DOWN -> {
               logger.log(Level.INFO, "model goes down");
           }

           case LEFT -> {
                logger.log(Level.INFO, "model goes left");
           }

           case RIGHT -> {
                logger.log(Level.INFO, "model goes right");
           }

           case ROTATE -> {
                logger.log(Level.INFO, "model rotates");
           }
       }
    }

}

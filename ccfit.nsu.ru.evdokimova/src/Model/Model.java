package Model;


import Tetris.Observer;
import Tetris.Subject;
import View.Constants;

import java.util.ArrayList;
import java.util.List;

public class Model implements Subject {

    private List<Observer> observers;
    private int [][] gameField;
    private int[] addedCellsInLine;

    public Model() {
        observers = new ArrayList<>();
        gameField = new int[Constants.GRID_ROWS][Constants.GRID_COLUMNS];
        addedCellsInLine = new int[Constants.GRID_COLUMNS];
    }

    private void generateField() {
        for(int i = 0; i < Constants.GRID_ROWS; i++) {
           for(int j = 0; j < Constants.GRID_COLUMNS; j++) {
               gameField[i][j] = -1;
           }
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
}

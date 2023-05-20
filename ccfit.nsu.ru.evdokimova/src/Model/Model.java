package Model;


import Tetris.Observer;
import Tetris.Subject;

import java.util.ArrayList;
import java.util.List;

public class Model implements Subject {

    private List<Observer> observers;
    public Model() {
        this.observers = new ArrayList<>();

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

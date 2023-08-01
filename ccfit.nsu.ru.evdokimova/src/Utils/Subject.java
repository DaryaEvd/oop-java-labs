package Utils;

public interface Subject {

    void register(Observer obj);

    void notifyObservers();
}
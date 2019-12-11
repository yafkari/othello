package esi.atl.g52196.model;

/**
 * Represents an Observable.
 *
 * @author g52196
 */
public interface Observable {

    void registerObserver(Observer obs);

    void removeObserver(Observer obs);

    void notifyObservers();
}

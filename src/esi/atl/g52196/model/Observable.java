package esi.atl.g52196.model;

/**
 * Represents an Observable.
 *
 * @author g52196
 */
public interface Observable {

    /**
     * Adds an observer to the list of observers of this object.
     *
     * @param obs the observer to add to the list
     */
    void registerObserver(Observer obs);

    /**
     * Deletes an observer from the list of observers of this object.
     *
     * @param obs the observer to remove from the list
     */
    void removeObserver(Observer obs);

    /**
     * If this object has changed, notify all of its observers.
     */
    void notifyObservers();
}

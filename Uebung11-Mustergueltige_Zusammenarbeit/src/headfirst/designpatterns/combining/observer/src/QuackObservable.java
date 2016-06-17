package headfirst.designpatterns.combining.observer;

/**
 * QuackObservable - QuackObservable ist ein Interface mit 2 Methoden.
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public interface QuackObservable {
	/**
	 * Die Methode hat einen Parameter mit dem Typen observer
	 */
	public void registerObserver(Observer observer);
	/**
	 * Die Methode dient zur Benachrichtigung für den Observer.
	 */
	public void notifyObservers();
}

package headfirst.designpatterns.combining.observer;

/**
 * MallardDuck - Eine Klasse die von dem Interface Quakable implementiert. Das heiﬂt
 * es enth‰lt alle Attribute und Methoden von Quakable.
 * Design: Factory Pattern(Factory Method)
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public class MallardDuck implements Quackable {
	Observable observable;
 
	/**
	 * Diese Methode erstellt eine neue Instanz von Observable mit 
	 * dem Parameter Observable.
	 */
	public MallardDuck() {
		observable = new Observable(this);
	}
 
	/**
	 * Bei dieser Methode wird ein String ausgegeben und 
	 * danach ruft es die Methode notifyObserver auf.
	 */
	public void quack() {
		System.out.println("Quack");
		notifyObservers();
	}
 
	/**
	 *  @param observer 
	 *  In dieser Methode wird die Methode registerObserver mit dem Parameter observer aufgerufen. 
	 *  Die Methode registerOberserver befindet sich in observable.
	 */

	public void registerObserver(Observer observer) {
		observable.registerObserver(observer);
	}
 
	/**
	 *  Diese Methode ruft die Methode notifyObservers von der Klasse Observable auf.
	 */

	public void notifyObservers() {
		observable.notifyObservers();
	}
 
	/**
	 *  Diese Methode ist ein String und gibt den Namen der Ente 
	 *  als String aus: 'Mallard Duck'.
	 */

	public String toString() {
		return "Mallard Duck";
	}
}


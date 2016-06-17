package headfirst.designpatterns.combining.observer;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * Flock - Diese Klasse Implementiert das Interface Quackable.
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public class Flock implements Quackable {
	// Klassen ArrayList ducks mit dem Typen Quackable
	ArrayList<Quackable> ducks = new ArrayList<Quackable>();
  
	/**
	 * Methoden Name: add
	 * Diese Methode hat einen Parameter mit dem Tyen Quackable mit dem namen duck
	 * Dieser duck wird in die Arraylist hinzugefügt.
	 */
	
	public void add(Quackable duck) {
		ducks.add(duck);
	}
  	
	/**
	 *	Methoden Name: quack
	 *	Hier befindet sich ein Iterator mit dem man alle elemente vom Arraylist durchgehen kann und dies auch gemacht wird.
	 *	Es wird noch dazu überprüft.
	 *	Es hat außerdem noch einen Parameter verlangt, dammit es etwas adden kann.
	 */
	public void quack() {
		Iterator<Quackable> iterator = ducks.iterator();
		while (iterator.hasNext()) {
			Quackable duck = (Quackable)iterator.next();
			duck.quack();
		}
	}
	
   	/**
	 *	Methoden Name: registerObserver
	 *	Hier befindet sich ein Iterator mit dem man alle elemente vom Arraylist durchgehen kann und dies auch gemacht wird.
	 *	Es wird noch dazu überprüft.
	 *	Es hat außerdem noch einen Parameter verlangt, dammit es etwas adden kann.
	 */
	public void registerObserver(Observer observer) {
		Iterator<Quackable> iterator = ducks.iterator();
		while (iterator.hasNext()) {
			Quackable duck = (Quackable)iterator.next();
			duck.registerObserver(observer);
		}
	}
	public void notifyObservers() { }
	
	/**
	 *	Methoden Name: toString
	 *	Rückgabe: String: 'Flock of Ducks'
	 */
	public String toString() {
		return "Flock of Ducks";
	}
}

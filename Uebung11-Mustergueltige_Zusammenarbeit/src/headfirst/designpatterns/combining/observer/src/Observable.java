package headfirst.designpatterns.combining.observer;

import java.util.Iterator;
import java.util.ArrayList;

/**
 * Observable - Eine Klasse die vom Interface QuackObservable implementiert.
 * Design: Observer Pattern
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public class Observable implements QuackObservable {
	
	ArrayList<Observer> observers = new ArrayList<Observer>(); // ArrayList für observer
	QuackObservable duck;
 
	/**
	 * Beim Konstruktor wird duck zugewiesen.
	 */
	public Observable(QuackObservable duck) {
		this.duck = duck;
	}
  
	/**
	 *  @param observer 
	 *  In dieser Methode werden Elemente in die ArrayList hinzugefügt.
	 */
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
  
	/**
	 * Bei dieser Methode werden alle Elemente durchgegangen mithilfe vom Iterator.
	 */
	public void notifyObservers() {
		Iterator<Observer> iterator = observers.iterator();
		while (iterator.hasNext()) {
			Observer observer = iterator.next();
			observer.update(duck);
		}
	}
 
	/**
	 * Eine getter-Methode, dass Observer mit dem Iterator zurückliefert.
	 */
	public Iterator<Observer> getObservers() {
		return observers.iterator();
	}
}       

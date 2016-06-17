package headfirst.designpatterns.combining.observer;

/**
 * QuackCounter - Eine Klasse die vom Interface Quackable implementiert.
 * Design: Decorator Pattern
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public class QuackCounter implements Quackable {
	Quackable duck;
	static int numberOfQuacks;
  
	/**
	 * Beim Konstruktor wird duck zugewiesen.
	 */
	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}
  
	/**
	 * Diese Methode ruft die Methode quack auf und erhöht die numberOfQuaks.
	 */
	public void quack() {
		duck.quack();
		numberOfQuacks++;
	}
 
	/**
	 * Eine getter-Methode für getQuacks. Hier wird die numberOfQuaks als int
	 * zurückgegeben.
	 */
	public static int getQuacks() {
		return numberOfQuacks;
	}
 
	/**
	 *  @param observer 
	 *  In dieser Methode wird die Methode registerObserver mit dem Parameter observer aufgerufen. 
	 *  Die Methode registerOberserver befindet sich in observable.
	 */
	public void registerObserver(Observer observer) {
		duck.registerObserver(observer);
	}
 
	/**
	 * Bei dieser Methode wird der Observer benachrichtigt.
	 */
	public void notifyObservers() {
		duck.notifyObservers();
	}
   
	/**
	 * Hier wird Quackable als String zurückgegeben.
	 */
	public String toString() {
		return duck.toString();
	}
}

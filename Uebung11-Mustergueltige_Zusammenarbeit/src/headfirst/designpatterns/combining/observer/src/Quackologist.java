package headfirst.designpatterns.combining.observer;

/**
 * Quackologist - Eine Klasse die vom Interface Observer implementiert.
 * Design: Observer Pattern
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public class Quackologist implements Observer {
 
	/**
	 * Bei dieser Methode update wird duck ausgegeben.
	 */
	public void update(QuackObservable duck) {
		System.out.println("Quackologist: " + duck + " just quacked.");
	}
 
	/**
	 * Eine toString-Methode, dass ein String ausgibt.
	 */
	public String toString() {
		return "Quackologist";
	}
}

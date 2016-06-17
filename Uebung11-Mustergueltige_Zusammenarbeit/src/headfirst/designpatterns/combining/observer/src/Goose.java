package headfirst.designpatterns.combining.observer;

/**
 * Goose - Eine Klasse das zwei Methoden zur Verfügung stellt.
 * Design: Adapter Pattern
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public class Goose {

	/**
	 * Eine Methode, dass Honk in der Konsole ausgibt.
	 */
	public void honk() {
		System.out.println("Honk");
	}

	/**
	 * Eine toString-Methode, dass ein String zurückliefert.
	 */
	public String toString() {
		return "Goose";
	}
}

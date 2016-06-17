package headfirst.designpatterns.combining.observer;

/**
 * GooseAdapter - Eine Klasse das von Quackable implementiert.
 * Design: Adapter Pattern
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public class GooseAdapter implements Quackable {
	Goose goose;
	Observable observable;

	/**
	 * Hier wird beim Konstruktor eine Zuweisung durchgeführt und 
	 * eine neue Instanz für Observable erzeugt.
	 */
	public GooseAdapter(Goose goose) {
		this.goose = goose;
		observable = new Observable(this);
	}
 
	/**
	 * Bei dieser Methode wird die Methode honk aufgerufen und
	 * der Observer benachrichtigt.
	 */
	public void quack() {
		goose.honk();
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
	 *  Diese Methode ist ein String und liefert 'Goose pretending to be a Duck' zurück.
	 */
	public String toString() {
		return "Goose pretending to be a Duck";
	}
}

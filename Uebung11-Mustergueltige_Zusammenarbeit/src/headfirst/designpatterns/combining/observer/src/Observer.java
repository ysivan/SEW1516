package headfirst.designpatterns.combining.observer;

/**
 * Observer - Observer ist ein Interface.
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public interface Observer {
	/**
	 * Bei dieser Methode update wird QuackObservable mit dem Typ duck definiert..
	 */
	public void update(QuackObservable duck);
}

package headfirst.designpatterns.combining.observer;

/**
 * Quackable - Quakable erbt von QuackObservable und hat eine Methode quack.
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public interface Quackable extends QuackObservable {
	public void quack();
}

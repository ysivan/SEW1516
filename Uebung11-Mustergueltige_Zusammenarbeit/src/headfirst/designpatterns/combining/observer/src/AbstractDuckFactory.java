package headfirst.designpatterns.combining.observer;

/**
 * AbstractDuckFactory - Eine Abstrakte Klasse die abtrakte Methoden beinhaltet.
 * Design: Factory Pattern(Factory Method)
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public abstract class AbstractDuckFactory {
 
	public abstract Quackable createMallardDuck();
	public abstract Quackable createRedheadDuck();
	public abstract Quackable createDuckCall();
	public abstract Quackable createRubberDuck();
}

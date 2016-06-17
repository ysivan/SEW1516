package headfirst.designpatterns.combining.observer;

/**
 * CountingDuckFactory - Eine Klasse die von der AbstractDuckFactory Klasse erbt und
 * die abstrakten Methoden in dieser Klasse überschreibt.
 * Bei diesen Methoden werden immer andere Duckklassen aufgerufen.
 * Design: Factory Pattern(Factory Method)
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public class CountingDuckFactory extends AbstractDuckFactory {
  
	/**
	 * Diese Methode ruft zuerst die QuackCounter-Klasse auf und dann wird
	 * in diesem eine neue MallardDuck-Klasse instanziiert und als Quackable zurück gegegben.
	 */
	public Quackable createMallardDuck() {
		return new QuackCounter(new MallardDuck());
	}
  
	/**
	 * Diese Methode ruft zuerst die QuackCounter-Klasse auf und dann wird
	 * in diesem eine neue RedheadDuck-Klasse instanziiert und als Quackable zurück gegegben.
	 */
	public Quackable createRedheadDuck() {
		return new QuackCounter(new RedheadDuck());
	}
  
	/**
	 * Diese Methode ruft zuerst die QuackCounter-Klasse auf und dann wird
	 * in diesem eine neue Duck-Klasse instanziiert und als Quackable zurück gegegben.
	 */
	public Quackable createDuckCall() {
		return new QuackCounter(new DuckCall());
	}
   
	/**
	 * Diese Methode ruft zuerst die QuackCounter-Klasse auf und dann wird
	 * in diesem eine neue RubberDuck-Klasse instanziiert und als Quackable zurück gegegben.
	 */
	public Quackable createRubberDuck() {
		return new QuackCounter(new RubberDuck());
	}
}

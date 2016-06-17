package headfirst.designpatterns.combining.observer;

/**
 * DuckFactory - Eine Klasse die von der AbstractDuckFactory Klasse erbt und
 * die abstrakten Methoden in dieser Klasse überschreibt.
 * Bei diesen Methoden werden neue Duckklassen instanziert.
 * Design: Factory Pattern(Factory Method)
 * @author Yehezkel Sivan
 * @version 17.06.2016
 */
public class DuckFactory extends AbstractDuckFactory {
  
	/**
	 * Bei dieser Methode wird eine neue MallarDuck-Klasse instanziiert 
	 * und als Quackable zurück gegegben.
	 */
	public Quackable createMallardDuck() {
		return new MallardDuck();
	}
  
	/**
	 * Bei dieser Methode wird eine neue RedheadDuck-Klasse instanziiert 
	 * und als Quackable zurück gegegben.
	 */
	public Quackable createRedheadDuck() {
		return new RedheadDuck();
	}
  
	/**
	 * Bei dieser Methode wird eine neue DuckCall-Klasse instanziiert 
	 * und als Quackable zurück gegegben.
	 */
	public Quackable createDuckCall() {
		return new DuckCall();
	}
   
	/**
	 * Bei dieser Methode wird eine neue RubberDuck-Klasse instanziiert 
	 * und als Quackable zurück gegegben.
	 */
	public Quackable createRubberDuck() {
		return new RubberDuck();
	}
}

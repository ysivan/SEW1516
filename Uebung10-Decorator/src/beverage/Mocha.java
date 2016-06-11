/**
 * 
 */
package beverage;

/**
 * @author Yehezkel Sivan
 * @version 14.April 2016, v1.0
 */
public class Mocha extends CondimentDecorator {
	Beverage beverage;
	
	public Mocha(Beverage beverage){
		this.beverage = beverage;
	}
	
	public String getDescription(){
		return beverage.getDescription() + ", Mocha";
	}
	
	public double cost(){
		return 0.20 + beverage.cost();
	}
	
}

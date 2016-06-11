/**
 * 
 */
package beverage;

/**
 * @author Yehezkel Sivan
 * @version 14.April 2016, v1.0
 */
public abstract class Beverage {
	String description = "Unknown";

	public String getDescription(){
		return description;
	}
	
	public abstract double cost();
}

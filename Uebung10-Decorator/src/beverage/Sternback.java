/**
 * 
 */
package beverage;

/**
 * @author Yehezkel Sivan
 *
 */
public class Sternback{
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Beverage beverage = new HouseBlend();
		System.out.println(beverage.getDescription()+" �"+beverage.cost());

		Beverage beverage2 = new HouseBlend();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		System.out.println(beverage2.getDescription()+" �"+beverage2.cost());
		
	}

}

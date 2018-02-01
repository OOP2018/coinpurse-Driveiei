package coinpurse;

/**
* An interface for objects having a monetary value and currency.
*/
public interface Valuable {
	
	/**
	 * Get the objects's value.
	 */
	public double getValue(); 
	
	/**
	 * Get the objects's currency.
	 */
	public String getCurrency();
	
}

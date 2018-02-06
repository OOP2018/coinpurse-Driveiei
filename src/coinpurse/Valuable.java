package coinpurse;

/**
* An interface for objects having a monetary value and currency.
* 
* @author Kornphon Noiprasert
*/
public interface Valuable {
	
	/**
	 * Get the objects's value.
	 * 
	 * @return the value of this object.
	 */
	public double getValue(); 
	
	/**
	 * Get the objects's currency.
	 * 
	 * @return the currency of this object.
	 */
	public String getCurrency();
	
}
package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Kornphon Noiprasert
 */
public class Coin extends Money {
	
	/**
	 * The value of the coin must not be negative. If value of the coin less than
	 * zero, change the value of the coin to zero.
	 * 
	 * @param value is value of a coin
	 * @param currency is coin's currency
	 */
	public Coin(double value, String currency) {
		super(value,currency);
	}

	/**
	 * toString describes value and currency of coin.
	 * 
	 * @return description of this coin.
	 */
	@Override
	public String toString() {
		if ((int) this.getValue() - getValue() == 0)
			return String.format("%.0f-%s", getValue(), getCurrency());
		else {
			return String.format("%.2f-%s", getValue(), getCurrency());
		}
	}
}

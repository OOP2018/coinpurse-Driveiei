package coinpurse;

/**
 * Coin represents coinage (money) with a fixed value and currency.
 * 
 * @author Kornphon Noiprasert
 */
public class Coin implements Valuable {

	/** The value of the coin */
	private final double value;
	/** The currency of the coin */
	private final String currency;

	/**
	 * The value of the coin must not be negative. If value of the coin less than
	 * zero, change the value of the coin to zero.
	 * 
	 * @param value is value of a coin
	 * @param currency is coin's currency
	 */
	public Coin(double value, String currency) {
		if (value < 0) {
			this.value = 0;
		} else {
			this.value = value;
		}
		this.currency = currency;
	}

	/**
	 * Get the coin's value.
	 * 
	 * @return the coin's value.
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Get the coin's currency
	 * 
	 * @return the coin's currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Compare 2 object of coins that have same value and currency or not.
	 * 
	 * @param arg is the object that use to compare with this object.
	 * @return true if both objects have the same value and currency.
	 */
	@Override
	public boolean equals(Object arg) {
		if (arg == null) {
			return false;
		}
		if (arg.getClass() != this.getClass()) {
			return false;
		}
		Coin coin = (Coin) arg;
		return coin.getCurrency().equals(this.getCurrency()) && coin.getValue() == this.getValue();
	}

	/**
	 * Compare 2 object of coins to sort them into the order by the value of them.
	 * 
	 * @param coin is the object that want to compare with this object.
	 * @return -1(negative integer) if this object has order before other object.
	 *         0(zero) if this object and other object have the same order.
	 *         1(positive integer) if this object has order after other object.
	 */
	public int compareTo(Coin coin) {
		double number = this.getValue() - coin.getValue();
		if (number < 0) {
			return -1;
		} else if (number > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * toString describes value and currency of coin.
	 * 
	 * @return description of this coin.
	 */
	@Override
	public String toString() {
		if ((int) this.value - value == 0)
			return String.format("%.0f-%s", value, currency);
		else {
			return String.format("%.2f-%s", value, currency);
		}
	}
}

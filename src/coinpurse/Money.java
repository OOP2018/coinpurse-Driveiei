package coinpurse;

/**
 * Money represents production contains fixed value and currency which are
 * supports Coin and BankNote, and can order money 
 * 
 * @author Kornphon Noiprasert
 */
public class Money implements Valuable {

	private double value;
	private String currency;
	
	/**
	 * Create Money with currency and value. The value cann't less than 0.
	 * 
	 * @param value is value of a Money.
	 * @param currency is Money's currency.
	 */
	public Money(double value , String currency) {
		this.value = value;
		this.currency = currency;
	}
	
	/**
	 * Get the money's value.
	 * 
	 * @return the money's value.
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Get the money's currency.
	 * 
	 * @return the money's currency.
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Compare 2 object of money that have same value and currency or not.
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
		Money money = (Money) arg;
		return money.getCurrency().equals(this.getCurrency()) && money.getValue() == this.getValue();
	}
	
	/**
	 * Compare 2 object of money to sort them into the order by the value of them.
	 * 
	 * @param value is the object that want to compare with this object.
	 * @return -1(negative integer) if this object has order before other object.
	 *         0(zero) if this object and other object have the same order.
	 *         1(positive integer) if this object has order after other object.
	 */
	@Override
	public int compareTo(Valuable value) {
		if (this.getCurrency().equals(value.getCurrency())) {
			return Double.compare(this.getValue(), value.getValue());
		} else return this.getCurrency().compareToIgnoreCase(value.getCurrency());
	}
}

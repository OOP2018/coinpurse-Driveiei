package coinpurse;

public class Money implements Valuable {

	private double value;
	private String currency;
	
	public Money(double value , String currency) {
		if(value < 0) throw new IllegalArgumentException ("Money value must be more than 0");
		this.value = value;
		this.currency = currency;
	}

	@Override
	public double getValue() {
		return value;
	}

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
	public int compareTo(Valuable value) {
		if (this.getCurrency().equals(value.getCurrency())) {
			return Double.compare(this.getValue(), value.getValue());
		} else return this.getCurrency().compareToIgnoreCase(value.getCurrency());
	}
}

package coinpurse;

/**
 * BankNote represents production with a fixed value, currency, and
 * serialNumber.
 * 
 * @author Kornphon Noiprasert
 */
public class BankNote implements Valuable {

	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;

	/**
	 * Create banknote with currency, value, and serialNumber and change
	 * serialnumber to make a unique banknote.
	 * 
	 * @param value is value of a banknote.
	 * @param currency is banknote's currency.
	 */
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}

	/**
	 * Get the banknote's value.
	 * 
	 * @return the banknote's value.
	 */
	@Override
	public double getValue() {
		return value;
	}

	/**
	 * Get the banknote's currency.
	 * 
	 * @return the banknote's currency.
	 */
	@Override
	public String getCurrency() {
		return currency;
	}

	/**
	 * Get the banknote's serialnumber.
	 * 
	 * @return the banknote's serialnumber
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * Compare 2 object of banknote that have same value and currency or not.
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
		BankNote bank = (BankNote) arg;
		return bank.getCurrency().equals(this.getCurrency()) && bank.getValue() == this.getValue();
	}

	/**
	 * toString describes value and currency of banknote.
	 * 
	 * @return description of this banknote.
	 */
	@Override
	public String toString() {
		if (this.value % 1 == 0)
			return String.format("%.0f-%s note [%d].", value, currency, serialNumber);
		else
			return String.format("%.2f-%s note [%d].", value, currency, serialNumber);
	}

}

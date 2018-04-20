package coinpurse;

/**
 * BankNote represents production with a fixed value, currency, and
 * serialNumber.
 * 
 * @author Kornphon Noiprasert
 */
public class BankNote extends Money {
	private long serialNumber;

	/**
	 * Create banknote with currency, value, and serialNumber and change
	 * serialnumber to make a unique banknote.
	 * 
	 * @param value is value of a banknote.
	 * @param currency is banknote's currency.
	 */
	public BankNote(double value, String currency , long serialNumber) {
		super(value,currency);
		this.serialNumber = serialNumber;
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
	 * toString describes value and currency of banknote.
	 * 
	 * @return description of this banknote.
	 */
	@Override
	public String toString() {
		if (this.getValue() % 1 == 0)
			return String.format("%.0f-%s note [%d].", this.getValue(), this.getCurrency(), serialNumber);
		else return String.format("%.2f-%s note [%d].", this.getValue(), this.getCurrency(), serialNumber);
	}

}

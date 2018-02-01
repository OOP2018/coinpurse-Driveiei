package coinpurse;

public class BankNote implements Valuable {

	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency;
	private long serialNumber;
	
	public BankNote(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber;
		nextSerialNumber++;
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public String getCurrency() {
		return currency;
	}
	
	public long getSerial() {
		return serialNumber;
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
		BankNote bank = (BankNote) arg;
		return bank.getCurrency().equals(this.getCurrency()) && bank.getValue() == this.getValue();
	}
	
	/**
	 * toString describes the game or problem.
	 * 
	 * @return description of this game or the problem to be solved.
	 */
	@Override
	public String toString() {
		if(this.value % 1 == 0) return String.format("%.0f-%s note [%d].",value,currency,serialNumber);
		else return String.format("%.2f-%s note [%d].",value,currency,serialNumber); 
	}

}

package coinpurse;

/**
 * ThaiMoneyFactory creates coin or banknote with currency of 'Baht'.
 * 
 * @author Kornphon Noiprasert
 */
public class ThaiMoneyFactory extends MoneyFactory {
	/** The serialNumber of Thai's money */
	private static long serialNumber = 1000000;

	/**
	 * Accepts money value to create BankNote or Coin in currency of Baht. The value
	 * must more than 0.
	 * 
	 * @param value is value of a Coin or BankNote.
	 * @return Coin or BankNote value(object) that come from Thai.
	 */
	@Override
	public Valuable createMoney(double value) {
		if (value <= 0)
			throw new IllegalArgumentException("Money value must be more than 0");
		if (value == 1 || value == 2 || value == 5 || value == 10)
			return new Coin(value, "Baht");
		if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000)
			return new BankNote(value, "Baht", serialNumber++);
		throw new IllegalArgumentException(value + "Baht is invalid in Thailand");
	}
}

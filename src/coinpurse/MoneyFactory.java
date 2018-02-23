package coinpurse;

/**
 * MoneyFactory contains of necessary method with Malaysia and Thai Factory.
 * MoneyFactory define which factory using to create coin or banknote.
 * 
 * @author Kornphon Noiprasert
 */
public abstract class MoneyFactory {

	private static MoneyFactory factory = null;

	public abstract Valuable createMoney(double value);

	public abstract String getCurrency();

	/**
	 * Get the factory's instance.
	 * 
	 * @return the factory's instance.
	 */
	public static MoneyFactory getInstance() {
		if (factory == null)
			factory = new ThaiMoneyFactory();
		return factory;
	}

	/**
	 * Accepts money value as a String, e.g. createMoney("10"). This method is for
	 * convenience of the U.I. The default implementation of this method converts
	 * parameter to a double and calls createMoney(double).
	 * 
	 * @param arg is value of a Coin or BankNote(String).
	 * @return Coin or BankNote value(object) that come from Thai or Malaysia.
	 */
	public Valuable createMoney(String arg) {
		double value = 0;
		try {
			value = Double.parseDouble(arg);
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(ex.getMessage(),ex);
		}
		return createMoney(value);
	}

	/**
	 * Change the country's factory.
	 * 
	 * @param mf is an object to set which factory to use.
	 */
	public static void setFactory(MoneyFactory mf) {
		factory = mf;
	}
}

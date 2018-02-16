package coinpurse;

public class ThaiMoneyFactory extends MoneyFactory {

	private static long serialNumber = 1000000;
	
	@Override
	public Valuable createMoney(double value) {
		if(value <= 0) throw new IllegalArgumentException ("Money value must be more than 0");
		if(value == 1 || value == 2 || value == 5 || value == 10) return new Coin(value,"Baht");
		if(value == 20 || value == 50 || value == 100 || value == 500 || value == 1000) return new BankNote(value,"Baht",serialNumber++);
		throw new IllegalArgumentException (value + "Baht is invalid in Thailand");
	}
}

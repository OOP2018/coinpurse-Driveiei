package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	
	private static long serialNumber = 1000000;
	
	@Override
	public Valuable createMoney(double value) {
		if(value <= 0) throw new IllegalArgumentException ("Money value must be more than 0");
		if(value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50) return new Coin(value*100,"Sen");
		if(value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100) return new BankNote(value,"Ringgit",serialNumber++);
		throw new IllegalArgumentException (value + " Ringgit is invalid in Malaysia.");
	}
}

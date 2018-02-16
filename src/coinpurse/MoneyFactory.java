package coinpurse;

public abstract class MoneyFactory {
	
	private static MoneyFactory factory = null;
	public abstract Valuable createMoney(double value);
	
	public static MoneyFactory getInstance() {
		if(factory == null) factory = new ThaiMoneyFactory();
		return factory;
	}
		
	public Valuable createMoney(String arg) {
		double value = 0;
		try {
			value = Double.parseDouble(arg);	
		} catch(IllegalArgumentException ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return createMoney(value);
	}

	public static void setFactory(MoneyFactory mf) {
		factory = mf;
	}
}

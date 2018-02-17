package coinpurse;
/**
 * The small factory test that MoneyFactory(ThaiMoneyFactory + MalayMoneyFactory)
 * are useable.
 * 
 * @author Kornphon Noiprasert
 * */
public class MoneyFactoryDemo {
	
	/**
	 * This method test that MoneyFactory are Singleton or not.
	 * */
	public static void testMoneyFactory() {
		MoneyFactory f1 = MoneyFactory.getInstance();
		System.out.println("f1 is a " + f1.getClass().getName());
		MoneyFactory f2 = MoneyFactory.getInstance();
		System.out.println("f2 is a " + f2.getClass().getName());
		System.out.println(f2.getClass().getName());
		System.out.println("f1 == f2 (Same object?) : " + (f1 == f2));
		String[] values = { "0.2", "0.25", "0.5", "1.0", "2.0", "5", "10", "20", "50", "100", "500", "1000", "22" };
		for (String arg : values) {
			System.out.printf("createMoney(%s) is ", arg);
			try {
				Valuable v = f1.createMoney(arg);
				System.out.println(v.toString());
			} catch (IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * Configure and start the application.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		testMoneyFactory();
		MoneyFactory.setFactory(new MalayMoneyFactory());
		testMoneyFactory();
	}

}

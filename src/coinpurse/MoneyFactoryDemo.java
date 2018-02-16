package coinpurse;

public class MoneyFactoryDemo {

	public MoneyFactoryDemo() {

	}

	public static void testMoneyFactory() {
		MoneyFactory f1 = MoneyFactory.getInstance();
		System.out.println("f1 is a " + f1.getClass().getName());
		MoneyFactory f2 = MoneyFactory.getInstance();
		System.out.println("f2 is a " + f2.getClass().getName());
		System.out.println(f2.getClass().getName());
		System.out.println("f1 == f2 (Same object?) : " + (f1 == f2));
		String[] values = {"0.2","0.25","0.5","1.0","2.0","5","10","20","50","100","500","1000","22"};
		for(String arg : values) {
			System.out.printf("createMoney(%s) is ",arg);
			try {
				Valuable v = f1.createMoney(arg);
				System.out.println(v.toString());
			} catch(IllegalArgumentException ex){
				System.out.println(ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		testMoneyFactory();
		System.out.printf("\nThailand is too hot. Moving to Malaysia!");
		MoneyFactory.setFactory(new MalayMoneyFactory());
		testMoneyFactory();
	}

}

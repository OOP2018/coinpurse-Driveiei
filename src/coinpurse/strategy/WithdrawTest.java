package coinpurse.strategy;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import coinpurse.BankNote;
import coinpurse.Coin;
import coinpurse.Money;
import coinpurse.MoneyFactory;
import coinpurse.Valuable;

/**
 * Test the GreedyWithdraw and RecursiveWithdraw using JUnit. This is a JUnit 4 test suite.
 * 
 * @author Kornphon Noiprasert
 */
public class WithdrawTest {

	private WithdrawStrategy strategy;
	private MoneyFactory factory;
	private List<Valuable> valuables;
	/** the default currency unit of money. */
	private final String CURRENCY = "Baht";
	/** tolerance for comparing two double values. */
	private static final double TOL = 1.0E-6;

	
	@Before
	/**
	 * Code to run before each test. Setup the "test fixture".
	 * */
	public void setUp() {
		strategy = new RecursiveWithdraw();
		valuables = new ArrayList<>();
		factory = MoneyFactory.getInstance();
	}
	
	/** 
	 * 	Make a coin with the default currency. To save typing "new Coin(...)"
	 * 
	 *  @param value - the number of value to create the money
	 *  @return the valuable of coin or banknote.
	 *  **/
	private Valuable makeMoney(double value) {
		if (value < 20)
			return new Coin(value, CURRENCY);
		else {
			Valuable valuable = null;
			try {
				valuable = factory.createMoney(value);
			} catch (IllegalArgumentException ex) {
				System.out.println("Sorry, " + value + " is not a valid amount.");
			}
			return valuable;
		}
	}
	
	/**
	 * Sum of valuable of the List. 
	 * 
	 * @param list of valuable
	 * @return sum of the list
	 * */
	private double sumList(List<Valuable> list) {
		double sum = 0;
		for(Valuable valuable : list) {
			sum += valuable.getValue();
		}
		return sum;
	}
	
	/**
	 * Testing when the list had nothing to withdraw
	 * */
	@Test(timeout=2000)
	public void testWithdrawNothing() {
		Valuable coin = new Coin(5,"Baht");
		Valuable banknote = factory.createMoney(50);
		valuables.clear();
		assertNull(strategy.withdraw(coin, valuables));
		assertNull(strategy.withdraw(banknote, valuables));
		assertNull(strategy.withdraw(new Money(5,CURRENCY), valuables));
	}
	
	/**
	 * Testing when withdraw null or 0 value.
	 * */
	@Test(timeout=2000)
	public void testEasyWithdraw() {
		valuables.clear();
		valuables.add(makeMoney(5));
		assertNull(strategy.withdraw(null, valuables));
		assertNull(strategy.withdraw(new BankNote(0,"Baht",1000000), valuables));
		assertNull(strategy.withdraw(new Money(0,"Baht"), valuables));
		assertNull(strategy.withdraw(new Coin(0,"Baht"), valuables));
	}
	
	/**
	 * Testing when withdraw one thing from the list.
	 * */
	@Test(timeout=2000)
	public void testSingleWithdraw() {
		Valuable coin = new Coin(5,CURRENCY);
	
		valuables.clear();
		valuables.add(makeMoney(5));
		assertEquals(5,strategy.withdraw(coin, valuables).get(0).getValue(),TOL);
		
		valuables.clear();
		valuables.add(makeMoney(50));
		assertEquals(50,strategy.withdraw(new BankNote(50, CURRENCY, 1000000), valuables).get(0).getValue(),TOL);
		
		valuables.clear();
		valuables.add(new Coin(5,CURRENCY));
		valuables.add(makeMoney(50));
		valuables.add(makeMoney(100));		
		assertEquals(5.0,strategy.withdraw(coin, valuables).get(0).getValue(), TOL);
	}
	
	/**
	 * Testing when withdraw multiple things from the list.
	 * */
	@Test(timeout=2000)
	public void testMultiWithdraw() {		
		valuables.clear();
		valuables.add(makeMoney(20));
		valuables.add(makeMoney(50));
		valuables.add(makeMoney(100));
		valuables.add(makeMoney(20));
		valuables.add(makeMoney(1));
		valuables.add(makeMoney(50));
		valuables.add(makeMoney(5));
		valuables.add(makeMoney(10));
		valuables.add(makeMoney(20));
		List<Valuable> test = strategy.withdraw(new Money(276,CURRENCY), valuables);
		assertEquals(276,sumList(test),TOL);
		test = strategy.withdraw(new Money(58,CURRENCY), valuables);
		assertNull(test);
		test = strategy.withdraw(new Money(70,CURRENCY), valuables);
		assertEquals(70,sumList(test),TOL);
		test = strategy.withdraw(new Money(140,CURRENCY), valuables);
		assertEquals(140,sumList(test),TOL);
		
		valuables.clear();
		valuables.add(makeMoney(15));
		valuables.add(makeMoney(5));
		valuables.add(makeMoney(5));
		test = strategy.withdraw(new Money(10,CURRENCY), valuables);
		assertEquals(10,sumList(test),TOL);
		
		valuables.clear();
		valuables.add(makeMoney(5));
		valuables.add(makeMoney(5));
		valuables.add(makeMoney(5));
		test = strategy.withdraw(new Money(15,CURRENCY), valuables);
		assertEquals(15,sumList(test),TOL);

		valuables.clear();
		valuables.add(makeMoney(5));
		valuables.add(makeMoney(4));
		valuables.add(makeMoney(3));
		test = strategy.withdraw(new Money(7,CURRENCY), valuables);
		assertEquals(7,sumList(test),TOL);
	}
	
	/**
	 * Testing when withdraw fails because of exceed withdraw or 
	 * uncorrected withdraw.
	 * */
	@Test(timeout=2000)
	public void testFailWithdraw() {
		valuables.clear();
		valuables.add(makeMoney(20));
		valuables.add(makeMoney(50));
		valuables.add(makeMoney(100));
		List<Valuable> test = strategy.withdraw(new Money(200,CURRENCY), valuables);
		assertNull(test);
		test = strategy.withdraw(new Money(25,CURRENCY), valuables);
		assertNull(test);
	}
	
	/**
	 * Testing when withdraw any kind of types of money, different currency.
	 * */
	@Test(timeout=2000)
	public void testWithdrawEverything() {
		valuables.clear();
		valuables.add(new Money(1,"Ringgit"));
		valuables.add(new Coin(5,"Baht"));
		valuables.add(new Money(50,"Baht"));
		valuables.add(new Coin(50,"Ringgit"));
		List<Valuable> test = strategy.withdraw(new Money(55,"Ringgit"), valuables);
		assertNull(test);
		test = strategy.withdraw(new Money(51,"Ringgit"), valuables);
		assertEquals(51,sumList(test),TOL);

		valuables.clear();
		valuables.add(new Money(3,"Ringgit"));
		valuables.add(new Money(4,"Ringgit"));
		valuables.add(new Money(3,"Ringgit"));
		valuables.add(new Money(3,"Baht"));
		valuables.add(new Money(6,"Baht"));
		test = strategy.withdraw(new Money(9,"Ringgit"), valuables);
		assertNull(test);
		test = strategy.withdraw(new Money(7,"Ringgit"), valuables);
		assertEquals(7,sumList(test),TOL);
	}
	

}

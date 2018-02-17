package coinpurse;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the MoneyFactory that concerned with ThaiMoneyFactory and
 * MalayMoneyFactory to test instance, createMoney, and setFactory using JUnit.
 * This is a JUnit 4 test suite.
 * 
 * @author Kornphon Noiprasert
 */
public class MoneyFactoryTest {

	private MoneyFactory factory = MoneyFactory.getInstance();

	/**
	* Test that MoneyFactory can get when it's define which factory to use.
	*/
	@Test
	public void testGetInstance() {
		factory = null;
		MoneyFactory.setFactory(null);
		factory = MoneyFactory.getInstance();
		assertEquals("coinpurse.ThaiMoneyFactory", factory.getClass().getName());
		assertEquals(ThaiMoneyFactory.getInstance(), factory);
	}

	/**
	* Test that MoneyFactory create money by double value both coin and banknote.
	*/
	@Test
	public void testCreateMoneyDouble() {
		assertNotNull(factory.createMoney(100));
		assertEquals(new Coin(1, "Baht"), factory.createMoney(1));
		assertEquals(new Coin(5, "Baht"), factory.createMoney(5));
		assertEquals(new BankNote(50, "Baht", 1000000), factory.createMoney(50));
		assertEquals(new BankNote(1000, "Baht", 1000001), factory.createMoney(1000));
	}

	/**
	* Test that MoneyFactory create money by String value both coin and banknote.
	*/
	@Test
	public void testCreateMoneyString() {
		assertNotNull(factory.createMoney(100));
		assertEquals(new Coin(1, "Baht"), factory.createMoney("1"));
		assertEquals(new Coin(5, "Baht"), factory.createMoney("5"));
		assertEquals(new BankNote(50, "Baht", 1000000), factory.createMoney("50"));
		assertEquals(new BankNote(1000, "Baht", 1000001), factory.createMoney("1000"));
	}

	/**
	* Test that MoneyFactory can define which factory to use.
	*/
	@Test
	public void testSetFactory() {
		MoneyFactory.setFactory(new MalayMoneyFactory());
		factory = MoneyFactory.getInstance();
		assertNotEquals(new BankNote(1, "Baht", 1000000), factory.createMoney(1));
		assertEquals(new BankNote(1, "Ringgit", 1000000), factory.createMoney(1));
	}
}

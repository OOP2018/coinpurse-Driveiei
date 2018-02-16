package coinpurse;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the Purse using JUnit. This is a JUnit 4 test suite.
 * 
 * IDEs (Eclipse, Netbeans, IntelliJ, BlueJ) include JUnit 4, but you have to
 * tell the IDE to add it to your project as a "Library". To run these tests,
 * right click on this file (in Project panel) and choose Run As -> JUnit test
 * 
 * @author Kornphon Noiprasert
 */
public class MoneyFactoryTest {
	/** tolerance for comparing two double values */
	private MoneyFactory factory = MoneyFactory.getInstance();
;

	@Test
	public void testGetInstance() {
		assertEquals("coinpurse.ThaiMoneyFactory",factory.getClass().getName());
		assertEquals(ThaiMoneyFactory.getInstance(),factory);
	}

	@Test
	public void testCreateMoneyDouble() {
			MoneyFactory factory = MoneyFactory.getInstance();
	        Coin oneBahtCoin = (Coin)factory.createMoney(1);
	        Coin twoBahtCoin = (Coin) factory.createMoney(2);
	        BankNote fiftyBahtNote = (BankNote) factory.createMoney(50);
	        BankNote thousandBahtNote = (BankNote) factory.createMoney(1000);
	        //*Test null as 4 baht coin doesnt exist.
	        Coin fourBahtCoin = (Coin) factory.createMoney(4);

	        assertEquals(new Coin(1,"Baht"), oneBahtCoin);
	        assertEquals(new Coin(2,"Baht"), twoBahtCoin);
	        assertEquals(new BankNote(50,"Baht"), fiftyBahtNote);
	        assertEquals(new BankNote(1000,"Baht"), thousandBahtNote);
	        //*Test not equals
	        assertNotEquals(new Coin(4,"Baht"), fourBahtCoin);
	}

	@Test
	public void testCreateMoneyString() {
		
	}
	
	@Test
	public void testSetFactory() {
		
	}
}

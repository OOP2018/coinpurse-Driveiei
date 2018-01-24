package coinpurse;

import java.util.ArrayList;
import java.util.List;

/**
 * MoneyUtil class use to sort the coins, print list of coins, separate the same
 * currency, test sort and comparedTo method.
 * 
 * @author Kornphon Noiprasert
 */
public class MoneyUtil {

	/**
	 * Configure and start the application.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		sortCoins();

	}

	/**
	 * Demonstrate that compareTo() method and sort by value of coins are correct.
	 */
	public static void sortCoins() {
		List<Coin> coins = new ArrayList<Coin>();
		System.out.println("===Starter===");
		coins.add(new Coin(20.0, "Baht"));
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		// test for different value by 0.5.
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(1.5, "Baht"));
		// test for same value and currency.
		coins.add(new Coin(1.0, "Rupie"));
		coins.add(new Coin(1.0, "Rupie"));
		// test for same value but, different currency.
		coins.add(new Coin(20.0, "Rupie"));
		// test if value less than 0
		coins.add(new Coin(-50, "Rupie"));
		printCoins(coins);
		System.out.println("===After Sort===");
		java.util.Collections.sort(coins);
		printCoins(coins);
		System.out.println("===Test compareTo method===");
		// test compareTo method - 3 cases
		// case 1. value a has order before value b. (result : -1).
		// (0-Rupie).compareTo(0.50-Baht).
		System.out.printf("(%.0f-%s).comparedTo(%.1f-%s).\n", coins.get(0).getValue(), coins.get(0).getCurrency(),
				coins.get(1).getValue(), coins.get(1).getCurrency());
		System.out.printf("returned : %d\n", coins.get(0).compareTo(coins.get(1)));
		// case 2. value a has order after value b. (result : 1).
		// (1-Baht).compareTo(0.50-Baht).
		System.out.printf("(%.0f-%s).comparedTo(%.1f-%s).\n", coins.get(2).getValue(), coins.get(2).getCurrency(),
				coins.get(1).getValue(), coins.get(1).getCurrency());
		System.out.printf("returned : %d\n", coins.get(2).compareTo(coins.get(1)));
		// case 3. value a and b have same order. (result : 0).
		// (1-Rupie).compareTo(1-Baht).
		System.out.printf("(%.0f-%s).comparedTo(%.0f-%s).\n", coins.get(4).getValue(), coins.get(4).getCurrency(),
				coins.get(2).getValue(), coins.get(2).getCurrency());
		System.out.printf("returned : %d\n", coins.get(4).compareTo(coins.get(2)));
		filterByCurrency(coins,"Baht");
		printCoins(coins);
		
	}

	/**
	 * Print a list of coins.
	 * 
	 * @param coins is list of coins with many currency values.
	 */
	public static void printCoins(List<Coin> coins) {
		for (Coin oneCoin : coins) {
			System.out.println(oneCoin);
		}
	}

	/**
	 * Filter coins by use the specified currency value of the coins.
	 * 
	 * @param coins is list of coins with many currency values.
	 * @param currency is currency value.
	 * @return a list of coins with the same currency value.
	 */
	public static List<Coin> filterByCurrency(List<Coin> coins, String currency) {
		List<Coin> toRemove = new ArrayList();
		
		for (Coin coin : coins) {
		    if (!coin.getCurrency().equals(currency)) {
		        toRemove.add(coin);
		    }
		}

		for (Coin coin : toRemove) {
		    coins.remove(coin);
		}
		
		return coins;
	}

	/**
	 * Sort all coins by using value of coins to sort and print a list of coins.
	 * 
	 * @param coins is list of coins with many currency values.
	 */
	public static void sortCoins(List<Coin> coins) {
		java.util.Collections.sort(coins);
		printCoins(coins);
	}
}

package coinpurse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * MoneyUtil class use to sort the coins or banknotes, print list of values,
 * separate the same currency, test sort and comparedTo method.
 * 
 * @author Kornphon Noiprasert
 */
public class MoneyUtil {

	private static Comparator<Valuable> comp = new ValueComparator();

	/**
	 * Configure and start the application.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		sortCoins();
	}

	/**
	 * Demonstrate that compareTo() method and sort by value of coins are correct
	 * including filterByCurrency.
	 */
	public static void sortCoins() {
		List<Coin> coins = new ArrayList<Coin>();
		System.out.println("===Starter===");
		coins.add(new Coin(20.0, "Baht"));
		coins.add(new Coin(50.0, "Baht"));
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
		coins.add(new Coin(0.5, "Rupie"));
		printCoins(coins);
		System.out.println("===After Sort===");
		java.util.Collections.sort(coins, comp);
		printCoins(coins);
		System.out.println("===Test compareTo method===");
		// test compareTo method - 3 cases
		// case 1. value a has order before value b. (result : -1).
		// (20-Baht).compareTo(50-Baht).
		System.out.printf("(%.2f-%s).comparedTo(%.2f-%s).\n", coins.get(0).getValue(), coins.get(0).getCurrency(),
				coins.get(1).getValue(), coins.get(1).getCurrency());
		System.out.printf("returned : %d\n", coins.get(0).compareTo(coins.get(1)));
		// case 2. value a has order after value b. (result : 1).
		// (2-Baht).compareTo(1-Baht).
		System.out.printf("(%.2f-%s).comparedTo(%.2f-%s).\n", coins.get(2).getValue(), coins.get(2).getCurrency(),
				coins.get(1).getValue(), coins.get(1).getCurrency());
		System.out.printf("returned : %d\n", coins.get(2).compareTo(coins.get(1)));
		// case 3. value a and b have same order. (result : 0).
		// (1-Rupie).compareTo(1-Rupie).
		System.out.printf("(%.2f-%s).comparedTo(%.2f-%s).\n", coins.get(7).getValue(), coins.get(7).getCurrency(),
				coins.get(8).getValue(), coins.get(8).getCurrency());
		System.out.printf("returned : %d\n", coins.get(7).compareTo(coins.get(8)));
		// case 4. value a and b by ValueComparator method Test
		// (50-Baht).compareTo(1-Rupie).
		System.out.printf("(%.2f-%s).comparedTo(%.2f-%s).\n", coins.get(5).getValue(), coins.get(5).getCurrency(),
				coins.get(8).getValue(), coins.get(8).getCurrency());
		System.out.printf("returned : %d\n", comp.compare(coins.get(5), coins.get(8)));
		System.out.println("==================End Coins====================");
		System.out.println("===Start test filter and sort===");
		List<Valuable> values = new ArrayList<Valuable>();
		List<Valuable> afterFilter = new ArrayList<Valuable>();
		values.addAll(coins);
		sortValues(values);
		afterFilter = filterByCurrency(values, "Baht");
		System.out.println("=========After filter========");
		System.out.println("---Only Baht---");
		printValues(afterFilter);
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
	 * Print a list of values.
	 * 
	 * @param values is a list of values with many currency values.
	 */
	public static void printValues(List<? extends Valuable> values) {
		for (Valuable oneValue : values) {
			System.out.println(oneValue);
		}
	}

	/**
	 * Filter coins by use the specified currency value of the coins.
	 * 
	 * @param values is a list of values with many currency values.
	 * @param currency is currency value.
	 * @return a list of values with the same currency value.
	 */
	public static <E extends Valuable> List<E> filterByCurrency(List<E> values, String currency) {
		List<E> toReturn = new ArrayList<E>();
		toReturn.addAll(values);
		for (Valuable value : values) {
			if (!value.getCurrency().equals(currency)) {
				toReturn.remove(value);
			}
		}
		return toReturn;
	}

	/**
	 * Return the larger argument, based on sort order, using the objects' own
	 * compareTo method for comparing.
	 * 
	 * @param args one or more Comparable objects to compare.
	 * @return the argument that would be last if sorted the elements.
	 * @throws IllegalArgumentException
	 *             if no arguments given.
	 */
	public static <E extends Comparable<? super E>> E max(E... args) {
		List<E> anyPurse = new ArrayList<E>();
		for (E anything : args) {
			anyPurse.add(anything);
		}
		if(anyPurse.size() == 0) {
			return null;
		}
		E max = anyPurse.get(0);
		for (int i = 0; i < anyPurse.size() - 1; i++) {
			if(anyPurse.get(i).compareTo(anyPurse.get(i + 1)) < 0){
				max = anyPurse.get(i+1);
			}
		}
		return max;
	}

	/**
	 * Sort all values by using value of coin or bank to sort and print a list of
	 * values.
	 * 
	 * @param values is list of coins or banknotes with many currency values.
	 */
	public static void sortValues(List<? extends Valuable> values) {
		java.util.Collections.sort(values, comp);
		printValues(values);
	}
}

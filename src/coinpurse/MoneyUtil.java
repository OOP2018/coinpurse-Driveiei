package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {

	public static void main(String[] args) {
		sortCoins();
	}

	public static void sortCoins() {
		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(20.0, "Baht"));
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		//test for different value by 0.5.
		coins.add(new Coin(1.0, "Baht"));
		coins.add(new Coin(1.5,"Baht"));
		//test for same value and currency.
		coins.add(new Coin(1.0,"Rupie")); 
		coins.add(new Coin(1.0,"Rupie"));
		//test for same value but, different currency.
		coins.add(new Coin(20.0,"Rupie"));
		// test if value less than 0
		coins.add(new Coin(-50,"Rupie")); 
		printCoins(coins);
		System.out.println("=====================");
		java.util.Collections.sort(coins);
		printCoins(coins);
	}

	public static void printCoins(List<Coin> coins) {
		for (Coin oneCoin : coins) {
			System.out.println(oneCoin);
		}
	}

}

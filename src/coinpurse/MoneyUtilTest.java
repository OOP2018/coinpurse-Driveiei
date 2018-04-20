package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoneyUtilTest {
	public static void main(String[] args) {

		String max = MoneyUtil.max("dog", "zebra", "cat");
		System.out.println(max);

		Money m1 = new BankNote(100, "Baht", 100);
		Money m2 = new BankNote(500, "Baht", 101);
		Money m3 = new Coin(20, "Baht");
		Money maximum = MoneyUtil.max(m1, m2, m3); // should be max=m2
		System.out.println(maximum);
		System.out.println("=====");

		List<BankNote> list = new ArrayList<BankNote>();
		list.add(new BankNote(10.0, "USD", 1000));
		list.add(new BankNote(500.0, "Baht", 1001));
		MoneyUtil.sortValues(list);
		System.out.println("=====");

		List<Coin> coins = Arrays.asList(new Coin(5, "Baht"), new Coin(0.1, "Ringgit"), new Coin(5, "Cent"));
		List<Coin> result = MoneyUtil.filterByCurrency(coins, "Baht"); // Error
		for (Coin x : result) {
			System.out.println(x);
		}
	}

}

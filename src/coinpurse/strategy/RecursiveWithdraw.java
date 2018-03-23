package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

public class RecursiveWithdraw {

	private List<Valuable> list = new ArrayList<>();

	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables) {
		list.clear();
		if (withdrawHelper(0, valuables, amount)) {
			return list;
		}
		return null;
	}

	private boolean withdrawHelper(int start, List<Valuable> money, Valuable amount) {
		if (start >= money.size())
			return amount.getValue() == 0;
		if (withdrawHelper(start + 1, money, new Money(amount.getValue() - money.get(start).getValue(),
				money.get(start).getCurrency()))) {
			list.add(money.get(start));
			return true;
		}
		if (withdrawHelper(start + 1, money, amount))
			return false;
		return false;
	}
}

package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;
import coinpurse.ValueComparator;

public class GreedyWithdraw implements WithdrawStrategy {
	
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> valuables) {
		if (amount == null || amount.getValue() <= 0 ) {
			return null;
		}
		Comparator<Valuable> comp = new ValueComparator();
		double amountNeededToWithdraw = amount.getValue();
		List<Valuable> templist = new ArrayList<Valuable>();
		Collections.sort(valuables , comp);
		
		List<Valuable> calculate = new ArrayList<Valuable>();
		for(Valuable oneValue : valuables) {
			if(amount.getCurrency().equalsIgnoreCase(oneValue.getCurrency())) {
				calculate.add(oneValue);
			}
		}
		int size = calculate.size();
		for (int j = 0; j < size; j++) {
			for (int i = size - (j + 1); i >= 0; i--) {
				if (amountNeededToWithdraw >= calculate.get(i).getValue()) {
					amountNeededToWithdraw -= calculate.get(i).getValue();
					templist.add(calculate.get(i));
				}
				if (amountNeededToWithdraw == 0) {
					break;
				}
				if (size == 1) {
					amountNeededToWithdraw = amount.getValue();
					templist.clear();
					size = calculate.size();
				} else {
					size--;
				}
			}
		}
		if (amountNeededToWithdraw != 0) {
			return null;
		}
		return templist;
	}
	
}

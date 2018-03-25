package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.Valuable;

/**
 * A RecursiveStrategy represents a withdraw method which can draw the money
 * with recursive process.
 * 
 * @author Kornphon Noiprasert
 * */
public class RecursiveWithdraw implements WithdrawStrategy {

	private List<Valuable> list = new ArrayList<>();

	/**
	* Find and return items from a collection whose total value equals
	* the requested amount.
	* @param amount is the amount of money to withdraw, with currency
	* @param money the contents that are available for possible withdraw.
	* Must not be null, but may be an empty list.
	* This list is not modified.
	* @return if a solution is found, return a List containing references
	* from the money parameter (List) whose sum equals the amount.
	*/
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		list.clear();
		if(amount == null || amount.getValue() == 0) return null;
		if (helper(0, money, amount))
			return list;
		return null;
	}

	/**
	 * helper is recursive method which helps withdraw method to withdraw a money more easier.
	 * 
	 * @param start is the integer number to count the loop for helping recursive easily.
     * @param amount is the amount of money to withdraw, with currency
     * @param money the contents that are available for possible withdraw.
     * @return the truth value that can withdraw the money or not.
	 * */
	public boolean helper(int start, List<Valuable> money, Valuable amount) {
		if (start >= money.size()) return amount.getValue() == 0;
		if (money.get(start).getCurrency().equals(amount.getCurrency())) {
			if (helper(start + 1, money, new Money(amount.getValue() - money.get(start).getValue(), money.get(start).getCurrency()))) {
				list.add(money.get(start));
				return true;
			}
		}
			if (helper(start + 1, money, amount)) return true;
		return false;
	}

}
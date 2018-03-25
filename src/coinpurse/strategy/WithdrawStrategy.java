package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

/**
 * A WithdrawStrategy represents a withdraw method which can draw with any process
 * of any method be.
 * 
 * @author Kornphon Noiprasert
 * */
public interface WithdrawStrategy {
	
	/**
	 * Withdraw the requested amount of money with fixed money. Return an array of Valuable withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount is the amount to withdraw that must have the same currency with the purse.
	 * @return List of valuable objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public List<Valuable> withdraw(Valuable amount , List<Valuable> valuables);
}

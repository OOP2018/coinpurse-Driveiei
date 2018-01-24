package coinpurse;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
// You will use Collections.sort() to sort the coins

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full.
 * 
 * @author Kornphon Noiprasert
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Coin> money;

	/**
	 * Capacity is maximum number of items the purse can hold. Capacity is set when
	 * the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		money = new ArrayList<Coin>();
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double total = 0;
		for (Coin oneMoney : money) {
			total = total + oneMoney.getValue();
		}
		return total;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in purse
	 * equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		return money.size() >= capacity;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		// if the purse is already full then can't insert anything.
		if (isFull() || coin.getValue() <= 0) {
			return false;
		} else {
			money.add(coin);
			return true;
		}
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins withdrawn
	 * from purse, or return null if cannot withdraw the amount requested.
	 * 
	 * @param amount is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot withdraw
	 *         requested amount.
	 */
	public Coin[] withdraw(double amount) {
		if (amount <= 0 || amount > getBalance() || count() == 0) {
			return null;
		}
		
		double amountNeededToWithdraw = amount;
		List<Coin> templist = new ArrayList<Coin>();
		java.util.Collections.sort(money);
		for (int j = 0; j < money.size(); j++) {
			for (int i = money.size() - (j + 1); i >= 0; i--) {
				if (amountNeededToWithdraw >= money.get(i).getValue()) {
					amountNeededToWithdraw -= money.get(i).getValue();
					templist.add(money.get(i));
				}
				if (amountNeededToWithdraw == 0) {
					break;
				}
				if (money.get(i).getValue() == money.get(0).getValue()) {
					amountNeededToWithdraw = amount;
					templist.removeAll(templist);
				}
			}
		}
		
		if (amountNeededToWithdraw != 0) {
			return null;
		}
		
		for (int i = 0; i < templist.size(); i++) {
			money.remove(templist.get(i));
		}
		Coin[] changeToArray = new Coin[templist.size()];
		return templist.toArray(changeToArray);
	}

	/**
	 * toString returns a string description of the purse contents. It can return
	 * whatever is a useful description.
	 * 
	 * @return many coins and values that are in purse.
	 */
	@Override
	public String toString() {
		return String.format("%d coins with value %.1f", count(), getBalance());
	}

}

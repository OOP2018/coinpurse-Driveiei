package coinpurse.strategy;

import java.util.List;

import coinpurse.Valuable;

public interface WithdrawStrategy {
	public List<Valuable> withdraw(Valuable amount , List<Valuable> valuables);
	
}

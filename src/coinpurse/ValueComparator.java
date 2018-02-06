package coinpurse;

import java.util.Comparator;

/*
 * Compare two valuables and define which one has more value than other.
 * 
 * @author Kornphon Noiprasert
 * */
public class ValueComparator implements Comparator<Valuable> {

	/**
	 * Compare two objects that implement Valuable.
	 * First compare them by currency how many alphabets are more, so that "Baht" < "Dollar".
	 * If both objects have the same currency, order them by value.
	 * 
	 * @param a is a value of coin or banknote that have a value and currency (or serialNumber).
	 * @param b is a value of coin or banknote that have a value and currency (or serialNumber).
	 * @return -1(negative integer) if a has order before b.
	 *         0(zero) if a and b have the same order.
	 *         1(positive integer) if a has order after b.
	 */
	public int compare(Valuable a, Valuable b) {
        if (a.getCurrency().length() == (b.getCurrency()).length() ) {
            if (a.getValue() < b.getValue()) return -1;
            else if (a.getValue() > b.getValue()) return 1;
            else return 0;
        }
        else if(a.getCurrency().length() < b.getCurrency().length()) return -1;
		else return 1;
	}

}

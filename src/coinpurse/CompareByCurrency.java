package coinpurse;

import java.util.Comparator;

public class CompareByCurrency implements Comparator<Coin> {
	@Override
	public int compare(Coin o1, Coin o2) {
		// TODO Auto-generated method stub
		return o1.getCurrency().compareTo(o2.getCurrency());	}
}

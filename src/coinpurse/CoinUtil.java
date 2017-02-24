package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.sound.sampled.ReverbType;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 */
public class CoinUtil implements Valuable {

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(
			final List<Valuable> valuelist, String currency) {
		List<Valuable> reValue = new ArrayList<Valuable>();
		for (Valuable v : valuelist) {
			if (v.getCurrency().equals(currency)) {
				reValue.add(v);
			}
		}
		return reValue; // return a list of coin references copied from coinlist
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param coins
	 *            is a List of Coin objects we want to sort.
	 *
	 *            TODO: 1. Write a Comparator<Coin> (you can write the class at
	 *            the end of this file. Declare it as "class CompareByCurrency"
	 *            without the "public"). You can also write Comparator as an
	 *            anonymous class, if you know how. The compare method should
	 *            order coins by currency. 2. Create a comparator instance and
	 *            use it to sort the coins.
	 */
	public static void sortByCurrency(List<Valuable> values) {
		Collections.sort(values, new Comparator<Valuable>() {

			@Override
			public int compare(Valuable arg0, Valuable arg1) {
				return (int) Math.signum(arg0.getValue() - arg1.getValue());
			}
		});
	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency. For example: coins = { Coin(1,"Baht"),
	 * Coin(20,"Ringgit"), Coin(10,"Baht"), Coin(0.5,"Ringgit") } then
	 * sumByCurrency(coins) would print:
	 * 
	 * 11.00 Baht 20.50 Ringgit
	 * 
	 * Hint: this is easy if you sort the coins by currency first. :-)
	 */
	public static void sumByCurrency(List<Valuable> value) {
		Map<String, Double> map = new HashMap<String, Double>();
		for (Valuable values : value) {
			if (map.containsKey(values.getCurrency())) {
				map.put(values.getCurrency(),
						values.getValue() + map.get(values.getCurrency()));
			} else
				map.put(values.getCurrency(), values.getValue());
		}
		for (String key : map.keySet()) {
			System.out.print(map.get(key)+"-");
			System.out.println(key);
			

		}
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Valuable> values = makeInternationalCoins();
		int size = values.size();
		System.out.print(" INPUT: ");
		printList(values, " ");
		List<Valuable> rupees = filterByCurrency(values, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (values.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		values = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(values, " ");
		sortByCurrency(values);
		System.out.print("RESULT: ");
		printList(values, " ");

		System.out.println("\nSum coins by currency");
		values = makeInternationalCoins();
		System.out.print("coins= ");
		printList(values, " ");
		sumByCurrency(values);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
			list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCurrency() {
		// TODO Auto-generated method stub
		return null;
	}
}

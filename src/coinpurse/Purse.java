package coinpurse;

//TODO import ArrayList and Collections (so you can use Collections.sort())
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author your name
 */
public class Purse {
	/** Collection of objects in the purse. */
	// TODO declare a List of Coins named "money".
	List<Coin> money = new ArrayList<Coin>();
	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;
	private double balance;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacit
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		// TODO initialize the attributes of purse
		this.capacity = capacity;
		this.balance = 0.0;
	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		return this.money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {

		for (int i = 0; i < count(); i++) {
			this.balance = this.balance + money.get(i).getValue();
		}
		return this.balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	// TODO write accessor method for capacity. Use Java naming convention.
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		// TODO complete this method
		// TODO Don't Repeat Yourself: Avoid writing duplicate code.
		if (count() >= this.capacity) {
			return true;
		}
		return false;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		// if the purse is already full then can't insert anything.
		// TODO complete the insert method
		if (!isFull()) {
			if (coin.getValue() <= 0) {
				return false;
			} else {
				money.add(coin);
				return true;
			}
		}
		return false;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Coin[] withdraw(double amount) {
		// TODO don't allow to withdraw amount < 0
		List<Coin> templist = new ArrayList<Coin>();
		Collections.sort(money);
		Collections.reverse(money);
		if (amount < 0)
			return null;
		/*
		 * See lab sheet for outline of a solution, or devise your own solution.
		 */

		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
		if (amount > this.balance) { // failed. Don't change the contents of the
			// purse.
			// Collections.sort(money);
			return null;
		}
		for (Coin d : money) {
			if (d.getValue() <= amount) {
				templist.add(d);
				amount -= d.getValue();
			}
		}
		System.out.println("Amount = " + amount);
		if (amount == 0) {

			for (Coin c : templist) {
				for (Coin e : money) {
					if (c.equals(e)) {
						this.balance -= e.getValue();
						money.remove(e);

						break;
					}
				}
			}

			Coin[] array = new Coin[templist.size()];
			templist.toArray(array);

			// Success.
			// Remove the coins you want to withdraw from purse,
			// and return them as an array.
			// Use list.toArray( array[] ) to copy a list into an array.
			// toArray returns a reference to the array itself.
			return array;
		}
		return null;// TODO replace this with real code
	}

	/**
	 * toString returns a string description of the purse contents. It can
	 * return whatever is a useful description.
	 */
	public String toString() {
		// TODO complete this
		return count() + " coins with value " + this.balance;
	}

	
}
// TODO remove the TODO comments after you complete them.
// TODO When you are finished, there should not be any TODO. Including this one.

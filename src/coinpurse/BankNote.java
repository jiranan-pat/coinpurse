package coinpurse;

public class BankNote implements Valuable {
	
	public static final String DEFAULT_CURRENCY = "Baht";
	private double value;
	private String currency;
	private long serialNumber;

	
	public BankNote(double value) {
		this.value = value;
		
	}
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency;
	}

	public long getSerial() {
		return serialNumber;
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
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote other = (BankNote) obj;
		if ((other.value == this.value)
				&& (other.currency.equalsIgnoreCase(this.currency))) {
			return true;
		}
		return false;
	}
	public String toString() {
		return value + "-" + currency + " note" + " ["+ serialNumber+"]";
	}

}

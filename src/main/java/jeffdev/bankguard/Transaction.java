package jeffdev.bankguard;

public class Transaction {
	private double amount;
	private String type;
	private boolean international;
	private int failedAttempts;

	public Transaction(double amount, String type, boolean international, int failedAttempts) {
		this.amount = amount;
		this.type = type;
		this.international = international;
		this.failedAttempts = failedAttempts;
	}

	public double getAmount() {
		return amount;
	}

	public String getType() {
		return type;
	}

	public boolean isInternational() {
		return international;
	}

	public int getFailedAttempts() {
		return failedAttempts;
	}
}

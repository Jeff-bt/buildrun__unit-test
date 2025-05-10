package jeffdev.bankguard;

public class TransactionValidator {
	public String validateTransaction(Transaction transaction) {
		if (transaction.getAmount() <= 0) {
			throw new IllegalArgumentException("Invalid transaction amount.");
		}
		if (transaction.getFailedAttempts() >= 3) {
			return "BLOCKED";
		}
		if (transaction.isInternational() && transaction.getAmount() > 1000) {
			return "MANUAL REVIEW";
		}
		if (transaction.getType().equalsIgnoreCase("PIX") && transaction.getAmount() > 5000) {
			return "MANUAL REVIEW";
		}
		if (transaction.getAmount() > 10000) {
			return "BLOCKED";
		}
		return "APPROVED";
	}
}

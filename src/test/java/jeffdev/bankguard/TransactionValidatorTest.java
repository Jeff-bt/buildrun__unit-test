package jeffdev.bankguard;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TransactionValidatorTest {

	TransactionValidator transactionValidator = new TransactionValidator();

	Transaction dummyTransaction = new Transaction(
			0.0,
			"PIX",
			false,
			0
	);

	@Nested
	class validateTransaction {

		@Test
		void shouldThrowIllegalArgumentWhenAmountEqualZero() {

			var errorMessage = assertThrows(IllegalArgumentException.class, () -> {
				transactionValidator.validateTransaction(dummyTransaction);
			});
			assertEquals("Invalid transaction amount.", errorMessage.getMessage());
		}
	}
}
package jeffdev.authms;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class UserTest {

	User user = new User("jeff", "123");

	@Nested
	class changePassword {

		@Test
		void shouldChangePasswordSuccess() {
			//arange
			String newPassword = "123456";
			//act
			user.changePassword(newPassword);
			//assert
			assertEquals(newPassword, user.getPassword());
		}

		@ParameterizedTest
		@NullSource
		void ShouldThrowExceptionWhenPasswordIsNull(String password) {
			//act e assert
			var erroMessage = assertThrows(IllegalArgumentException.class, () -> {
				user.changePassword(password);
			});

			assertEquals("A senha não pode ser vazia", erroMessage.getMessage());
		}

		@ParameterizedTest
		@ValueSource(strings = {"", " "})
		void ShouldThrowExceptionWhenPasswordIsEmpty(String password) {
			//act e assert
			var erroMessage = assertThrows(IllegalArgumentException.class, () -> {
				user.changePassword(password);
			});

			assertEquals("A senha não pode ser vazia", erroMessage.getMessage());
		}
	}

	@Nested
	class isValidPassword {

		@Test
		void shouldReturnTrueWhenPasswordIsValid() {
			//act
			var result = user.isValidPassword("123");
			//assert
			assertTrue(result);
		}

		@Test
		void shouldReturnFalseWhenPasswordIsNotValid() {
			//act
			var result = user.isValidPassword("1234");
			//assert
			assertFalse(result);
		}
	}
}
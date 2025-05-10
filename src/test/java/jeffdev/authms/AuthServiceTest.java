package jeffdev.authms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

	@Mock
	User user;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	AuthService authService;

	@BeforeAll
	public static void beforeAll() {

	}

	@Nested
	class authenticate {

		@Test
		void shouldReturnTrueWhenAuthenticateIsValid() {
			String username = "Jeff";
			String password = "123";
			doReturn(user).when(userRepository).findByUsername(eq(username));
			doReturn(true).when(user).isValidPassword(eq(password));

			var result = authService.authenticate(username, password);

			assertTrue(result);
			verify(userRepository, times(1)).findByUsername(eq(username));
			verify(user, times(1)).isValidPassword(eq(password));
		}

		@Test
		void shouldReturnFalseWhenUserDoesNotFind() {
			String username = "Jeff";
			String password = "123";
			doReturn(user).when(userRepository).findByUsername(eq(username));
			doReturn(false).when(user).isValidPassword(eq(password));

			var result = authService.authenticate(username, password);

			assertFalse(result);
			verify(userRepository, times(1)).findByUsername(eq(username));
			verify(user, times(1)).isValidPassword(eq(password));
		}

		@Test
		void shouldReturnFalseWhenUserExistAndPasswordIsInvalid() {
			String username = "Jeff";
			String password = "123";

			doReturn(null).when(userRepository).findByUsername(eq(username));

			var result = authService.authenticate(username, password);

			assertFalse(result);
			verify(userRepository, times(1)).findByUsername(eq(username));
		}
	}

	@Nested
	class register {
	}
}
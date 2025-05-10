package jeffdev.mockito;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //É colocado essa extensão para o @Mock e @InjectMocks funcionarem
class UserServiceTest {

	@Mock
	private Database databaseMock;

	@InjectMocks
	private UserService userService;

	@Nested
	class getUserStatus {

		@Test
		@DisplayName("Should return an active user")
		void shouldReturnAnActiveUser() {
			//Arrange
			int userId = 1;
			doReturn("ACTIVE").when(databaseMock).getStatus(userId); // test stub, fazer um retorno quando algo x acontecer;
			//Act
			var result = userService.getUserStatus(userId);
			// Assert
			assertEquals("ACTIVE", result);
			verify(databaseMock, times(1)).getStatus(userId);
		}
	}
}

@ExtendWith(MockitoExtension.class) //É colocado essa extensão para o @Mock e @InjectMocks funcionarem
class UserServiceTest2 {

//	@Mock
//	private Database databaseMock;

	@Spy //Usa agora o banco de dados real
	private RealDatabase realDatabase;

	@InjectMocks
	private UserService userService;

	@Nested
	class getUserStatus {

		@Test
		@DisplayName("Should return an active user")
		void shouldReturnAnActiveUser() {
			//Arrange
			int userId = 1;
			doReturn("ACTIVE").when(realDatabase).getStatus(userId); // Usando o test stub, consigo sobrescrever o reusltado do banco real
			//Act
			var result = userService.getUserStatus(userId);
			// Assert
			assertEquals("ACTIVE", result);
			verify(realDatabase, times(1)).getStatus(userId);
		}
	}
}

//@ExtendWith(MockitoExtension.class) //É colocado essa extensão para o @Mock e @InjectMocks funcionarem
class UserServiceTest3 {

	//	@Mock
	private static Database databaseMock;

//	@Spy
//	private static RealDatabase realDatabase;

	//	@InjectMocks
	private static UserService userService;

	@BeforeAll
	public static void beforeAll() {
		databaseMock = mock(Database.class);
		userService = new UserService(databaseMock);
	}

	@Nested
	class getUserStatus {

		@Test
		@DisplayName("Should return an active user")
		void shouldReturnAnActiveUser() {
			//Arrange
			int userId = 1;
			doReturn("ACTIVE").when(databaseMock).getStatus(userId); // test stub, fazer um retorno quando algo x acontecer;
			//Act
			var result = userService.getUserStatus(userId);
			// Assert
			assertEquals("ACTIVE", result);
			verify(databaseMock, times(1)).getStatus(userId);
		}
	}
}
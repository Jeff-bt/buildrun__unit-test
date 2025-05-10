package jeffdev;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {

	private Calculadora calculadora = new Calculadora();

	@Nested
	class somar {

		@Test
		@DisplayName("Deve adicionar 2 numeros")
		void shouldAddTwoNubemrs() {
			// Tripe AAA (Arrange, act, Assert)

			// Arrange (preparar)
			int a = 2;
			int b = 3;

			// act (atuar)
			var soma = calculadora.somar(a, b);

			// Assert (validar)
			assertEquals(5, soma);
		}

		@Test
		void shouldAddWhenTwoNumbersIsZero() {
			// Tripe AAA (Arrange, act, Assert)

			// Arrange (preparar)
			int a = 0;
			int b = 0;

			// act (atuar)
			var soma = calculadora.somar(a, b);

			// Assert (validar)
			assertEquals(0, soma);
		}
	}

	@Nested
	class subtrair {

		@Test
		void deveSubtrair() {

			int a = 5;
			int b = 3;

			var result = calculadora.subtrair(a, b);

			assertEquals(2, result);

		}
	}

	@Nested
	class dividir {

		@Test
		void shouldThrowExceptionWhenDivideToZero() {

			// Arrange
			int a = 4;
			int b = 0;

			// Act & Assert
			assertThrows(ArithmeticException.class, () -> calculadora.dividir(a, b));

		}
	}
}
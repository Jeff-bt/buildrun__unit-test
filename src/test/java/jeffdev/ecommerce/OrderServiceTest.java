package jeffdev.ecommerce;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

	@Mock
	private OrderRepository repository;

	@Captor
	private ArgumentCaptor<Order> orderArgumentCaptor;

	@InjectMocks
	private OrderService orderService;

	@Nested
	class placeOrder {

		@Test
		void shouldPlaceOrderWithSuccess() {
			//arrange
			var dummyOrder = new Order(1, "Jeff", 200.0);
			//act
			orderService.placeOrder(dummyOrder);
			//assert
			verify(repository, times(1)).save(orderArgumentCaptor.capture());
			var orderCaptured = orderArgumentCaptor.getValue();
			assertEquals(dummyOrder, orderCaptured);
		}

		@Test
		void shouldThrowExceptionWhenTOtalIsBelowOrEqualZeroVersao1() {
			//arrange
			var dummyOrder = new Order(1, "Jeff", 0);
			//act & Assert
			assertThrows(IllegalArgumentException.class, () -> {
				orderService.placeOrder(dummyOrder);
			});

			verify(repository, times(0)).save(any());
		}

		//Dessa maneira ele vai fazer varios teste com base na quantidade de valuesSource, ou seja ele testará o total com 0, -2.0 e -50.0
		@ParameterizedTest
		@ValueSource(doubles = {0, -2.0, -50.0})
		void shouldThrowExceptionWhenTOtalIsBelowOrEqualZeroVersao2(double total) {
			//arrange
			var dummyOrder = new Order(1, "Jeff", total);
			//act & Assert
			assertThrows(IllegalArgumentException.class, () -> {
				orderService.placeOrder(dummyOrder);
			});

			verify(repository, times(0)).save(any());
		}

		@Test
		void shouldThrowExceptionWhenPlaceOrder() {
			//arrange
			var dummyOrder = new Order(1, "Jeff", 200.0);
			doThrow(new RuntimeException()).when(repository).save(any());
			//act & Assert
			assertThrows(RuntimeException.class, () -> {
				orderService.placeOrder(dummyOrder);
			});
		}
	}

	@Nested
	class getOrder {

		@Test
		void shouldReturnOrderWhenExists() {
			//arrange
			var orderId = 1;
			var dummyOrder = new Order(1, "Jeff", 200.0);
			doReturn(dummyOrder).when(repository).findById(eq(orderId)); // test stub
			//act
			var order = orderService.getOrder(orderId);
			//assert
			assertNotNull(order);
			verify(repository, times(1)).findById(eq(orderId));
			assertEquals(dummyOrder, order);
		}

		@Test
		void shouldReturnNullWhenOrderDoesNotExists() {
			//arrange
			var orderId = 1;
			doReturn(null).when(repository).findById(eq(orderId)); // test stub
			//act
			var order = orderService.getOrder(orderId);
			//assert
			assertNull(order);
			verify(repository, times(1)).findById(eq(orderId));
		}
	}
}
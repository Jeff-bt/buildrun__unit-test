package jeffdev.ecommerce;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RealOrderRepositoryTest {

	@Spy
	private HashMap<Integer, Order> ordersSpy;

	@Captor
	private ArgumentCaptor<Order> orderArgumentCaptor;

	@InjectMocks
	private RealOrderRepository realOrderRepository;

	@Nested
	class sabe {

		@Test
		@DisplayName("Should save order")
		void shouldSaveOrder() {
			// arrange
			var dummyOrder = new Order(1, "Jeff", 200.0);
			// act
			realOrderRepository.save(dummyOrder);
			// assert
			verify(ordersSpy, times(1)).put(eq(dummyOrder.getId()), orderArgumentCaptor.capture());
			var orderCaptured = orderArgumentCaptor.getValue();
			assertSame(dummyOrder, orderCaptured);
		}

		@Test
		@DisplayName("Should find by id when order exists")
		void shouldFindByIdWhenOrderExists() {
			// arrange
			int id = 1;
			var dummyOrder = new Order(1, "Jeff", 200.0);
			doReturn(dummyOrder).when(ordersSpy).get(eq(id)); // Test stub
			// act
			var order = realOrderRepository.findById(id);
			// assert
			assertNotNull(order);
			assertEquals(dummyOrder, order);
			verify(ordersSpy, times(1)).get(eq(id));
		}

		@Test
		@DisplayName("Should return null order when does not exists")
		void shouldReturnNullOrderWhenDoesNotExists() {
			// arrange
			int id = 1;
			doReturn(null).when(ordersSpy).get(eq(id)); // Test stub
			// act
			var order = realOrderRepository.findById(id);
			// assert
			assertNull(order);
			verify(ordersSpy, times(1)).get(eq(id));
		}
	}
}
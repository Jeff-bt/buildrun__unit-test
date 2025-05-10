package jeffdev.ecommerce;

public class OrderService {
	private OrderRepository repository;

	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}

	public void placeOrder(Order order) {
		if (order.getTotal() <= 0) {
			throw new IllegalArgumentException("Total do pedido deve ser positivo");
		}
		repository.save(order);
	}

	public Order getOrder(int id) {
		return repository.findById(id);
	}
}

package jeffdev.ecommerce;

public class Order {
	private int id;
	private String customer;
	private double total;

	public Order(int id, String customer, double total) {
		this.id = id;
		this.customer = customer;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public String getCustomer() {
		return customer;
	}

	public double getTotal() {
		return total;
	}
}
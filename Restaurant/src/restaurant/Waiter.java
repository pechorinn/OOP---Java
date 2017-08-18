package restaurant;

import java.util.ArrayList;
import clients.Order;

public class Waiter {

	private double cash;
	private String name;
	private ArrayList<Order> myOrders;

	public Waiter(String name) {
		super();
		this.cash = 0;
		this.name = name;
		myOrders = new ArrayList<>();
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash += cash;
	}

	public String getName() {
		return name;
	}

	public void takeOrder(Order order) {
		System.out.println("Waiter " + name + " took order.");
		myOrders.add(order);
	}

	public double deliverBill(Order order) {
        System.out.println("The bill was presented to the client: " + order.getClient().getName() );
		return order.getCost();
	}

	
}

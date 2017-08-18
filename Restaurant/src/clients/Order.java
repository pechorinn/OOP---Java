package clients;

import java.util.ArrayList;

import menuitems.MenuItems;
import restaurant.Waiter;

public class Order {

	private ArrayList<MenuItems> order;
	private Client client;
	private Waiter waiter;
	private double cost;
	private boolean paid;
	private double orderCost;

	public Order(ArrayList<MenuItems> order, Client client, Waiter waiter, double orderCost) {
		super();
		this.order = order;
		this.client = client;
		this.waiter = waiter;
		this.cost = orderCost;
	}

	
	public void setPaid() {
		paid = true;
	}

	public boolean isPaid() {
		return paid;
	}

	public double getCost() {
		return cost;
	}

	public Client getClient() {
		return client;
	}


	@Override
	public String toString() {
		return "Order [order=" + order + ", client=" + client + ", waiter=" + waiter + ", cost=" + cost + ", paid="
				+ paid + ", orderCost=" + orderCost + "]";
	}

	
}

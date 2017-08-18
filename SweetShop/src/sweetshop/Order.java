package sweetshop;

import java.time.LocalDate;
import java.util.ArrayList;

import cake.Cake;
import client.Client;

public class Order {
	private static int orderNumber;
	private int uniqueOrderNumber;
	private Client client;
	private double price;
	private String address;
	private ArrayList<Cake> orderedCakes;
	private LocalDate localDate;
	private boolean handled;
	private DeliveryMan deliveryMan;
	private double discountAmount;

	public Order(Client client, double price, String address, ArrayList<Cake> orderedCakes, LocalDate localDate) {
		super();
		if (client == null) {
			throw new IllegalArgumentException();
		}
		this.client = client;
		if (price < 0) {
			throw new IllegalArgumentException();
		}
		this.price = price;
		if (address == null || address.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.address = address;
		if (orderedCakes == null) {
			throw new IllegalArgumentException();
		}
		this.orderedCakes = orderedCakes;
		this.localDate = localDate;
		orderNumber++;
		uniqueOrderNumber = orderNumber;
	}

	public ArrayList<Cake> getOrderedCakes() {
		return orderedCakes;
	}

	public void setPrice(double price) {
		this.price += price;
	}

	public void setDeliveryMan(DeliveryMan deliveryMan) {
		this.deliveryMan = deliveryMan;
		deliveryMan.deliverOrder(this);
	}

	public String getAddress() {

		return address;
	}

	public int getUniqueOrderNumber() {
		return uniqueOrderNumber;
	}

	public String getClientName() {
		return client.getName();
	}

	public Client getClient() {
		return client;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		String priceString = String.format("%.2f", price);
		String discountString = String.format("%.2f$", discountAmount);
		return "\nOrder information:\n----------------------------------\nOrder [uniqueOrderNumber: "
				+ uniqueOrderNumber + ", client: " + client.getName() + ", price: " + priceString + ", address: "
				+ address + ", orderedCakes: " + orderedCakes + ",\n Discount amount: " + discountString
				+ " \n Delivery date: " + localDate + ",\n handled: " + handled + ",\n " + "Deliviry man: "
				+ deliveryMan + "\n----------------------------------";
	}

	public void setStatusHandled() {
		handled = true;
	}

	public void setDiscountAmount(double d) {
		this.discountAmount = d;
	}

}

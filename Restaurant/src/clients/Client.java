package clients;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import menuitems.MenuItems;
import restaurant.Restaurant;
import restaurant.Waiter;
import restaurant.Restaurant.MenuItem;

public abstract class Client {

	protected double cash;
	protected String name;
	protected Restaurant myRestaurant;
	protected ArrayList<Order> myOrders;
	protected Waiter myWaiter;
	protected static Random rnd = new Random();

	protected Client(double cash, String name, Restaurant myRestaurant) {
		super();
		if (cash < 0) {
			throw new IllegalArgumentException();
		}
		this.cash = cash;
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}

		this.name = name;
		this.myRestaurant = myRestaurant;
		myRestaurant.getClients().add(this);
		myOrders = new ArrayList<>();
	}

	protected abstract boolean checkAccordingToDiet(MenuItems item);

	protected Waiter getRandomWaiter() {
		myWaiter = myRestaurant.getWaiters().get(rnd.nextInt(myRestaurant.getWaiters().size()));
		return myWaiter;
	}

	public void placeAnOrder() {
		HashMap<MenuItem, ArrayList<MenuItems>> hashMap = myRestaurant.getMenu();
		ArrayList<MenuItems> orderedItems = new ArrayList<>();
		Waiter waiter = getRandomWaiter();
		Order currentOrder = new Order(orderedItems, this, waiter, scanMenu(hashMap, orderedItems));
		myOrders.add(currentOrder);
		System.out.println("The client " + name + " made an order.");
		waiter.takeOrder(currentOrder);
	}

	private double scanMenu(HashMap<MenuItem, ArrayList<MenuItems>> hashMap, ArrayList<MenuItems> orderedItems) {

		double orderCost = 0;
		for (Map.Entry<MenuItem, ArrayList<MenuItems>> entry : hashMap.entrySet()) {
			// to make sure the order is random
			Collections.shuffle(hashMap.get(entry.getKey()));
			for (MenuItems item : hashMap.get(entry.getKey())) {
				int itemsCount = rnd.nextInt(3) + 1;
				if (checkAccordingToDiet(item)) {
					if (item.getAvailableCount() - itemsCount < 0 && orderCost > cash * 0.9) {
						System.out.println("Item is not available: " + item.getName());
						System.out.println("Available count of " + item.getName() + ": " + item.getAvailableCount());
						System.out.println("Were ordered " + itemsCount + " items of " + item.getName() + ".");
						continue;
					} else {

						if (orderCost + item.getPrice() * itemsCount <= cash * 0.9) {
							orderCost += item.getPrice() * itemsCount;
							// System.out.println("orderCost: " + orderCost);
							orderedItems.add(item);
							item.setAvailableCount(-itemsCount);
							System.out.println(
									"The client " + name + " orders: " + item.getName() + ", count = " + itemsCount);
							System.out.println(
									"Available count of " + item.getName() + " left: " + item.getAvailableCount());
							System.out.println("Client's cash: " + cash);
						} else {
							break;
						}
					}
				}
			}
		}

		return orderCost;

	}

	private double askForBill() {
		double theCostOfTheOrder = 0;
		if (hasNotPaidBills()) {
			for (int i = 0; i < myOrders.size(); i++) {
				theCostOfTheOrder += myWaiter.deliverBill(myOrders.get(i));
			}
			return theCostOfTheOrder;
		} else {
			System.out.println("The customer doesn't have unpaid bills.");
			return 0;
		}
	}

	public void payTheBills() {
		double amountDue = askForBill();
		if (amountDue > 0) {
			cash -= amountDue;
			System.out.printf("The client paid the bill: %.2f$%n", amountDue);
		}
		myRestaurant.setCapital(amountDue);
		offerATipp(amountDue);
	}

	private void offerATipp(double amountDue) {
		double tip = rnd.nextInt((int) (amountDue * 0.05) + 1) + amountDue * 0.05;
		cash -= tip;
		myWaiter.setCash(tip);
		System.out.printf("Waiter got a tip: %.2f$%n", tip);
		System.out.println("---------------------------------------------");
	}

	private boolean hasNotPaidBills() {

		for (int i = 0; i < myOrders.size(); i++) {
			if (!myOrders.get(i).isPaid()) {
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return name;
	}
}

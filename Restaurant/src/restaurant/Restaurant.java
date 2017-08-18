package restaurant;

import java.util.ArrayList;
import java.util.HashMap;

import clients.Client;
import menuitems.Alcohol;
import menuitems.AlcoholFree;
import menuitems.Dessert;
import menuitems.MainCourse;
import menuitems.MenuItems;
import menuitems.Salad;

public class Restaurant {

	public enum MenuItem {
		MEALS, DRINKS
	}

	private String name;
	private String address;
	private double capital;
	private HashMap<MenuItem, ArrayList<MenuItems>> menu;
	private ArrayList<Waiter> waiters;
	private ArrayList<Client> clients;

	public Restaurant(String name, String address) {
		super();
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.address = address;
		if (address == null || address.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (capital < 0) {
			throw new IllegalArgumentException();
		}
		this.capital = 1000;
		this.waiters = new ArrayList<>();
		this.clients = new ArrayList<>();
		this.menu = new HashMap<>();
		this.addMenuItems(MenuItem.MEALS, new Salad());
		this.addMenuItems(MenuItem.MEALS, new Dessert());
		this.addMenuItems(MenuItem.MEALS, new MainCourse());
		this.addMenuItems(MenuItem.DRINKS, new Alcohol());
		this.addMenuItems(MenuItem.DRINKS, new AlcoholFree());
		System.out.println("Restraunt's name: " + this.name);
		System.out.println("Address: " + this.address);
		System.out.printf("Restraunt's capital: %.2f$%n", capital);
		System.out.println("All meals and drinks created as requsted by the manual.");
		createWaiters(5);
	}

	private void createWaiters(int i) {

		for (int j = 0; j < i; j++) {
			waiters.add(new Waiter("Waiter " + (j + 1)));
			System.out.println("New waiter created: " + waiters.get(j).getName());
		}
	}

	public ArrayList<Waiter> getWaiters() {
		return waiters;
	}

	public void setCapital(double income) {
		capital += income;
	}

	private void addMenuItems(MenuItem string, MenuItems itemName) {

		if (!menu.containsKey(string)) {
			menu.put(string, new ArrayList<>());
		}

		menu.get(string).add(itemName);
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public HashMap<MenuItem, ArrayList<MenuItems>> getMenu() {
		return menu;
	}

	public void startSimulation() {

		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).placeAnOrder();
			clients.get(i).payTheBills();
		}
		
	}

	public double getCapital() {
		return capital;
	}

}

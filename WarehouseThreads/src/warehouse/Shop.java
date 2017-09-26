package warehouse;

import java.util.HashMap;

import warehouse.Warehouse.Type;

public class Shop {

	private Warehouse wh;
	private static final int MIN_QUANTITY = 5;
	private HashMap<Type, HashMap<String, Integer>> catalog;

	public Shop(Warehouse wh) {
		this.wh = wh;

		catalog = new HashMap<>();
		catalog.put(Type.VEGETABLES, new HashMap<>());
		catalog.put(Type.FRUITS, new HashMap<>());
		catalog.put(Type.MEATS, new HashMap<>());
		catalog.get(Type.VEGETABLES).put("Potato", 15);
		catalog.get(Type.VEGETABLES).put("EggPlant", 15);
		catalog.get(Type.VEGETABLES).put("Cucumber", 15);
		catalog.get(Type.FRUITS).put("Banana", 15);
		catalog.get(Type.FRUITS).put("Orange", 15);
		catalog.get(Type.FRUITS).put("Apple", 15);
		catalog.get(Type.MEATS).put("Pork", 15);
		catalog.get(Type.MEATS).put("Beef", 15);
		catalog.get(Type.MEATS).put("Chicken", 15);

		new Thread() {
			@Override
			public void run() {
				while (true) {
					deliver();
				}
			}
		}.start();
	}

	public synchronized void deliver() {
		while (!hasInsufficient()) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		fillQuantities();
		notifyAll();
	}

	private boolean hasInsufficient() {
		for (HashMap<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (products.get(s) < MIN_QUANTITY) {
					return true;
				}
			}
		}
		return false;
	}

	private void fillQuantities() {
		for (HashMap<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (products.get(s) < MIN_QUANTITY) {
					System.out.println(s + " not enough! Fill from storage!");
					wh.getProduct(s);
					products.put(s, products.get(s) + 5);
				}
			}
		}
	}

	public synchronized void getProduct(String name, int quantity) {
		while (insufficient(name, quantity)) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		removeQuantity(name, quantity);
		notifyAll();
	}

	private boolean insufficient(String name, int quantity) {
		for (HashMap<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (s.equals(name) && products.get(s) < quantity) {
					return true;
				}
			}
		}
		return false;
	}

	private void removeQuantity(String name, int quantity) {
		for (HashMap<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (s.equals(name)) {
					products.put(s, products.get(s) - quantity);
				}
			}
		}
	}

}

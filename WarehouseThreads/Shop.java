package warehouse;

import java.util.Map;


public class Shop extends Store {

	private Warehouse wh;
	
	public Shop(Warehouse wh) {
		this.wh = wh;


		new Thread() {
			@Override
			public void run() {
				while (true) {
					deliver();
				}
			}
		}.start();
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
		for (Map<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (s.equals(name) && products.get(s) < quantity) {
					return true;
				}
			}
		}
		return false;
	}

	private void removeQuantity(String name, int quantity) {
		for (Map<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (s.equals(name)) {
					products.put(s, products.get(s) - quantity);
				}
			}
		}
	}
	
	protected void fillQuantities() {
		for (Map<String, Integer> products : catalog.values()) {
			for (String s : products.keySet()) {
				if (products.get(s) < MIN_QUANTITY) {
					System.out.println(s + " not enough! Fill from storage!");
					wh.getProduct(s);
					products.put(s, products.get(s) + 5);
				}
			}
		}
	}


}

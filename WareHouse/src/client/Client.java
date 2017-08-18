package client;

import java.util.ArrayList;
import java.util.Random;

import motherhouse.MotherOfAllWarehousesAndShops.ProductType;
import motherhouse.Shop;
import product.Product;
import product.Product.ProductName;

public class Client {

	private String name;
	private ArrayList<Product> basket;
	private Shop myShop;
	private Random rnd = new Random();

	public Client(String name, Shop myShop) {
		super();
		this.name = name;
		basket = new ArrayList<>();
		this.myShop = myShop;
	}

	public ArrayList<Product> getBasket() {
		return basket;
	}

	public void buyGoods() {
		int random = rnd.nextInt(3);
		Product product = null;

		if (random == 0) {
			product = myShop.getAllProductsInStock().get(ProductType.FRUITS).get(ProductName.values()[rnd.nextInt(3)])
					.remove(0);
			System.out.println("A client of " + myShop.getName() + " bought " + product);

		} else if (random == 1) {
			product = myShop.getAllProductsInStock().get(ProductType.VEGETABLES)
					.get(ProductName.values()[rnd.nextInt(3) + 3]).remove(0);
			System.out.println("A client of " + myShop.getName() + " bought " + product);
		} else if (random == 2) {
			product = myShop.getAllProductsInStock().get(ProductType.MEATS)
					.get(ProductName.values()[rnd.nextInt(3) + 6]).remove(0);
			System.out.println("A client of " + myShop.getName() + " bought " + product);
		}

		basket.add(product);
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", basket=" + basket + ", myShop=" + myShop + "]";
	}

	
}

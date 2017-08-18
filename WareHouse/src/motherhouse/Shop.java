package motherhouse;

import java.util.ArrayList;

import client.Client;
import client.DeliveryMan;
import product.Product;
import product.Product.ProductName;

public class Shop extends MotherOfAllWarehousesAndShops {

	private ArrayList<Client> clients;

	public Shop(String name, DeliveryMan dm, WareHouse warehouse) {
		super(name, 3, 15, 10, dm);
		clients = new ArrayList<>();
		myWarehouse = warehouse;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void restock() {
		dm.restock(this);
	}

	public void deliver(ProductName productName) {
		ArrayList<Product> products = ((WareHouse) myWarehouse).removeProductFromWarehouseByProductName(productName);
		System.out.println("Products were moved from warehouse to shop: " + name);
		addProductsToShop(productName, products);
	}

	private void addProductsToShop(ProductName productName, ArrayList<Product> products) {

		if (productName == ProductName.APPLE) {
			allProductsInStock.get(ProductType.FRUITS).get(ProductName.APPLE).addAll(products);
		} else if (productName == ProductName.BANANA) {
			allProductsInStock.get(ProductType.FRUITS).get(ProductName.BANANA).addAll(products);
		} else if (productName == ProductName.ORANGE) {
			allProductsInStock.get(ProductType.FRUITS).get(ProductName.ORANGE).addAll(products);
		} else if (productName == ProductName.CUCUMBER) {
			allProductsInStock.get(ProductType.VEGETABLES).get(ProductName.CUCUMBER).addAll(products);
		} else if (productName == ProductName.EGGPLANT) {
			allProductsInStock.get(ProductType.VEGETABLES).get(ProductName.EGGPLANT).addAll(products);
		} else if (productName == ProductName.POTATO) {
			allProductsInStock.get(ProductType.VEGETABLES).get(ProductName.POTATO).addAll(products);
		} else if (productName == ProductName.PORK) {
			allProductsInStock.get(ProductType.MEATS).get(ProductName.PORK).addAll(products);
		} else if (productName == ProductName.BEEF) {
			allProductsInStock.get(ProductType.MEATS).get(ProductName.BEEF).addAll(products);

		} else if (productName == ProductName.CHICKEN) {

			if (allProductsInStock.get(ProductType.MEATS).get(ProductName.CHICKEN).size() > 0) {
				allProductsInStock.get(ProductType.MEATS).get(ProductName.CHICKEN).addAll(products);
			}
		}
		System.out.println("Goods were added to shop " + name);
	}
}

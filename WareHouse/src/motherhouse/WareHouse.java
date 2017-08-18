package motherhouse;

import java.util.ArrayList;

import client.DeliveryMan;
import product.Product;
import product.Product.ProductName;

public class WareHouse extends MotherOfAllWarehousesAndShops {

	public WareHouse(String name, DeliveryMan dm) {
		super(name, 5, 25, 15, dm);
	}

	public void removeProductFromWarehouse(int replenishAmount, ArrayList<Product> arrayList) {

		if (replenishAmount >= arrayList.size()) {
			for (int i = 0; i < replenishAmount; i++) {
				arrayList.remove(arrayList.size() - 1);
			}
		} else {
			System.out.println("The warehouse has not enough products of this type: " + arrayList.get(0));
		}
	}

	public ArrayList<Product> removeProductFromWarehouseByProductName(ProductName productName) {

		int count = 5;
		ArrayList<Product> products = new ArrayList<>();

		if (productName == ProductName.APPLE) {
			for (int i = 0; i < count; i++) {
				if (allProductsInStock.get(ProductType.FRUITS).get(ProductName.APPLE).size() > 0) {
					products.add(allProductsInStock.get(ProductType.FRUITS).get(ProductName.APPLE).remove(0));
				} else {
					System.out.println("No more of this product is available at warehouse: " + ProductName.APPLE);
				}
			}

		} else if (productName == ProductName.BANANA) {
			for (int i = 0; i < count; i++) {
				if (allProductsInStock.get(ProductType.FRUITS).get(ProductName.BANANA).size() > 0) {
					products.add(allProductsInStock.get(ProductType.FRUITS).get(ProductName.BANANA).remove(0));
				} else {
					System.out.println("No more of this product is available at warehouse: " + ProductName.BANANA);
				}
			}

		} else if (productName == ProductName.ORANGE) {
			for (int i = 0; i < count; i++) {
				if (allProductsInStock.get(ProductType.FRUITS).get(ProductName.ORANGE).size() > 0) {
					products.add(allProductsInStock.get(ProductType.FRUITS).get(ProductName.ORANGE).remove(0));
				} else {
					System.out.println("No more of this product is available at warehouse: " + ProductName.ORANGE);
				}
			}

		} else if (productName == ProductName.CUCUMBER) {
			for (int i = 0; i < count; i++) {
				if (allProductsInStock.get(ProductType.VEGETABLES).get(ProductName.CUCUMBER).size() > 0) {
					products.add(allProductsInStock.get(ProductType.VEGETABLES).get(ProductName.CUCUMBER).remove(0));
				} else {
					System.out.println("No more of this product is available at warehouse: " + ProductName.CUCUMBER);
				}
			}

		} else if (productName == ProductName.EGGPLANT) {
			for (int i = 0; i < count; i++) {
				if (allProductsInStock.get(ProductType.VEGETABLES).get(ProductName.EGGPLANT).size() > 0) {
					products.add(allProductsInStock.get(ProductType.VEGETABLES).get(ProductName.EGGPLANT).remove(0));
				} else {
					System.out.println("No more of this product is available at warehouse: " + ProductName.EGGPLANT);
				}
			}

		} else if (productName == ProductName.POTATO) {
			for (int i = 0; i < count; i++) {
				if (allProductsInStock.get(ProductType.VEGETABLES).get(ProductName.POTATO).size() > 0) {
					products.add(allProductsInStock.get(ProductType.VEGETABLES).get(ProductName.POTATO).remove(0));
				} else {
					System.out.println("No more of this product is available at warehouse: " + ProductName.POTATO);
				}
			}

		} else if (productName == ProductName.PORK) {
			for (int i = 0; i < count; i++) {
				if (allProductsInStock.get(ProductType.MEATS).get(ProductName.PORK).size() > 0) {
					products.add(allProductsInStock.get(ProductType.MEATS).get(ProductName.PORK).remove(0));
				} else {
					System.out.println("No more of this product is available at warehouse: " + ProductName.PORK);
				}
			}

		} else if (productName == ProductName.BEEF) {
			for (int i = 0; i < count; i++) {
				if (allProductsInStock.get(ProductType.MEATS).get(ProductName.BEEF).size() > 0) {
					products.add(allProductsInStock.get(ProductType.MEATS).get(ProductName.BEEF).remove(0));
				} else {
					System.out.println("No more of this product is available at warehouse: " + ProductName.BEEF);
				}
			}

		} else if (productName == ProductName.CHICKEN) {
			for (int i = 0; i < count; i++) {
				if (allProductsInStock.get(ProductType.MEATS).get(ProductName.CHICKEN).size() > 0) {
					products.add(allProductsInStock.get(ProductType.MEATS).get(ProductName.CHICKEN).remove(0));
				} else {
					System.out.println("No more of this product is available at warehouse: " + ProductName.CHICKEN);
				}
			}

		}
		return products;
	}
}

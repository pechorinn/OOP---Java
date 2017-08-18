package client;

import motherhouse.MotherOfAllWarehousesAndShops;
import motherhouse.MotherOfAllWarehousesAndShops.ProductType;
import motherhouse.Shop;
import product.Product.ProductName;

public class DeliveryMan {

	private String name;

	public DeliveryMan(String name) {
		super();
		this.name = name;
	}

	public void restock(MotherOfAllWarehousesAndShops store) {
		System.out.println("=======================================");
		for (int i = 0; i < ProductType.values().length; i++) {
			int productNameIndex = 0;
			int temp = 0;
			if (i == 0) {
				productNameIndex = 3;
				temp = 0;
			} else if (i == 1) {
				productNameIndex = 6;
				temp = 3;
			} else if (i == 2) {
				productNameIndex = 9;
				temp = 6;
			}

			for (int j = temp; j < productNameIndex; j++) {

				if (store.getAllProductsInStock().get(ProductType.values()[i]).get(ProductName.values()[j])
						.size() < store.getCriticalQuantity()) {

					if (store instanceof Shop) {
						store.getMyWarehouse().removeProductFromWarehouse(store.getReplenishAmount(), store.getMyWarehouse()
								.getAllProductsInStock().get(ProductType.values()[i]).get(ProductName.values()[j]));
					}
					store.getAllProductsInStock().get(ProductType.values()[i]).put(ProductName.values()[j],
							store.fillWithProducts(ProductName.values()[j], store.getReplenishAmount()));
					System.out.println("The product " + ProductName.values()[j] + " was restocked.");
				}
			}
		}
	}

	@Override
	public String toString() {
		return "DeliveryMan [name: " + name + "]";
	}

}

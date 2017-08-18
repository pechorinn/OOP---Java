package motherhouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import client.DeliveryMan;
import product.Apple;
import product.Banana;
import product.Beef;
import product.Chicken;
import product.Cucumber;
import product.Eggplant;
import product.Orange;
import product.Pork;
import product.Potato;
import product.Product;
import product.Product.ProductName;

public abstract class MotherOfAllWarehousesAndShops {

	public enum ProductType {
		FRUITS, VEGETABLES, MEATS
	}

	protected String name;
	protected int criticalQuantity;
	protected int replenishAmount;
	protected int inStoreDefaultAmount;
	protected Map<ProductType, Map<ProductName, ArrayList<Product>>> allProductsInStock;
	protected DeliveryMan dm;
	protected WareHouse myWarehouse;

	public MotherOfAllWarehousesAndShops(String name, int criticalQuantity, int replenishAmount, int inStoreDefaultAmount, DeliveryMan dm) {
		this.name = name;
		this.criticalQuantity = criticalQuantity;
		this.replenishAmount = replenishAmount;
		this.inStoreDefaultAmount = inStoreDefaultAmount;
		this.dm = dm;
		String storeType = null;
		if(this instanceof WareHouse) {
			storeType = "warehouse";
		} else if (this instanceof Shop)  {
			storeType = "shop";
		}
		System.out.println("----------------------------------------");
		System.out.println("     New "+ storeType + " created: " + name);
		System.out.println("----------------------------------------");
		this.name = name;
		this.allProductsInStock = new HashMap<>();
		allProductsInStock.put(ProductType.FRUITS, new HashMap<>());
		allProductsInStock.put(ProductType.VEGETABLES, new HashMap<>());
		allProductsInStock.put(ProductType.MEATS, new HashMap<>());
		allProductsInStock.get(ProductType.FRUITS).put(ProductName.APPLE,
				fillWithProducts(ProductName.APPLE, inStoreDefaultAmount));
		allProductsInStock.get(ProductType.FRUITS).put(ProductName.BANANA,
				fillWithProducts(ProductName.BANANA, inStoreDefaultAmount));
		allProductsInStock.get(ProductType.FRUITS).put(ProductName.ORANGE,
				fillWithProducts(ProductName.ORANGE, inStoreDefaultAmount));
		allProductsInStock.get(ProductType.VEGETABLES).put(ProductName.CUCUMBER,
				fillWithProducts(ProductName.CUCUMBER, inStoreDefaultAmount));
		allProductsInStock.get(ProductType.VEGETABLES).put(ProductName.EGGPLANT,
				fillWithProducts(ProductName.EGGPLANT, inStoreDefaultAmount));
		allProductsInStock.get(ProductType.VEGETABLES).put(ProductName.POTATO,
				fillWithProducts(ProductName.POTATO, inStoreDefaultAmount));
		allProductsInStock.get(ProductType.MEATS).put(ProductName.BEEF,
				fillWithProducts(ProductName.BEEF, inStoreDefaultAmount));
		allProductsInStock.get(ProductType.MEATS).put(ProductName.PORK,
				fillWithProducts(ProductName.PORK, inStoreDefaultAmount));
		allProductsInStock.get(ProductType.MEATS).put(ProductName.CHICKEN,
				fillWithProducts(ProductName.CHICKEN, inStoreDefaultAmount));
		System.out.println("--------------------------------------------------------");
	}

	public ArrayList<Product> fillWithProducts(ProductName productName, int howManyOjectsToAdd) {

		ArrayList<Product> products = new ArrayList<>();
		if (productName == ProductName.APPLE) {
			for (int i = 0; i < howManyOjectsToAdd; i++) {
				products.add(new Apple());
			}
		} else if (productName == ProductName.BANANA) {
			for (int i = 0; i < howManyOjectsToAdd; i++) {
				products.add(new Banana());
			}
		} else if (productName == ProductName.ORANGE) {
			for (int i = 0; i < howManyOjectsToAdd; i++) {
				products.add(new Orange());
			}
		} else if (productName == ProductName.CUCUMBER) {
			for (int i = 0; i < howManyOjectsToAdd; i++) {
				products.add(new Cucumber());
			}
		} else if (productName == ProductName.EGGPLANT) {
			for (int i = 0; i < howManyOjectsToAdd; i++) {
				products.add(new Eggplant());
			}
		} else if (productName == ProductName.POTATO) {
			for (int i = 0; i < howManyOjectsToAdd; i++) {
				products.add(new Potato());
			}
		} else if (productName == ProductName.BEEF) {
			for (int i = 0; i < howManyOjectsToAdd; i++) {
				products.add(new Beef());
			}
		} else if (productName == ProductName.PORK) {
			for (int i = 0; i < howManyOjectsToAdd; i++) {
				products.add(new Pork());
			}
		} else if (productName == ProductName.CHICKEN) {
			for (int i = 0; i < howManyOjectsToAdd; i++) {
				products.add(new Chicken());
			}
		}
		System.out.println(productName + " was delivered in needed quantity.");
		System.out.println(products);
		return products;
	}

	public Map<ProductType, Map<ProductName, ArrayList<Product>>> getAllProductsInStock() {
		return allProductsInStock;
	}

	public int getCriticalQuantity() {
		return criticalQuantity;
	}

	public int getReplenishAmount() {
		return replenishAmount;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "MotherOfAllWarehousesAndShops [name=" + name + ", criticalQuantity=" + criticalQuantity
				+ ", replenishAmount=" + replenishAmount + ", inStoreDefaultAmount=" + inStoreDefaultAmount
				+  "]";
	}

	public WareHouse getMyWarehouse() {
		return myWarehouse;
	}
	
	public DeliveryMan getDeliveryMan() {
		return dm;
	}
	
}

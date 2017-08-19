package shop;

public class Demo {

	public static void main(String[] args) {

		Shop shop = new Shop("Verde", "Sofia", 100, 10);
		// adding products to the shop
		shop.addProduct(new ProductSoldInKg("Fish", 30, 50));
		shop.addProduct(new ProductSoldInKg("Cheese", 5, 60));
		shop.addProduct(new ProductSoldInKg("Meat", 5, 100));
		shop.addProduct(new ProductSoldInKg("Apple", 2, 70));
		shop.addProduct(new ProductSoldInKg("WaterMelon", 2.5, 70));
		shop.addProduct(new ProductSoldByCount("Beer", 3, 50));
		shop.addProduct(new ProductSoldByCount("Book", 5, 60));
		shop.addProduct(new ProductSoldByCount("Chair", 5, 100));
		shop.addProduct(new ProductSoldByCount("Table", 2, 70));
		shop.addProduct(new ProductSoldByCount("Sticks", 2.5, 70));
		shop.addProduct(new ProductSoldByCount("Sticks", 2.5, 70));
		shop.addProduct(new ProductSoldByCount("Sticks", 2.5, 70));
		// printing shop products
		shop.printStockInfo();
		// creating customers
		Customer ivan = new Customer(shop, 150, 10, "Ivan");
		Customer sergey = new Customer(shop, 200, 15, "Sergey");
		Customer marina = new Customer(shop, 350, 25, "Marina");
        // creating orders
		Product order1 = ivan.createShoppingReguestForCustomerKg("Fish", 5);
		Product order2 = ivan.createShoppingReguestForCustomerKg("Fish", 3);
		Product order3 = ivan.createShoppingReguestForCustomerKg("Apple", 7);
		Product order4 = ivan.createShoppingReguestForCustomerKg("Cheese", 5);
		Product order5 = ivan.createShoppingReguestForCustomerKg("Fish", -500);
		Product order6 = ivan.createShoppingRequestForCustomerItems("Book", 20);

		ivan.removeItemSoldInKg(order6, 5);
		ivan.removeItemSoldByCount(order6, 5);
		ivan.makeTransaction();

		Product order7 = sergey.createShoppingReguestForCustomerKg("Fish", 5);
		Product order8 = sergey.createShoppingReguestForCustomerKg("Meat", 8);
		Product order9 = sergey.createShoppingReguestForCustomerKg("Apple", 13);
		Product order10 = sergey.createShoppingReguestForCustomerKg("Cheese", 8);
		Product order11 = sergey.createShoppingRequestForCustomerItems("Sticks", 14);
		Product order12 = sergey.createShoppingRequestForCustomerItems("Cheese", 20);
		Product order13 = sergey.createShoppingReguestForCustomerKg("Book", 20);
		Product order14 = sergey.createShoppingRequestForCustomerItems("Sticks", 14);
		Product order15 = sergey.createShoppingRequestForCustomerItems("Sticks", 14);
		sergey.removeItemSoldByCount(order11, 3);

	}
}

package shop;

class Shop {

	private String name;
	private String address;
	private double cashier;
	private Product[] products;

	public Shop(String name, String address, double cashier, int numberOfArticuls) {
		super();
		this.name = name;
		this.address = address;
		this.cashier = cashier;
		this.products = new Product[numberOfArticuls];
		System.out.println("             --------------------------");
		System.out.println("             New shop created - \"" + name + "\"");
		System.out.println("             --------------------------");
	}
	
	void addToCashier(double cash) {
		this.cashier += cash;
	}
	
	double getCashier() {
		return cashier;
	}

	Product[] getProducts() {
		return products;
	}

	void addProduct(Product product) {
		boolean hasSpace = false;
		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				products[i] = product;
				hasSpace = true;
				System.out.println("       Product " + product.getName() + " was added to the store.");
				break;
			}
		}

		if (!hasSpace) {
			System.out.println(
					"------ No more items can be added. Product " + product.getName() + " were not added ------");
		}
	}

	void printStockInfo() {
		System.out.println("\n      ---- All products in stock ----       ");
		System.out.println("==========================================");
		for (int i = 0; i < products.length; i++) {
			System.out.println("Name: " + products[i].getName());
			System.out.println("Price: " + products[i].getPrice() + "$");
			if(products[i] instanceof ProductSoldInKg) {
				System.out.println("Kg available in store: " + ((ProductSoldInKg)products[i]).getKg());
			} else {
				System.out.println("Items available in store: " + ((ProductSoldByCount)products[i]).getItemCount());
			}
			System.out.println("------------------");
		}
		
		System.out.println("Money in the cashier: " + cashier + "$");
		System.out.println("==========================================");
	}
}

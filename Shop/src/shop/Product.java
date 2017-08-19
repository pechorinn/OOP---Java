package shop;

abstract class Product {
	
	private String name;
	private double price;
	
	Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
    String getName() {
		return name;
	}

	double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product name: " + name + ", price: " + price + "$";
	}	
}

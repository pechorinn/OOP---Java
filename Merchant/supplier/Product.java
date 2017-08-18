package supplier;

public class Product {
	
	private String name;
	private double price;
	
	public Product(String name, double price) {
		super();
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		if(price < 0) {
			throw new IllegalArgumentException();
		}
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}


}

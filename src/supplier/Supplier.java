package supplier;

import java.util.ArrayList;
import java.util.Random;

public class Supplier {

	private String name;
	private String address;
	private String workingHours;
	private boolean wholesale;
	private double discount;
	private ArrayList<Product> products;

	public Supplier(String name, String address, String workingHours, boolean wholesale) {
		super();
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		if (address == null || address.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.address = address;
		if (workingHours == null || workingHours.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.workingHours = workingHours;
		this.wholesale = wholesale;
		if (wholesale) {
			this.discount = 15;
		}
		this.products = new ArrayList<>();
		generateProducts();
		System.out.println("New supplier is created: " + name);
	}

	public double getDiscount() {
		return discount;
	}

	public void generateProducts() {
		Random rnd = new Random();
		for (int i = 0; i < 1000; i++) {
			products.add(new Product("Product " + (i + 1),
					wholesale ? (rnd.nextInt(11) + 5) * 0.85 : (rnd.nextInt(11) + 5)));
		}
		products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
	}

	public boolean getWholesale() {
		return wholesale;
	}

	public ArrayList<Product> deliverProducts(double d) {
		double valueOfGoods = 0;
		ArrayList<Product> arrayList = new ArrayList<>();
		int i = 0;
		while (valueOfGoods < d) {
			valueOfGoods += products.get(i).getPrice();
			arrayList.add(products.remove(i));
			i++;
		}

		System.out.println("Products sent to customer: ");
		System.out.println(arrayList);
		return arrayList;
	}

}

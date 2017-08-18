package businessunit;

import java.util.ArrayList;
import java.util.Random;

import merchant.Merchant;
import supplier.Product;

public abstract class BusinessUnit {

	protected String address;
	protected String workingHours;
	protected double area;
	protected double taxes;
	protected ArrayList<Product> products;
	protected Merchant merchant;
	protected static Random rnd = new Random();

	public BusinessUnit(String address, String workingHours, double area, double taxes) {
		super();
		if(address == null || address.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.address = address;
		if(workingHours == null || workingHours.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.workingHours = workingHours;
		if(area <= 0) {
			throw new IllegalArgumentException();
		}
		this.area = area;
		if(taxes < 0) {
			throw new IllegalArgumentException();
		}
		this.taxes = taxes;
		products = new ArrayList<>();
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	public ArrayList<Product> getProducts() {
		products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
		return products;
	}

	public String getName() {
		return this.getClass().toString();
	}

	public double getTax() {
		return taxes;
	}

	public Merchant getMerchant() {
		return merchant;
	}


}

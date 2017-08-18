package menuitems;

import java.util.Random;

public abstract class MenuItems implements IStudentDiet {
	
	protected String name;
	protected double price;
	protected int availableCount;
	protected static Random rnd = new Random();
	
	public MenuItems(String name, double price, int availableCount) {
		super();
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		if (price < 0) {
			throw new IllegalArgumentException();
		}
		this.price = price;
		this.availableCount = availableCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void setAvailableCount(int availableCount) {
		this.availableCount += availableCount;
	}
		

}

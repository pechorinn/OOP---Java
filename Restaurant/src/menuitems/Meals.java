package menuitems;

public abstract class Meals extends MenuItems {

	private double weight;

	public Meals(String name, double price, double weight, int availableCount) {
		super(name, price, availableCount);
		this.weight = weight;
		//System.out.println("Available count: " + availableCount);
	}

	@Override
	public String toString() {
		return "Meals [weight=" + weight + "]";
	}
}

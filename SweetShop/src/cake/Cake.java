package cake;

public abstract class Cake {

	protected String name;
	protected String description;
	protected double price;
	protected int numberOfPieces;

	public Cake(String name, String description, double price, int numberOfPieces) {
		super();
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.description = description;
		if (price < 0) {
			throw new IllegalArgumentException();
		}
		this.price = price;
		if (numberOfPieces < 0) {
			throw new IllegalArgumentException();
		}
		this.numberOfPieces = numberOfPieces;
	}

	public int getPieces() {
		return numberOfPieces;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "\nCake [name=" + name + ", description=" + description + ", price=" + price + ", numberOfPieces="
				+ numberOfPieces + "]";
	}

	

}

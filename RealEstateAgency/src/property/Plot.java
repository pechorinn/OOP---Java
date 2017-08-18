package property;


public class Plot extends Property {

	private boolean regulation;

	public Plot(String description, String address, double area, double price, boolean regulationStatus) {
		super(description, address, area, price);
		this.regulation = regulationStatus;
	}

	@Override
	public String toString() {
		return "\nPlot regulation: " + regulation + ",\n description: " + description + ",\n address " + address
				+ ",\n area " + area + ",\n " + agent + ",\n price " + price + "$,\n"
				+ "Owner: " + owner.getName()
				+ "\n-----------------------------------";
	}

}

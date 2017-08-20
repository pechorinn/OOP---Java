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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (regulation ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plot other = (Plot) obj;
		if (regulation != other.regulation)
			return false;
		return true;
	}
	
	

}

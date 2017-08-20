package property;


public class House extends PropertyType {

	public enum HousesTypes{FLOOR_OF_A_HOUSE, HOUSE};
	
	private int parkingSpaces;
	private double yardSpace;
	private HousesTypes houseType;
	
	public House(String description, String address, double area, PropertiesCanBe type, int parkingSpaces,
			double yardSpace, HousesTypes housesType, double price) {
		super(description, address, area, type, price);
		this.parkingSpaces = parkingSpaces;
		this.yardSpace = yardSpace;
		this.houseType = housesType;
	
	}

	@Override
	public String toString() {
		return "\nHouse parkingSpaces: " + parkingSpaces + ",\n yardSpace " + yardSpace + ",\n type " + type
				+ ",\n description: " + description + ",\n address " + address + ", area " + area + ",\n  " + agent
				+ ",\n price " + price + "$,\n"
				+ "House type: " + houseType
				+ "\nOwner: " + owner.getName()
				+ "\n-----------------------------------";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((houseType == null) ? 0 : houseType.hashCode());
		result = prime * result + parkingSpaces;
		long temp;
		temp = Double.doubleToLongBits(yardSpace);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		House other = (House) obj;
		if (houseType != other.houseType)
			return false;
		if (parkingSpaces != other.parkingSpaces)
			return false;
		if (Double.doubleToLongBits(yardSpace) != Double.doubleToLongBits(other.yardSpace))
			return false;
		return true;
	}
	
	
		
}

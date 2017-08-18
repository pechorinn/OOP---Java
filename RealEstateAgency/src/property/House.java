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
		
}

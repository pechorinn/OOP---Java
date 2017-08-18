package property;


public class Appartment extends PropertyType {

	public enum AppartmentType {
		STUDIO, GARSONIERA, TWO_BEDROOM, THREE_BEDROOM, MESONET
	};

	private AppartmentType apartmentType;;

	public Appartment(String description, String address, double area, PropertiesCanBe type,
			AppartmentType appartmentType, double price) {
		super(description, address, area, type, price);
		this.apartmentType = appartmentType;
	}

	@Override
	public String toString() {
		return "\nProperty: " + type + ",\n description: " + description + ",\n address: " + address + ",\n area " + area
				+ ",\n " + agent + ",\n price: " + price + "$,\n"
				+ "Appartment type: " + apartmentType
				+ "\nOwner: " + owner.getName()
				+ "\n-----------------------------------";
	}

}
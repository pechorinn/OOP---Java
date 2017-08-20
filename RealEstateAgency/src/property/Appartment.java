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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((apartmentType == null) ? 0 : apartmentType.hashCode());
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
		Appartment other = (Appartment) obj;
		if (apartmentType != other.apartmentType)
			return false;
		return true;
	}

		
}
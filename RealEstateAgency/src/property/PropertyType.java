package property;


public abstract class PropertyType extends Property {
	
	public enum PropertiesCanBe{EPK, TUHLA, PANEL, KIRPICH};
	
	protected PropertiesCanBe type;

	public PropertyType(String description, String address, double area, PropertiesCanBe type, double price) {
		super(description, address, area, price);
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		PropertyType other = (PropertyType) obj;
		if (type != other.type)
			return false;
		return true;
	}
	
}

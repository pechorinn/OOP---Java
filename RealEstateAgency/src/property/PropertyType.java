package property;


public abstract class PropertyType extends Property {
	
	public enum PropertiesCanBe{EPK, TUHLA, PANEL, KIRPICH};
	
	protected PropertiesCanBe type;

	public PropertyType(String description, String address, double area, PropertiesCanBe type, double price) {
		super(description, address, area, price);
		this.type = type;
	}

	
}

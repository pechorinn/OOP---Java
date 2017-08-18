package realestateagency;

import java.time.LocalDate;

import client.Buyer;
import property.Property;

public class View {

	private Property property;
	private Agent agent;
	private Buyer buyer;
	private LocalDate date;

	public View(Property property, Agent agent, Buyer buyer, LocalDate date) {
		super();
		this.property = property;
		this.agent = agent;
		this.buyer = buyer;
		this.date = date;
	}

	@Override
	public String toString() {
		return "-------View------- " + property + ",\n " + agent + ",\n " + buyer + ",\n Date of viewing: " + date
				+ "\n===================================";
	}

	public Property getProperty() {
		return property;
	}

}

package property;

import client.Client;
import realestateagency.Agent;

public abstract class Property implements Comparable<Property> {

	protected String description;
	protected String address;
	protected double area;
	protected Agent agent;
	protected double price;
	protected Client owner;

	public Property(String description, String address, double area, double price) {
		super();

		this.description = description;
		this.address = address;
		this.area = area;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public void setOwner(Client client) {
		this.owner = client;
	}

	@Override
	public int compareTo(Property property) {
		if (price < property.getPrice())
			return 1;
		else if (getPrice() > property.getPrice())
			return -1;
		else
			return 0;
	}

	public Agent getAgent() {
		return agent;
	}

	public Client getOwner() {
		return owner;
	}
}

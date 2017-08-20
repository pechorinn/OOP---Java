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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((agent == null) ? 0 : agent.hashCode());
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (agent == null) {
			if (other.agent != null)
				return false;
		} else if (!agent.equals(other.agent))
			return false;
		if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}
	
	
	
}

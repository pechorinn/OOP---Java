package client;

import property.Property;
import realestateagency.Agency;
import realestateagency.Agent;

public class Seller extends Client {

	private Property property;

	public Seller(String name, String phoneNumber, Agency myAgency, Property property) {
		super(name, phoneNumber, myAgency);
		this.property = property;
	}

	public void registerPropertyForSale() {
		myAgency.assignAgent(this);
		myAgency.addToCatalog(this.property);
		myAgent.addToAgentListOfSellers(this);
	}

	public void setAgent(Agent agent) {
		this.property.setAgent(agent);
		myAgent = agent;
	}
}

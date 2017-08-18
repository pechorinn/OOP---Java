package client;

import realestateagency.Agency;
import realestateagency.Agent;
import static realestateagency.Verification.*;

public abstract class Client {
	protected double cash;
	protected String name;
	protected String phoneNumber;
	protected Agency myAgency;
	protected Agent myAgent;

	public Client(String name, String phoneNumber, Agency myAgency) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.myAgency = myAgency;
	}

	public abstract void setAgent(Agent agent);

	public String getName() {
		return name;
	}

	public void setCash(double cash) {
		checkForNonNegative(cash);
		this.cash = cash;
	}

	public Agency getMyAgency() {
		return myAgency;
	}

	@Override
	public String toString() {
		return "Client: " + name;
	}

	public void addCash(double income) {
		cash += income;
	}

	public Agent getMyAgent() {
		return myAgent;
	}

}

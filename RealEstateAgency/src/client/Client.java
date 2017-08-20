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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((myAgency == null) ? 0 : myAgency.hashCode());
		result = prime * result + ((myAgent == null) ? 0 : myAgent.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		Client other = (Client) obj;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (myAgency == null) {
			if (other.myAgency != null)
				return false;
		} else if (!myAgency.equals(other.myAgency))
			return false;
		if (myAgent == null) {
			if (other.myAgent != null)
				return false;
		} else if (!myAgent.equals(other.myAgent))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	
}

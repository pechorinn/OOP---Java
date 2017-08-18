package realestateagency;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import client.Buyer;
import client.Seller;

public class Agent {

	private double cash;
	private String name;
	private String phoneNumber;
	private Agency myAgency;
	private ArrayList<View> views;
	private Set<Seller> sellers;
	private Set<Buyer> buyers;

	public Agent(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.views = new ArrayList<>();
		this.sellers = new HashSet<>();
		this.buyers = new HashSet<>();

	}

	public void setMyAgency(Agency agency) {
		myAgency = agency;
	}

	public void addToAgentListOfBuyers(Buyer buyer) {
		buyers.add(buyer);
	}

	public void addToAgentListOfSellers(Seller seller) {
		sellers.add(seller);
	}

	@Override
	public String toString() {
		String money = String.format("%.2f", cash);
		return "\nAgent: " + name
				+ "\n" + name + "'s balance: " + money + "$";
	}

	public ArrayList<View> getViews() {
		return views;
	}

	public ArrayList<Buyer> getBuyers() {
		return new ArrayList(buyers);
	}

	public void addCash(double halfTheTax) {
		cash += halfTheTax;
	}

	public void removeFromSetListOfBuyers(Buyer buyer) {
		buyers.remove(buyer);
	}

	public double getCash() {
		return cash;
	}

}
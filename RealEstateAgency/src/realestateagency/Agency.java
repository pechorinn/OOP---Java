package realestateagency;

import static realestateagency.Verification.checkForNonNegative;
import static realestateagency.Verification.checkStringInput;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


import client.Buyer;
import client.Client;
import client.Seller;
import property.Appartment;
import property.House;
import property.Plot;
import property.Property;

public class Agency {

	private String name;
	private String address;
	private String phoneNumber;
	private double cash;
	private ArrayList<Agent> agents;
	private Set<Property> appartments;
	private Set<Property> houses;
	private Set<Property> plots;
	private ArrayList<Property> catalog;
	private ArrayList<Client> sellers;
	private ArrayList<Client> buyers;

	public Agency(String name, String address, String phoneNumber, double cash, ArrayList<Agent> agents) {
		super();
		checkStringInput(name);
		this.name = name;
		checkStringInput(address);
		this.address = address;
		this.phoneNumber = phoneNumber;
		checkForNonNegative(cash);
		this.cash = cash;
		this.agents = agents;
		this.appartments = new TreeSet();
		this.houses = new TreeSet();
		this.plots = new TreeSet();
		sellers = new ArrayList<>();
		buyers = new ArrayList<>();
		for (Agent agent : agents) {
			agent.setMyAgency(this);
		}
		catalog = new ArrayList<>();
	}

	public Set<Property> getApartments() {
		return appartments;
	}

	public Set<Property> getHouses() {
		return houses;
	}

	public Set<Property> getPlots() {
		return plots;
	}

	public void assignAgent(Client client) {
		Random rnd = new Random();
		Agent agent = agents.get(rnd.nextInt(agents.size()));
		client.setAgent(agent);
	}

	public void addToCatalog(Property property) {
		if (property instanceof Appartment) {
			appartments.add(property);
		} else if (property instanceof House) {
			houses.add(property);
		} else if (property instanceof Plot) {
			plots.add(property);
		}
	}

	public ArrayList<Property> getCatalog() {
		return catalog;
	}

	public ArrayList<Client> getSellers() {
		return sellers;
	}

	public ArrayList<Client> getBuyers() {
		return buyers;
	}

	public void updateCatalog() {
		catalog = new ArrayList<>();
		if (appartments != null) {
			catalog.addAll(appartments);
		}
		if (houses != null) {
			catalog.addAll(houses);
		}
		if (plots != null) {
			catalog.addAll(plots);
		}
	}

	public ArrayList<Agent> getAgents() {
		return agents;
	}

	public void addCash(double taxes) {
		System.out.println("Agency paid for the cervices.");
		cash += taxes;
	}
	
	public void payTheAgent(double halfTheTax, Agent agent) {
		cash -= halfTheTax;
		System.out.println("An agent is paid by the agency.");
		agent.addCash(halfTheTax);
	}

	public Set<Property> getSetOfAppartments() {
		return appartments;
	}
	
	public Set<Property> getSetOfHouses() {
		return houses;
	}
	
	public Set<Property> getSetOfPlots() {
		return plots;
	}

	public double getCash() {
		return cash;
	}

	
	
	
	

}

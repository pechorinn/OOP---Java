package client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import property.Appartment;
import property.House;
import property.Plot;
import property.Property;
import realestateagency.Agency;
import realestateagency.Agent;
import realestateagency.View;

public class Buyer extends Client {

	private ArrayList<View> views;

	public Buyer(String name, String phoneNumber, Agency myAgency, double cash) {
		super(name, phoneNumber, myAgency);
		this.views = new ArrayList<>();
		myAgency.getBuyers().add(this);
		this.cash = cash;
	}

	public void registerRequestToSearch() {
		System.out.println("A new request for search of property is made by " + name);
		myAgency.assignAgent(this);
		myAgent.addToAgentListOfBuyers(this);
	}

	public void orderToView() {
		System.out.println("A new viewing request is put forward by " + this.name);
		Random rnd = new Random();
		Property property = myAgency.getCatalog().get(rnd.nextInt(myAgency.getCatalog().size()));
		if (cash >= property.getPrice()) {
			View view = new View(property, property.getAgent(), this, LocalDate.of(2017, rnd.nextInt(12)+1, rnd.nextInt(26)+1));
			System.out.println("New view is added.");
			System.out.println(view	);
			views.add(view);
			myAgent.getViews().add(view);
			return;
		} else {
			System.out.println("Not enough funds to buy this property.");
			System.out.println("Property price: " + property.getPrice());
			System.out.println("Available funds: " + cash + "$");
			System.out.println("A vewing is cancelled.");
			System.out.println("--------------------------------");
		}
	}
	
	public void makeAnOfferToBuy(View view) {
		Property property = view.getProperty();
		
		double taxesForBuyer = view.getProperty().getPrice()*0.3;
		cash -= property.getPrice() - taxesForBuyer;
		myAgency.addCash(taxesForBuyer);
		myAgency.payTheAgent(taxesForBuyer/2, myAgent);
		
		double taxesForSeller = view.getProperty().getPrice()*0.3;
		property.getOwner().addCash(-taxesForSeller);
		property.getOwner().getMyAgency().addCash(taxesForSeller);
		property.getOwner().getMyAgency().payTheAgent(taxesForSeller/2, property.getOwner().getMyAgent());
		
		myAgency.getSellers().remove(property.getOwner());
		if(property instanceof Appartment) {
			myAgency.getSetOfAppartments().remove(property);
		}
		else if(property instanceof House) {
			myAgency.getSetOfHouses().remove(property);
		}
		else if(property instanceof Plot) {
			myAgency.getSetOfPlots().remove(property);
		}
		
		myAgency.updateCatalog();	
		property.setOwner(this);
		
		if(myAgency.getBuyers().remove(this)) {
			System.out.println(this + "\nRemoved from the list with buyers.");
			System.out.println("The property is SOLD: ");
			System.out.println("--------------------------------------");
			System.out.println(property);
			System.out.println("--------------------------------------");
		}
		myAgent.removeFromSetListOfBuyers(this);
		
	}

	public void setAgent(Agent agent) {
		myAgent = agent;
	}
	
	public ArrayList<View> getViews() {
		return views;
	}

}

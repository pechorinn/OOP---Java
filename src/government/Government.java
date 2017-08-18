package government;

import java.util.ArrayList;

import businessunit.BusinessUnit;
import merchant.Merchant;

public class Government {

	private String municipalityName;
	private double budget;
	private ArrayList<BusinessUnit> businessUnits;
	private ArrayList<Merchant> merchants;

	public Government(String municipalityName, double budget) {
		super();
		if (municipalityName == null || municipalityName.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.municipalityName = municipalityName;
		if (budget < 0) {
			throw new IllegalArgumentException();
		}
		this.budget = budget;
		this.businessUnits = new ArrayList<>();
		this.merchants = new ArrayList<>();
	}

	public ArrayList<BusinessUnit> getBusinessUnits() {
		return businessUnits;
	}

	public void setBudget(double income) {
		budget += income;
	}

	public void startOperation(ArrayList<Merchant> merchants) {

		for (int i = 0; i < merchants.size(); i++) {
			merchants.get(i).startOperation();
		}

	}

	public ArrayList<Merchant> getMerchants() {

		return merchants;
	}

	@Override
	public String toString() {
		return "Government [municipalityName=" + municipalityName + ", budget=" + budget + ", businessUnits="
				+ businessUnits + ", merchants=" + merchants + "]";
	}
	
	

}

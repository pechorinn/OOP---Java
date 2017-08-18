package bankproduct;

import static bank.Verification.*;

import java.util.Random;

import client.Client;

public abstract class BankProduct {
	
	protected Client client;
	protected double interest;
	protected int timePeriod;
	protected double cash;

	public BankProduct(Client client, int timePeriod) {
		super();
		this.client = client;
		checkIfInputPositiveAndNotEqualToZero(timePeriod);
		this.timePeriod = timePeriod;
		this.interest = new Random().nextInt(16) + 5;
	}
	
	public double getInterest() {
		
		return interest;
	}
	
	public Client getClient() {
		
		return client;
	}

	public double getCash() {
		return cash;
	}
	
	public void addCash(double amount) {
		cash += amount;
	}
	
	public int getTimePeriod() {
		return timePeriod;
	}
}

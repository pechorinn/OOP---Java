package bank;

import static bank.Verification.checkStringInput;

import java.util.ArrayList;

import bankproduct.Credit;
import bankproduct.Credit.CreditName;
import bankproduct.Deposit;
import bankproduct.Deposit.DepositName;
import client.Client;

public class Bank {

	private String name;
	private String address;
	private double cash;
	private ArrayList<Client> clients;
	private double reserves;
	private ArrayList<Credit> credits;
	private ArrayList<Deposit> deposits;

	public Bank(String name, String address) {
		super();
		checkStringInput(name);
		this.name = name;
		checkStringInput(address);
		this.address = address;
		this.cash = 0;
		this.clients = new ArrayList<Client>();
		this.deposits = new ArrayList<Deposit>();
		this.credits = new ArrayList<Credit>();
		this.reserves = 0;
	}

	public void payInterestOnAllDeposits() {
	
		for (int i = 0; i < deposits.size(); i++) {
			cash -= deposits.get(i).getMonthlyIncomeFromDeposit();
			if (cash < 0) {
				cash += deposits.get(i).getMonthlyIncomeFromDeposit();
				System.out.println(
						"The bank's cash is very low. The bank cannot fullfil it's obligations paying interest on deposits.");
				return;
			}	
			deposits.get(i).getClient().addCash(deposits.get(i).getMonthlyIncomeFromDeposit());
			System.out.println("An interest on deposit of " + deposits.get(i).getMonthlyIncomeFromDeposit() + " is paid to " + deposits.get(i).getClient().getName() );
			System.out.println("Deposit amount: " + deposits.get(i).getCash());
			System.out.println("Deposit period:" + deposits.get(i).getTimePeriod());
			System.out.println("Interest: " + deposits.get(i).getInterest());
		}
	}

	public boolean checkForCreditEligibility(double creditAmount) {

		if (cash - creditAmount <= reserves / 9) {

			return false;
		}
		return true;
	}

	public void openCreditAccount(Client client, int timePeriod, double creditAmount, CreditName productName) {
		if (!checkForCreditEligibility(creditAmount)) {
			System.out
					.println("The bank is not able to grant credit at this circumstances. The bank is short of cash.");
		}
		credits.add(new Credit(client, timePeriod, creditAmount, productName));
	}

	public void openDepositAccount(Client client, double depositAmount, DepositName productName) {
		deposits.add(new Deposit(client, depositAmount, productName));
	}

	public ArrayList<Deposit> getDeposits() {
		return deposits;
	}

	public double getReserves() {
		return reserves;
	}

	public void setReserves(double reserves) {
		this.reserves = reserves;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Bank: " + name + ",\n address: " + address + ",\n cash: " + cash + " leva,\n reserves: "
				+ reserves + ","
				+ "\n Granted credits: " + credits + ","
				+ "\n deposits: " + deposits
				+ "\n =================================";
	}

	public void addCash(double depositAmount) {
		cash += depositAmount;
	}

	public double getCash() {
		return cash;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public ArrayList<Credit> getCredits() {
		return credits;
	}


}

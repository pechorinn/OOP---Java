package client;

import static bank.Verification.checkIfInputPositive;
import static bank.Verification.checkIfInputPositiveAndNotEqualToZero;
import static bank.Verification.checkStringInput;

import java.util.ArrayList;

import bank.Bank;
import bankproduct.Credit;
import bankproduct.Credit.CreditName;
import bankproduct.Deposit;
import bankproduct.Deposit.DepositName;

public class Client {

	private String name;
	private String address;
	private double cash;
	private double salary;
	private ArrayList<Deposit> deposits;
	private ArrayList<Credit> credits;
	private Bank myBank;

	public Client(String name, String address, double cash, double salary, Bank myBank) {
		super();
		checkStringInput(name);
		this.name = name;
		checkStringInput(address);
		this.address = address;
		checkIfInputPositive(cash);
		this.cash = cash;
		checkIfInputPositiveAndNotEqualToZero(salary);
		this.salary = salary;
		this.deposits = new ArrayList<Deposit>();
		this.credits = new ArrayList<Credit>();
		this.myBank = myBank;
		this.myBank.getClients().add(this);
		System.out.println("New client was created: " + name);
	}

	public void makeDeposit(double depositAmount, DepositName productName) {
		if (checkTotalAmountOfCredits() < cash) {
			if (cash >= depositAmount) {
				myBank.openDepositAccount(this, depositAmount, productName);
				cash -= depositAmount;
			} else {
				System.out.println("You don't have enough money to make deposit for provided amount.");
			}
		} else {
			System.out.println("You have too much credits. Please pay off credits first.");
		}
	}

	private double checkTotalAmountOfCredits() {
		double sumOfCredits = 0;
		for (int i = 0; i < credits.size(); i++) {
			sumOfCredits += credits.get(i).getCash();
		}
		return sumOfCredits;
	}

	public void requestCredit(int timePeriod, double creditAmount, CreditName accountName) {
		if (timePeriod > 60) {
			System.out.println("The time period should be up to 60 months.");
			return;
		}

		if (timePeriod == 0) {
			System.out.println("The time period should be above zero.");
			return;
		}

		if (creditAmount <= 0) {
			System.out.println("Credit amount should be above zero.");
			return;
		}

		if (!checkMonthlyPaymentsToIncomeRatio(accountName, creditAmount)) {

			System.out.println("The monthly payments exceed customer's financial capability.");
			System.out.println("Credit request refused to " + name);
			System.out.println("------------------------------");
			return;
		}

		myBank.openCreditAccount(this, timePeriod, creditAmount, accountName);
	}

	private boolean checkMonthlyPaymentsToIncomeRatio(CreditName accountName, double creditAmount) {

		double totalMonthlyPayments = 0;

		for (int i = 0; i < credits.size(); i++) {
			totalMonthlyPayments += credits.get(i).getMonthlyPaymentForCredit();
		}

		if (totalMonthlyPayments > cash / 2) {
			return false;
		}

		return true;
	}

	public String getName() {
		return name;
	}

	public Bank getMyBank() {
		return myBank;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", address=" + address + ", cash=" + cash + ", salary=" + salary + ", deposits="
				+ deposits + ", credits=" + credits + ", myBank=" + myBank.getName() + "]";
	}

	public void addCash(double amount) {
		cash += amount;

	}

	public ArrayList<Deposit> getDeposits() {
		return deposits;
	}

	public double getCash() {
		return cash;
	}

	public ArrayList<Credit> getCredits() {
		return credits;
	}

	public void makePaymentsForCredits() {
		for (int i = 0; i < credits.size(); i++) {
			if (credits.get(i).getTimePeriod() == 0) {
				System.out.println(credits.get(i) + " was removed.");
				myBank.getCredits().remove(credits.get(i));
				credits.remove(i);
				break;
			}

			credits.get(i).decreaseTimePeriod();
			cash -= credits.get(i).getMonthlyPaymentForCredit();
		}
	}
}

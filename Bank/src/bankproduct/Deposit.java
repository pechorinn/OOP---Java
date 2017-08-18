package bankproduct;

import client.Client;

public class Deposit extends BankProduct {

	public enum DepositName {
		LONG_DEPOSIT, SHORT_DEPOSIT;
	}

	private double monthlyIncomeFromDeposit;

	public Deposit(Client client, double depositAmount, DepositName productName) {
		super(client, 1);
		if (productName == DepositName.LONG_DEPOSIT) {
			super.interest = 5;
			super.timePeriod = 12;
			System.out.println("New long-term deposit was created. Time duration: 12 months and interest 5%. Customer: "
					+ client.getName());
		} else if (productName == DepositName.SHORT_DEPOSIT) {
			super.interest = 3;
			super.timePeriod = 3;
			System.out.println("New short-term deposit was created. Time duration: 3 months and interest 3%. Customer: "
					+ client.getName());
		} else {
			System.out.println("New custom length deposit was created. Time duration: " + timePeriod
					+ " months and interest " + super.interest + "%. Customer: " + client.getName());
		}
		cash = depositAmount;
		client.getMyBank().setReserves(client.getMyBank().getReserves() + depositAmount * 0.9);
		client.getMyBank().addCash(depositAmount);
		client.getDeposits().add(this);
		monthlyIncomeFromDeposit = calculateIncomeFromDeposit(depositAmount, interest);
		System.out.println(depositAmount);
		System.out.println(interest);
	System.out.println("--------------------");
	}

	@Override
	public String toString() {
		return "Deposit [cash=" + cash + ", monthlyIncomeFromDeposits=" + monthlyIncomeFromDeposit + "]";
	}
	
	public double calculateIncomeFromDeposit(double depositAmount, double interest) {
		return (depositAmount * (interest / 100));
	}

	public double getMonthlyIncomeFromDeposit() {
		return monthlyIncomeFromDeposit;
	}
}

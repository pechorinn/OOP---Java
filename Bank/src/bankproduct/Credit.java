package bankproduct;

import client.Client;

public class Credit extends BankProduct {

	public enum CreditName {
		HOME_CREDIT, CONSUMER_CREDIT;
	}
    private CreditName creditName;
	private double monthlyPaymentForCredit;

	public Credit(Client client, int timePeriod, double creditAmount, CreditName productName) {
		super(client, timePeriod);
		if (productName == CreditName.CONSUMER_CREDIT) {
			super.interest = 10;
		} else if (productName == CreditName.HOME_CREDIT) {
			super.interest = 6;
		}
		
		this.creditName = productName;
	
		monthlyPaymentForCredit = calculateMonthlyPaymentForCredit(creditAmount, interest, timePeriod);
		System.out.println("Credit amount: " + creditAmount);
		System.out.println("Monthly payment: " + monthlyPaymentForCredit);
		System.out.println("Interest: " + interest);
		System.out.println("Credit period in months: " + timePeriod);
		client.getCredits().add(this);
		super.cash = creditAmount;
		client.getMyBank().addCash(creditAmount);
		client.addCash(creditAmount);
		System.out.println(
				"Credit granted " + productName + ". Amount " + creditAmount + ". To the customer: " + client.getName());
		System.out.println("------------------------------");
	}
	
	public double calculateMonthlyPaymentForCredit(double creditAmount, double interest, int timePeriod) {
		double monthly = timePeriod / 12;
		return ((creditAmount * (1+((interest * monthly / 100))))/timePeriod);
	}

	@Override
	public String toString() {
		
		return "\n Credit name: " + creditName
				+ "\n Credit owner: " + client.getName()
				+ "\n Credit amount: " + cash
				+ "\n monthlyPaymentForCredit: " + monthlyPaymentForCredit
				+ "\n -------------------------------\n"
				;
	}

	public void setMonthlyPaymentForCredit(double monthlyPaymentForCredit) {
		this.monthlyPaymentForCredit = monthlyPaymentForCredit;
	}

	public double getMonthlyPaymentForCredit() {
		return monthlyPaymentForCredit;
	}

	public void decreaseTimePeriod() {
		timePeriod--;
	}

}

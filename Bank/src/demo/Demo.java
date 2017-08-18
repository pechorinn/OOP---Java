package demo;

import java.util.ArrayList;
import java.util.Random;

import bank.Bank;
import bankproduct.Credit.CreditName;
import bankproduct.Deposit.DepositName;
import client.Client;

public class Demo {

	public static void main(String[] args) {

		Bank bulBank = new Bank("BulBank", "Sofia");

		Client ivan = new Client("Ivan", "Sofia", 100, 500, bulBank);
		Client hristo = new Client("Hristo", "Sofia", 150, 1000, bulBank);
		Client vyara = new Client("Vyara", "Sofia", 50, 1500, bulBank);
		Client lyubov = new Client("Lyubov", "Dupnica", 300, 2000, bulBank);
		Client marina = new Client("Marina", "Varna", 271, 1700, bulBank);
		Client dancho = new Client("Daniel", "Sofia", 30, 500, bulBank);
		Client hrisi = new Client("Hristina", "Sofia", 150, 1030, bulBank);
		Client iva = new Client("Iva", "Sofia", 357, 1770, bulBank);
		Client petya = new Client("Petya", "Dupnica", 10, 2555, bulBank);
		Client sergey = new Client("Sergey", "Varna", 170, 1990, bulBank);

		ArrayList<Client> clients = new ArrayList<>();
		clients.add(ivan);
		clients.add(hristo);
		clients.add(vyara);
		clients.add(lyubov);
		clients.add(marina);
		clients.add(dancho);
		clients.add(hrisi);
		clients.add(iva);
		clients.add(petya);
		clients.add(sergey);
		Random rnd = new Random();

		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).makeDeposit(
					rnd.nextInt((int) ((int) clients.get(i).getCash() * 0.2)) + clients.get(i).getCash() * 0.8,
					rnd.nextBoolean() ? DepositName.LONG_DEPOSIT : DepositName.SHORT_DEPOSIT);
		}
		
		System.out.println("The bank's casheir: "  + bulBank.getCash() + " leva.");
		System.out.println("The bank's reserves: " + bulBank.getReserves() + " leva.");
		
		
		for (int i = 0; i < clients.size(); i++) {
			clients.get(i).requestCredit(rnd.nextInt(60)+1, rnd.nextInt(500), rnd.nextBoolean() ? CreditName.CONSUMER_CREDIT : CreditName.HOME_CREDIT);
					
		}
				
		bulBank.payInterestOnAllDeposits();
	    System.out.println("==============================");
		System.out.println(bulBank);
	
		
		System.out.println("Credits issued by the bank: ");
		System.out.println(bulBank.getCredits());

		

	}
}

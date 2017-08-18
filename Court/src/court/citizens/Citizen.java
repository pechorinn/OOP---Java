package court.citizens;

import java.util.ArrayList;

import court.jurists.Lawyer;

public abstract class Citizen{

	private String names;
	private int age;
	private String address;
	private ArrayList<Lawyer> lawyers;
	
	public Citizen(String names, int age, String address) {
		//TODO validate
		this.names = names;
		this.age = age;
		this.address = address;
	}
	
	public Citizen(String names, int age, String address, ArrayList<Lawyer> lawyers) {
		this(names, age, address);
		this.lawyers = lawyers;
	}
	
	
}

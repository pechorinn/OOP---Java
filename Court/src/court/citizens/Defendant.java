package court.citizens;

import java.util.ArrayList;

import court.jurists.Lawyer;

public class Defendant extends LawyerClient {

	public Defendant(String names, int age, String address, ArrayList<Lawyer> lawyers) {
		super(names, age, address, lawyers);
	}

}

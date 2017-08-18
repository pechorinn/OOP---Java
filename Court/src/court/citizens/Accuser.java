package court.citizens;

import java.util.ArrayList;

import court.IAccuser;
import court.jurists.Lawyer;

public class Accuser extends LawyerClient implements IAccuser {
	
	public Accuser(String names, int age, String address, ArrayList<Lawyer> lawyers) {
		super(names, age, address, lawyers);
	}

	@Override
	public void askQuestion() {
		for (int i = 0; i < lawyers.size(); i++) {
			lawyers.get(i).askQuestion();
		}
	}
}

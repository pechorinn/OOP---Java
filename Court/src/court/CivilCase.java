package court;

import java.util.ArrayList;
import java.util.Random;

import court.citizens.Accuser;
import court.citizens.Defendant;
import court.citizens.Witness;
import court.jurists.Judge;
import court.jurists.Jury;
import court.jurists.Lawyer;

public class CivilCase extends Case{

	public CivilCase(Judge judge, ArrayList<Jury> jury, Accuser accuser, ArrayList<Witness> witnesses,
			Defendant defendant) {
		super(judge, jury, accuser, witnesses, defendant);
		System.out.println("New civil case created.");
	}

	@Override
	protected void askQuestions() {
		ArrayList<Lawyer> lawyers = ((Accuser) accuser).getLawyers();
		for (int i = 0; i < lawyers.size(); i++) {
			lawyers.get(i).askQuestion();
		}
		for (int i = 0; i < lawyers.size(); i++) {
			lawyers.get(i).askQuestion();
		}
	}

	

	
}

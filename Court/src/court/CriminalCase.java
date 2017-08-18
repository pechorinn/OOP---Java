package court;

import java.util.ArrayList;

import court.citizens.Defendant;
import court.citizens.Witness;
import court.jurists.Judge;
import court.jurists.Jury;
import court.jurists.Procecutor;

public class CriminalCase extends Case{

	public CriminalCase(Judge judge, ArrayList<Jury> jury, Procecutor accuser, ArrayList<Witness> witnesses,
			Defendant defendant) {
		super(judge, jury, accuser, witnesses, defendant);
		System.out.println("New criminal case created.");
	}
	
	@Override
	protected void increaseXP() {
		super.increaseXP();
		((Procecutor)this.accuser).increaseCases();
	}

	@Override
	protected void askQuestions() {
		for (int i = 0; i < 5; i++) {
			this.accuser.askQuestion();
		}
	}
	
}

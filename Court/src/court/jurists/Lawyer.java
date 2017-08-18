package court.jurists;

import court.IAccuser;

public class Lawyer extends Jurist {

	public Lawyer(String name, int exp, int cases) {
		super(name, exp, cases > 10 ? cases : 10);
		this.position = "Lawyer";
	}

	@Override
	public void askQuestion() {
		System.out.println(IAccuser.getRandomQuestion());
		takeNotes();
	}
}

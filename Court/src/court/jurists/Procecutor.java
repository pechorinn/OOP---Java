package court.jurists;

import java.util.Random;

import court.IAccuser;

public class Procecutor extends Jurist implements IAccuser {

	
	public Procecutor(String name, int exp, int cases) {
		super(name, exp > 10 ? exp : 10, cases);
		this.position = "Procecutor";

	}

	@Override
	public void askQuestion() {
		System.out.println(IAccuser.getRandomQuestion());
		takeNotes();
	}

}
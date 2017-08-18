package court.jurists;

public class Jury extends Jurist{

	public Jury(String name, int exp, int cases) {
		super(name, exp, cases);
		this.position = "Jury";
	}

	@Override
	protected void askQuestion() {
		System.out.println("Ti mene useshtash li me kato zasedatel?");
		takeNotes();
	}

	

}
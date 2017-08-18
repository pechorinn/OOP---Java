package court.jurists;

public class Judge extends Jurist{

	public Judge(String name, int exp, int cases) {
		super(name, exp > 5 ? exp : 5, cases);
		this.position = "Judge";
	}

	@Override
	protected void askQuestion() {
		System.out.println("Ti mene chuvahs li me kato sudia?");
	}

	

}
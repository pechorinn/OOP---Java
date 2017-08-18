package court.jurists;

import java.util.Random;

public abstract class Jurist {

	private String name;
	protected String position;
	private int exp;
	private int cases;
	
	public Jurist(String name, int exp, int cases) {
		this.name = name;
		this.exp = exp;
		this.cases = cases;
	}
	
	protected abstract void askQuestion();
		
	public void increaseCases(){
		this.cases++;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name + " - "+ cases + "\n";
	}
	
	public static void takeNotes() {

		System.out.println("Lawyer takes notes:");
		if(new Random().nextBoolean()) {
			System.out.println("No respect from this character.");
		} else  {
			System.out.println("He shows respect. Let's see!!!");
		}
	}
	
	
}

package musicinstruments.strunni;


public class Arfa extends Strunni {
	
	public Arfa() {
		this(Strunni.ARFA, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Arfa(Strunni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}



}

package musicinstruments.klavishni;


public class Piano extends Klavishni {
	
	public Piano() {
		this(Klavishni.PIANO, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Piano(Klavishni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

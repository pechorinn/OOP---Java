package musicinstruments.klavishni;

public class Organ extends Klavishni {

	public Organ() {
		this(Klavishni.ORGAN, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Organ(Klavishni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

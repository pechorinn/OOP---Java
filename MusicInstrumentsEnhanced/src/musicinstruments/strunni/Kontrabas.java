package musicinstruments.strunni;

public class Kontrabas extends Strunni {
	
	public Kontrabas() {
		this(Strunni.KONTRABAS, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Kontrabas(Strunni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

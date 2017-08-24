package musicinstruments.klavishni;

import musicinstruments.Instrument;

public class Akordeon extends Klavishni {
	
	public Akordeon() {
		this(Klavishni.AKORDEON, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Akordeon(Instrument.Klavishni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

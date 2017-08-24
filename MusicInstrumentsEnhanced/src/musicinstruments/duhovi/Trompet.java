package musicinstruments.duhovi;

import musicinstruments.Instrument;

public class Trompet extends Duhovi {

	public Trompet() {
		this(Duhovi.TROMPET, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Trompet(Instrument.Duhovi name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

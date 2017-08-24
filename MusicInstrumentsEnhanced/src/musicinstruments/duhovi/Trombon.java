package musicinstruments.duhovi;

import musicinstruments.Instrument;

public class Trombon extends Duhovi {

	public Trombon() {
		this(Duhovi.TROMBON, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Trombon(Instrument.Duhovi name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

package musicinstruments.duhovi;

import musicinstruments.Instrument;

public class Fleita extends Duhovi {

	public Fleita() {
		this(Duhovi.FLEITA, rnd.nextInt(100)+50, rnd.nextInt(10)+5);
	}

	public Fleita(Instrument.Duhovi duhovi, double price, int availbaleCount) {
		super(duhovi, price, availbaleCount);
	}

}

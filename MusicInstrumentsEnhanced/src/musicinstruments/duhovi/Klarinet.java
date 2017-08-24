package musicinstruments.duhovi;

import musicinstruments.Instrument;


public class Klarinet extends Duhovi {

	public Klarinet() {
		this(Duhovi.KLARINET, rnd.nextInt(100)+50, rnd.nextInt(10)+5);
	}

	public Klarinet(Instrument.Duhovi name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

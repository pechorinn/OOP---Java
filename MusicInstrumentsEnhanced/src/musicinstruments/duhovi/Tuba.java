package musicinstruments.duhovi;

import musicinstruments.Instrument;

public class Tuba extends Duhovi {
	
	public Tuba() {
		this(Duhovi.TUBA, rnd.nextInt(100)+50, rnd.nextInt(10)+5);
	}

	public Tuba(Instrument.Duhovi name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

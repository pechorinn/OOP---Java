package musicfestival;

public class Instrumentalist extends Musician {

	private String instrument;

	Instrumentalist(String name, String instrument, Band band) {
		super(name, band);
		if (instrument != null && !instrument.isEmpty()) {
			this.instrument = instrument;
		}
	}

	public String getInfo() {
		return getName() + " - " + this.instrument;
	}

	@Override
	public String toString() {
		return getName() + " - " + this.instrument;
	}

}

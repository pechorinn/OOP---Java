package musicinstruments.strunni;

public class Viola extends Strunni {

	public Viola() {
		this(Strunni.VIOLA, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Viola(Strunni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}
}

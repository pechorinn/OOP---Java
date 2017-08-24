package musicinstruments.strunni;

public class Tsigulka extends Strunni {

	public Tsigulka() {

		this(Strunni.TSIGULKA, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Tsigulka(Strunni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

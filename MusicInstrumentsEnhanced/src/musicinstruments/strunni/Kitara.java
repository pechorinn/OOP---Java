package musicinstruments.strunni;

public class Kitara extends Strunni {

	public Kitara() {
		this(Strunni.KITARA, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Kitara(Strunni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

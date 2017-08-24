package musicinstruments.udarni;

public class Baraban extends Udarni {

	public Baraban() {
		this(Udarni.BARABAN, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}
	public Baraban(Udarni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

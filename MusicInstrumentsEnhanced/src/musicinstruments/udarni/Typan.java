package musicinstruments.udarni;

public class Typan extends Udarni {

	public Typan() {
		this(Udarni.TYPAN, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Typan(Udarni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

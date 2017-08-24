package musicinstruments.udarni;

public class Daire extends Udarni {

	public Daire() {
		this(Udarni.DAIRE, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Daire(Udarni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

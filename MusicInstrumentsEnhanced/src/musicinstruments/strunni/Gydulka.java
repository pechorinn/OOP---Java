package musicinstruments.strunni;

public class Gydulka extends Strunni {

	public Gydulka() {
		this(Strunni.GYDULKA, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}
	
	public Gydulka(Strunni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

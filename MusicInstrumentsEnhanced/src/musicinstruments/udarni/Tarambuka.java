package musicinstruments.udarni;

public class Tarambuka extends Udarni {

	public Tarambuka() {
		this(Udarni.TARAMBUKA, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}
	public Tarambuka(Udarni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}
}

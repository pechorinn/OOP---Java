package musicinstruments.electronni;

public class Sintezator extends Electronni {

	public Sintezator() {
		this(Electronni.SINTEZATOR, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public Sintezator(Electronni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

package musicinstruments.electronni;

public class ElektricheskaTsigulka extends Electronni {

	public ElektricheskaTsigulka() {
		this(Electronni.ELEKTRICHESKA_TSIGULKA, rnd.nextInt(100) + 50, rnd.nextInt(10) + 5);
	}

	public ElektricheskaTsigulka(Electronni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}
}

package musicinstruments.electronni;

public class BasKitara extends Electronni {
	
	public BasKitara() {
		this(Electronni.BAS_KITARA, rnd.nextInt(100)+50, rnd.nextInt(10)+5);
	}

	public BasKitara(Electronni name, double price, int availbaleCount) {
		super(name, price, availbaleCount);
	}

}

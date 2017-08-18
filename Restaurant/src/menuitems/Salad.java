package menuitems;

public class Salad extends Meals implements IVeganDiet {

	public Salad() {
		super("Salad", 5, rnd.nextInt(301)+300 ,10);
	}

}

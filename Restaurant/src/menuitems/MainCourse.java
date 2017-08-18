package menuitems;

public class MainCourse extends Meals implements IBadBoyDiet{

	public MainCourse() {
		super("Main Course", 9, rnd.nextInt(401)+400, 10);
	}

}

package clients;

import menuitems.MenuItems;
import restaurant.Restaurant;

public class Student extends Client {

	public Student(String name, Restaurant myRestaurant) {
		super(10, name, myRestaurant);
		System.out.println("New student created: " + name);
	}

	@Override
	protected boolean checkAccordingToDiet(MenuItems item) {
		return true;
	}

}

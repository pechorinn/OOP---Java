package clients;

import menuitems.IBadBoyDiet;
import menuitems.MenuItems;
import restaurant.Restaurant;

public class BadBoy extends Client {

	public BadBoy(String name, Restaurant myRestaurant) {
		super(50, name, myRestaurant);
		System.out.println("New bad boy created: " + name);
	}

	@Override
	protected boolean checkAccordingToDiet(MenuItems item) {
		return (item instanceof IBadBoyDiet);
	}

}

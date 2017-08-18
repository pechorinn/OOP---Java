package clients;

import menuitems.IVeganDiet;
import menuitems.MenuItems;
import restaurant.Restaurant;

public class Vegan extends Client {

	public Vegan(String name, Restaurant myRestaurant) {
		super(30, name, myRestaurant);
		System.out.println("New vegan created: " + name);
	}

	@Override
	protected boolean checkAccordingToDiet(MenuItems item) {
		return (item instanceof IVeganDiet);
	}

}

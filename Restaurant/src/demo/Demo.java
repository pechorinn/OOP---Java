package demo;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import clients.BadBoy;
import clients.Student;
import clients.Vegan;
import menuitems.Meals;
import menuitems.MenuItems;
import restaurant.Restaurant;
import restaurant.Restaurant.MenuItem;

public class Demo {

	public static void main(String[] args) {

		/*
		 * Създава ресторант с име „При Пешо Таланта(let it be Viking :))“ и 5
		 * сервитьора, работещи в него. Началната сума, налична в ресторанта е
		 * 1000 лева. При създаването си ресторантът съдържа 10 порции от всеки
		 * вид ястие и 20 броя от всеки вид напитка
		 */
		Restaurant restaurant = new Restaurant("Viking", "Sofia");
		System.out.println("============================================================");

		/*
		 * 2. Създава 15 клиента, като на произволен принцип трябва да бъдат
		 * студенти, мутри или вегани. Вероятността да се създаде веган трябва
		 * да е 20%, студент – 30% , а мутра – 50%.
		 */

		Random rnd = new Random();

		for (int i = 0; i < 15; i++) {
			int random = rnd.nextInt(101);
			if (random < 20) {
				new Student("Student " + (i + 1), restaurant);
			} else if (random < 50) {
				new Vegan("Vegan " + (i + 1), restaurant);
			} else {
				new BadBoy("Bad Boy " + (i + 1), restaurant);
			}
		}
		System.out.println("============================================================");
		/*
		 * 3. Създава метод, който стартира работата на ресторанта. Работата на
		 * ресторанта се състои в следното: ◦ влизане на всички клиенти в
		 * ресторанта; ◦ поръчка на всички клиенти към произволен сервитьор.
		 * Поръчките се правят като на произволен принцип клиентът поръчва
		 * продукт, който може да консумира. Всеки продукт има равен шанс да
		 * бъде поръчан. ◦ поискване на сметката от всеки клиент; ◦ плащане на
		 * сметката от всеки клиент.
		 * 
		 */

		restaurant.startSimulation();
		System.out.println("============================================================");

		/*
		 * 4. Да се изпише текущия паричен баланс на ресторантът след като
		 * всички клиенти са си отишли.
		 */

		System.out.printf("Restaurant balance: %.2f$%n", restaurant.getCapital());
		System.out.println("============================================================");

		// 5. Да се изведе сервитьорът с най-голям бакшиш.

		restaurant.getWaiters().sort((w1, w2) -> Double.compare(w2.getCash(), w1.getCash()));
		System.out.println("The waiter with highest tip is: " + restaurant.getWaiters().get(0).getName());
		System.out.printf("His tip amount: %.2f$%n", restaurant.getWaiters().get(0).getCash());
		System.out.println("============================================================");

		/*
		 * 6. Да се изведат имената и бакшишите на всички сервитьори, подредени
		 * от този с най-големия бакшиш за вечерта към този с най-малкия.
		 */
		System.out.println("List of waiters sorted in descending order according to total tip amount:");
		restaurant.getWaiters().forEach(
				waiter -> System.out.printf("%s his total tip is: %.2f$%n", waiter.getName(), waiter.getCash()));
		System.out.println("============================================================");

		/*
		 * 7. Да се изведе списък с останалите продукти, налични в ресторанта.
		 * Продуктите да са сортирани по цена и разделени по вид. Да изглеждат
		 * по следния начин:
		 */

		for (Map.Entry<MenuItem, ArrayList<MenuItems>> entry : restaurant.getMenu().entrySet()) {
			System.out.println(entry.getKey() + ": ");
			for (MenuItems item : restaurant.getMenu().get(entry.getKey())) {
				if (item.getAvailableCount() > 0) {
					System.out.println("         " + item.getName() + " - " + item.getAvailableCount()
							+ (item instanceof Meals ? " portion/s" : " item/s"));
				}
			}
		}
	}
}

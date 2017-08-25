package demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import driver.Driver;
import gasstation.GasStation;
import vehicle.Vehicle;
import vehicle.Vehicle.VehicleType;

public class Demo {

	public static void main(String[] args) {
		Random rnd = new Random();
		/*
		 * 1. Създаване на бензиностанция с автоматично генерирани винетки. Да
		 * се изведат на екрана, заедно с техните цена и цвят. - 5т.
		 */
		GasStation gs = new GasStation();
		gs.printAllVignettes();

		/*
		 * 2. Създаване на 20 шофьора с произволни имена. Да им се дадат
		 * произволна стойност пари. Да им се зададе бензиностанция, от която да
		 * пазаруват винетки. - 5т.
		 */
		ArrayList<Driver> drivers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			drivers.add(new Driver("Driver " + (i + 1), rnd.nextInt(1000), gs));
		}

		/*
		 * 3. Създаване на 200 превозни средства от произволен тип (кола,
		 * автобус, камион) и на всеки шофьор да се дадат по 10 от тях като
		 * всяко превозно средство се управлява от един шофьор. - 10т.
		 */
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			vehicles.add(new Vehicle(VehicleType.values()[rnd.nextInt(VehicleType.values().length)],
					rnd.nextInt(21) + 1990, "Volvo Model: RL" + rnd.nextInt(100)));
		}

		while (!vehicles.isEmpty()) {
			for (int i = 0; i < drivers.size(); i++) {
				Vehicle vehicle = vehicles.remove(rnd.nextInt(vehicles.size()));
				drivers.get(i).getVehicles().add(vehicle);
				vehicle.setDriver(drivers.get(i));
			}
		}

		/*
		 * 4. Всеки 3-ти шофьор на произволен принцип за някои превозни средства
		 * да купи 5 винетки за произволно генериран срок (ден, месец, година).
		 * Останалите шофьори да купят винетки за всичките си превозни средства
		 * за произволно генериран срок. - 10т.
		 */

		for (int i = 0; i < drivers.size(); i++) {
			if ((i + 1) % 3 == 0) {
				for (int j = 0; j < 5; j++) {
					drivers.get(i).buyVignette(drivers.get(i).getVehicles().get(j));
				}
			} else {
				drivers.get(i).buyVignette();
			}
		}

		/*
		 * 5. Да се изведе информация за всички шофьори – колко коли карат,
		 * колко от техните превозни средства имат винетка с изтичащ срок за
		 * дадена дата и колко пари са им останали. - 15т.
		 */

		for (int i = 0; i < drivers.size(); i++) {

			drivers.get(i).printInfoAboutDriversVehiclesCashVignettes(
					LocalDate.of(2017, rnd.nextInt(12) + 1, rnd.nextInt(28) + 1));
		}

		/*
		 * 6. Да се изведат всички останали винетки в бензиностанцията в
		 * сортиран по цена ред. -5т.
		 */
		gs.printAllVignettes();

		/*
		 * 7. Да се изведат всички камиони, които имат изтекли винетки за дадена
		 * дата.
		 */

		System.out.println("=======================================================");
		System.out.println("        Below trucks are with expired vignette: ");
		System.out.println("=======================================================");
		LocalDate localDate = LocalDate.of(2017, rnd.nextInt(12) + 1, rnd.nextInt(28) + 1);
		System.out.println("The reference date is: " + localDate);
		for (int i = 0; i < drivers.size(); i++) {
			drivers.get(i).printInfoForTrucksWithExpiredVignette(localDate);
		}

	}
}

package demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import driver.Driver;
import gasstation.GasStation;
import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;
import vignette.Vignette.Period;

public class Demo {

	public static void main(String[] args) {

		Random rnd = new Random();
		GasStation gs = new GasStation("OMV");
		gs.printData();

		ArrayList<Driver> drivers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			drivers.add(new Driver("Driver N" + (i + 1), rnd.nextInt(1000) + 1000, gs));
		}

		ArrayList<Vehicle> vehicles = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			if (i < 200 / 3) {
				vehicles.add(new Car("Lada" + rnd.nextInt(1000) + 1, rnd.nextInt(20) + 1995));
			} else if (i < 200 / 3 * 2) {
				vehicles.add(new Truck("Volvo" + rnd.nextInt(1000) + 1, rnd.nextInt(20) + 1995));
			} else {
				vehicles.add(new Bus("Mercedes" + rnd.nextInt(1000) + 1, rnd.nextInt(20) + 1995));
			}
		}

		ArrayList<Vehicle> vehicles2 = new ArrayList<>(vehicles);

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 10; j++) {
				drivers.get(i).addVehicle(vehicles.remove(rnd.nextInt(vehicles.size())));
			}
		}

		for (int i = 1; i <= 20; i++) {

			if (i % 3 == 0) {
				for (int j = 0; j < 5; j++) {
					drivers.get(i - 1).buyVignette(j, Period.values()[rnd.nextInt(Period.values().length)]);
				}
			} else {
				drivers.get(i - 1).buyVignette();
			}
		}

		for (int i = 0; i < drivers.size(); i++) {
			drivers.get(i).printCarsReadyForDrive();
			drivers.get(i).printVehiclesWithExpiredVignetteForSpecifiedDate(LocalDate.of(2017, rnd.nextInt(12) + 1, 1));
			drivers.get(i).printRemainingCash();
			;
		}

		gs.printData();

		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Below vehicles will be with expired vignettes by the date: " + LocalDate.of(2018, 1, 1));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

		
		for (int i = 0; i < vehicles2.size(); i++) {

			if (vehicles2.get(i).getVignette() != null
					&& vehicles2.get(i).getVignette().getExpDate().isBefore(LocalDate.of(2018, 1, 1))) {
				System.out.println(vehicles2.get(i));
			}
		}

	}
}

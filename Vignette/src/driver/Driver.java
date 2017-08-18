package driver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import gasstation.GasStation;
import vehicle.Vehicle;
import vehicle.Vehicle.VehicleType;
import vignette.Vignette.VignetteDuration;

public class Driver {

	private String name;
	private double cash;
	private ArrayList<Vehicle> vehicles;
	private GasStation gasStation;
	private Random rnd = new Random();

	public Driver(String name, double cash, GasStation gasStation) {
		super();
		this.name = name;
		this.cash = cash;
		this.vehicles = new ArrayList<>();
		this.gasStation = gasStation;
	}

	public double getCash() {

		return cash;
	}

	public void setCash(double payment) {

		cash -= payment;
	}

	public ArrayList<Vehicle> getVehicles() {
		return vehicles;
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + ", cash=" + cash + ", vehicles=" + vehicles + ", gasStation=" + gasStation
				+ "]\n";
	}

	public void buyVignette(Vehicle vehicle) {

		gasStation.sellVignette(VignetteDuration.values()[rnd.nextInt(VignetteDuration.values().length)], vehicle);
	}

	public void buyVignette() {

		gasStation.sellVignettesForAllVehiclesOfTheDriver(this);
	}

	public void placeVignetteOnWindowsScreen(Vehicle vehicle) {

		vehicle.getVignette().setPlacedOnWindowScreen(true);
		printTimeTakenToStickTheVignette(vehicle);
	}

	private void printTimeTakenToStickTheVignette(Vehicle vehicle) {

		if (vehicle.getVehicleType() == VehicleType.BUS) {
			System.out.println("It took 20 seconds to stick vignette on the front window of the Bus.");
		} else if (vehicle.getVehicleType() == VehicleType.TRUCK) {
			System.out.println("It took 10 seconds to stick vignette on the front window of the Truck.");
		} else if (vehicle.getVehicleType() == VehicleType.CAR) {
			System.out.println("It took 5 seconds to stick vignette on the front window of the Car.");
		}
	}

	public String getName() {
		return name;
	}

	public void printInfoAboutDriversVehiclesCashVignettes(LocalDate date) {

		int vehiclesWithValidVignettes = 0;
		int vehiclesWithNoVignettes = 0;
		int vehiclesWithExpiredVignettes = 0;

		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getVignette() == null) {
				vehiclesWithNoVignettes++;
				continue;
			}
			if (vehicles.get(i).getVignette().getVignetteDuration() == VignetteDuration.DAY) {
				if (date.isAfter(vehicles.get(i).getVignette().getIssueDate())) {
					vehiclesWithExpiredVignettes++;
				} else {
					vehiclesWithValidVignettes++;
				}
			} else if (vehicles.get(i).getVignette().getVignetteDuration() == VignetteDuration.MONTH) {
				if (date.isAfter(vehicles.get(i).getVignette().getIssueDate().plusMonths(1))) {
					vehiclesWithExpiredVignettes++;
				} else {
					vehiclesWithValidVignettes++;
				}
			} else if (vehicles.get(i).getVignette().getVignetteDuration() == VignetteDuration.YEAR) {
				if (date.isAfter(vehicles.get(i).getVignette().getIssueDate().plusYears(1))) {
					vehiclesWithExpiredVignettes++;
				} else {
					vehiclesWithValidVignettes++;
				}
			}
		}

		System.out.println("=====================================");
		System.out.println("The driver \"" + name + "\" has " + vehicles.size() + " vehicles.");
		System.out.println(vehiclesWithValidVignettes + " vehicles are with valid vignette.");
		System.out.println(vehiclesWithExpiredVignettes + " vehicles are with expired vignette.");
		System.out.println(vehiclesWithNoVignettes + " vehicles are without a vignette at all.");
		System.out.println("The driver's cash available: " + cash + "$");
		System.out.println("=====================================");
	}

	public void printInfoForTrucksWithExpiredVignette(LocalDate date) {

		
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getVignette() == null || vehicles.get(i).getVehicleType() != VehicleType.TRUCK) {
				continue;
			}

			if (vehicles.get(i).getVignette().getVignetteDuration() == VignetteDuration.DAY) {
				if (date.isAfter(vehicles.get(i).getVignette().getIssueDate())) {
				System.out.println(vehicles.get(i));
				}
			} else if (vehicles.get(i).getVignette().getVignetteDuration() == VignetteDuration.MONTH) {
				if (date.isAfter(vehicles.get(i).getVignette().getIssueDate().plusMonths(1))) {
					System.out.println(vehicles.get(i));
				}
			} else if (vehicles.get(i).getVignette().getVignetteDuration() == VignetteDuration.YEAR) {
				if (date.isAfter(vehicles.get(i).getVignette().getIssueDate().plusYears(1))) {
					System.out.println(vehicles.get(i));
				}
			}
		}
	}
}

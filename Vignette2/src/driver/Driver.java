package driver;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import gasstation.GasStation;
import vehicle.Vehicle;
import vignette.Vignette.Period;

public class Driver {

	private String name;
	private ArrayList<Vehicle> vehicles;
	private double cash;
	private GasStation myGasStation;
	private static Random rnd = new Random();

	public Driver(String name, double cash, GasStation myGasStation) {
		super();
		this.name = name;
		this.cash = cash;
		this.myGasStation = myGasStation;
		this.vehicles = new ArrayList<>();
		System.out.println("New driver created: " + name);
	}

	public void addVehicle(Vehicle vehicle) {

		if (vehicle.getDriver() == null) {
			vehicles.add(vehicle);
			vehicle.setDriver(this);
			System.out.println("Vehicle " + vehicle.getModel() + " added to driver " + name);
		} else {
			System.out.println("The vehicle alredy has a driver.");
		}
	}

	public void buyVignette(int vehicleNumber, Period period) {

		if (vehicleNumber < 0 || vehicles.size() <= vehicleNumber) {
			System.out.println("Please provide the correct vehicle number.");
			System.out.println("Vehicles number: " + vehicleNumber);
		} else {
			myGasStation.sellVignette(vehicles.get(vehicleNumber), period, this);
		}
	}

	public void buyVignette() {
		for (int i = 0; i < vehicles.size(); i++) {
			buyVignette(i, Period.values()[rnd.nextInt(Period.values().length)]);
		}
	}

	public double getCash() {
		return cash;
	}

	public String getName() {
		return name;
	}

	public void deductCash(double price) {
		cash -= price;
	}

	public void printCarsReadyForDrive() {

		System.out.println("==============================================================");
		System.out.println("Below vehicles have valid vignettes and are drived by " + name);
		System.out.println("==============================================================");
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getVignette() != null
					&& vehicles.get(i).getVignette().getExpDate().isAfter(LocalDate.now())) {
				System.out.println(vehicles.get(i));
			}
		}
		System.out.println("==============================================================");
	}

	public void printVehiclesWithExpiredVignetteForSpecifiedDate(LocalDate date) {

		int vehiclesWithExpiredVignette = 0;
		for (int i = 0; i < vehicles.size(); i++) {
			if (vehicles.get(i).getVignette() != null && vehicles.get(i).getVignette().getExpDate().isBefore(date));
			vehiclesWithExpiredVignette++;
		}

		System.out.println("==============================================================");
		if (vehiclesWithExpiredVignette > 0) {
			System.out.println("The driver " + name + " has " + vehiclesWithExpiredVignette
					+ " vehicles with expired vignettesfor the date " + date);
		} else {
			System.out.println("The driver " + name + " has no vehicles with expired vignettes for the date " + date);
		}
		System.out.println("==============================================================");
	}
	
	public void printRemainingCash() {
		String cashFormated = String.format("(%.1f $)", cash);
		System.out.println("The driver " + name + " has "+ cashFormated + " left on the balance.");
	}

	@Override
	public String toString() {
		return "Driver [name=" + name + "]";
	}
	
	
}

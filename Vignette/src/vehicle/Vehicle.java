package vehicle;

import driver.Driver;
import vignette.Vignette;

public class Vehicle {

	public enum VehicleType {
		BUS, CAR, TRUCK
	}

	private Driver driver;
	private VehicleType vehicleType;
	private int yearOfProduction;
	private Vignette vignette;
	private String model;

	public Vehicle(VehicleType vehicleType, int yearOfProduction, String model) {
		super();

		this.vehicleType = vehicleType;
		this.yearOfProduction = yearOfProduction;
		this.model = model;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public void setVignette(Vignette vignette) {
		this.vignette = vignette;
	}

	@Override
	public String toString() {
		return "Vehicle [driver=" + driver.getName()
				+ ", vehicleType=" + vehicleType + ", "
						+ "yearOfProduction=" + yearOfProduction
				+ ", vignette issue date: " + vignette.getIssueDate() + ", vignette duration " + vignette.getVignetteDuration() + ", model=" + model + "]\n";
	}

	public Vignette getVignette() {
		return vignette;
	}

}

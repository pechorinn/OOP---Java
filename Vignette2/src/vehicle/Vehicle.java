package vehicle;

import driver.Driver;
import vignette.Vignette;

public abstract class Vehicle {

	protected String name;
	protected String model;
	protected Vignette vignette;
	protected int yearOfProduction;
	protected Driver myDriver;

	public Vehicle(String model, int yearOfProduction, String name) {
		super();
		this.name = name;
		this.model = model;
		this.yearOfProduction = yearOfProduction;
		System.out.println("New vehicle created: " + model);
	}

	public String getModel() {
		return model;
	}

	public String getName() {
		return name;
	}

	public void setDriver(Driver driver) {

		myDriver = driver;
	}

	public Driver getDriver() {

		return myDriver;
	}

	public void setVignette(Vignette vignette) {
		this.vignette = vignette;
		placeOnWindowScreen();
		vignette.setAsSticked();
	}

	public abstract void placeOnWindowScreen();

	public Vignette getVignette() {
		return vignette;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + ", model=" + model + ", vignette=" + vignette + ", yearOfProduction="
				+ yearOfProduction + ", myDriver=" + myDriver + "]";
	}

	
}

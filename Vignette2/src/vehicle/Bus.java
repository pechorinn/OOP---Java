package vehicle;

public class Bus extends Vehicle {

	public Bus(String model, int yearOfProduction) {
		super(model, yearOfProduction, "Bus");

	}

	@Override
	public void placeOnWindowScreen() {
		System.out.println("It took 20 seconds to place the vignette.");
	}
}

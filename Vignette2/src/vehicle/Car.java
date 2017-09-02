package vehicle;

public class Car extends Vehicle {

	public Car(String model, int yearOfProduction) {
		super(model, yearOfProduction,"Car");
	}

	@Override
	public void placeOnWindowScreen() {
		System.out.println("It took 5 seconds to place the vignette.");
	}
}

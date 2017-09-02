package vehicle;

public class Truck extends Vehicle {

	public Truck(String model, int yearOfProduction) {
		super(model, yearOfProduction, "Truck");
	}
	
	@Override
	public void placeOnWindowScreen() {
		System.out.println("It took 10 seconds to place the vignette.");
	}
}

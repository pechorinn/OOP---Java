package gasstation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import driver.Driver;
import vehicle.Vehicle;
import vehicle.Vehicle.VehicleType;
import vignette.Vignette;
import vignette.Vignette.VignetteDuration;

public class GasStation {

	private Map<VehicleType, Map<VignetteDuration, ArrayList<Vignette>>> allVignettes;
	private double cash;
	private Random rnd = new Random();

	public GasStation() {
		super();
		this.allVignettes = new TreeMap<>();
		allVignettes.put(VehicleType.BUS, new TreeMap<>());
		allVignettes.put(VehicleType.CAR, new TreeMap<>());
		allVignettes.put(VehicleType.TRUCK, new TreeMap<>());
		allVignettes.get(VehicleType.BUS).put(VignetteDuration.DAY, new ArrayList<>());
		allVignettes.get(VehicleType.BUS).put(VignetteDuration.MONTH, new ArrayList<>());
		allVignettes.get(VehicleType.BUS).put(VignetteDuration.YEAR, new ArrayList<>());
		allVignettes.get(VehicleType.CAR).put(VignetteDuration.DAY, new ArrayList<>());
		allVignettes.get(VehicleType.CAR).put(VignetteDuration.MONTH, new ArrayList<>());
		allVignettes.get(VehicleType.CAR).put(VignetteDuration.YEAR, new ArrayList<>());
		allVignettes.get(VehicleType.TRUCK).put(VignetteDuration.DAY, new ArrayList<>());
		allVignettes.get(VehicleType.TRUCK).put(VignetteDuration.MONTH, new ArrayList<>());
		allVignettes.get(VehicleType.TRUCK).put(VignetteDuration.YEAR, new ArrayList<>());
		this.cash = 1000;

		createVignettes();
	}

	private void createVignettes() {

		for (int i = 0; i < VehicleType.values().length; i++) {

			for (int j = 0; j < VignetteDuration.values().length; j++) {

				for (int j2 = 0; j2 < 50; j2++) {

					allVignettes.get(VehicleType.values()[i]).get(VignetteDuration.values()[j])
							.add(new Vignette(VignetteDuration.values()[j], VehicleType.values()[i]));
				}
			}
		}
	}

	public void printAllVignettes() {
		System.out.println(allVignettes);
	}

	public void sellVignette(VignetteDuration vignetteDuration, Vehicle vehicle) {
		if (allVignettes.get(vehicle.getVehicleType()).get(vignetteDuration).size() > 0) {
			Vignette vignette = allVignettes.get(vehicle.getVehicleType()).get(vignetteDuration).remove(0);
			vignette.setVehicle(vehicle);
			vignette.setIssueDate(LocalDate.of(2017, rnd.nextInt(12) + 1, rnd.nextInt(28) + 1));
			vehicle.setVignette(vignette);
			if (vehicle.getDriver().getCash() < vignette.getPrice()) {
				System.out.println(
						"The driver \"" + vehicle.getDriver().getName() + "\" has not enough cash to buy a vignette.");
			} else {
				vehicle.getDriver().setCash(vignette.getPrice());
				vehicle.getDriver().placeVignetteOnWindowsScreen(vehicle);
				cash += vignette.getPrice();
			}
		} else {
			System.out.println("No more vignettes of this type left in stock:");
			System.out.println(vehicle.getVehicleType());
			System.out.println(vignetteDuration);
		}
	}

	public void sellVignettesForAllVehiclesOfTheDriver(Driver driver) {

		for (int i = 0; i < driver.getVehicles().size(); i++) {
			sellVignette(VignetteDuration.values()[rnd.nextInt(VignetteDuration.values().length)],
					driver.getVehicles().get(i));
		}
	}

	@Override
	public String toString() {
		return "GasStation [allVignettes=" + allVignettes + ", cash=" + cash + "]";
	}
	
	
}

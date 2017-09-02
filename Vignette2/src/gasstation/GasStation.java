package gasstation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

import driver.Driver;
import vehicle.Vehicle;
import vignette.BusVignette;
import vignette.CarVignette;
import vignette.TruckVignette;
import vignette.Vignette;
import vignette.Vignette.Period;

public final class GasStation {

	private String name;
	private HashMap<String, TreeSet<Vignette>> data;
	private static int NUMBER_OF_VIGNETTES_IN_STORE = 200;
	private double cash;

	public GasStation(String name) {
		super();
		this.name = name;
		this.data = new HashMap<>();
		data.put("Car", new TreeSet<Vignette>());
		data.put("Truck", new TreeSet<Vignette>());
		data.put("Bus", new TreeSet<Vignette>());
		createVignettes();
		System.out.println("New Gas Station created.");
	}

	private void createVignettes() {

		int numberOfVignettesOfEachType = NUMBER_OF_VIGNETTES_IN_STORE / 3;

		for (int i = 0; i < numberOfVignettesOfEachType; i++) {
			if (i < numberOfVignettesOfEachType / Period.values().length) {
				data.get("Car").add(new CarVignette(Period.WEEK));
			} else if (i < (numberOfVignettesOfEachType / Period.values().length) * 2) {
				data.get("Car").add(new CarVignette(Period.MONTH));
			} else {
				data.get("Car").add(new CarVignette(Period.YEAR));
			}
		}

		for (int i = 0; i < numberOfVignettesOfEachType; i++) {
			if (i < numberOfVignettesOfEachType / Period.values().length) {
				data.get("Truck").add(new TruckVignette(Period.WEEK));
			} else if (i < (numberOfVignettesOfEachType / Period.values().length) * 2) {
				data.get("Truck").add(new TruckVignette(Period.MONTH));
			} else {
				data.get("Truck").add(new TruckVignette(Period.YEAR));
			}
		}

		for (int i = 0; i < numberOfVignettesOfEachType; i++) {
			if (i < numberOfVignettesOfEachType / Period.values().length) {
				data.get("Bus").add(new BusVignette(Period.WEEK));
			} else if (i < (numberOfVignettesOfEachType / Period.values().length) * 2) {
				data.get("Bus").add(new BusVignette(Period.MONTH));
			} else {
				data.get("Bus").add(new BusVignette(Period.YEAR));
			}
		}
	}

	public void printData() {
		System.out.println("-------------------List of vignettes in stock---------------------- ");

		for (TreeSet<Vignette> treeSet : data.values()) {
			for (Vignette vignette : treeSet) {
				System.out.println(vignette);
			}
			System.out.println("=======================================================================");
		}
	}

	public void sellVignette(Vehicle vehicle, Period period, Driver driver) {
		
		for (Iterator<Vignette> it = data.get(vehicle.getName()).iterator(); it.hasNext();) {
			Vignette vignette = it.next();
						if (data.get(vehicle.getName()).size() > 0) {
				if (vignette.getPrice() <= driver.getCash()) {
					driver.deductCash(vignette.getPrice());
					cash += vignette.getPrice();
					vehicle.setVignette(data.get(vehicle.getName()).first());
					System.out.println( vignette +" was sold to "+ driver.getName());
					it.remove();
					break;
				} else {
					System.out.println("The driver " + driver.getName()
							+ " doesn't have enough money to buy this vignette: " + vignette + ". He has only " + driver.getCash() + "$");
					break;
				}
			} else {
				System.out.println("No vignettes of this type and period are available.");
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "GasStation name: " + name;
	}
}

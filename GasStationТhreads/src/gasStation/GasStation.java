package gasStation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import gasStation.Car.FuelType;

public class GasStation extends Thread {

	private Cashier penka;
	private Cashier minka;
	private FuelBoy pesho = new FuelBoy();
	private FuelBoy gosho = new FuelBoy();

	private static class Reporter extends Thread {
		@Override
		public void run() {
			while (true) {
				// do some db magic
				System.out.println("Starting reporter...............");
				try {
					Thread.sleep(5000);
					System.out.println("Reporter.");

				} catch (InterruptedException e) {
					System.out.println("ops");
				}
			}
		}
	}

	@Override
	public void run() {

		while (true) {
			boolean emptyKolonka = true;
			for (Queue<Car> queue : kolonki) {
				emptyKolonka &= queue.isEmpty();
			}

			boolean emptyKasi = true;
			for (Queue<Car> queue : kolonki) {
				emptyKasi &= queue.isEmpty();
			}

			if (emptyKasi && emptyKolonka) {
				break;
			}
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("------------------------------------------------");
		System.out.println("The stats are as follows: ");
		System.out.println("------------------------------------------------");
		printStatistics();

		DBManager.getInstance().getAllLoadings();

	}

	private ArrayList<Queue<Car>> kolonki = new ArrayList<>();
	private ArrayList<ArrayBlockingQueue<Car>> kasi = new ArrayList<>();
	// kolonka -> fueltype -> date, amount
	private HashMap<Integer, HashMap<FuelType, ConcurrentHashMap<LocalDateTime, Integer>>> statistics;

	public GasStation() {
		statistics = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			kolonki.add(new LinkedList<>());
			statistics.put(i + 1, new HashMap<>());
			statistics.get(i + 1).put(Car.FuelType.DIESEL, new ConcurrentHashMap<>());
			statistics.get(i + 1).put(Car.FuelType.GAS, new ConcurrentHashMap<>());
			statistics.get(i + 1).put(Car.FuelType.PETROL, new ConcurrentHashMap<>());
		}
		for (int i = 0; i < 2; i++) {
			kasi.add(new ArrayBlockingQueue<>(15));
		}
		penka = new Cashier(kasi.get(0));
		penka.setName("Penka");
		minka = new Cashier(kasi.get(1));
		minka.setName("Minka");
		FuelBoy.station = this;
		Cashier.station = this;
		penka.start();
		minka.start();
		pesho.setName("Pesho");
		pesho.start();
		gosho.start();
		gosho.setName("Gosho");
		Reporter r = new Reporter();
		r.setDaemon(true);
		r.start();
		this.start();
		this.setName("GasStation");
	}

	public void enterGasStation(Car c) {
		kolonki.get(new Random().nextInt(kolonki.size())).offer(c);
	}

	public List<Queue<Car>> getKolonki() {
		return Collections.synchronizedList(kolonki);
	}

	public void alignToPay(Car car) {
		try {
			kasi.get(new Random().nextInt(kasi.size())).put(car);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addData(FuelType fuel, int amount, int kolonka, LocalDateTime date) {
		// System.out.println("Kolonka id: " + kolonka);
		String lock = "lock";
		synchronized (lock) {
			statistics.get(kolonka).get(fuel).put(date, amount);
			DBManager.getInstance().insertIntoDB(fuel, amount, kolonka, date);
		}
	}

	public void printStatistics() {
		for (Integer kolonka : statistics.keySet()) {
			System.out.println("Na kolonka " + kolonka + " sa zaredili:");
			for (FuelType type : statistics.get(kolonka).keySet()) {
				System.out.println("    " + type.toString() + ":");
				for (Entry<LocalDateTime, Integer> e : statistics.get(kolonka).get(type).entrySet()) {
					System.out.println("        " + e.getValue() + " litra na " + e.getKey());
				}
			}
		}
	}

	@Override
	public String toString() {
		return "GasStation [penka=" + penka + ", minka=" + minka + ", pesho=" + pesho + ", gosho=" + gosho
				+ ", kolonki=" + kolonki + ", kasi=" + kasi + ", statistics=" + statistics + "]";
	}
}

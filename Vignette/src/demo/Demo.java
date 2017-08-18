package demo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import driver.Driver;
import gasstation.GasStation;
import vehicle.Vehicle;
import vehicle.Vehicle.VehicleType;

public class Demo {

	public static void main(String[] args) {
		Random rnd = new Random();
		/*
		 * 1. ��������� �� �������������� � ����������� ���������� �������. ��
		 * �� ������� �� ������, ������ � ������� ���� � ����. - 5�.
		 */
		GasStation gs = new GasStation();
		gs.printAllVignettes();

		/*
		 * 2. ��������� �� 20 ������� � ���������� �����. �� �� �� �����
		 * ���������� �������� ����. �� �� �� ������ ��������������, �� ����� ��
		 * ��������� �������. - 5�.
		 */

		ArrayList<Driver> drivers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			drivers.add(new Driver("Driver " + (i + 1), rnd.nextInt(1000), gs));
		}

		/*
		 * 3. ��������� �� 200 �������� �������� �� ���������� ��� (����,
		 * �������, ������) � �� ����� ������ �� �� ����� �� 10 �� ��� ����
		 * ����� �������� �������� �� ��������� �� ���� ������. - 10�.
		 */
		ArrayList<Vehicle> vehicles = new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			vehicles.add(new Vehicle(VehicleType.values()[rnd.nextInt(VehicleType.values().length)],
					rnd.nextInt(21) + 1990, "Volvo Model: RL" + rnd.nextInt(100)));
		}

		while (!vehicles.isEmpty()) {
			for (int i = 0; i < drivers.size(); i++) {
				Vehicle vehicle = vehicles.remove(rnd.nextInt(vehicles.size()));
				drivers.get(i).getVehicles().add(vehicle);
				vehicle.setDriver(drivers.get(i));
			}
		}

		/*
		 * 4. ����� 3-�� ������ �� ���������� ������� �� ����� �������� ��������
		 * �� ���� 5 ������� �� ���������� ��������� ���� (���, �����, ������).
		 * ���������� ������� �� ����� ������� �� �������� �� �������� ��������
		 * �� ���������� ��������� ����. - 10�.
		 */

		for (int i = 0; i < drivers.size(); i++) {
			if ((i + 1) % 3 == 0) {
				for (int j = 0; j < 5; j++) {
					drivers.get(i).buyVignette(drivers.get(i).getVehicles().get(j));
				}
			} else {
				drivers.get(i).buyVignette();
			}
		}

		/*
		 * 5. �� �� ������ ���������� �� ������ ������� � ����� ���� �����,
		 * ����� �� ������� �������� �������� ���� ������� � ������� ���� ��
		 * ������ ���� � ����� ���� �� �� ��������. - 15�.
		 */

		for (int i = 0; i < drivers.size(); i++) {

			drivers.get(i).printInfoAboutDriversVehiclesCashVignettes(
					LocalDate.of(2017, rnd.nextInt(12) + 1, rnd.nextInt(28) + 1));
		}

		/*
		 * 6. �� �� ������� ������ �������� ������� � ���������������� �
		 * �������� �� ���� ���. -5�.
		 */
		gs.printAllVignettes();

		/*
		 * 7. �� �� ������� ������ �������, ����� ���� ������� ������� �� ������
		 * ����.
		 */

		System.out.println("=======================================================");
		System.out.println("        Below trucks are with expired vignette: ");
		System.out.println("=======================================================");
		LocalDate localDate = LocalDate.of(2017, rnd.nextInt(12) + 1, rnd.nextInt(28) + 1);
		System.out.println("The reference date is: " + localDate);
		for (int i = 0; i < drivers.size(); i++) {
			drivers.get(i).printInfoForTrucksWithExpiredVignette(localDate);
		}

	}
}

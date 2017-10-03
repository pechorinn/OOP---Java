package gasStation;

public class Demo {

	public static void main(String[] args) {

		GasStation station = new GasStation();
		for (int i = 0; i < 100; i++) {
			station.enterGasStation(new Car());
		}
	}
}

package gasStation;

import java.time.LocalDateTime;

public class Loading implements Comparable<Loading> {

	private String kolonkaId;
	private String fuelType;
	private int fuelQuantiy;
	private LocalDateTime loadingTime;
	private static int id = 0;
	private int uniqueId;

	public Loading(String kolonkaId, String fuelType, int fuelQuantiy, LocalDateTime loadingTime) {
		this.kolonkaId = kolonkaId;
		this.fuelType = fuelType;
		this.fuelQuantiy = fuelQuantiy;
		this.loadingTime = loadingTime;
		this.uniqueId = ++id;
	}

	@Override
	public int compareTo(Loading o) {
		return this.uniqueId - o.uniqueId;
	}

	@Override
	public String toString() {
		return "Loading [fuelType=" + fuelType + ", fuelQuantiy=" + fuelQuantiy + ", loadingTime=" + loadingTime + "]";
	}
	
	public int getFuelQuantity() {
		return fuelQuantiy;
	}

}

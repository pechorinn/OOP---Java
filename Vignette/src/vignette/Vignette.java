package vignette;

import java.time.LocalDate;

import vehicle.Vehicle;
import vehicle.Vehicle.VehicleType;


public class Vignette {

	public enum VignetteType {
		BUS, CAR, TRUCK
	}

	public enum VignetteDuration {
		DAY, MONTH, YEAR
	}

	public enum Color {
		GREEN, BLUE, RED
	}

	private LocalDate issueDate;
	private Vehicle vehicle;
	private boolean placedOnWindowScreen;
	private Color color;
	private VignetteDuration vignetteDuration;
	private VignetteType vignetteType;
	private double price;

	public Vignette(VignetteDuration vignetteDuration, VehicleType vehicleType) {
		super();
		this.vignetteDuration = vignetteDuration;
		if (VehicleType.BUS == vehicleType) {
			color = Color.BLUE;
			vignetteType = VignetteType.BUS;
			if (vignetteDuration == VignetteDuration.DAY) {
				price = 9;
			} else if (vignetteDuration == VignetteDuration.MONTH) {
				price = 9 * 10;
			} else if (vignetteDuration == VignetteDuration.YEAR) {
				price = 9 * 10 * 6;
			}
		} else if (VehicleType.CAR == vehicleType) {
			color = Color.GREEN;
			vignetteType = VignetteType.CAR;
			if (vignetteDuration == VignetteDuration.DAY) {
				price = 5;
			} else if (vignetteDuration == VignetteDuration.MONTH) {
				price = 5 * 10;
			} else if (vignetteDuration == VignetteDuration.YEAR) {
				price = 5 * 10 * 6;
			}
		} else if (VehicleType.TRUCK == vehicleType) {
			color = Color.RED;
			vignetteType = VignetteType.TRUCK;
			if (vignetteDuration == VignetteDuration.DAY) {
				price = 7;
			} else if (vignetteDuration == VignetteDuration.MONTH) {
				price = 7 * 10;
			} else if (vignetteDuration == VignetteDuration.YEAR) {
				price = 7 * 10 * 6;
			}
		}
	}

	public double getPrice() {
		return price;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setPlacedOnWindowScreen(boolean setTrue) {
		placedOnWindowScreen = setTrue;
	}

	@Override
	public String toString() {
		return "Vignette [issueDate=" + issueDate + ", vehicle=" + vehicle + ", placedOnWindowScreen="
				+ placedOnWindowScreen + ", color=" + color + ", vignetteDuration=" + vignetteDuration
				+ ", vignetteType=" + vignetteType + ", price=" + price + "]\n";
	}

	public LocalDate getIssueDate() {

		return issueDate;
	}

	
	public VignetteDuration getVignetteDuration() {
		return vignetteDuration;
	}

}

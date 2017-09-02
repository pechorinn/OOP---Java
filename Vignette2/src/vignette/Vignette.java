package vignette;

import java.time.LocalDate;

public abstract class Vignette implements Comparable<Vignette> {

	public enum Color {
		RED, BLUE, YELLOW
	}

	public enum Period {
		WEEK, MONTH, YEAR
	}

	public static final double WEEK_CAR = 5;
	public static final double WEEK_TRUCK = 7;
	public static final double WEEK_BUS = 9;
	public static final double MONTH_CAR = WEEK_CAR * 10;
	public static final double MONTH_TRUCK = WEEK_TRUCK * 10;
	public static final double MONTH_BUS = WEEK_BUS * 10;
	public static final double YEAR_CAR = MONTH_CAR * 6;
	public static final double YEAR_TRUCK = MONTH_TRUCK * 6;
	public static final double YEAR_BUS = MONTH_BUS * 6;

	protected LocalDate expDate;
	protected Color color;
	protected double price;
	protected Period period;
	private static int uniqueId = 0;
	protected int id;
	boolean placedOnWindowScreen;

	public Vignette(Color color, Period period) {
		super();
		this.color = color;
		this.period = period;
		this.id = ++uniqueId;
		if (period == Period.WEEK && color == Color.RED) {
			this.price = WEEK_CAR;
		} else if (period == Period.MONTH && color == Color.RED) {
			this.price = MONTH_CAR;
		} else if (period == Period.YEAR && color == Color.RED) {
			this.price = YEAR_CAR;
		} else if (period == Period.WEEK && color == Color.BLUE) {
			this.price = WEEK_TRUCK;
		} else if (period == Period.MONTH && color == Color.BLUE) {
			this.price = MONTH_TRUCK;
		} else if (period == Period.YEAR && color == Color.BLUE) {
			this.price = YEAR_TRUCK;
		} else if (period == Period.WEEK && color == Color.YELLOW) {
			this.price = WEEK_BUS;
		} else if (period == Period.MONTH && color == Color.YELLOW) {
			this.price = MONTH_BUS;
		} else if (period == Period.YEAR && color == Color.YELLOW) {
			this.price = YEAR_BUS;
		}

		if (period == Period.WEEK) {
			this.expDate = LocalDate.now().plusWeeks(1);
		} else if (period == Period.MONTH) {
			this.expDate = LocalDate.now().plusMonths(1);
		} else if (period == Period.YEAR) {
			this.expDate = LocalDate.now().plusYears(1);
		}
	}

	@Override
	public int compareTo(Vignette vig) {
		if (this.price == vig.price) {
			return this.id - vig.id;
		}
		return Double.compare(this.price, vig.price);
	}

	
	public Color getColor() {
		return color;
	}

	public double getPrice() {

		return price;
	}

	public void setAsSticked() {
		placedOnWindowScreen = true;
	}

	@Override
	public String toString() {
		return "Vignette [expDate=" + expDate + ", color=" + color + ", price=" + price + ", period=" + period + ", id="
				+ id + ", placedOnWindowScreen=" + placedOnWindowScreen + "]";
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	
}

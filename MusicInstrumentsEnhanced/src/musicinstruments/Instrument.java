package musicinstruments;

import java.util.Random;

public class Instrument {

	public enum Duhovi implements InstrumentName {
		FLEITA, KLARINET, TROMBON, TROMPET, TUBA
	}

	public enum Electronni implements InstrumentName {
		BAS_KITARA, ELEKTRICHESKA_TSIGULKA, SINTEZATOR
	}

	public enum Klavishni implements InstrumentName {
		AKORDEON, ORGAN, PIANO
	}

	public enum Strunni implements InstrumentName {
		ARFA, GYDULKA, KITARA, KONTRABAS, TSIGULKA, VIOLA
	}

	public enum Udarni implements InstrumentName {
		BARABAN, DAIRE, TARAMBUKA, TYPAN
	}

	protected InstrumentName name;
	protected double price;
	protected int availableCount;
	protected int idNumber;
	private static int uniqueId = 0;
	protected int numberOfSales = 0;
	protected static Random rnd = new Random();

	public Instrument(InstrumentName name, double price, int availbaleCount) {
		super();
		if (!(name instanceof InstrumentName)) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		if (price <= 0) {
			throw new IllegalArgumentException("Price must be above zero.");
		}
		this.price = price;
		if (availbaleCount < 0) {
			throw new IllegalArgumentException();
		}
		this.availableCount = availbaleCount;
		this.idNumber = ++uniqueId;

		System.out.println(name + " created. Available count: " + availbaleCount);
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public InstrumentName getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void deductSoldItems(int count) {

		this.availableCount -= count;
	}

	public void addInstruments(int count) {
		availableCount += count;
	}
	
	
	public void addToNumberOfSales(int count) {
		
		numberOfSales += count;
	}
	
	public int getNumberOfSales() {
		return numberOfSales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availableCount;
		result = prime * result + idNumber;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrument other = (Instrument) obj;
		if (availableCount != other.availableCount)
			return false;
		if (idNumber != other.idNumber)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	

	@Override
	public String toString() {
		return "Instrument [name=" + name + ", price=" + price + ", availableCount=" + availableCount + ", idNumber="
				+ idNumber + ", numberOfSales=" + numberOfSales + "]";
	}

	public int getId() {
		return idNumber;
	}

}

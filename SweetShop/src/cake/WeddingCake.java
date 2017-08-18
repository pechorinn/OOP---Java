package cake;

public class WeddingCake extends Cake {

	public enum CakeType {
		BIG, SMALL, MEDIUM
	}
	
	private int floors;
	private CakeType cakeType;

	public WeddingCake(String name, String description, double price, int numberOfPieces, CakeType cakeType,
			int floors) {
		super(name, description, price, numberOfPieces);
		if (floors <= 0) {
			throw new IllegalArgumentException();
		}
		this.floors = floors;
		if (cakeType == null) {
			throw new IllegalArgumentException();
		}
		this.cakeType = cakeType;
	}

	public WeddingCake(WeddingCake weddingCake) {
		this(weddingCake.name, weddingCake.description, weddingCake.price, weddingCake.numberOfPieces,
				weddingCake.cakeType, weddingCake.floors);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cakeType == null) ? 0 : cakeType.hashCode());
		result = prime * result + floors;
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
		WeddingCake other = (WeddingCake) obj;
		if (cakeType != other.cakeType)
			return false;
		if (floors != other.floors)
			return false;
		return true;
	}
	
	

}

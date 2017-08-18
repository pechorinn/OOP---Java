package cake;

public class KidsDelight extends Cake {

	public enum CakeType {
		BIRTHDAY, BAPTISM, PROSHAPULNIK
	}

	private String childName;
	private CakeType cakeType;

	public KidsDelight(String name, String description, double price, int numberOfPieces, CakeType cakeType,
			String childName) {
		super(name, description, price, numberOfPieces);
		if (cakeType == null) {
			throw new IllegalArgumentException();
		}
		this.cakeType = cakeType;
		if (childName == null || childName.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.childName = childName;
	}

	public KidsDelight(KidsDelight kidsDelight) {
		this(kidsDelight.name, kidsDelight.description, kidsDelight.price, kidsDelight.numberOfPieces,
				kidsDelight.cakeType, kidsDelight.childName);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cakeType == null) ? 0 : cakeType.hashCode());
		result = prime * result + ((childName == null) ? 0 : childName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		KidsDelight other = (KidsDelight) obj;
		if (cakeType != other.cakeType)
			return false;
		if (childName == null) {
			if (other.childName != null)
				return false;
		} else if (!childName.equals(other.childName))
			return false;
		return true;
	}

}

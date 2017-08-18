package cake;

public class SpecialCake extends Cake {

	public enum CakeType {
		JUBILEE, CORPORATE_EVENTS, PROMO_CAKE, BIRTHDAY
	}

	private String descriptionOfTheEvent;
	private CakeType cakeType;

	public SpecialCake(String name, String description, double price, int numberOfPieces, CakeType cakeType,
			String descriptionOfTheEvent) {
		super(name, description, price, numberOfPieces);
		if (cakeType == null) {
			throw new IllegalArgumentException();
		}
		this.cakeType = cakeType;
		if (description == null || description.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.descriptionOfTheEvent = descriptionOfTheEvent;
	}
	
	public SpecialCake(SpecialCake specialCake) {
		this(specialCake.name, specialCake.description, specialCake.price, specialCake.numberOfPieces, specialCake.cakeType, specialCake.descriptionOfTheEvent);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cakeType == null) ? 0 : cakeType.hashCode());
		result = prime * result + ((descriptionOfTheEvent == null) ? 0 : descriptionOfTheEvent.hashCode());
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
		SpecialCake other = (SpecialCake) obj;
		if (cakeType != other.cakeType)
			return false;
		if (descriptionOfTheEvent == null) {
			if (other.descriptionOfTheEvent != null)
				return false;
		} else if (!descriptionOfTheEvent.equals(other.descriptionOfTheEvent))
			return false;
		return true;
	}

	
}

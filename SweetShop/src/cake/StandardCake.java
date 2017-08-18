package cake;

public class StandardCake extends Cake{

	public enum CakeType {
		BISKVITENA, EKLEROVA, PLODOVA, SHOKOLADOVA
	}

	private boolean withSyrop;
	private CakeType cakeType;

	public StandardCake(String name, String description, double price, int numberOfPieces, boolean withSyrop, CakeType cakeType) {
		super(name, description, price, numberOfPieces);
		this.withSyrop = withSyrop;
		if (cakeType == null) {
			throw new IllegalArgumentException();
		}
		this.cakeType = cakeType;
	}

	public StandardCake(StandardCake standardCake) {
		this(standardCake.name, standardCake.description, standardCake.price, standardCake.numberOfPieces, standardCake.withSyrop, standardCake.cakeType);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cakeType == null) ? 0 : cakeType.hashCode());
		result = prime * result + (withSyrop ? 1231 : 1237);
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
		StandardCake other = (StandardCake) obj;
		if (cakeType != other.cakeType)
			return false;
		if (withSyrop != other.withSyrop)
			return false;
		return true;
	}
}

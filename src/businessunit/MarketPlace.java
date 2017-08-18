package businessunit;

public class MarketPlace extends BusinessUnit implements IKioskOrMarketPlace {

	public MarketPlace(String address, String workingHours) {
		super(address, workingHours, rnd.nextInt(9) + 2, 50);
		System.out.println("New market place is created.");
	}

	@Override
	public String toString() {
		return "Market Place";
	}
}

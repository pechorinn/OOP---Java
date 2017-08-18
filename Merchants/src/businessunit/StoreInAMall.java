package businessunit;

public class StoreInAMall extends BusinessUnit implements IKioskOrStoreInAMall {

	public StoreInAMall(String address, String workingHours) {
		super(address, workingHours, rnd.nextInt(91) + 10, 150);
		System.out.println("New store in a Mall is created.");
	}

	@Override
	public String toString() {
		return "Store in a Mall";
	}
}

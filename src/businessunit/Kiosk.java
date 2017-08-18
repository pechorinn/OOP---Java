package businessunit;

public class Kiosk extends BusinessUnit implements IKioskOrStoreInAMall, IKioskOrMarketPlace {
	
	public Kiosk(String address, String workingHours) {
		super(address, workingHours, rnd.nextInt(3) + 4, 50);
		System.out.println("New kiosk is created.");
	}

	@Override
	public String toString() {
		return "Kiosk";
	}
	
	

}

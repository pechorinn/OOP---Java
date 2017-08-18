package realestateagency;

public abstract class Verification {

	public static void checkStringInput(String string) {
		if (string == null || string.isEmpty()) {
			throw new IllegalArgumentException();
		}
	}

	public static void checkForNonNegative(double number) {
		if (number < 0) {
			throw new IllegalArgumentException();
		}
	}

}

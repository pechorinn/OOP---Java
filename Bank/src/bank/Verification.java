package bank;

public class Verification {

	public static void checkStringInput(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Please provide valid String.");
		}
	}

	public static void checkIfInputPositive(double number) {
		if (number < 0) {
			throw new IllegalArgumentException("The value provided must be positive.");
		}
	}
	
	public static void checkIfInputPositiveAndNotEqualToZero(double number) {
		if (number <= 0) {
			throw new IllegalArgumentException("The value provided must be positive/not equal to zero.");
		}
	}
}

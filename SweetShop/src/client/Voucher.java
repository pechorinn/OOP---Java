package client;

import java.util.Random;

public class Voucher {
	
	private double value;
	
	Voucher() {
		Random rnd = new Random();
		value = rnd.nextInt(21)+10;
	}

	public double getValue() {
		return value;
	}

}

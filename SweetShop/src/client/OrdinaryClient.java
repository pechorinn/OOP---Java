package client;

import java.util.ArrayList;
import java.util.Random;

import sweetshop.SweetShop;


public class OrdinaryClient extends Client {

	private ArrayList<Voucher> vouchers;

	public OrdinaryClient(String name, String phone, SweetShop sweetShop, String address, double cash) {
		super(name, phone, sweetShop, address, cash);
		this.vouchers = new ArrayList<>();
		Random rnd = new Random();
		int numberOfVouchers = rnd.nextInt(4)+1;
		for (int i = 0; i < numberOfVouchers; i++) {
			vouchers.add(new Voucher());
		}
	}

	public ArrayList<Voucher> getVouchers() {
		return vouchers;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((vouchers == null) ? 0 : vouchers.hashCode());
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
		OrdinaryClient other = (OrdinaryClient) obj;
		if (vouchers == null) {
			if (other.vouchers != null)
				return false;
		} else if (!vouchers.equals(other.vouchers))
			return false;
		return true;
	}

	
}

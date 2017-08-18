package client;


import sweetshop.SweetShop;

public class CorporateClient extends Client {

	private double discount;
	

	public CorporateClient(String name, String phone, SweetShop sweetShop, String address, double cash) {
		super(name, phone, sweetShop, address, cash);
		this.discount = rnd.nextInt(11) + 5;
	}
	
	public double getDiscount() {
		return discount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		CorporateClient other = (CorporateClient) obj;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		return true;
	}
	
	

}

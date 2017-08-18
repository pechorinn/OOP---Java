package client;

import java.util.ArrayList;
import java.util.Random;

import cake.Cake;
import sweetshop.SweetShop;

public abstract class Client {

	protected String name;
	protected String phone;
	protected SweetShop mySweetShop;
	protected double cash;
	protected String address;
	protected double tip;
	protected Random rnd = new Random();
	protected double initialAmount;

	public Client(String name, String phone, SweetShop sweetShop, String address, double cash) {
		super();
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		if(phone == null || phone.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.phone = phone;
		if(sweetShop == null) {
			throw new IllegalArgumentException();
		}
		this.mySweetShop = sweetShop;
		if(address == null || address.isEmpty()) {
			throw new IllegalArgumentException();
		}

		this.address = address;
		this.tip = this instanceof CorporateClient ? 5 : 2;
		if(cash < 0) {
			throw new IllegalArgumentException();
		}
		this.cash = cash;
		this.initialAmount = cash;
		mySweetShop.getClients().add(this);
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public void setCash(double payments) {

		cash += payments;
	}

	public double getTip() {
		return tip;
	}
	
	public double getInitialAmount() {
		return initialAmount;
	}

	protected Cake chooseCake() {
		Cake cake = mySweetShop.getCatalog().get(rnd.nextInt(mySweetShop.getCatalog().size()));
		return cake;
	}

	protected void sendOrder(ArrayList<Cake> cakes, double orderValue) {
		mySweetShop.handleOrder(this, cakes, orderValue);
	}

	public void createOrder() {
		double orderValue = 0;
		ArrayList<Cake> cakes = new ArrayList<>();
		int numberOfCakes = 0;
		if (this instanceof CorporateClient) {
			numberOfCakes = rnd.nextInt(3) + 3;
		} else if (this instanceof OrdinaryClient) {
			numberOfCakes = rnd.nextInt(3) + 1;
		}

		for (int i = 0; i < numberOfCakes; i++) {
			cakes.add(chooseCake());
			orderValue += cakes.get(i).getPrice();
		}
		if (orderValue > cash) {
			System.out.println("The order price is higher of the available balance. The order cannot be submitted.");
		} else {
			sendOrder(cakes, orderValue);
		}
	}

	public double getCash() {
		return cash;
	}

	@Override
	public String toString() {
		String cashString = String.format("%.2f$", cash);
		String tipString = String.format("%.2f percents", tip);

		return "\nClient name: " + name + ",\n phone: " + phone + ",\n mySweetShop: " + mySweetShop + ",\n cash: " + cashString
				+ ", address: " + address + ",\n tip: " + tipString + ",\n initialAmount: " + initialAmount + "$]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(cash);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(initialAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		temp = Double.doubleToLongBits(tip);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(cash) != Double.doubleToLongBits(other.cash))
			return false;
		if (Double.doubleToLongBits(initialAmount) != Double.doubleToLongBits(other.initialAmount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (Double.doubleToLongBits(tip) != Double.doubleToLongBits(other.tip))
			return false;
		return true;
	}
	
	
	
}

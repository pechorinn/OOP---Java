package shop;

class ProductSoldInKg extends Product {

	private double kg;

	ProductSoldInKg(String name, double price, double kg) {
		super(name, price);
		this.kg = kg;
	}

	double getKg() {
		return kg;
	}

	void setKg(double kg) {
		this.kg = kg;
	}

	
}

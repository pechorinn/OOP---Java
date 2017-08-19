package shop;

class ProductSoldByCount extends Product {

	private int itemCount;

	ProductSoldByCount(String name, double price, int itemCount) {
		super(name, price);
		this.itemCount = itemCount;
	}

	int getItemCount() {
		return itemCount;
	}

	void setItemCount(int items) {
		itemCount = items;
	}
	
}

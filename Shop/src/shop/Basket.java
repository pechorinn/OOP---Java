package shop;


class Basket {

	private Customer customer;
	private Product[] productList;
    
	Basket(Customer customer) {
		super();
		this.customer = customer;
		this.productList = new Product[customer.getMaxArticuls()];
		this.customer.setBasket(this);
		System.out.println("    New basket created for customer " + customer.getName());
	}

	Product[] getProductList() {
		return productList;
	}

	
}

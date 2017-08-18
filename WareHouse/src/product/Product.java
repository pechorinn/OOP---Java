package product;


public abstract class Product {
	public enum ProductName {BANANA, ORANGE, APPLE, POTATO, EGGPLANT, CUCUMBER, PORK, BEEF, CHICKEN}
	protected  ProductName productName;

	
	public Product(ProductName productName) {
		super();
		this.productName = productName;
		
	}
	
	public ProductName getProductName() {
		return productName;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName +"]";
	}

}

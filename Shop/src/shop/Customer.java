package shop;

class Customer {

	private Shop shop;
	private double cash;
	private int maxArticuls;
	private Basket basket;
	private String name;

	public Customer(Shop shop, double cash, int maxArticuls, String name) {
		super();
		this.shop = shop;
		this.cash = cash;
		this.maxArticuls = maxArticuls;
		this.name = name;
		System.out.println("    ===============================================");
		System.out.println("    New customer created. Customer name: " + name);
		this.basket = new Basket(this);
		System.out.println("    ===============================================");
	}

	private boolean addProductToTheBasketInKg(Product product) {

		if (product == null) {
			System.out.println("Please specify product you want to add to the busket.");
			System.out.println("---------------------------------------- ");
			return false;
		} else if (((ProductSoldInKg) product).getKg() <= 0) {
			System.out.println("Please provide adequate value for kgs.");
			System.out.println("---------------------------------------- ");
			return false;

		} else {

			for (int i = 0; i < shop.getProducts().length; i++) {

				if (shop.getProducts()[i].getName().equals(product.getName())) {
					if (((ProductSoldInKg) (shop.getProducts()[i])).getKg() < ((ProductSoldInKg) product).getKg()) {
						System.out.println("Not enough kgs of the product is available. Item " + product.getName()
								+ ".  Left in stock: " + ((ProductSoldInKg) (shop.getProducts()[i])).getKg() + "kg");
						System.out.println("---------------------------------------- ");
						return false;
					}

					for (int j = 0; j < basket.getProductList().length; j++) {
						if (j == maxArticuls - 1 && basket.getProductList()[j] != null) {
							System.out.println(
									"No more items can be added to the basket. The muximum number of articuls was reached.");
							System.out.println("---------------------------------------- ");
							return false;
						}
						if (basket.getProductList()[j] == null) {
							basket.getProductList()[j] = product;
							System.out.println("The product is in stock and added to the basket. Product "
									+ product.getName() + ". Kg = " + ((ProductSoldInKg) product).getKg());
							((ProductSoldInKg) (shop.getProducts()[i]))
									.setKg(((ProductSoldInKg) (shop.getProducts()[i])).getKg()
											- ((ProductSoldInKg) product).getKg());
							System.out.println("Kg left in the shop "
									+ ((ProductSoldInKg) (shop.getProducts()[i])).getKg() + " kg");
							System.out.println("---------------------------------------- ");
							return true;
						}
					}
				}
			}
		}
		System.out.println("No product with that name in the store. Provided name: " + product.getName());
		return false;
	}

	private boolean addProductToTheBasketSoldByCount(Product product) {
		if (product == null) {
			System.out.println("Please specify product you want to add to the busket.");
			System.out.println("---------------------------------------- ");
			return false;
		}

		else if (((ProductSoldByCount) product).getItemCount() <= 0) {
			System.out.println("Please provide adequate value for number of items.");
			System.out.println("---------------------------------------- ");
			return false;
		} else {

			for (int i = 0; i < shop.getProducts().length; i++) {

				if (shop.getProducts()[i].getName().equals(product.getName())) {
					if (((ProductSoldByCount) (shop.getProducts()[i])).getItemCount() < ((ProductSoldByCount) product)
							.getItemCount()) {
						System.out.println("Not enough items of the product is available. Item " + product.getName()
								+ ". Left in stock: " + ((ProductSoldByCount) (shop.getProducts()[i])).getItemCount()
								+ "item/s.");
						System.out.println("---------------------------------------- ");
						return false;
					}

					for (int j = 0; j < basket.getProductList().length; j++) {
						if (j == maxArticuls - 1 && basket.getProductList()[j] != null) {
							System.out.println("No more articules can be added to the basket ");
							System.out.println("---------------------------------------- ");
							return false;
						}
						if (basket.getProductList()[j] == null) {
							basket.getProductList()[j] = product;
							System.out.println(
									"The product is in stock and added to the basket. Product: " + product.getName()
											+ ". Number of items: " + ((ProductSoldByCount) product).getItemCount());
							((ProductSoldByCount) (shop.getProducts()[i]))
									.setItemCount(((ProductSoldByCount) (shop.getProducts()[i])).getItemCount()
											- ((ProductSoldByCount) product).getItemCount());
							System.out.println("Items left in the shop: "
									+ ((ProductSoldByCount) (shop.getProducts()[i])).getItemCount() + " items.");

							System.out.println("---------------------------------------- ");
							return true;
						}
					}
				}
			}
		}

		System.out.println("Add by count. No product with that name in the store. Provided name: " + product.getName());
		return false;
	}

	void printBasket(Product[] productList) {

		for (int i = 0; i < productList.length; i++) {
			if (productList[i] != null) {
				System.out.println(productList[i]);
			}
		}
	}

	boolean removeItemSoldByCount(Product product, int items) {
		System.out.println("New request to remove product is made.");
		if (product == null) {
			System.out.println("Please specify the product you want to remove.");
			System.out.println("---------------------------------------- ");
			return false;
		} else if (items <= 0) {
			System.out.println("Items cannot be a negative number.");
			System.out.println("---------------------------------------- ");
			return false;
		} else if (!(product instanceof ProductSoldByCount)) {
			System.out.println("========================================");
			System.out.println("The product cannot be removed. It is not a product sold in items. " + product);
			System.out.println("========================================");
			return false;
		
		} else {
			System.out.println("Product " + product.getName()
					+ ", items to be removed: " + items + " items. Customer name: " + this.getName());

			for (int i = 0; i < basket.getProductList().length; i++) {

				if (basket.getProductList()[i] != null)

					if (basket.getProductList()[i] != null
							&& basket.getProductList()[i].getName().equals(product.getName())) {
						if (((ProductSoldByCount) basket.getProductList()[i]).getItemCount() > items) {
							((ProductSoldByCount) basket.getProductList()[i]).setItemCount(
									((ProductSoldByCount) basket.getProductList()[i]).getItemCount() - items);
							System.out.println("The items were removed from the basket. Product " + product.getName()
									+ ", items removed: " + items + ". Customer name: " + this.getName());
							returnProductsToStoreItem(product, items);
							return true;
						} else if (((ProductSoldByCount) basket.getProductList()[i]).getItemCount() > items) {
							System.out.println("The items were removed from the basket. Product " + product.getName()
									+ ", items removed: " + items + "Customer name: " + this.getName());
							System.out.println("---------------------------------------- ");
							returnProductsToStoreItem(product, items);
							basket.getProductList()[i] = null;
							return true;

						} else {
							System.out.println("You cannot remove more items than you have in the basket.");
							System.out.println("---------------------------------------- ");
							return false;
						}
					}
			}
		}
		System.out.println("No product with that name in the store. Provided name: " + product.getName());
		return false;
	}

	private void returnProductsToStoreItem(Product product, int items) {
		for (int j = 0; j < shop.getProducts().length; j++) {
			if (shop.getProducts()[j].getName().equals(product.getName())) {
				((ProductSoldByCount) shop.getProducts()[j])
						.setItemCount(((ProductSoldByCount) shop.getProducts()[j]).getItemCount() + items);
				System.out.println("The items were returned to the store. Product " + product.getName()
						+ ", items left in store " + ((ProductSoldByCount) shop.getProducts()[j]).getItemCount());
			}
		}

	}

	boolean removeItemSoldInKg(Product product, double kg) {
		
		System.out.println("New request to remove product is made.");
		if (product == null) {
			System.out.println("Please specify the product you want to remove.");
			System.out.println("---------------------------------------- ");
			return false;
		} else if (kg <= 0) {
			System.out.println("Items cannot be a negative number.");
			System.out.println("---------------------------------------- ");
			return false;
		} else if (!(product instanceof ProductSoldInKg)) {
			System.out.println("========================================");
			System.out.println("The product cannot be removed. It is not a product sold by kgs. " + product);
			System.out.println("========================================");
			return false;
		} else {
			System.out.println("Product " + product.getName()
					+ ", kgs to be removed: " + kg + "kg. Customer name: " + this.getName());
			for (int i = 0; i < basket.getProductList().length; i++) {
				if (basket.getProductList()[i] != null
						&& basket.getProductList()[i].getName().equals(product.getName())) {
					if (((ProductSoldInKg) basket.getProductList()[i]).getKg() > kg) {
						((ProductSoldInKg) basket.getProductList()[i])
								.setKg(((ProductSoldInKg) basket.getProductList()[i]).getKg() - kg);
						System.out.println("The product was removed from the basket. Product " + product.getName()
								+ ", kgs removed: " + kg + "kg. Customer name: " + this.getName());
						returnProductsToStoreKg(product, kg);
						return true;

					} else if (((ProductSoldInKg) basket.getProductList()[i]).getKg() == kg) {
						System.out.println("The product was removed from the basket. Product " + product.getName()
								+ ", kgs removed: " + kg + "kg" + ", Customer name: " + this.getName());
						returnProductsToStoreKg(product, kg);

						basket.getProductList()[i] = null;
						return true;

					} else {
						System.out.println("You cannot remove more kgs than you have in the basket.");
						System.out.println("---------------------------------------- ");
						return false;
					}
				}
			}
		}
		System.out.println("Shouldn't print that.(remove kgs)");
		return false;
	}

	private void returnProductsToStoreKg(Product product, double kg) {
		for (int j = 0; j < shop.getProducts().length; j++) {
			if (shop.getProducts()[j].getName().equals(product.getName())) {
				((ProductSoldInKg) shop.getProducts()[j]).setKg(((ProductSoldInKg) shop.getProducts()[j]).getKg() + kg);
				System.out.println("The products were returned to the store. Product " + product.getName()
						+ ", kgs in store " + ((ProductSoldInKg) shop.getProducts()[j]).getKg());

			}
		}
		System.out.println("---------------------------------------- ");
	}

	Product createShoppingRequestForCustomerItems(String name, int countItems) {

		Product result = null;
		for (int i = 0; i < shop.getProducts().length; i++) {
			if (shop.getProducts()[i].getName().equals(name) && shop.getProducts()[i] instanceof ProductSoldByCount) {
				System.out.println("New request created for the customer " + this.name + ". Name of the product: "
						+ shop.getProducts()[i].getName() + ". Number of items: " + countItems);
				result = new ProductSoldByCount(name, shop.getProducts()[i].getPrice(), countItems);
				addProductToTheBasketSoldByCount(result);
				return result;
			}
		}
		System.out.println("No product of this name \"" + name
				+ "\" could be located. Sorry. Please check it might be sold in kgs.");
		System.out.println("---------------------------------------- ");
		return result;

	}

	Product createShoppingReguestForCustomerKg(String name, double kg) {
		Product result = null;
		for (int i = 0; i < shop.getProducts().length; i++) {
			if (shop.getProducts()[i].getName().equals(name) && shop.getProducts()[i] instanceof ProductSoldInKg) {
				result = new ProductSoldInKg(name, shop.getProducts()[i].getPrice(), kg);
				System.out.println("New request is put forward by the customer " + this.name + ". Name of the product: "
						+ name + ", Weight: " + kg + "kg");
				addProductToTheBasketInKg(result);
				return result;
			}

		}
		System.out.println("No product of this name \"" + name
				+ "\" could be located. Sorry. Please check it might be sold by item.");
		System.out.println("---------------------------------------- ");
		return result;
	}

	void makeTransaction() {
		System.out.println("==================================================");
		System.out.println("New transaction request is made by customer " + name);
		System.out.println("==================================================");
		double sum = calculateCostOfTheBasket();
		System.out.println("The cost of the basket is: " + sum + ". Customer name: " + name);
		if (sum <= cash) {
			System.out.println("Cash deducted from customer's account. Amount: " + sum + "$");
			cash -= sum;
			shop.addToCashier(sum);
			System.out.println("Cash added to shop's cashier. Amount after addition: " + shop.getCashier() + "$");
			System.out.println("---------------------------------------- ");
		} else {
			System.out.println(
					"You have no enough cash to pay for goods. Please unload some items and try again. Your budget is: "
							+ cash + "$");
			System.out.println("---------------------------------------- ");
		}

	}

	private double calculateCostOfTheBasket() {
		double result = 0;
		for (int i = 0; i < basket.getProductList().length; i++) {

			if (basket.getProductList()[i] != null) {
				if (basket.getProductList()[i] instanceof ProductSoldInKg) {
					result += ((ProductSoldInKg) basket.getProductList()[i]).getKg()
							* basket.getProductList()[i].getPrice();
				} else {
					result += ((ProductSoldByCount) basket.getProductList()[i]).getItemCount()
							* basket.getProductList()[i].getPrice();
				}
			}
		}

		return result;
	}

	int getMaxArticuls() {
		return maxArticuls;
	}

	void setBasket(Basket basket) {
		this.basket = basket;
	}

	public String getName() {
		return name;
	}

	public Product[] getBasket() {
		return basket.getProductList();
	}

}

package merchant;

import java.util.ArrayList;
import java.util.Iterator;

import government.Government;
import supplier.Product;
import supplier.Supplier;

public class Ambulanten extends Merchant {

	ArrayList<Product> products;

	public Ambulanten(String name, String address, double initialCapital, Government government) {
		super(name, address, initialCapital, government);
		System.out.println("New ambulant merchant created: " + name);
		products = new ArrayList<>();
	}

	public boolean addSupplier(ArrayList<Supplier> supplier) {

		for (int i = 0; i < supplier.size(); i++) {
			Supplier sup = supplier.get(rnd.nextInt(supplier.size()));
			if (!suppliers.contains(sup) && !sup.getWholesale()) {
				suppliers.add(sup);
				System.out.println("Supplier assigned to " + name);
				return true;
			}
		}
		return false;
	}

	public void orderProductsFromSupplier() {

		System.out.println("Self employed " + name + " started ordering....");
		Iterator<Supplier> iter = suppliers.iterator();
		Supplier supplier = null;
		while (iter.hasNext()) {
			supplier = iter.next();
		}
		products.addAll(supplier.deliverProducts(initialCapital / 2));
	}

	public void sellGoods() {
		ArrayList<Product> soldGoods = new ArrayList<>();

		int numberOfSoldGoods = rnd.nextInt(products.size());
		setSoldGoodsCount(numberOfSoldGoods);
		System.out.println("The merchant " + name + " sold goods. Number of sold goods: " + numberOfSoldGoods);
		for (int j = 0; j < numberOfSoldGoods; j++) {
			soldGoods.add(products.remove(0));
		}
		collectTurnover(soldGoods);
		System.out.printf("The total amount of turnover from sold goods: %.2f$\n", collectTurnover(soldGoods));
	}

	@Override
	public String toString() {
		return "Ambulanten [name: " + name + "], Number of products sold: " + soldGoodsCount + ", Total tax paid: " + totalTaxPaid;
	}
	
	

}

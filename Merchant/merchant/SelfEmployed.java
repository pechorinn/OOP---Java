package merchant;

import java.util.ArrayList;

import government.Government;
import supplier.Supplier;

public class SelfEmployed extends Merchant implements IBusinessUnits {

	public SelfEmployed(String name, String address, double initialCapital, Government government) {
		super(name, address, initialCapital, government);
		System.out.println("New selfemployed merchant created: " + name);
	}

	public boolean addSupplier(ArrayList<Supplier> supplier) {
		int count = 0;
		for (int i = 0; i < supplier.size(); i++) {
			Supplier sup = supplier.get(rnd.nextInt(supplier.size()));
			if (!suppliers.contains(sup) && !sup.getWholesale()) {
				suppliers.add(sup);
				System.out.println("Supplier assigned to " + name);
				count++;
				if (count == 5) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Selfemployed [name: " + name + "], Number of business units: "+ businessUnits.size() + ", Number of products sold: " + soldGoodsCount + ", Total tax paid: " + totalTaxPaid + "$";
	}
	
}

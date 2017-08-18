package merchant;



import java.util.ArrayList;

import government.Government;
import supplier.Supplier;

public class MarketChain extends Merchant implements IBusinessUnits {


	public MarketChain(String name, String address, double initialCapital, Government government) {
		super(name, address, initialCapital, government);
		System.out.println("New Market chain merchant created: " + name);
	}

	
	public boolean addSupplier(ArrayList<Supplier> supplier) {
		
		for (int i = 0; i < 15; i++) {
			Supplier sup = supplier.get(rnd.nextInt(supplier.size()));
			if (!suppliers.contains(sup)) {
				suppliers.add(sup);
				System.out.println("Supplier assigned to " + name);
			}
		}
		return false;
	}


	@Override
	public String toString() {
		return "MarketChain [name: " + name + "], Number of business units: "+ businessUnits.size() + ", Number of products sold: " + soldGoodsCount + ", Total tax paid: " + totalTaxPaid + "$";
	}


	
}

package merchant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import businessunit.BusinessUnit;
import businessunit.IKioskOrMarketPlace;
import businessunit.IKioskOrStoreInAMall;
import government.Government;
import supplier.Product;
import supplier.Supplier;

public abstract class Merchant {

	protected String name;
	protected String address;
	protected double initialCapital;
	protected Set<Supplier> suppliers;
	protected Random rnd = new Random();
	protected Government myGovernment;
	protected ArrayList<BusinessUnit> businessUnits;
	protected int soldGoodsCount = 0;
	protected double totalTaxPaid = 0;

	public Merchant(String name, String address, double initialCapital, Government government) {
		super();
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		if (address == null || address.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.address = address;
		if (initialCapital < 0) {
			throw new IllegalArgumentException();
		}
		this.initialCapital = initialCapital;
		this.suppliers = new HashSet<>();
		this.myGovernment = government;
		this.businessUnits = new ArrayList<>();
		myGovernment.getMerchants().add(this);
	}

	public void startOperation() {
		System.out.println(name + " started operation......");
		orderProductsFromSupplier();
		sellGoods();
		payTaxes();
	}

	public void orderProductsFromSupplier() {

		System.out.println(name + " started ordering....");
		Iterator<Supplier> iter = suppliers.iterator();
		Supplier supplier = null;
		while (iter.hasNext()) {
			supplier = iter.next();
		}
		for (int i = 0; i < businessUnits.size(); i++) {
			businessUnits.get(i).getProducts().addAll(supplier.deliverProducts(initialCapital / businessUnits.size()));
		}
	}

	public void sellGoods() {
		ArrayList<Product> soldGoods = new ArrayList<>();
		for (int i = 0; i < businessUnits.size(); i++) {
			int numberOfSoldGoods = rnd.nextInt(businessUnits.get(i).getProducts().size());
			setSoldGoodsCount(numberOfSoldGoods);
			System.out.println("The merchant " + name + " sold goods. Number of sold goods: " + numberOfSoldGoods);
			for (int j = 0; j < numberOfSoldGoods; j++) {
				soldGoods.add(businessUnits.get(i).getProducts().remove(0));
			}
			collectTurnover(soldGoods);
			System.out.printf("The total amount of turnover from sold goods: %.2f$\n", collectTurnover(soldGoods));
		}
	}

	public double collectTurnover(List<Product> soldGoods) {

		double turnover = 0;
		for (int j = 0; j < soldGoods.size(); j++) {
			turnover += soldGoods.get(j).getPrice() * 1.3;
		}
		initialCapital += turnover;
		return turnover;
	}

	public void assignBusinessUnits() {
		for (int i = 0; i < 10; i++) {
			if (myGovernment.getBusinessUnits().get(i).getMerchant() != null) {
				continue;
			}
			if (myGovernment.getBusinessUnits().get(i) instanceof IKioskOrMarketPlace && this instanceof SelfEmployed) {
				businessUnits.add(myGovernment.getBusinessUnits().get(i));
				myGovernment.getBusinessUnits().get(i).setMerchant(this);
				System.out.println("New business unit was assigned to " + name + ". Name of the unit: "
						+ myGovernment.getBusinessUnits().get(i));
				return;
			} else if (myGovernment.getBusinessUnits().get(i) instanceof IKioskOrStoreInAMall
					&& this instanceof MarketChain) {
				businessUnits.add(myGovernment.getBusinessUnits().get(i));
				myGovernment.getBusinessUnits().get(i).setMerchant(this);
				System.out.println("New business unit was assigned to " + name + ". Name of the unit: "
						+ myGovernment.getBusinessUnits().get(i));
			}
		}
	}

	public abstract boolean addSupplier(ArrayList<Supplier> supplier);

	public void payTaxes() {
		for (int i = 0; i < businessUnits.size(); i++) {
			String taxPaid = String.format("%.2f$", businessUnits.get(i).getTax());
			totalTaxPaid += businessUnits.get(i).getTax();
			System.out.println("Tax paid for: " + businessUnits.get(i) + " by " + name + ". Amount paid " + taxPaid);
			initialCapital -= businessUnits.get(i).getTax();
			myGovernment.setBudget(businessUnits.get(i).getTax());
		}
	}

	public int getSoldGoodsCount() {
		return soldGoodsCount;
	}

	public void setSoldGoodsCount(int countOfSoldGoods) {
		soldGoodsCount += countOfSoldGoods;
	}

	public double getTaxPaid() {
		return totalTaxPaid;
	}

}

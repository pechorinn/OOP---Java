package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import businessunit.BusinessUnit;
import businessunit.Kiosk;
import businessunit.MarketPlace;
import businessunit.StoreInAMall;
import government.Government;
import merchant.Ambulanten;
import merchant.IBusinessUnits;
import merchant.MarketChain;
import merchant.Merchant;
import merchant.SelfEmployed;
import supplier.Supplier;

public class Demo {

	private static Random rnd = new Random();

	public static void main(String[] args) {
		Government government = new Government("Sofi", 1000);
		ArrayList<Supplier> sup = new ArrayList<>();
		// 1. Създава 10 доставчика на произволен принцип – на дребно и на едро.
		for (int i = 0; i < 10; i++) {
			sup.add(new Supplier("Supplier " + (i + 1), "Sofia", "08:00 - 17:00", rnd.nextBoolean()));
		}

		// 2. Създава 20 търговски обекта на произволен принцип – сергии,
		// магазини и будки.

		ArrayList<BusinessUnit> businessUnits = new ArrayList<>();

		for (int i = 0; i < 20; i++) {
			if (i < 8) {
				businessUnits.add(new MarketPlace("Sofia", "10:00-19:00"));
			} else if (i < 14) {
				businessUnits.add(new Kiosk("Sofia", "10:00-19:00"));
			} else if (i < 20) {
				businessUnits.add(new StoreInAMall("Sofia", "10:00-19:00"));
			}
		}
		Collections.shuffle(businessUnits);

		// 3. Създава един амбулантен търговец с капитал 100 лева, един ЕТ с
		// капитал 500 лева и една търговска верига с капитал 3000 лева.

		ArrayList<Merchant> merchants = new ArrayList<>();
		merchants.add(new Ambulanten("Ivan", "Sofia", 100, government));
		merchants.add(new SelfEmployed("Petar", "Sofia", 500, government));
		merchants.add(new MarketChain("Marin", "Sofia", 3000, government));
		merchants.add(new Ambulanten("Ivan 1", "Sofia", 100, government));
		merchants.add(new SelfEmployed("Petar 2", "Sofia", 500, government));
		merchants.add(new MarketChain("Marin 3", "Sofia", 3000, government));

		// 4. Подава на търговците съответни търговски обекти на произволен
		// принцип.

		government.getBusinessUnits().addAll(businessUnits);

		for (int i = 0; i < merchants.size(); i++) {
			merchants.get(i).addSupplier(sup);
			if (merchants.get(i) instanceof IBusinessUnits) {
				merchants.get(i).assignBusinessUnits();
			}
		}

		/*
		 * 5. Да се извика метод, който приема списък от създадените търговци и
		 * за всеки търговец се започва търговска дейност. Търговската дейност
		 * представлява: ◦ поръчка на стоки от доставчик за всеки търговски
		 * обект. Да се извежда на екрана списъка със стоки, сортиран по цена в
		 * нарастващ ред. ◦ прибиране на оборот от всеки търговски обект – да се
		 * извежда на екрана общата сума на печалбата. След продажба списъкът с
		 * останалите стоки в магазина трябва отново да е сортиран по цена. ◦
		 * плащане на месечен данък към държавата за всеки търговски обект.
		 */
		/*
		 * 6. Да се изпише текущия паричен баланс на всеки обект след
		 * упражняването на търговска дейност.
		 * 
		 * TURNOVER IS THE CURRENT BALANCE IT'S ZERO AFTER COLLECTION AT THE END
		 * OF MARKET OPERATIONS
		 */

		government.startOperation(merchants);

		// 7. Да се изведе търговецът с най-голям брой продадени стоки за
		// месеца.

		System.out.println("================================================");
		System.out.println("The merchant with highest count of sold goods: ");
		System.out.println("================================================");

		government.getMerchants().sort((p1, p2) -> p1.getSoldGoodsCount() - p2.getSoldGoodsCount());
		System.out.println(government.getMerchants().get(government.getMerchants().size() - 1));
		// government.getMerchants().forEach(a -> System.out.println(a));

		/*
		 * 8. Да се изведе търговецът с най-голям размер на изплатения данък към
		 * държавата.
		 */
		
		System.out.println("================================================");
		System.out.println("The merchant paid the highest amount of tax: ");
		System.out.println("================================================");

		government.getMerchants().sort((p1, p2) -> Double.compare(p1.getTaxPaid(), p2.getTaxPaid()));

		System.out.println(government.getMerchants().get(government.getMerchants().size() - 1));
		// government.getMerchants().forEach(a -> System.out.println(a));

	}
}

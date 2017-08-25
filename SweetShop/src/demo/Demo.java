package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import cake.Cake;
import cake.KidsDelight;
import cake.SpecialCake;
import cake.SpecialCake.CakeType;
import cake.StandardCake;
import cake.WeddingCake;
import client.Client;
import client.CorporateClient;
import sweetshop.DeliveryMan;
import sweetshop.SweetShop;
import sweetshop.Vitrina;

public class Demo {

	public static void main(String[] args) {
		Random rnd = new Random();

		SweetShop sweetShop = new SweetShop(100, "Sweet Talants", "Sofia", "08554488855");
		// 1. Да се създаде сладкарница „Сладки таланти“ с пет доставчика с
		// произволни имена.
		for (int i = 0; i < 5; i++) {
			new DeliveryMan("Delivery man " + (i + 1), "08925547" + (rnd.nextInt(100)), sweetShop);
		}
		// creating cakes for the catalog
		sweetShop.getStandardCakes().add(
				new StandardCake("Standard Cake", "Biskvitena cake", 20, 10, true, StandardCake.CakeType.BISKVITENA));
		sweetShop.getStandardCakes()
				.add(new StandardCake("Standard Cake", "Ekler cake", 25, 11, true, StandardCake.CakeType.EKLEROVA));
		sweetShop.getStandardCakes()
				.add(new StandardCake("Standard Cake", "Plodov cake", 21, 17, true, StandardCake.CakeType.PLODOVA));
		sweetShop.getStandardCakes()
				.add(new StandardCake("Standard Cake", "Shoko cake", 22, 15, true, StandardCake.CakeType.SHOKOLADOVA));
		sweetShop.getWeddingCakes()
				.add(new WeddingCake("Wedding Cake", "Big cake", 30, 20, WeddingCake.CakeType.BIG, 7));
		sweetShop.getWeddingCakes()
				.add(new WeddingCake("Wedding Cake", "Medium cake", 25, 18, WeddingCake.CakeType.MEDIUM, 5));
		sweetShop.getWeddingCakes()
				.add(new WeddingCake("Wedding Cake", "Small cake", 23, 10, WeddingCake.CakeType.SMALL, 3));
		sweetShop.getSpecialCakes().add(new SpecialCake("Special event", "Jubilee", 30, 11, CakeType.CORPORATE_EVENTS,
				"20 years at workplace."));
		sweetShop.getSpecialCakes()
				.add(new SpecialCake("Special event", "Promo", 18, 18, CakeType.PROMO_CAKE, "Advertising campaign."));
		sweetShop.getSpecialCakes()
				.add(new SpecialCake("Special event", "Jubilee", 17, 15, CakeType.JUBILEE, "Advertising campaign."));
		sweetShop.getKidsDelight().add(
				new KidsDelight("Kid's event", "Birthday", 14, 17, KidsDelight.CakeType.BIRTHDAY, "name of the child"));
		sweetShop.getKidsDelight().add(new KidsDelight("Kid's event", "Proshapulnik", 10, 11,
				KidsDelight.CakeType.PROSHAPULNIK, "name of the child"));
		sweetShop.getKidsDelight().add(
				new KidsDelight("Kid's event", "Baptism", 9, 23, KidsDelight.CakeType.BAPTISM, "name of the child"));

		sweetShop.printCatalog();

		Vitrina vitrina = new Vitrina(sweetShop);

		/*
		 * 2. Да се създадат 30 торти с произволни типове и видове, като е
		 * възможно от един тип и от един вид да има повече от една торти. Всяка
		 * торта има 25% процента шанс да бъде от един от четирите описани вида.
		 */

		for (int i = 0; i < 30; i++) {
			int cakeTypeOdds = rnd.nextInt(100);
			TreeMap treeMap = null;
			Cake cake = null;
			if (cakeTypeOdds < 25) {
				cake = new StandardCake((StandardCake) sweetShop.getCatalog().get(rnd.nextInt(4)));
				treeMap = vitrina.getStandardCakes();
			} else if (cakeTypeOdds < 50) {
				int random = rnd.nextInt(3) + 4;
				cake = new WeddingCake((WeddingCake) sweetShop.getCatalog().get(random));
				treeMap = vitrina.getWeddingCakes();
			} else if (cakeTypeOdds < 75) {
				int random = rnd.nextInt(3) + 7;
				cake = new SpecialCake((SpecialCake) sweetShop.getCatalog().get(random));
				treeMap = vitrina.getSpecialCakes();
			} else {
				int random = rnd.nextInt(3) + 10;
				cake = new KidsDelight((KidsDelight) sweetShop.getCatalog().get(random));
				treeMap = vitrina.getKidsDelight();
			}
			vitrina.addCake(cake, treeMap);
		}

		vitrina.printAllInStock();

		// 3. Да се създадат десет клиента – пет корпоративни и пет частни с
		// произволни имена и
		// съответните им отстъпки и ваучери.

		for (int i = 0; i < 10; i++) {
			if (i < 5) {
				new CorporateClient("Coprorate client " + (i + 1), "089544587" + rnd.nextInt(100), sweetShop,
						"Sofia" + (i + 10), rnd.nextInt(1000) + 100);
				System.out.println("New corporate client added.");
			} else {
				System.out.println("New ordinary client added.");
				new CorporateClient("Ordinary client " + (i + 1), "08955674" + rnd.nextInt(100), sweetShop,
						"Sofia" + (i + 10), rnd.nextInt(100) + 100);
			}
		}

		// 4. Всеки клиент да направи поръчка на торти и те да му бъдат
		// доставени.
		for (int i = 0; i < sweetShop.getClients().size(); i++) {
			sweetShop.getClients().get(i).createOrder();
		}
		
		// 5. Да се изведе на екрана наличността на торти, разписана по видове и
		// типове, преди и след поръчките.
		
		vitrina.printAllInStock();
		
                //6. Да се изпише общата сума, получена от сладкарницата, след поръчка на тортите.
		
		System.out.printf("The income of the shop after orders were closed: %.2f$\n", sweetShop.getCash() - 100);
		
		// 7. Да се изведе списък с всички доставчици на сладкарницата, сортиран по големина на
		//    техните бакшиши, като подредбата е от най-богатия към този с най-малко бакшиши.*/
		
		sweetShop.getDeliveryMan().sort((p1, p2) -> (int) (p2.getCash() - p1.getCash()));
		System.out.println(sweetShop.getDeliveryMan());

		// 8. Да се изведе вида торти, който най-често се е продавал.
		
		HashMap<String, Integer> numberOfSoldCakesByType = new HashMap<>();
		numberOfSoldCakesByType.put("Standard Cake", 0);
		numberOfSoldCakesByType.put("Wedding Cake", 0);
		numberOfSoldCakesByType.put("Special Cake", 0);
		numberOfSoldCakesByType.put("Kids Delight", 0);

		ArrayList<Cake> allOrders = new ArrayList<>();
		for (int i = 0; i < sweetShop.getOrders().size(); i++) {
			allOrders.addAll(sweetShop.getOrders().get(i).getOrderedCakes());
		}

		for (int i = 0; i < allOrders.size(); i++) {

			if (allOrders.get(i) instanceof StandardCake && numberOfSoldCakesByType.containsKey("Standard Cake")) {
				Integer temp = numberOfSoldCakesByType.get("Standard Cake");
				numberOfSoldCakesByType.put("Standard Cake", temp + 1);
			} else if (allOrders.get(i) instanceof WeddingCake && numberOfSoldCakesByType.containsKey("Wedding Cake")) {
				Integer temp = numberOfSoldCakesByType.get("Wedding Cake");
				numberOfSoldCakesByType.put("Wedding Cake", temp + 1);
			} else if (allOrders.get(i) instanceof SpecialCake && numberOfSoldCakesByType.containsKey("Special Cake")) {
				Integer temp = numberOfSoldCakesByType.get("Special Cake");
				numberOfSoldCakesByType.put("Special Cake", temp + 1);
			} else if (allOrders.get(i) instanceof KidsDelight && numberOfSoldCakesByType.containsKey("Kids Delight")) {
				Integer temp = numberOfSoldCakesByType.get("Kids Delight");
				numberOfSoldCakesByType.put("Kids Delight", temp + 1);
			}

		}
		System.out.println("==========================================");
		System.out.println("The most often sold cake: "
				+ Collections.max(numberOfSoldCakesByType.entrySet(), Map.Entry.comparingByValue()).getKey());
		System.out.println("Number of sold cakes of this type: " + numberOfSoldCakesByType
				.get(Collections.max(numberOfSoldCakesByType.entrySet(), Map.Entry.comparingByValue()).getKey()));
		System.out.println("==========================================");
		System.out.println();

	        // 9. Да се изведе доставчика, направил най-много поръчки.
		
		sweetShop.getDeliveryMan().sort((p1, p2) -> p2.getOrders().size() - p1.getOrders().size());
		System.out.println("Delivery man with highest number of orders: " + sweetShop.getDeliveryMan().get(0));

		// 10. Да се изведе клиентът, който е заплатил най-голяма сума за
		// тортички.
		
		double highestAmount = sweetShop.getClients().get(0).getInitialAmount()
				- sweetShop.getClients().get(0).getCash();
		Client client = sweetShop.getClients().get(0);
		for (int i = 1; i < sweetShop.getClients().size(); i++) {
			if ((sweetShop.getClients().get(i).getInitialAmount()
					- sweetShop.getClients().get(i).getCash()) > highestAmount) {
				highestAmount = sweetShop.getClients().get(i).getInitialAmount()
						- sweetShop.getClients().get(i).getCash();
				client = sweetShop.getClients().get(i);
			}
		}
		System.out.println("==========================================");
		System.out.println("The client that spent the highest amount on cakes is: " + client);
		System.out.printf("%nSpent cash: %.2f$", highestAmount);
		System.out.println("\n==========================================");

	}
}

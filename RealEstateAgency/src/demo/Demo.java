package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import client.Buyer;
import client.Client;
import client.Seller;
import property.Appartment;
import property.Appartment.AppartmentType;
import property.House;
import property.House.HousesTypes;
import property.Plot;
import property.Property;
import property.PropertyType.PropertiesCanBe;
import realestateagency.Agency;
import realestateagency.Agent;

public class Demo {

	public static void main(String[] args) {

		Random rnd = new Random();
		Agent ivan = new Agent("Ivan", "0898955548");
		Agent petar = new Agent("Petar", "0898955549");
		Agent igor = new Agent("Igor", "0898955520");
		Agent maria = new Agent("Maria", "0898955530");
		Agent lili = new Agent("Lilia", "0898955510");
		ArrayList<Agent> agents = new ArrayList<>();
		agents.add(ivan);
		agents.add(petar);
		agents.add(igor);
		agents.add(maria);
		agents.add(lili);
		// 1. Да се създаде агенция „Таланти Естейтс“ с пет агента с произволни
		// имена.
		Agency agency = new Agency("Talants Estates", "Sofia", "0858855444", 0, agents);

		/*
		 * 2. Да се създадат 30 продавача на имоти. За всеки продавач да се
		 * създаде имот на произволен принцип – 33% шанс да е апартамент, 33%
		 * шанс да е къща и 33% шанс за парцел. Останалите характеристики също
		 * да са на произволен принцип. Цените на имотите да варират – за къщите
		 * между 50 000 и 80 000 евро, за апартаментите – между 70 000 и 150 000
		 * евро; за парцелите – между 30 000 и 85 000 евро.
		 */

		// 3. Всички продавачи да регистрират имотите си за продажба в
		// агенцията;

		Property property;
		Client client;
		for (int i = 0; i < 30; i++) {
			if (i < 10) {
				property = new Appartment("A beuatiful appartment N" + (i + 1), "Sofia", rnd.nextInt(200),
						PropertiesCanBe.values()[rnd.nextInt(PropertiesCanBe.values().length)],
						AppartmentType.values()[rnd.nextInt(AppartmentType.values().length)],
						rnd.nextInt(80_001) + 70_000);

				client = new Seller("Seller " + (i + 1), "089xxxxxxx", agency, property);

			} else if (i < 20) {
				property = new House("A beuatiful house N" + (i + 1), "Sofia", rnd.nextInt(200),

						PropertiesCanBe.values()[rnd.nextInt(PropertiesCanBe.values().length)], rnd.nextInt(10),
						rnd.nextInt(1000), HousesTypes.values()[rnd.nextInt(HousesTypes.values().length)],
						rnd.nextInt(30_001) + 50_000);
				client = new Seller("Seller " + (i + 1), "089xxxxxxx", agency, property);

			} else {
				property = new Plot("A beuatiful plot N" + (i + 1), "Sofia", rnd.nextInt(200),
						rnd.nextInt(50_001) + 30_000, rnd.nextBoolean());
				client = new Seller("Seller " + (i + 1), "089xxxxxxx", agency, property);

			}
			property.setOwner(client);
			agency.getSellers().add(client);
			((Seller) client).registerPropertyForSale();
		}

		agency.updateCatalog();
	/*	System.out.println(agency.getApartments());
		System.out.println("===========================================");
		System.out.println(agency.getHouses());
		System.out.println("===========================================");
		System.out.println(agency.getPlots());
		System.out.println("===========================================");*/

		// 4. Да се създадат 10 купувача на произволен принцип с бюджети между
		// 30 000 и 150 000 евро;
		ArrayList<Client> buyers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			buyers.add(new Buyer("Buyer " + (i + 1), "099xxxxxxxxx", agency, rnd.nextInt(170_001) + 30_000));
		}

		// 5. Всички купувачи да регистрират заявки за търсене на имот към
		// агенцията;

		for (Client buyer : buyers) {
			((Buyer) buyer).registerRequestToSearch();
		}

		// 6. Всеки купувач да заяви 3 огледа на произволни имоти от агенцията;

		for (int i = 0; i < agency.getAgents().size(); i++) {
			for (int j = 0; j < agency.getAgents().get(i).getBuyers().size(); j++) {
				for (int count = 0; count < 3; count++) {
					agency.getAgents().get(i).getBuyers().get(j).orderToView();
				}
			}
		}
		
                // 7. Всеки купувач да заяви покупка на някой от огледаните от него
		// имоти на произволен принцип;

		for (int i = 0; i < agency.getBuyers().size(); i++) {
			if (((Buyer) agency.getBuyers().get(i)).getViews().size() > 0) {

				((Buyer) agency.getBuyers().get(i)).makeAnOfferToBuy(((Buyer) agency.getBuyers().get(i)).getViews()
						.get(rnd.nextInt(((Buyer) agency.getBuyers().get(i)).getViews().size())));
			}
		}

		// 8. Да се изпише на екрана паричния баланс на агенцията след
		// продажбата на имотите;
		System.out.printf("Agency cash: %.2f$%n", agency.getCash());

		// 9. Да се изпише на екрана паричния баланс на всеки агент от агенцията
		// след продажбата
		// на имотите, като агентите са сортирани от най-богатия към този с
		// най-малко печалби.

		Collections.sort(agency.getAgents(), (p1, p2) -> ((int) p2.getCash()) - ((int) p1.getCash()));
		
		System.out.println(agency.getAgents());

	}
}

package sweetshop;

import java.lang.annotation.Retention;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

import cake.Cake;
import cake.KidsDelight;
import cake.SpecialCake;
import cake.StandardCake;
import cake.WeddingCake;
import client.Client;

public class SweetShop {

	private double cash;
	private String name;
	private String address;
	private String phone;
	private ArrayList<DeliveryMan> deliveryMen;
	private ArrayList<Cake> catalog;
	private TreeSet<StandardCake> standardCakes;
	private TreeSet<WeddingCake> weddingCakes;
	private TreeSet<SpecialCake> specialCakes;
	private TreeSet<KidsDelight> kidsDelight;
	private ArrayList<Client> clients;
	private ArrayList<Order> orders;
	private Random rnd = new Random();

	private Vitrina vitrina;

	public SweetShop(double cash, String name, String address, String phone) {
		super();
		if (cash < 0) {
			throw new IllegalArgumentException();
		}
		this.cash = cash;
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		if (address == null || address.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.address = address;
		if (phone == null || phone.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.phone = phone;
		this.deliveryMen = new ArrayList<>();
		this.catalog = new ArrayList<>();
		this.standardCakes = new TreeSet<>((p1, p2) -> (int) p2.getPrice() - (int) p1.getPrice());
		this.weddingCakes = new TreeSet<>((p1, p2) -> (int) p1.getPieces() - (int) p2.getPieces());
		this.specialCakes = new TreeSet<>((p1, p2) -> (int) p2.getPrice() - (int) p1.getPrice());
		this.kidsDelight = new TreeSet<>((p1, p2) -> (int) p1.getPieces() - (int) p2.getPieces());
		this.clients = new ArrayList<>();
		this.orders = new ArrayList<>();

	}

	public ArrayList<DeliveryMan> getDeliveryMan() {
		return deliveryMen;
	}

	public void printCatalog() {
		getCatalog();
		System.out.println("The sweetshop's catalog: ");
		System.out.println("------------------------");
		System.out.println(catalog);
		System.out.println("------------------------");
	}

	public ArrayList<Cake> getCatalog() {
		catalog = new ArrayList<>();
		catalog.addAll(standardCakes);
		catalog.addAll(weddingCakes);
		catalog.addAll(specialCakes);
		catalog.addAll(kidsDelight);
		return catalog;
	}

	public TreeSet<StandardCake> getStandardCakes() {
		return standardCakes;
	}

	public TreeSet<WeddingCake> getWeddingCakes() {
		return weddingCakes;
	}

	public TreeSet<SpecialCake> getSpecialCakes() {
		return specialCakes;
	}

	public TreeSet<KidsDelight> getKidsDelight() {
		return kidsDelight;
	}

	@Override
	public String toString() {

		String cashString = String.format("%.2f$", cash);

		return "\n------------------------\nSweetShop [cash: " + cashString + ", " + name + ", address: " + address
				+ ", phone: " + phone + "]\n------------------------";
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void handleOrder(Client client, ArrayList<Cake> cakes, double orderValue) {
		Order order = new Order(client, orderValue, client.getAddress(), cakes,
				LocalDate.of(2017, rnd.nextInt(12) + 1, rnd.nextInt(28) + 1));

		for (int i = 0; i < cakes.size(); i++) {
			if ((cakes.get(i) instanceof StandardCake) && vitrina.getStandardCakes().containsKey(cakes.get(i))
					|| ((cakes.get(i) instanceof WeddingCake) && vitrina.getWeddingCakes().containsKey(cakes.get(i)))
					|| ((cakes.get(i) instanceof SpecialCake) && vitrina.getSpecialCakes().containsKey(cakes.get(i)))
					|| ((cakes.get(i) instanceof KidsDelight) && vitrina.getKidsDelight().containsKey(cakes.get(i)))) {

				if (cakes.get(i) instanceof StandardCake && vitrina.getStandardCakes().get(cakes.get(i)) > 0) {
					vitrina.deductCake(cakes.get(i), vitrina.getStandardCakes());

					if (vitrina.getStandardCakes().get(cakes.get(i)) == new Integer(0)) {
						System.out.println("Standard cake removed from showcase.");
						vitrina.getStandardCakes().remove(cakes.get(i));
						order.getOrderedCakes().remove(cakes.get(i));

					}
				} else if (cakes.get(i) instanceof WeddingCake && vitrina.getWeddingCakes().get(cakes.get(i)) > 0) {
					vitrina.deductCake(cakes.get(i), vitrina.getWeddingCakes());
					if (vitrina.getWeddingCakes().get(cakes.get(i)) == new Integer(0)) {
						System.out.println("Wedding cake removed from showcase.");
						vitrina.getWeddingCakes().remove(cakes.get(i));
						order.getOrderedCakes().remove(cakes.get(i));

					}
				} else if (cakes.get(i) instanceof SpecialCake && vitrina.getSpecialCakes().get(cakes.get(i)) > 0) {
					vitrina.deductCake(cakes.get(i), vitrina.getSpecialCakes());
					if (vitrina.getSpecialCakes().get(cakes.get(i)) == new Integer(0)) {
						System.out.println("Special cake removed from showcase.");
						vitrina.getSpecialCakes().remove(cakes.get(i));
						order.getOrderedCakes().remove(cakes.get(i));

					}
				} else if (cakes.get(i) instanceof KidsDelight && vitrina.getKidsDelight().get(cakes.get(i)) > 0) {
					vitrina.deductCake(cakes.get(i), vitrina.getKidsDelight());
					if (vitrina.getKidsDelight().get(cakes.get(i)) == new Integer(0)) {
						vitrina.getKidsDelight().remove(cakes.get(i));
						order.getOrderedCakes().remove(cakes.get(i));
						System.out.println("Kids Delight cake removed from showcase.");
					}
				}
			} else {
				order.setPrice(-cakes.get(i).getPrice());
				orderValue -= cakes.get(i).getPrice();
				System.out.println("Below cake is out of stock, the order was ammended: " + cakes.get(i));
				cakes.remove(i);
			}

		}

		if (order.getOrderedCakes().size() > 0) {
			orders.add(order);
			assignDeliveryMan(order);
		} else {
			System.out.println("No order can be made since no cakes are available");
		}
	}

	public void assignDeliveryMan(Order order) {
		order.setDeliveryMan(deliveryMen.get(rnd.nextInt(deliveryMen.size())));
	}

	public void setCash(double income) {

		cash += income;
	}

	public void setVitrina(Vitrina vitrina) {

		this.vitrina = vitrina;
	}

	public double getCash() {
		return cash;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}
}

package sweetshop;

import java.util.TreeMap;

import cake.Cake;
import cake.KidsDelight;
import cake.SpecialCake;
import cake.StandardCake;
import cake.WeddingCake;

public class Vitrina {

	private TreeMap<StandardCake, Integer> standCakes;
	private TreeMap<WeddingCake, Integer> wedCakes;
	private TreeMap<SpecialCake, Integer> specCakes;
	private TreeMap<KidsDelight, Integer> kidCakes;
	private SweetShop sweetShop;

	public Vitrina(SweetShop sweetshop) {
		super();
		this.standCakes = new TreeMap<>((p1, p2) -> (int) p2.getPrice() - (int) p1.getPrice());
		this.wedCakes = new TreeMap<>((p1, p2) -> (int) p1.getPieces() - (int) p2.getPieces());
		this.specCakes = new TreeMap<>((p1, p2) -> (int) p2.getPrice() - (int) p1.getPrice());
		this.kidCakes = new TreeMap<>((p1, p2) -> (int) p1.getPieces() - (int) p2.getPieces());
		if (sweetshop == null) {
			throw new IllegalArgumentException();
		}
		this.sweetShop = sweetshop;
		sweetShop.setVitrina(this);

	}

	public void addCake(Cake cake, TreeMap<Cake, Integer> treeMap) {
		if (treeMap.containsKey(cake)) {
			int value = (int) treeMap.get(cake);
			treeMap.put(cake, value + 1);
		} else {
			treeMap.put(cake, 1);
		}
	}

	public void deductCake(Cake cake, TreeMap treeMap) {
		if (treeMap.containsKey(cake)) {
			int value = (int) treeMap.get(cake);
			treeMap.put(cake, value - 1);
		}
	}

	public TreeMap<StandardCake, Integer> getStandardCakes() {
		return standCakes;
	}

	public TreeMap<WeddingCake, Integer> getWeddingCakes() {
		return wedCakes;
	}

	public TreeMap<SpecialCake, Integer> getSpecialCakes() {
		return specCakes;
	}

	public TreeMap<KidsDelight, Integer> getKidsDelight() {
		return kidCakes;
	}

	public void printAllInStock() {
		System.out.println("====================================================");
		System.out.println("                  All cakes in stock: ");
		System.out.println("====================================================");

		System.out.println("Standard Cakes:");
		System.out.println(standCakes);
		System.out.println("-------------------------");
		System.out.println("Wedding cakes: ");
		System.out.println(wedCakes);
		System.out.println("-------------------------");
		System.out.println("Special events cakes:");
		System.out.println(specCakes);
		System.out.println("-------------------------");
		System.out.println("Kid cakes:");
		System.out.println(kidCakes);
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println();
	}
}

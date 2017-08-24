package musicinstruments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

import musicinstruments.duhovi.Fleita;
import musicinstruments.duhovi.Klarinet;
import musicinstruments.duhovi.Trombon;
import musicinstruments.duhovi.Trompet;
import musicinstruments.duhovi.Tuba;
import musicinstruments.electronni.BasKitara;
import musicinstruments.electronni.ElektricheskaTsigulka;
import musicinstruments.electronni.Sintezator;
import musicinstruments.klavishni.Akordeon;
import musicinstruments.klavishni.Organ;
import musicinstruments.klavishni.Piano;
import musicinstruments.strunni.Arfa;
import musicinstruments.strunni.Gydulka;
import musicinstruments.strunni.Kitara;
import musicinstruments.strunni.Kontrabas;
import musicinstruments.strunni.Tsigulka;
import musicinstruments.strunni.Viola;
import musicinstruments.udarni.Baraban;
import musicinstruments.udarni.Daire;
import musicinstruments.udarni.Tarambuka;
import musicinstruments.udarni.Typan;

public class Shop {

	public enum InstrumentType {
		DUHOVI, KLAVISHNI, STRUNNI, UDARNI, ELECTRONNI
	}

	private String name;
	private Map<InstrumentType, ArrayList<Instrument>> availableInstruments;
	private double cash;

	public Shop(String name, double cash) {
		super();
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Please provide adequate name for the shop.");
		}
		this.name = name;
		if (cash < 0) {
			throw new IllegalArgumentException("Balance of the shop cannot be a negative value.");
		}
		this.cash = cash;
		this.availableInstruments = new HashMap<>();
		this.add(InstrumentType.DUHOVI, new Fleita());
		this.add(InstrumentType.DUHOVI, new Klarinet());
		this.add(InstrumentType.DUHOVI, new Trombon());
		this.add(InstrumentType.DUHOVI, new Trompet());
		this.add(InstrumentType.DUHOVI, new Tuba());
		this.add(InstrumentType.ELECTRONNI, new BasKitara());
		this.add(InstrumentType.ELECTRONNI, new ElektricheskaTsigulka());
		this.add(InstrumentType.ELECTRONNI, new Sintezator());
		this.add(InstrumentType.KLAVISHNI, new Akordeon());
		this.add(InstrumentType.KLAVISHNI, new Organ());
		this.add(InstrumentType.KLAVISHNI, new Piano());
		this.add(InstrumentType.STRUNNI, new Arfa());
		this.add(InstrumentType.STRUNNI, new Gydulka());
		this.add(InstrumentType.STRUNNI, new Kitara());
		this.add(InstrumentType.STRUNNI, new Kontrabas());
		this.add(InstrumentType.STRUNNI, new Tsigulka());
		this.add(InstrumentType.STRUNNI, new Viola());
		this.add(InstrumentType.UDARNI, new Baraban());
		this.add(InstrumentType.UDARNI, new Daire());
		this.add(InstrumentType.UDARNI, new Tarambuka());
		this.add(InstrumentType.UDARNI, new Typan());

	}

	private void add(InstrumentType type, Instrument instr) {

		if (!availableInstruments.containsKey(type)) {
			availableInstruments.put(type, new ArrayList<>());
		}
		availableInstruments.get(type).add(instr);
	}

	public void sellInstrument(InstrumentName name, int count) {
		if (!(name instanceof InstrumentName)) {
			throw new IllegalArgumentException("Please provide adequate name.");
		}
		if (count <= 0) {
			throw new IllegalArgumentException("Please provide adequate count of items to buy.");
		}

		for (ArrayList<Instrument> arrayList : availableInstruments.values()) {
			boolean exitFlag = false;

			for (Instrument in : arrayList) {
				if (in.getAvailableCount() < count && name == in.getName()) {
					System.out.println("==============================================");
					System.out.println("Not enough items of this type in the shop. Available qantity of " + in.getName()
							+ ": " + in.getAvailableCount());
					exitFlag = true;
					break;
				} else if (name == in.getName()) {
					System.out.println("==============================================");
					System.out
							.println(count + " " + in.getName() + " sold. Single unit price:  " + in.getPrice() + "$");
					cash += in.getPrice() * count;
					System.out.println("Amount of " + in.getPrice() * count + "$ was added to the shop cashier.");
					System.out.println("==============================================");
					in.deductSoldItems(count);
					in.addToNumberOfSales(count);
					exitFlag = true;
				}
			}
			if (exitFlag) {
				break;
			}
		}
	}

	public void addNewInstrumentsToTheShop(InstrumentName name, int count) {
		if (!(name instanceof InstrumentName)) {
			throw new IllegalArgumentException("Please provide adequate name.");
		}
		if (count <= 0) {
			throw new IllegalArgumentException("Please provide adequate count of items to buy.");
		}
		for (ArrayList<Instrument> arrayList : availableInstruments.values()) {
			boolean exitFlag = false;
			for (Instrument in : arrayList) {
				if (in.getName() == name) {
					exitFlag = true;
					System.out.println(count + " items of " + in.getName() + " added to the store.");
					System.out.println("==============================================");
					in.addInstruments(count);
					break;
				}
			}
			if (exitFlag) {
				break;
			}
		}
	}

	public void printCatalogByCategory() {
		System.out.println("==============================================");
		System.out.println("       Printing instruments by category:");
		System.out.println("==============================================");

		for (Entry<InstrumentType, ArrayList<Instrument>> entry : availableInstruments.entrySet()) {
			System.out.println(entry.getKey() + " intstruments: ");
			for (Instrument instr : entry.getValue()) {
				System.out.println(instr);
			}
		}
	}

	private void printCatalogAccordingToProvidedCriteria(Comparator<Instrument> comp) {

		TreeSet<Instrument> treeSet = new TreeSet<>(comp);

		for (Entry<InstrumentType, ArrayList<Instrument>> entry : availableInstruments.entrySet()) {
			treeSet.addAll(entry.getValue());
		}

		for (Instrument instr : treeSet) {
			System.out.println(instr);
		}
	}

	public void printCatalogInAlphabeticalOrder() {
		System.out.println("==============================================");
		System.out.println("All instruments sorted in alphabetical order:");
		System.out.println("==============================================");
		printCatalogAccordingToProvidedCriteria((a, b) -> a.getPrice() == b.getPrice() ? a.getId() - b.getId()
				: a.getName().toString().compareTo(b.getName().toString()));
	}

	public void printCatalogByPriceAcsending() {
		System.out.println("==============================================");
		System.out.println("All instruments sorted by price ascending:");
		System.out.println("==============================================");
		printCatalogAccordingToProvidedCriteria((a, b) -> a.getPrice() == b.getPrice() ? a.getId() - b.getId()
				: Double.compare(a.getPrice(), b.getPrice()));
	}

	public void printCatalogByPriceDescending() {
		System.out.println("==============================================");
		System.out.println("All instruments sorted by price descending:");
		System.out.println("==============================================");
		printCatalogAccordingToProvidedCriteria((a, b) -> a.getPrice() == b.getPrice() ? a.getId() - b.getId()
				: Double.compare(b.getPrice(), a.getPrice()));
	}

	public void printAvailableInstruments() {
		System.out.println("==============================================");
		System.out.println(" Printing available instruments by category:");
		System.out.println("==============================================");

		for (Entry<InstrumentType, ArrayList<Instrument>> entry : availableInstruments.entrySet()) {
			System.out.println(entry.getKey() + " intstruments: ");
			for (Instrument instr : entry.getValue()) {
				if (instr.getAvailableCount() > 0) {
					System.out.println(instr);
				}
			}
		}
	}

	private LinkedList<Entry<Instrument, Integer>> collectInfoForSales() {

		Map<Instrument, Integer> map = new HashMap<>();

		for (ArrayList<Instrument> arrayList : availableInstruments.values()) {
			for (Instrument in : arrayList) {
				if (in.getNumberOfSales() > 0) {
					map.put(in, in.getNumberOfSales());
				}
			}
		}

		LinkedList<Entry<Instrument, Integer>> linkedList = new LinkedList<>(map.entrySet());
		linkedList.sort(new SortingByNumberOfSales());
		return linkedList;
	}

	public void printInstrumentsAccordingToNumberOfSales() {
		System.out.println("==============================================");
		System.out.println("Sorted according to number of sales: ");
		System.out.println("==============================================");
		LinkedList<Entry<Instrument, Integer>> sortedBySales = new LinkedList<>(collectInfoForSales());
		for (Entry<Instrument, Integer> entry : sortedBySales) {
			System.out.println(entry.getKey().getName() + " : " + entry.getValue());
		}
		System.out.println("==============================================");
	}

	public void printIncomeFromSales() {
		double income = 0;
		LinkedList<Entry<Instrument, Integer>> sortedBySales = new LinkedList<>(collectInfoForSales());
		for (Entry<Instrument, Integer> entry : sortedBySales) {
			income += entry.getKey().getPrice() * entry.getValue();
		}
		System.out.println("==============================================");
		System.out.println("Total income from sales: " + income + "$");
		System.out.println("==============================================");
	}

	public void printTheMostSellingInstrument() {
		System.out.println("==============================================");
		System.out.println("The most selling instrument: " + collectInfoForSales().getLast().getKey().getName()
				+ ". Number of items sold: " + collectInfoForSales().getLast().getValue());
		System.out.println("==============================================");
	}

	public void printTheLeastSellingInstrument() {
		System.out.println("==============================================");
		System.out.println("The least selling instrument: " + collectInfoForSales().getFirst().getKey().getName()
				+ ". Number of items sold: " + collectInfoForSales().getFirst().getValue());
		System.out.println("==============================================");
	}

	public void printInfoAboutMostSellingInstrumentType() {

		int currentItemstSoldByType = 0;
		int maxSoldInstrumentsByType = 0;
		InstrumentType instrumentType = null;

		for (Entry<InstrumentType, ArrayList<Instrument>> entry : availableInstruments.entrySet()) {
			InstrumentType currentInstrumentType = entry.getKey();
			for (Instrument in : entry.getValue()) {
				currentItemstSoldByType += in.getNumberOfSales();
			}
			if (currentItemstSoldByType > maxSoldInstrumentsByType) {
				maxSoldInstrumentsByType = currentItemstSoldByType;
				instrumentType = currentInstrumentType;
			}
			currentItemstSoldByType = 0;
		}

		System.out.println("The most selling instrument type is " + instrumentType + ". The number of total sales: "
				+ maxSoldInstrumentsByType);
		System.out.println("==============================================");
	}

	public void printInfoAboutMostIncomeGeneratingInstrumentType() {

		double currentAmountIncome = 0;
		double maxIncomeByType = 0;
		InstrumentType instrumentType = null;

		for (Entry<InstrumentType, ArrayList<Instrument>> entry : availableInstruments.entrySet()) {
			InstrumentType currentInstrumentType = entry.getKey();
			for (Instrument in : entry.getValue()) {
				currentAmountIncome += in.getNumberOfSales()*in.getPrice();
			}
			if (currentAmountIncome > maxIncomeByType) {
				maxIncomeByType = currentAmountIncome;
				instrumentType = currentInstrumentType;
			}
			currentAmountIncome = 0;
		}

		System.out.println("The most income generating instrument type is " + instrumentType + ". The amount of total sales by this type: " + maxIncomeByType + "$");
		System.out.println("==============================================");
	}

	@Override
	public String toString() {
		return "Shop [name=" + name + ", availableInstruments=" + availableInstruments + ", cash=" + cash + "]";
	}

}

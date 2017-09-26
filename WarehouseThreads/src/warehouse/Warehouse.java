package warehouse;

import java.util.Map;
import java.util.TreeMap;

public class Warehouse {

	public enum Type {VEGETABLES, FRUITS, MEATS};
	//type -> (name->quantity)
	private static final int MIN_QUANTITY = 5;
	private Map<Type, Map<String, Integer>> catalog;
	
	public Warehouse() {
		catalog = new TreeMap<>();
		catalog.put(Type.VEGETABLES, new TreeMap<>());
		catalog.put(Type.FRUITS, new TreeMap<>());
		catalog.put(Type.MEATS, new TreeMap<>());
		catalog.get(Type.VEGETABLES).put("Potato", 15);
		catalog.get(Type.VEGETABLES).put("EggPlant", 15);
		catalog.get(Type.VEGETABLES).put("Cucumber", 15);
		catalog.get(Type.FRUITS).put("Banana", 15);
		catalog.get(Type.FRUITS).put("Orange", 15);
		catalog.get(Type.FRUITS).put("Apple", 15);
		catalog.get(Type.MEATS).put("Pork", 15);
		catalog.get(Type.MEATS).put("Beef", 15);
		catalog.get(Type.MEATS).put("Chicken", 15);
	}
	
	public synchronized void deliver(){
		while(!hasInsufficient()){
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("oops");
			}
		}
		fillQuantities();
		this.notifyAll();
	}
	
	private void fillQuantities() {
		for(Map<String, Integer> products : catalog.values()){
			for(String s : products.keySet()){
				if(products.get(s) < MIN_QUANTITY){
					System.out.println(s +"not sufficient in warehouse! Supplier! Give me " + s + "!");
					products.put(s, products.get(s)+25);
				}
			}
		}
	}

	private boolean hasInsufficient() {
		for(Map<String, Integer> products : catalog.values()){
			for(String s : products.keySet()){
				if(products.get(s) < MIN_QUANTITY){
					return true;
				}
			}
		}
		return false;
	}

	public synchronized void getProduct(String name){
		while(insufficient(name)){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
		removeQuantity(name);
		notifyAll();
	}

	private void removeQuantity(String name) {
		for(Map<String, Integer> products : catalog.values()){
			for(String s : products.keySet()){
				if(s.equals(name)){
					products.put(s, products.get(s)-5);
				}
			}
		}
	}

	private boolean insufficient(String name) {
		for(Map<String, Integer> products : catalog.values()){
			for(String s : products.keySet()){
				if(s.equals(name) && products.get(s) < MIN_QUANTITY){
					return true;
				}
			}
		}
		return false;
	}
}

package warehouse;

import java.util.Map;
import java.util.TreeMap;

public abstract class Store {

		public enum Type {VEGETABLES, FRUITS, MEATS};
		//type -> (name->quantity)
		protected static final int MIN_QUANTITY = 5;
		protected Map<Type, Map<String, Integer>> catalog;
		
		public Store() {
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
		
		protected abstract void fillQuantities();

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

package warehouse;

import java.util.Map;

public class Warehouse extends Store {

	public Warehouse() {

	}
	
	protected void fillQuantities() {
		for(Map<String, Integer> products : catalog.values()){
			for(String s : products.keySet()){
				if(products.get(s) < MIN_QUANTITY){
					System.out.println(s +"not sufficient in warehouse! Supplier! Give me " + s + "!");
					products.put(s, products.get(s)+25);
				}
			}
		}
	}

}

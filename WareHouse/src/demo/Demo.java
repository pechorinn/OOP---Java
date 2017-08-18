package demo;

import client.Client;
import client.DeliveryMan;
import motherhouse.Shop;
import motherhouse.WareHouse;
import product.Product.ProductName;

public class Demo {

	public static void main(String[] args) {
		DeliveryMan dm = new DeliveryMan("Ivan");
		WareHouse wh = new WareHouse("Eldorado", dm);
		Shop sh1 = new Shop("Verde1", dm, wh);
		Shop sh2 = new Shop("Verde2", dm, wh);
		Shop sh3 = new Shop("Verde3", dm, wh);

		for (int i = 0; i < 3; i++) {
			sh1.getClients().add(new Client("Client " + (i + 1), sh1));
		}
		for (int i = 0; i < 3; i++) {
			sh2.getClients().add(new Client("Client " + (i + 1), sh2));
		}
		for (int i = 0; i < 3; i++) {
			sh3.getClients().add(new Client("Client " + (i + 1), sh3));
		}

		System.out.println(sh1.getAllProductsInStock());
	
		for (int i = 0; i < 100; i++) {
			
			sh1.getClients().get(0).buyGoods();
			sh1.getClients().get(1).buyGoods();
			sh1.getClients().get(2).buyGoods();
			sh1.restock();
			dm.restock(wh);
			sh2.getClients().get(0).buyGoods();
			sh2.getClients().get(1).buyGoods();
			sh2.getClients().get(2).buyGoods();
			sh2.restock();
			dm.restock(wh);
			sh3.getClients().get(0).buyGoods();
			sh3.getClients().get(1).buyGoods();
			sh3.getClients().get(2).buyGoods();
			sh3.restock();
			wh.getDeliveryMan().restock(wh);

		}
		
		System.out.println(sh1.getClients().get(0));
		sh1.deliver(ProductName.APPLE);
	}
}

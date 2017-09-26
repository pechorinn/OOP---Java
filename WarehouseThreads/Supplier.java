package warehouse;

public class Supplier extends Thread{

	private Warehouse wh;
	
	public Supplier(Warehouse wh) {
		this.wh = wh;
	}

	@Override
	public void run() {
		while(true){
			wh.deliver();
		}
	}
}

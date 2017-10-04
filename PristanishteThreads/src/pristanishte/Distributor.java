package pristanishte;

import java.util.concurrent.ArrayBlockingQueue;

public class Distributor extends Thread{

	private ArrayBlockingQueue<Pratka> sklad;
	
	public Distributor(ArrayBlockingQueue<Pratka> sklad) {
		this.sklad = sklad;
	}
	
	@Override
	public void run() {
		while(true){
			try {
				sklad.take();
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

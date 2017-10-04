package rakia;

public class Shkembedjia extends Thread{

	private Koop koop;
	
	public Shkembedjia(Koop koop, String name){
		this.koop = koop;
		setName(name);
	}
	
	@Override
	public void run() {
		while(true){
			koop.removeRakia(5);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
}

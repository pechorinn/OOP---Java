package rakia;

public class Rakidjia extends Thread{

	private Bidon bidon;
	private Koop koop;
	
	public Rakidjia(Bidon bidon, Koop koop, String name){
		this.bidon = bidon;
		this.koop = koop;
		setName(name);
	}
	
	@Override
	public void run() {
		while(true){
			bidon.removeGrozde(25);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			koop.addRakia(30);
		}
	}
}

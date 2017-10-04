package rakia;

public class Berachka extends Thread{

	private Bidon bidon;
	
	public Berachka(Bidon bidon, String name){
		this.bidon = bidon;
		setName(name);
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bidon.addGrozde(10);
		}
	}
}

package rakia;

public class Bidon {
	
	private int grozde = 0;
	private static final int MAX_GROZDE = 100;

	public synchronized void addGrozde(int grozde) {
		while(this.grozde > MAX_GROZDE - grozde){
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Oops. Something went wrong. In addGrozde.");
			}
		}
		this.grozde+=grozde;
		System.out.println(Thread.currentThread().getName() + " added " + grozde + " grozde to bidon");
		this.notifyAll();
	}

	public synchronized void removeGrozde(int grozde) {
		while(this.grozde < grozde){
			try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Oops. Something went wrong. In removeGrozde.");
			}
		}
		this.grozde-=grozde;
		System.out.println(Thread.currentThread().getName() + " removed " + grozde + " grozde from bidon");
		this.notifyAll();
	}
}

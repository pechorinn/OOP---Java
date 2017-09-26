package warehouse;

public class Client extends Thread{

	private Shop sh;
	private String productName;
	
	public Client(Shop sh, String n) {
		this.sh = sh;
		this.productName = n;
	}

	@Override
	public void run() {
		while(true){
			sh.getProduct(productName, 3);
			System.out.println("Client bought 3 kg" + productName);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				System.out.println("ops");
			}
		}
	}
}

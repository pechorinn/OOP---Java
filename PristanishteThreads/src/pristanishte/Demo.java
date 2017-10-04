package pristanishte;

public class Demo {

	public static void main(String[] args) {
		
		DB_Insert db = new DB_Insert();
		Pristanishte pristanishte = new Pristanishte();

		for (int i = 1; i <= 50; i++) {
			pristanishte.akustirai(new Korab("Korab " + i));
		}
		try {
			Thread.sleep(60 * 1000);
		} catch (InterruptedException e) {
			System.out.println("Greshka");
		}

		DB_Insert.getCranesInfo();
		DB_Insert.getDocsInfo();
		DB_Insert.best();
	}
}

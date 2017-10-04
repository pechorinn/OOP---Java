package rakia;

public class Demo {

	public static void main(String[] args) {
		
		Koop koop = new Koop();
		Bidon bidon = new Bidon();
		Berachka mara = new Berachka(bidon, "Mara");
		Berachka sara = new Berachka(bidon, "Sara");
		Rakidjia kolio = new Rakidjia(bidon, koop, "Kolio");
		Shkembedjia stavri = new Shkembedjia(koop, "Stavri");
		mara.start();
		sara.start();
		kolio.start();
		stavri.start();
	}
}
	
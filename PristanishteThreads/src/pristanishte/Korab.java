package pristanishte;

import java.util.ArrayList;
import java.util.Random;

public class Korab {
	
	private String name;
	private ArrayList<Pratka> pratki;
	private int vremeZaRaztovarvane;
	
	public Korab(String name) {
		this.name = name;
		pratki = new ArrayList<Pratka>();
		pratki = generate();
	}
	
	private ArrayList<Pratka> generate() {
		int rand = new Random().nextInt(3)+1;
		ArrayList<Pratka> generirani = new ArrayList<Pratka>();
		for (int i = 0; i < rand; i++) {
			generirani.add(new Pratka(this));
		}
		this.vremeZaRaztovarvane = new Random().nextInt(10)+5;
		return generirani;
	}
	
	public ArrayList<Pratka> raztovari() {
		ArrayList<Pratka> raztovareni = pratki;
		this.pratki = null;
		this.vremeZaRaztovarvane = 0;
		return raztovareni;
	}
	
	public int getVreme(){
		return vremeZaRaztovarvane;
	}
	public String getName() {
		return name;
	}
}



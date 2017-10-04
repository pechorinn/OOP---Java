package pristanishte;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Kran extends Thread{
	
	static Pristanishte pristanishte;
	static ArrayList<ArrayBlockingQueue<Pratka>> skladove = new ArrayList<>();
	static ArrayList<Entry> entries;
	private int vreme;
	private boolean check = false;
	
	@Override
	public void run() {
		while(true){
			for(int i = 0; i < Pristanishte.getDokove().size(); i++){
				Queue<Korab> dok = Pristanishte.getDokove().get(i);
				Korab korab;
				synchronized(dok){
					if(dok.isEmpty()){
						continue;
					}
					korab = dok.peek();
					raztovariVSklada(korab.raztovari(), korab, i, this);
					vreme = korab.getVreme();
				}
				try {
					sleep(vreme*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dok.remove(korab);
			}
		}
	}
	
	private void raztovariVSklada(ArrayList<Pratka> pratki, Korab korab, int i, Kran kran){
		boolean rand = new Random().nextBoolean();
		int temp = rand ? 0 : 1;
		for(Pratka p : pratki){
			addEntry(p, korab, i, temp);
			try {
				Kran.skladove.get(temp).put(p);
				System.out.println("Beshe raztovarena pratka " + p.getNumber() + " ot korab " + korab.getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void addEntry(Pratka pratka, Korab korab, int i, int kran){
		Entry entry = new Entry(pratka.getNumber(), i, korab, kran);
		entries.add(entry);
		DB_Insert.getInstance().importEntry(entry);
	}
}



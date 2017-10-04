package pristanishte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Pristanishte {

	private Kran edno;
	private Kran dve;
	private Distributor ivan;
	private Distributor dragan;
	private static ArrayList<Queue<Korab>> dokove = new ArrayList<>();
	private ArrayList<ArrayBlockingQueue<Pratka>> skladove = new ArrayList<>();
	private static ArrayList<Entry> entries = new ArrayList<Entry>();

	public Pristanishte() {
		for (int i = 0; i < 5; i++) {
			dokove.add(new LinkedList<>());
		}
		for (int i = 0; i < 2; i++) {
			skladove.add(new ArrayBlockingQueue<>(5));
		}

		ivan = new Distributor(skladove.get(0));
		dragan = new Distributor(skladove.get(1));
		edno = new Kran();
		dve = new Kran();
		Kran.pristanishte = this;
		Kran.skladove = skladove;
		Kran.entries = entries;
		edno.start();
		dve.start();
		ivan.start();
		dragan.start();
	}

	public synchronized void akustirai(Korab korab) {
		int rand = new Random().nextInt(dokove.size());
		dokove.get(rand).offer(korab);
		System.out.println(korab.getName() + " akustira na dok nomer " + rand);
		notifyAll();
	}

	public static List<Queue<Korab>> getDokove() {
		return Collections.unmodifiableList(dokove);
	}
}

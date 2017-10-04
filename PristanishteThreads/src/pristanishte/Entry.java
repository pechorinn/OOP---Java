package pristanishte;

import java.time.LocalDateTime;

public class Entry {

	private long pratkaNomer;
	private int dok;
	private Korab korab;
	private int kran;
	private LocalDateTime time;

	public Entry(long pratkaNomer, int dok, Korab korab, int kran) {
		this.pratkaNomer = pratkaNomer;
		this.dok = dok;
		this.korab = korab;
		this.kran = kran;
		this.time = LocalDateTime.now();
	}

	public String getTime() {
		return time.toString();
	}

	public long getPratkaNomer() {
		return pratkaNomer;
	}

	public int getDok() {
		return dok;
	}

	public Korab getKorab() {
		return korab;
	}

	public int getKran() {
		return kran;
	}

}

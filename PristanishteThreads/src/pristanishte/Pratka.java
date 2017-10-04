package pristanishte;


public class Pratka {
	
	private static long uniqueId = 1000_000_000;
	
	private long idNumber;
	private Korab korab;

	public Pratka(Korab korab) {
		this.korab = korab;
		this.idNumber = ++uniqueId;
	}

	public long getNumber() {
		return idNumber;
	}

	public Korab getKorab() {
		return korab;
	}
}

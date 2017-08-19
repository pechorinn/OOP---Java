package musicfestival;

public abstract class Musician {

	private String name;

	public Musician(String name, Band band) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			this.name = "Musician";
		}
		for (int i = 0; i < band.getMusicians().length; i++) {
			if (band.getMusicians()[i] == null) {
				band.getMusicians()[i] = this;
				break;
			}
		}
	}

	public String getName() {
		return name;
	}

	
	public abstract String getInfo();
}

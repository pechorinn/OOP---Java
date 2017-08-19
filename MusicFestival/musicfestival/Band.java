package musicfestival;

public class Band {
	private String name;
	private Song[] songs;
	private Musician[] musicians;

	public Band(String name, int numberOfSongs, int numberOfmusicians) {
		this.name = name;
		this.songs = new Song[numberOfSongs];
		this.musicians = new Musician[numberOfmusicians];
	}

	public String getName() {
		return name;
	}

	public Song[] getSongs() {
		return songs;
	}
	

	public Musician[] getMusicians() {
		return musicians;
	}

	public void printInforSongs() {
		for (int i = 0; i < musicians.length; i++) {
			if (musicians[i] != null && !(musicians[i] instanceof Vocalist)) {
				System.out.println(musicians[i].getInfo());
			} else if (musicians[i] != null ) {
				System.out.println(musicians[i].getInfo());
				for (int k = 0; k < this.songs.length; k++) {
					System.out.println("          " + this.songs[k].getTitle());
					System.out.println(this.songs[k].getText());
				}
			}
		}

		System.out.println("-----------------------------------");
	}
}

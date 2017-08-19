package musicfestival;

public class MusicFestival {
	private String name;
	private Act[] acts;
	private String time;
	private String venue;

	public MusicFestival(String name, int participants, String time, String venue) {
		this.name = name;
		this.acts = new Act[participants];
		this.time = time;
		this.venue = venue;
	}

	public Act[] getActs() {
		return acts;
	}

	public void printGeneralInfo() {
		System.out.println("Musical Festival: " + this.name);
		System.out.println("When: " + this.time);
		System.out.println("Where: " + this.venue);
		System.out.println("Participants: ");
		for (int i = 0; i < acts.length; i++) {
			acts[i].printInfoForBand();
		}
	}

	public void printInfoForTheFestival() {
		for (int i = 0; i < acts.length; i++) {
			if (acts[i] != null) {
				System.out.println("\nBand: " + acts[i].getBand().getName()+"\n");
				acts[i].getBand().printInforSongs();
			}
		}
		System.out.println();
	}
}

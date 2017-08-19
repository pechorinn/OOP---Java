package musicfestival;

public class Act {
	
	private Band band;
	private String start;
	private String end;

	public Act(Band band, String start, String end, MusicFestival mf) {
		super();
		this.band = band;
		this.start = start;
		this.end = end;
		for (int i = 0; i < mf.getActs().length; i++) {
			if (mf.getActs()[i] == null) {
				mf.getActs()[i] = this;
				break;
			}
		}
	}

	public Band getBand() {
		return band;
	}
	
	public void printInfoForBand() {
		System.out.println(this.band.getName() + ", Starts at: " + this.start + ", Ends at: " + this.end);
	}
}

package musicfestival;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		
		MusicFestival x = new MusicFestival("New Festival", 4, "20.07.2017, 20:00", "Downtown");
		Band band1 = new Band("Band1", 3, 3);
		Band band2 = new Band("Band2", 2, 2);
		Act act = new Act(band1, "20:00", "21:00",x);
		Act act2 = new Act(band2, "21:00", "22:00",x);
		Act act3 = new Act(band1, "22:00", "23:00",x);
		Act act4 = new Act(band2, "23:00", "00:00",x);		
		Musician ivan = new Instrumentalist("Ivan", "quitar",band1);
	    Musician pesho = new Vocalist ("Petur", band1);
		Musician igor = new Instrumentalist("Igor", "quitar",band1);
	    Musician niki = new Instrumentalist("Niki", "quitar",band2);
		Musician goro = new Instrumentalist("Goro", "quitar",band2);
		
		band1.getSongs()[0] = new Song("Song 1", "Song text...");
		band1.getSongs()[1] = new Song("Song 2", "Song text...");
		band1.getSongs()[2] = new Song("Song 3", "Song text...");
		
		x.printInfoForTheFestival();
		x.printGeneralInfo();
		System.out.println(Arrays.toString(band2.getMusicians()));
		System.out.println(Arrays.toString(band1.getMusicians()));
	}
}



package musicfestival;

public class Vocalist extends Musician {
	
	public Vocalist (String name, Band band) {
		super(name,band);
	}
	
	public String getInfo () {
		return "Vocalist: " + super.getName();
	}
	
	@Override
	public String toString() {
		return getName() + " - vocalist";
	}
}

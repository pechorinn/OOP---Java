package court;

import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

import court.jurists.Jurist;

public class Court {
	
	private String name;
	private String address;
	private ArrayList<Jurist> lica;
	private ArrayList<Case> dela;
	
	public Court(String name, String address, ArrayList<Jurist> lica, ArrayList<Case> dela) {
		//TODO validation
		this.name = name;
		this.address = address;
		this.lica = lica;
		this.dela = dela;
	}
	

	
	@Override
	public String toString() {
		return lica.toString();
	}
	
}

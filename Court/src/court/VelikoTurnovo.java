package court;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import court.citizens.Accuser;
import court.citizens.Citizen;
import court.citizens.Defendant;
import court.citizens.Witness;
import court.jurists.Judge;
import court.jurists.Jurist;
import court.jurists.Jury;
import court.jurists.Lawyer;
import court.jurists.Procecutor;

public class VelikoTurnovo {

	public static void main(String[] args) {

		ArrayList<Jurist> lica = new ArrayList<>();
		ArrayList<Lawyer> listLawyers = new ArrayList<>();
		ArrayList<Judge> listJudges = new ArrayList<>();
		ArrayList<Procecutor> listProcecutors = new ArrayList<>();
		ArrayList<Jury> listJuries = new ArrayList<>();
		

		for (int i = 0; i < 10; i++) {
			Jurist judge = new Judge("Judge " + i, 3, 10);
			lica.add(judge);
			listJudges.add((Judge) judge);
		}
		for (int i = 0; i < 60; i++) {
			Jurist jury = new Jury("Jury " + i, 2, 50);
			lica.add(new Jury("Jury " + i, 2, 50));
			listJuries.add((Jury) jury);
		}
		for (int i = 0; i < 15; i++) {
			Jurist lawyer = new Lawyer("Lawyer " + i, 15, 100);
			lica.add(lawyer);
			listLawyers.add((Lawyer) lawyer);
		}
		
		for (int i = 0; i < 5; i++) {
			Jurist procecutor = new Procecutor("Procecutor " + i, 12, 300);
			lica.add(procecutor);
			listProcecutors.add((Procecutor) procecutor);
		}

		ArrayList<Citizen> grajdani = new ArrayList<>();
		ArrayList<Accuser> accusers = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			ArrayList<Lawyer> lawyerList = new ArrayList<>();
			lawyerList.add((Lawyer) listLawyers.remove(new Random().nextInt(listLawyers.size())));
			Accuser accuser = new Accuser("Accuser " + i, 44, "Kilifarevo", lawyerList);
			grajdani.add(accuser);
			accusers.add(accuser);
		}
		ArrayList<Defendant> defendants = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ArrayList<Lawyer> lawyerList = new ArrayList<>();
			lawyerList.add((Lawyer) listLawyers.remove(new Random().nextInt(listLawyers.size())));
			Defendant defendant = new Defendant("Defendant " + i, 22, "Gabrovo", lawyerList);
			grajdani.add(defendant);
			defendants.add(defendant);
		}
		
		ArrayList<Witness> witnesses = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Witness witness = new Witness("Baba " + i, 82, "Gabrovo");
			grajdani.add(witness);
			witnesses.add(witness);
		}
		
		ArrayList<Case> dela = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			ArrayList<Jury> jury = new ArrayList<>();

			for(int j = 0; j < 3; j++) {
				jury.add((Jury) listJuries.remove(j));
			}
			 dela.add(new CivilCase(listJudges.remove(new Random().nextInt(listJudges.size())), jury , accusers.remove(new Random().nextInt(accusers.size())), witnesses,
			defendants.remove(new Random().nextInt(defendants.size()))));
		}
		for (int i = 0; i < 3; i++) {
			ArrayList<Jury> jury = new ArrayList<>();
			for(int j = 0; j < 13; j++) {
				jury.add((Jury) listJuries.remove(j));
			}
			 dela.add(new CriminalCase(listJudges.remove(new Random().nextInt(listJudges.size())), jury, listProcecutors.get(new Random().nextInt(listProcecutors.size())), witnesses,
					 defendants.remove(new Random().nextInt(defendants.size()))));
		}
		Court c = new Court("vt", "vt", lica, dela);

		for (int i = 0; i < dela.size(); i++) {
			dela.get(i).execute();
		}
		
		Collections.sort(lica, (p1, p2) -> p1.getName().compareTo(p2.getName()));
		System.out.println(c);
		
	}
}

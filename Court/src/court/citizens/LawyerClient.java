package court.citizens;

import java.util.ArrayList;

import court.IAccuser;
import court.jurists.Lawyer;

public abstract class LawyerClient extends Citizen{
	
	static {
		IAccuser.questions.add("Kъде беше тази нощ?");
		IAccuser.questions.add("Kаква е твоята версия на събитията?");
		IAccuser.questions.add("Заплашвал ли се пострадалия преди случката?");
		IAccuser.questions.add("Ti men vijdash li me?");
	}

	protected ArrayList<Lawyer> lawyers;
	
	public LawyerClient(String names, int age, String address, ArrayList<Lawyer> lawyers) {
		super(names, age, address);
		this.lawyers = lawyers;
	}
	
	public ArrayList<Lawyer> getLawyers() {
		return lawyers;
	}

}

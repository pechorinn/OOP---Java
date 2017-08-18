package court;

import java.util.ArrayList;
import java.util.Random;

public interface IAccuser {

	ArrayList<String> questions = new ArrayList();
	
	static String getRandomQuestion(){
		//fill list
		return questions.get(new Random().nextInt(questions.size()));
	}
		
	void askQuestion();
}

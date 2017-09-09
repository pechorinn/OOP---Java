package employee;

import docs.Document;
import docs.RegularDocument;

public class Junior extends Employee {

	public Junior() {
		super(Rang.JUNIOR, rnd.nextInt(500)+1000);
	}

	@Override
	public void handleDocument(Document doc) {

		if(doc instanceof RegularDocument) {
			System.out.println("The employee " + name + " is handling document " + doc.getTitle());
			
			if((rnd.nextInt(101) < 80 && doc.getDifficulty() > 10 || (rnd.nextInt(101) > 80 && doc.getDifficulty() <= 10))) {
				messedDocuments++;
				allMisshandled.add(doc);
				System.out.println("Document was NOT handled properly.");
			}else {
				System.out.println("Document was handled properly.");
			}
			doc.changeStatus();
			docs.add(doc);
			
		} else {
			System.out.println("Junior cannot handle secret document.");
		}
	}

	@Override
	public void sackTheWorsePerformer() {
		
	}

	@Override
	public void giveDocumentToSomeoneElse(Document doc) {
		
	}
	
	

}

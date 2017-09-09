package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import docs.Document;
import docs.RegularDocument;
import docs.SecretDocument;

public class Regular extends Employee implements IHandleSecretDocs {

	public Regular() {
		super(Rang.REGULAR, rnd.nextInt(2000) + 1200);
	}

	@Override
	public void handleDocument(Document doc) {

		System.out.println("The employee " + name + " is handling document " + doc.getTitle());

		int probability = rnd.nextInt(101);
		if (probability >= 80 && doc.getDifficulty() > 15) {
			messedDocuments++;
			allMisshandled.add(doc);
			System.out.println("Document was NOT handled properly.");
		} else {
			if (doc instanceof SecretDocument) {
				getPassword((SecretDocument) doc);
			}
			System.out.println("Document was handled properly.");
		}
		doc.changeStatus();
		docs.add(doc);
	}

	@Override
	public void sackTheWorsePerformer() {

	}

	@Override
	public void giveDocumentToSomeoneElse(Document doc) {

		ArrayList<Employee> employeesInDepartment = new ArrayList<>(myDepartment.getEmployees());
		Collections.shuffle(employeesInDepartment);

		if (doc instanceof RegularDocument) {
			for (Employee emp : myDepartment.getEmployees()) {
				if (emp instanceof Junior) {
					System.out.println("The employee " + name + " reassignes regular document " + doc.getTitle()
							+ " to employee " + emp.name);
					emp.handleDocument(doc);
					break;
				}
			}
			
		}  else {
			System.out.println("Cannot reassign secret document to junior.");
			System.out.println("The document will be handled by the employee himself/herself.");
			handleDocument(doc);
		}
	}

}

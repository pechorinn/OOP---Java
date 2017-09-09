package employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import docs.Document;
import docs.RegularDocument;
import docs.SecretDocument;

public class Senior extends Employee implements IHandleSecretDocs {

	private final static double SALARY_INCREASE_RATE = 5;

	public Senior() {
		super(Rang.SENIOR, rnd.nextInt(3000) + 1500);
	}

	@Override
	public void handleDocument(Document doc) {

		System.out.println("The employee " + name + " is handling document " + doc.getTitle());

		int probability = rnd.nextInt(101);
		if (probability >= 90 && doc instanceof RegularDocument && doc.getDifficulty() < 18) {
			messedDocuments++;
			allMisshandled.add(doc);
			System.out.println("Document was NOT handled properly.");
		} else if (probability >= 80 && doc instanceof SecretDocument && doc.getDifficulty() < 19) {
			messedDocuments++;
			System.out.println("Document was NOT handled properly.");

		} else if (doc instanceof SecretDocument) {
			System.out.println("The password of the document is: ");
			getPassword((SecretDocument) doc);
			System.out.println("Document was handled properly.");
		}

		doc.changeStatus();
		docs.add(doc);

	}

	@Override
	public void sackTheWorsePerformer() {
		System.out.println("The employee " + name + " is checking who has to be sacked...");
		int maxErrors = 0;
		Employee employeeToBeSacked = null;
		for (Employee empl : myDepartment.getEmployees()) {
			if (empl.getMessedUpDocs() > maxErrors) {
				maxErrors = empl.getMessedUpDocs();
				employeeToBeSacked = empl;
			}
		}
		if(employeeToBeSacked != null) {
		System.out.println("The employee with highest number of misshandled docs is " + employeeToBeSacked.name);
		System.out.println(employeeToBeSacked);
		myDepartment.removeEmployee(employeeToBeSacked);
		} else {
			System.out.println("None of the employees has misshanled docs. No one's got the sack.");
		}
	}

	@Override
	public void giveDocumentToSomeoneElse(Document doc) {

		ArrayList<Employee> employeesInDepartment = new ArrayList<>(myDepartment.getEmployees());
		Collections.shuffle(employeesInDepartment);
		if (doc instanceof RegularDocument) {
			for (Employee emp : employeesInDepartment) {
				if (emp instanceof Junior) {
					System.out.println("The employee " + name + " reassignes regular document " + doc.getTitle()
							+ " to employee " + emp.name);
					emp.handleDocument(doc);
					emp.setSalaryIncrease(SALARY_INCREASE_RATE);
					break;
				}
			}

		} else {
			List<Employee> filtered = employeesInDepartment.stream().filter(empl -> empl instanceof Regular).collect(Collectors.toList());
			for (Employee emp : filtered) {
				if (emp instanceof Regular && doc instanceof SecretDocument) {
					System.out.println("The employee " + name + " reassignes secrtet document " + doc.getTitle()
							+ " to employee " + emp.name);
					emp.handleDocument(doc);
					emp.setSalaryIncrease(SALARY_INCREASE_RATE);
					System.out.println(emp.getName() + " gets a salary increase.");
					break;
				}
			}
		}
	}

}

package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import docs.Document;
import docs.RegularDocument;
import docs.SecretDocument;
import employee.Employee;
import employee.IHandleSecretDocs;
import employee.Junior;
import employee.Regular;
import employee.Senior;
import firm.Firm;

public class Demo {

	private static Random rnd = new Random();

	public static void main(String[] args) {

		Firm firm = new Firm("Audit_BG");

		ArrayList<String> departments = new ArrayList<>();
		departments.add("Olimp");
		departments.add("Vitosha");
		departments.add("Hemus");
		departments.add("Everest");
		departments.add("MontBlank");

		for (int i = 0; i < 5; i++) {
			firm.addEmployee(departments.get(i % 5), new Senior());
			firm.addEmployee(departments.get(i % 5), new Junior());
			firm.addEmployee(departments.get(i % 5), new Junior());
			firm.addEmployee(departments.get(i % 5), new Regular());
		}

		Employee junior = new Junior();
		firm.addEmployee("Vitosha", junior);
		firm.printAllDepartments();

		ArrayList<Document> docs = new ArrayList<>();

		for (int i = 0; i < 50; i++) {

			if (i < 30) {
				docs.add(new RegularDocument());
			} else {
				docs.add(new SecretDocument(String.valueOf(rnd.nextInt(1000_000) + 10_000)));
			}
		}

		for (int i = 0; i < docs.size(); i++) {
			firm.giveDocumentForHandling(docs.get(i));
		}

		ArrayList<Document> docs1 = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			if (i < 7) {
				docs1.add(new RegularDocument());
				randomEmployeeDocReassignment(docs1.get(i), firm);
			} else {
				docs1.add(new SecretDocument(String.valueOf(rnd.nextInt(1000_000) + 10_000)));
				randomEmployeeDocReassignment(docs1.get(i), firm);
			}
		}
		
		List <Employee> employees = firm.getAllEmployees();
		
		for (int i = 0; i < 5; i++) {
			int random = rnd.nextInt(firm.getAllEmployees().size());
			System.out.println("================================================");
			employees.get(random).printTotalMisshandledDocsOrderdByTitle();
			employees.get(random).printTotalNumberOfMisshandledDocs();
			employees.get(random).printTotalNumberOfProperlyHandledDocs();
			employees.get(random).printTotalNumberOfHandledDocs();
			System.out.println("================================================");
		}
		
		List<Employee> filtered = employees.stream().filter(empl -> empl instanceof Senior).collect(Collectors.toList());
        Collections.shuffle(filtered);
		for (int i = 0; i < 5; i++) {
			filtered.get(i).sackTheWorsePerformer();
		}
		
		firm.printAllHandledDocumentsSortedByDifficulty();
		firm.sumOfAllSalariesOnMonthlyBases();
		firm.printEmployeeWithTheLowestNumberMisshandledDocs();
		firm.printDepartmentWithTheHighestNumberMisshandledDocs();
		
		
		List<Employee> employees1 = new ArrayList<>(firm.getAllEmployees());
		
		employees1.sort((emp1, emp2) -> emp1.getMessedUpDocs() - emp2.getMessedUpDocs());
		
		System.out.println("Below three employees are from the group of employees that have made no mistakes while handling docs.");
		for (int i = 0; i < 3; i++) {
		System.out.println(employees1.get(i));
		}
				
	}

	private static void randomEmployeeDocReassignment(Document doc, Firm firm) {
		Employee empl = null;
		while (empl == null) {
			int random = rnd.nextInt(firm.getAllEmployees().size());
			if (firm.getAllEmployees().get(random) instanceof IHandleSecretDocs) {
				empl = firm.getAllEmployees().get(random);
				empl.giveDocumentToSomeoneElse(doc);
			}
		}
	}
	
}

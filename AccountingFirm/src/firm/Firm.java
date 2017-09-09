package firm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import department.Department;
import docs.Document;
import employee.Employee;
import employee.Employee.Rang;

public class Firm {

	private TreeMap<String, Department> departments;
	private String name;

	public Firm(String name) {
		super();
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
		this.departments = new TreeMap<>();
		System.out.println("A company " + name + " created.");
	}

	public void addEmployee(String departName, Employee emp) {

		if (departments.size() == 5 && !departments.containsKey(departName)) {
			System.out.println("No more than five departments are allowed.");
			return;
		}
		if (!departments.containsKey(departName) && emp.getRang() == Rang.SENIOR) {
			removeFromDepartmentIfAlreadyHasOne(emp);
			departments.put(departName, new Department(departName));
			departments.get(departName).addEmployee(emp);

		} else if (!departments.containsKey(departName) && emp.getRang() != Rang.SENIOR) {
			System.out.println("The first employee added to the department must be senior.");
		} else {
			removeFromDepartmentIfAlreadyHasOne(emp);
			departments.get(departName).addEmployee(emp);
		}
		emp.setMyDepartment(departments.get(departName));
	}

	private void removeFromDepartmentIfAlreadyHasOne(Employee emp) {
		if (emp.getMyDepartment() != null) {
			System.out.println("Emploee " + emp.getName() + " was removed from " + emp.getMyDepartment());
			emp.getMyDepartment().remove(emp);
		}
	}

	public List<Employee> getAllEmployees() {

		ArrayList<Employee> allEmployees = new ArrayList<>();
		for (Department dep : departments.values()) {
			allEmployees.addAll(dep.getEmployees());
		}
		return Collections.unmodifiableList(allEmployees);
	}

	public void giveDocumentForHandling(Document doc) {
		Random rnd = new Random();

		List<Employee> allEmployees = getAllEmployees();

		int randomEmployee = rnd.nextInt(allEmployees.size());
		allEmployees.get(randomEmployee).handleDocument(doc);
		System.out.println("The document will be handled by " + allEmployees.get(randomEmployee).getName());

	}

	public void printAllHandledDocumentsSortedByDifficulty() {
		List<Employee> allEmployees = getAllEmployees();

		ArrayList<Document> arrayListDocs = new ArrayList<>();

		for (Employee empl : allEmployees) {
			arrayListDocs.addAll(empl.getDocs());
		}

		arrayListDocs.sort((a, b) -> a.getDifficulty() - b.getDifficulty());

		for (Document doc : arrayListDocs) {
			System.out.println(doc);
		}
	}

	public void sumOfAllSalariesOnMonthlyBases() {

		List<Employee> allEmployees = getAllEmployees();
		double sum = 0;

		for (Employee empl : allEmployees) {
			sum += empl.getSalary();
		}

		String sumFormated = String.format("%.2f$", sum);
		System.out.println("=======================================================");
		System.out.println("Total amount of paid salaries in one month: " + sumFormated);
		System.out.println("=======================================================");

	}

	public void printEmployeeWithTheLowestNumberMisshandledDocs() {
        List<Employee> modifiable = new ArrayList<>(getAllEmployees());
        modifiable.sort((a,b) -> a.getMessedUpDocs() - b.getMessedUpDocs());
		System.out.println("One of the employees with the lowest amount of misshandled docs: "
				+ modifiable.get(0));
		System.out.println("---------------------------------------");
		
	}

	public void printDepartmentWithTheHighestNumberMisshandledDocs() {

		Department currentDepartment = null;
		int currentTotalMisshandledDocs = 0;
		Department departmentWithHighestNumberMisshandledDocs = null;
		int totalMisshandledDocs = 0;

		for (Entry<String, Department> entry : departments.entrySet()) {
			currentDepartment = departments.get(entry.getKey());
			for (Employee emp : departments.get(entry.getKey()).getEmployees()) {
				currentTotalMisshandledDocs += emp.getMessedUpDocs();
			}

			if (currentTotalMisshandledDocs > totalMisshandledDocs) {
				totalMisshandledDocs = currentTotalMisshandledDocs;
				departmentWithHighestNumberMisshandledDocs = currentDepartment;
			}
			currentTotalMisshandledDocs = 0;
		}
		System.out.println("---------------------------------------");
		System.out.println("Department with highest number of misshandled docs: " + departmentWithHighestNumberMisshandledDocs);
		System.out.println("Total number of misshandled docs: " + totalMisshandledDocs);
		System.out.println("---------------------------------------");

	}

	@Override
	public String toString() {
		return "Firm [departments=" + departments + ", name=" + name + "]";
	}

	public void printAllDepartments() {

		for (Entry<String, Department> entry : departments.entrySet()) {
			System.out.println("Department: " + entry.getKey());
			for (Employee emp : departments.get(entry.getKey()).getEmployees()) {
				System.out.println(emp);
			}
			System.out.println("---------------------------------------");
		}
	}
}

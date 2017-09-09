package employee;


import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import department.Department;
import docs.Document;

public abstract class Employee {

	public enum Rang {
		JUNIOR, SENIOR, REGULAR
	}

	protected String name;
	protected Rang rang;
	protected int messedDocuments;
	protected double salary;
	protected Set<Document> docs;
	protected int id;
	protected static int idNumber = 0;
	protected static Random rnd = new Random();
	protected Set<Document> allMisshandled;
	protected Department myDepartment;
	
	public Employee(Rang rang, double salary) {
		super();
		this.id = ++idNumber;
		this.rang = rang;
		this.name = rang.toString() + " " + id;
		this.messedDocuments = 0;
		this.salary = salary;
		this.docs = new HashSet<>();
		this.allMisshandled = new TreeSet<>((a,b) -> a.getTitle().compareTo(b.getTitle()));
		
	}

	public abstract void handleDocument(Document doc);

	public void printTotalNumberOfHandledDocs() {
		System.out.println("Total number of handled document/s of the employee " + name + ": " + docs.size());
	}
	
	public void printTotalNumberOfMisshandledDocs() {
		System.out.println("Total number of mishandled document/s of the employee " + name + ": " + messedDocuments);
	}
	
	public void printTotalNumberOfProperlyHandledDocs() {
		System.out.println("Total number of properly handled document/s of the employee " + name + ": " + (docs.size() - messedDocuments));
	}
	
	public void printTotalMisshandledDocsOrderdByTitle() {
		System.out.println("Please find below all docs misshandled ordered by title for employee: " + name);
		for(Document doc : allMisshandled) {
			System.out.println(doc);
		}
	}
	
	public abstract void sackTheWorsePerformer();

	public int getMessedUpDocs() {
		return messedDocuments;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", rang=" + rang + ", salary=" + salary + ", id=" + id + ", allMisshandled="
				+ allMisshandled + ", myDepartment=" + myDepartment + "]";
	}
	
	public abstract void giveDocumentToSomeoneElse(Document doc);

	public void setSalaryIncrease(double i) {
		
		salary += (salary * i/100);
		
	}

	
	

	public Rang getRang() {
		
		return rang;	
	}

	public String getName() {
		return name;
	}

	public Set<Document> getDocs() {
		return docs;
	}

	public Department getMyDepartment() {
		return myDepartment;
	}

	public void setMyDepartment(Department department) {

		myDepartment = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allMisshandled == null) ? 0 : allMisshandled.hashCode());
		result = prime * result + ((docs == null) ? 0 : docs.hashCode());
		result = prime * result + id;
		result = prime * result + messedDocuments;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rang == null) ? 0 : rang.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (allMisshandled == null) {
			if (other.allMisshandled != null)
				return false;
		} else if (!allMisshandled.equals(other.allMisshandled))
			return false;
		if (docs == null) {
			if (other.docs != null)
				return false;
		} else if (!docs.equals(other.docs))
			return false;
		if (id != other.id)
			return false;
		if (messedDocuments != other.messedDocuments)
			return false;
		if (myDepartment == null) {
			if (other.myDepartment != null)
				return false;
		} else if (!myDepartment.equals(other.myDepartment))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rang != other.rang)
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	public double getSalary() {
		return salary;
	}
	
	
}

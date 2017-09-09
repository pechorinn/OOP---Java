package department;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import employee.Employee;

public class Department implements Comparable<Department>{
	
	protected String name;
	protected Set<Employee> employees;
	
	
	public Department(String name) {
		super();
		
		this.name = name;
		this.employees = new HashSet<>();
	}
	
	public Set<Employee> getEmployees() {
		return Collections.unmodifiableSet(employees);
	}

	@Override
	public int compareTo(Department dep) {
		
		return this.name.compareTo(dep.name);
	}

	
	public void removeEmployee(Employee emp) {
		employees.remove(emp);
	}

	public void addEmployee(Employee emp) {
		employees.add(emp);
		System.out.println("Employee " + emp.getName() + " added to the department " + name);
	}

	@Override
	public String toString() {
		return "Department name: " + name;
	}

	public void remove(Employee emp) {
            employees.remove(emp);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employees == null) ? 0 : employees.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Department other = (Department) obj;
		if (employees == null) {
			if (other.employees != null)
				return false;
		} else if (!employees.equals(other.employees))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

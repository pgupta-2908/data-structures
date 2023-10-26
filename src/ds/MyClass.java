package ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyClass {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		Employee e1 = new Employee("1", "Aa", "Fin", 10000);
		Employee e2 = new Employee("2", "Bb", "Fin", 20000);
		Employee e3 = new Employee("3", "Cc", "Fin", 30000);
		Employee e4 = new Employee("4", "Dd", "Dev", 40000);
		Employee e5 = new Employee("5", "Ee", "Dev", 5000);
		Employee e6 = new Employee("6", "Ff", "Dev", 6000);
		Employee e7 = new Employee("7", "Gg", "Fin", 70000);
		Employee e8 = new Employee("8", "Hh", "Fin", 80000);
		Employee e9 = new Employee("9", "Ii", "Fin", 9000);
		Employee e10 = new Employee("10", "Jj", "Fin", 100000);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		list.add(e7);
		list.add(e8);
		list.add(e9);
		list.add(e10);

		List<Employee> finalList = list.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		for (Employee e : finalList) {
			System.out.println(e);
		}
	}

}

class Employee {
	private String id;
	private String name;
	private String department;
	private int salary;

	public Employee() {
	}

	public Employee(String id, String name, String department, int salary) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setId(int salary) {
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getSalary() {
		return salary;
	}

	public String toString() {
		return "Employee = [" + "id: " + this.id + ", name: " + this.name + ", department: " + this.department
				+ ", salary: " + this.salary + "]";
	}

}

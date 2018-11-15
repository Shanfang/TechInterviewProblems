package domain;

public class Employee {
	String name;
	int id;
	String department;
	boolean working;
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", department=" + department + ", working=" + working + "]";
	}

	public Employee(String name, int id, String department, boolean working) {
		super();
		this.name = name;
		this.id = id;
		this.department = department;
		this.working = working;
	}
	
	
}

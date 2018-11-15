package client;

import java.util.ArrayList;
import java.util.List;

import domain.Employee;
import domain.IndividualContributer;

public class EmployeeDAO {
	List<Employee> employees;
	public EmployeeDAO() {
		this.employees = new ArrayList<Employee> ();
	}
	public void populateEmployees() {
		Employee e1 = new IndividualContributer("Sophia1", 1, "Tech", true);
		Employee e2 = new IndividualContributer("Sophia2", 2, "Tech", true);
		Employee e3 = new IndividualContributer("Sophia3", 3, "Tech", true);
		Employee e4 = new IndividualContributer("Sophia4", 4, "Tech", true);

		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
	}
	public List<Employee> getAllEmployees() {
		return employees;
	}
}

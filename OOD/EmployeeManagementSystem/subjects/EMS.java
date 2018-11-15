package subjects;

import java.util.ArrayList;
import java.util.List;

import client.EmployeeDAO;
import domain.Employee;
import observers.IObserver;

public class EMS implements ISubject {
	private List<IObserver> observers;
	private List<Employee> employees;
	private EmployeeDAO employeeDao;
	private Employee employee;
	private String msg;
	
	public EMS(){
		observers = new ArrayList<IObserver>();
		employeeDao = new EmployeeDAO();
		employees = employeeDao.getAllEmployees();
	}
	
	public void registerObserver(IObserver o) {
		observers.add(o);
	}
	
	public void removeObserver(IObserver o) {
		observers.remove(o);
	}
	
	public void notifyAllObservers() {
		for (IObserver department : observers) {
			department.callMe(this.employee);
		}
	}
	
//	public void addSubscriber(IObserver subscriber) {
//		observers.add(subscriber);
//	}
//	
	public void hireNew(Employee e) {
		this.employee = e;
		notifyAllObservers();
	}
//	
//	private void notifyAllDepartments(Employee e) {
//		for (IObserver observer : observers) {
//			observer.callMe(e);
//		}
//	}
}

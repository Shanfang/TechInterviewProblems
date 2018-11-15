package app;

import domain.Employee;
import domain.IndividualContributer;
import observers.HRDepartment;
import observers.IObserver;
import observers.TechDepartment;
import subjects.EMS;
import subjects.ISubject;

public class App {
	public static void main(String[] args) {
		IObserver tech = new TechDepartment();
		IObserver hr = new HRDepartment();
		
		ISubject ems = new EMS();
		ems.registerObserver(tech);
		ems.registerObserver(hr);
		
		Employee e = new IndividualContributer("Sophia0", 0, "Tech", true);
		ems.hireNew(e);
	}
}

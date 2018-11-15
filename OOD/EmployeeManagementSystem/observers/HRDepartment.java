package observers;

import domain.Employee;

public class HRDepartment implements IObserver {

	@Override
	public void callMe(Employee e) {
		System.out.println("Get a message in HR department " + e);		
	}

}

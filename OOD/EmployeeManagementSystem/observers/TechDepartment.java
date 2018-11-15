package observers;

import domain.Employee;

public class TechDepartment implements IObserver {

	@Override
	public void callMe(Employee e) {
		System.out.println("Get a new message in Tech Department " + e);		
	}

}

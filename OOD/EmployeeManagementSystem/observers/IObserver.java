package observers;

import domain.Employee;

public interface IObserver {
	void callMe(Employee e);
}

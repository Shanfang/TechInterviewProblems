package subjects;

import domain.Employee;
import observers.IObserver;

public interface ISubject {
	public void registerObserver(IObserver o);
	public void removeObserver(IObserver o);
	public void notifyAllObservers();
	public void hireNew(Employee e);
}

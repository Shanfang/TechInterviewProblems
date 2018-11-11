package devices;

public class Projecter implements Device{

	@Override
	public void turnOn() {
		System.out.println("Turn on the projecter");
	}

	@Override
	public void turnOff() {
		System.out.println("Turn off the projector");
		
	}

	@Override
	public String toString() {
		return "Projecter";
	}
	

}

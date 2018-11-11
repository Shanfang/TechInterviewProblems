package devices;

public class TV implements Device {

	@Override
	public void turnOn() {
		System.out.println("Turn on the TV");
	}

	@Override
	public void turnOff() {
		System.out.println("Turn off the TV");
	}

	@Override
	public String toString() {
		return "TV";
	}

}

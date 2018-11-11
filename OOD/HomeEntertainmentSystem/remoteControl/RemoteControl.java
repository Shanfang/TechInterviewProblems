package remoteControl;

import devices.Device;

public class RemoteControl {
	private Device device = null;
	private static RemoteControl INSTANCE = null;
	private RemoteControl() {
		
	}
	
	public static RemoteControl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RemoteControl();
		}
		return INSTANCE;
	}
	
	public void chooseDevice(Device d) {
		this.device  = d;
		System.out.println("Current device is " + d);
	}


	public void turnOnDevice() {
		device.turnOn();
	}
	
	public void turnOffDevice() {
		device.turnOff();
	}
}

package clients;

import devices.Projecter;
import devices.SurroundSoundSystem;
import devices.TV;
import remoteControl.RemoteControl;

public class Person {
	public static void main(String[] args) {
		TV myTV = new TV();
		Projecter myProjecter = new Projecter();
		SurroundSoundSystem mySoundSystem = new SurroundSoundSystem();
		
		RemoteControl remote = RemoteControl.getInstance();
		//remote.chooseDevice(myTV);
		remote.chooseDevice(mySoundSystem);
		
		remote.turnOnDevice();
		remote.turnOffDevice();
	}
}

package devices;

public class SurroundSoundSystem implements Device {

	@Override
	public void turnOn() {
		System.out.println("Turn on the surround sound system");
		switchToFavoriteCD();
		increaseVolume();
		
	}

	private void switchToFavoriteCD() {
		System.out.println("Playing my favorite music!!");
	}
	
	private void increaseVolume() {
		System.out.println("Increase the volume to a comfortable level");
	}
	
	
	@Override
	public void turnOff() {
		System.out.println("Turn off the surround sound system");
		decreseVolume();	
	}
	
	private void decreseVolume() {
		System.out.println("Decrease the volume until there is no soud");
	}

	@Override
	public String toString() {
		return "SurroundSoundSystem";
	}

}

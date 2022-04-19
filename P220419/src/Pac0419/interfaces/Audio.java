package Pac0419.interfaces;

public class Audio implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다");
	}

	@Override
	public void volumeUp() {
		System.out.println("Audio의 Volume을 올립니다");
	}

	@Override
	public void volumeDown() {
		System.out.println("Audio의 Volume을 내립니다");
	}

}

package Pac0419.interfaces;

// 인터페이스를 구현하는 구현객체(구현클래스). 인터페이스 쓸거면 필수 동반 요소
public class Television implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("TV를 끕니다");
	}

	@Override
	public void volumeUp() {
		System.out.println("TV의 Volume을 올립니다");
	}

	@Override
	public void volumeDown() {
		System.out.println("TV의 Volume을 내립니다");
	}

}

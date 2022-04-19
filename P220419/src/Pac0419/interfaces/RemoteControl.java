package Pac0419.interfaces;
// abstract랑 용도 비슷한데 abstract는 클래스고 이건 "상수"로 조짐
public interface RemoteControl {
	// 상수
	public static final int MAX_VOLUME = 10;
	
	public void turnOn(); // 추상메소드
	public void turnOff(); 
	public void volumeUp(); 
	public void volumeDown(); 
	public default void adjustScreen() {
		System.out.println("화면을 조정합니다");
	}
	
	public static void changeBattery() {
		System.out.println("건전지를 교환합니다");
	}

}

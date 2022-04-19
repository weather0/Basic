package Pac0419.interfaces;

public class RemoteExample {
	public static void main(String[] args) {
		// 상속관계에서는 부모클래스의 참조변수 자식클래스의 인스턴스가 할당
		
//		RemoteControl rc = new RemoteControl(); // 인터페이스는 이렇게 호출 불가. 하려면 익명구현객체 사용해야함(Runnable예제)
		RemoteControl rc = null;
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		rc.volumeUp();
		rc.volumeDown();
		
		rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		rc.volumeUp();
		rc.volumeDown();
		
		RemoteControl.changeBattery();
		
	}

}

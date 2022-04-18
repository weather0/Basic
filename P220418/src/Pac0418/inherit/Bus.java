package Pac0418.inherit;

public class Bus extends Car {
	// 필드
	String busNo; // 개인택시, 회사택시
	
	// 생성자
	public Bus() {
		super(); // '부모'가 가진 필드나 속성을 의미
		System.out.println("Bus() 생성자 호출");
	}
	
	// 메서드
	public void fee() {
		System.out.println("요금을 받습니다");
	}
	@Override // 이 어노테이션을 붙이면 부모메서드와 불일치시 알려줌. 우클릭-소스-오버라이드
	public void drive() { // 이 자식클래스에서 drive 메서드를 재정의
		System.out.println("버스가 운행합니다");
	}

	@Override
	public String toString() { // 이 자식클래스에서 toString메서드를 재정의
		return "Bus [busNo=" + busNo + ", model="+ super.model +"]"; 
	}
	
	

}

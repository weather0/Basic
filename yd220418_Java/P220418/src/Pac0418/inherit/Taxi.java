package Pac0418.inherit;

public class Taxi extends Car {
	// 필드
	String type; // 개인택시, 회사택시
	
	// 생성자
	public Taxi() {
		System.out.println("Taxi() 생성자 호출");
	}
	
	// 메서드
	public void metering() {
		System.out.println("요금계기판");
	}
//	@Override
//	public void drive() {
//		System.out.println("택시가 운행합니다");
//	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		super.drive();
	}

	@Override
	public String toString() { // 우클릭-소스-오버라이드-Object클래스(Car의 부모)-toString 또는 그냥 우클릭-소스-Generate toSting으로 바로 가능
		// TODO Auto-generated method stub
		return super.toString(); // super뜻: 부모의 속성 그대로를 의미
	}

	
	
	
	
	
}

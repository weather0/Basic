package Pac0418.inherit;

public class CarExample {
	public static void main(String[] args) {
		Bus bus = new Bus(); // 부모생성자와 자식생성자 둘 다 호출됨
		// 부모에게 상속받은 필드, 메소드
		bus.model = "45인승버스";
		bus.drive(); // 오버라이딩: 부모와 똑같은 drive지만 자식클래스에서 재정의됨(덮어씀)
		
		// 자식에서 새로 필드, 메소드
		bus.busNo = "240";
		bus.fee();
		System.out.println(bus.toString());
		
		Taxi taxi = new Taxi();
		taxi.model = "SonanaTaxi";
		taxi.drive(); // 오버라이딩
		System.out.println(taxi.toString());
		
		taxi.type = "개인택시";
		taxi.metering();
		
		// 자식클래스의 인스턴스 -> 부모 참조변수 할당 가능
		Bus[] buses = new Bus[10];
		Taxi[] taxies = new Taxi[10];
		
		Car[] cars = new Car[10];
		cars[0] = bus; // promotion자동현변환됨
		cars[1] = taxi;
		
	
		
		
		
	}

}

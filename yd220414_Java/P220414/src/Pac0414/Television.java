package Pac0414;
// 객체 -> 도면 -> 텔레비전(삼성,엘지)
// Object -> Class -> Instance
// 추상화(텔레비전 모든 속성x -> 필요한 부분)
public class Television {
	// 속성(필드)
	String company;
	String model;
	int price;
	String color;
	
	// 기능(메서드): 반환유형 메소드명(매개변수) {}
	void turnOn() { // void: 반환유형이 없음
		System.out.println("텔레비전 켭니다");
		
	}
	
	void turnOff() {
		System.out.println("텔레비전 끕니다");
		
	}
	
	void changeChannel(int Channel){
		System.out.println(Channel +"번 채널로 변경합니다");
		
		
	}
	

}

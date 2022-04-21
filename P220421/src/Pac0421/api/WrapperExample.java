package Pac0421.api;

public class WrapperExample {
	public static void main(String[] args) {
		// 랩퍼클래스
		// 기본데이터 -> 참조데이터
		// int, long, byte -> Integer, Long
		int n1 = 100;
		Integer n2 = 200;
//		Integer n2 = new Integer(200); // 원래 클래스라 이렇게 호출해야하는데, 래퍼는 생략가능 = 박싱 
		n1 = n2; // 이렇게도 가능. 언박싱
		byte b1 = n2.byteValue();
		System.out.println(b1);
		Float f1 = 12.3F;
		
		Integer.parseInt("100");
		Double.parseDouble("123.456");
		
	}

}

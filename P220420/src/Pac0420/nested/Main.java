package Pac0420.nested;

//import Pac0419.nested.Outer.Inner; // Outer.Inner 이렇게 클래스 풀네임 써주면 import 필요없음

public class Main {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.method1();
		
		// 인스턴스 멤버클래스: 인스턴스 생성 필요
		Outer.Inner1 inner = outer.new Inner1(); 
		inner.method2();
		
		
		// static 멤버클래스: 인스턴스 생성 필요없음(static 클래스는 메모리에 올라온 시점에 바로 사용 가능)
		Outer.Inner2.method5();
		
		Outer.Inner2 inner2 = new Outer.Inner2(); 
		inner2.method4(); // 인스턴스 메서드
		inner2.method5(); // 정적 메서드
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

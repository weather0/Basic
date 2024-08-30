package Pac0420.nested;

public class Outer {
	private String f1;

	// 인스턴스 멤버클래스
	class Inner1 {
		String f2;

		void method2() {
			System.out.println("method2() call.");
		}
	}
	
	// static정적 멤버클래스
	static class Inner2 {
		String f4;   // 일반필드
		static String f5; // static 필드
		
		void method4() {  // 인스턴스 메서드
			System.out.println("method4() call.");
		}
		static void method5() {  // static 메서드
			System.out.println("method5() call.");
		}
	}
	
	
	

	public void method1() {
		System.out.println("method1() call.");
		
		// 로컬클래스(멤버 안 클래스)
		class Local {
			String f3;
			
			void method3() {
				System.out.println("method3() call.");
			}
		}
		
		Local local = new Local();
		local.method3();
	}

}

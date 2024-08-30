package Pac0419.project;

// 인터페이스
interface Runnable {
	public void run();
}

// 구현클래스
class RunClass implements Runnable{

	@Override
	public void run() {
		System.out.println("움직입니다");
	}
	
}

// 메인클래스
public class RunnableExample {
	public static void main(String[] args) {
		Runnable runnable = new RunClass();
		runnable.run();
		runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("멍멍이가 달립니다");
			} // 익명구현객체
			
		};
		runnable.run();
		
		// 익명구현객체. 람다표현식
		runnable = () -> System.out.println("야옹이가 달립니다");
		runnable.run();
		
		
		
		
		
		
		
		
		
		
		
	}
	

}

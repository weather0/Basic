package Pac0414.statics;

public class Singleton { // public: 모든 패키지에서 사용 가능함(단, public class는 한 파일에 하나만 선언 가능)
	private static Singleton singleton = new Singleton();
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		return singleton;
		
	}

}

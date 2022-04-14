package Pac0414.statics;

public class SingletonEample {
	public static void main(String[] args) {
//		Singleton s1 = new Singleton(); 불가함 private이라서
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		if(s1 == s2) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		
	}
}

package Pac0418.abstracts;

public class Main {
	public static void main(String[] args) {
		
		Animal animal = null; // abstract 클래스는 생성자로 인스턴스 생성X (new Animal() 에러남)
		animal = new Bird();
		animal.eat();
		animal.run();
		animal.sleep();
		
		animal = new Fish();
		animal.eat();
		animal.run();
		animal.sleep();
	}

}

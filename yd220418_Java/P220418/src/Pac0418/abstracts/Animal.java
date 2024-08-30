package Pac0418.abstracts;

public abstract class Animal {
	// abstract 클래스는 생성자로 인스턴스 생성X (new Animal() 에러남)

	public Animal() {

	}

	public abstract void eat(); 
	public abstract void run();
	// abstract 메서드는 구현부{}가 없다. 즉 이 메서드를 상속받은 하위클래스에서 강제로 구현하도록
	public void sleep() {
		System.out.println("동물이 잠을 잡니다");
	}

}

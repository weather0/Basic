package Pac0418.abstracts;

public class Bird extends Animal {

	@Override
	public void eat() {
		System.out.println("새가 먹이를 먹습니다.");
	}

	@Override
	public void run() {
		System.out.println("새가 날아갑니다");
	}

	@Override
	public void sleep() {
		System.out.println("새가 잡을 잡니다");
	}
	
	



}

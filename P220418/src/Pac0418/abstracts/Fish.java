package Pac0418.abstracts;

public class Fish extends Animal {

	@Override
	public void eat() {
		System.out.println("물고기가 먹이를 먹습니다.");
	}

	@Override
	public void run() {
		System.out.println("물고기가 헤업을 칩니다");
	}
	
	public void sleep() {
		System.out.println("물고기가 잡을 잡니다");
	}




}

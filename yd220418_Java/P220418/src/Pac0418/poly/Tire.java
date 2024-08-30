package Pac0418.poly;

public class Tire {
	// 필드
	public int maxRotation; // 최대 10회
	public int accumulateRotation; // 현재 사용한 누적 회전수
	public String location; // 자동차의 위치

	// 생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}

	// 메소드
	public boolean roll() {
		accumulateRotation++;
		if (accumulateRotation < maxRotation) {
			System.out.println(location + " Tire수명 " + (maxRotation - accumulateRotation) + "회");
			return true;
		} else {
			System.out.println("***" + location + "Tire 펑크 ***");
			return false;
		}
	}

}

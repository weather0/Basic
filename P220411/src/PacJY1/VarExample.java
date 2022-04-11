package PacJY1;

public class VarExample {
	public static void main(String[] args) {
//		 변수의 선언
		int age = 20; // 오른쪽의 값을 왼쪽 변수에 할당
		double height = 163.6;
		String myName = "홍길동";
		age = 23;
		System.out.println("이름은 " + myName);
		System.out.println("나이는 " + age + "살 입니다.");
		System.out.println("키는 " + height + "입니다.");
		
		int engScore = 85;
		int mathScore = 90;
		int result = engScore + mathScore;
		
		engScore = 80;
		mathScore = 70;
		result = engScore + mathScore;
		
		System.out.println("영어점수 " + engScore + "과 수학점수 "//
				+ mathScore + "의 합은 " + result + "입니다.");
	}

}

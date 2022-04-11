package PacJY1;

public class VarExample6 {
	public static void main(String[] args) {
		String myName = "홍길동";
		
		int age = 10;
		double height = 167.4;
		
		int mat, eng;
		mat = 80;
		eng = 90;
		// 이런식으로 선언부터 먼저 하고 값을 따로 담아도 됨
		
		System.out.println(myName + "의 나이는 " + age
				+ "이고 키는 " + height + "이고 "
				+ "영어,수학점수의 합은 " + (mat + eng)
				+ "입니다.");
		// 첨나온놈(myName)이 문자열(String)이면 뒷놈들도 다 문자열로 인식해버림.
		// 그래서 (mat+eng)이렇게 괄호로 묶어야 숫자끼리 따로 연산이 됨.
		
//		char firstChar = myName.charAt(0);
//		System.out.println((int) firstChar);
//		행전체 주석화: 컨+/
	}
}

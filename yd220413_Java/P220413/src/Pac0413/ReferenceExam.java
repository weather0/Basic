package Pac0413;

public class ReferenceExam {
	public static void main(String[] args) {

		// 기본타입. 타입은 소문자로
		int num1 = 100;
		int num2 = 100;

		if (num1 == num2) {
			System.out.println("같은 값");
		} else {
			System.out.println("다른 값");
		}

		// 참조타입. 클래스는 대문자로
		String str1 = new String("홍길동"); // 인스턴스
		String str2 = new String("홍길동");
		str1 = null; // str1이 참조하던 값(홍길동)이 사라짐(연결 끊어짐)→NullPointerExeption오류
		str1 = "김길동";

//		if (str1 == str2) {       // 참조변수(==) 주소값으로 비교하므로 다름
		if (str1.equals(str2)) {  // 메서드(equals)를 사용해야 정확히 비교 가능
			System.out.println("같은 값");
		} else {
			System.out.println("다른 값");

		}

		
		
		
		
		
		
		
		
		
//────────────────────────────────────────────
	}

}

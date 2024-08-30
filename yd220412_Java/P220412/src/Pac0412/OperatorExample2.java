package Pac0412;

public class OperatorExample2 {
	public static void main(String[] args) {
		// 십진수10 = 2진수1010
		int num10 = 10;
		System.out.println(~num10); 
		// 십진수-11 = 2진수-11110101. 간단하게 ~반전 붙이면 음수되고 -1
		
		
		boolean isTrue = false;
		isTrue = !isTrue; // isTure(false)의 논리부정!(not)은 true 
		isTrue = !isTrue; // false 
		isTrue = !isTrue; // true
		isTrue = !isTrue; // false
		isTrue = !isTrue; // true
		System.out.println(isTrue);
		
		if (num10 > 5) {
			System.out.println("참");
		} else {
			System.out.println("거짓");
		}
		 
		
	}

}

package Pac0412;

public class OperatorExample3 {
	public static void main(String[] args) {
		// 비교연산자, 논리연산자
		int num1 = 10;
		int num2 = 20;
		
		if (num1 == num2) {
			System.out.println("두 수는 같습니다.");
		}
		
		if (num1 != num2) {
			System.out.println("두 수는 같지 않음");
		}
		if (num1 >= num2) {
			System.out.println(num1 + "이 " + num2 + "보다 큽니다.");
		}
		
		
		
		if ((++num1 % 2 == 0) && (num2++ % 2 == 0)) {
			System.out.println("두 수는 짝수");
		} else {
			System.out.println("두 수가 다 짝수는 아님");
		}
		System.out.println(num1 + ", " + num2);
		// &&(AND가 두개)면 전자가 false 판정나면 뒤에 건 판별자체를 안 함
		// &면 일단 전자 후자 둘 다 판별(한개짜리는 잘 안 씀)
		
		
		
		if ((++num1 % 2 == 0) || (num2++ % 2 == 0)) {
			System.out.println("두 수 중에 하나 짝수");
		} else {
			System.out.println("두 수가 다 홀수임");
		}
		System.out.println(num1 + ", " + num2);
		
		
		System.out.println("end of prog");
	}

}
